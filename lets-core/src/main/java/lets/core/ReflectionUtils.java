/*
 * Copyright (c) 2002-2018 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lets.core;

import static java.lang.String.format;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.io.File;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lets.core.collections.CollectionUtils;
import lets.core.function.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple utility class for working with the reflection API and handling reflection exceptions.
 *
 * <p>Only intended for internal use.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Rod Johnson
 * @author Costin Leau
 * @author Sam Brannen
 * @author Chris Beams
 * @since 1.2.2
 */
public abstract class ReflectionUtils {

  private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

  /**
   * Naming prefix for CGLIB-renamed methods.
   *
   * @see #isCglibRenamedMethod
   */
  private static final String CGLIB_RENAMED_METHOD_PREFIX = "CGLIB$";

  private static final Method[] NO_METHODS = {};

  private static final Field[] NO_FIELDS = {};

  /**
   * Cache for {@link Class#getDeclaredMethods()} plus equivalent default methods from Java 8 based
   * interfaces, allowing for fast iteration.
   */
  private static final Map<Class<?>, Method[]> declaredMethodsCache =
      new ConcurrentReferenceHashMap<Class<?>, Method[]>(256);

  /** Cache for {@link Class#getDeclaredFields()}, allowing for fast iteration. */
  private static final Map<Class<?>, Field[]> declaredFieldsCache =
      new ConcurrentReferenceHashMap<Class<?>, Field[]>(256);

  /**
   * Attempt to find a {@link Field field} on the supplied {@link Class} with the supplied {@code
   * name}. Searches all superclasses up to {@link Object}.
   *
   * @param clazz the class to introspect
   * @param name the name of the field
   * @return the corresponding Field object, or {@code null} if not found
   */
  public static Field findField(Class<?> clazz, String name) {
    return findField(clazz, name, null);
  }

  /**
   * Attempt to find a {@link Field field} on the supplied {@link Class} with the supplied {@code
   * name} and/or {@link Class type}. Searches all superclasses up to {@link Object}.
   *
   * @param clazz the class to introspect
   * @param name the name of the field (may be {@code null} if type is specified)
   * @param type the type of the field (may be {@code null} if name is specified)
   * @return the corresponding Field object, or {@code null} if not found
   */
  public static Field findField(Class<?> clazz, String name, Class<?> type) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.isTrue(
        name != null || type != null, "Either name or type of the field must be specified");
    Class<?> searchType = clazz;
    while (Object.class != searchType && searchType != null) {
      Field[] fields = getDeclaredFields(searchType);
      for (Field field : fields) {
        if ((name == null || name.equals(field.getName()))
            && (type == null || type.equals(field.getType()))) {
          return field;
        }
      }
      searchType = searchType.getSuperclass();
    }
    return null;
  }

  /**
   * Set the field represented by the supplied {@link Field field object} on the specified {@link
   * Object target object} to the specified {@code value}. In accordance with {@link
   * Field#set(Object, Object)} semantics, the new value is automatically unwrapped if the
   * underlying field has a primitive type.
   *
   * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
   *
   * @param field the field to set
   * @param target the target object on which to set the field
   * @param value the value to set (may be {@code null})
   */
  public static void setField(Field field, Object target, Object value) {
    try {
      field.set(target, value);
    } catch (IllegalAccessException ex) {
      handleReflectionException(ex);
      throw new IllegalStateException(
          "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
    }
  }

  /**
   * Get the field represented by the supplied {@link Field field object} on the specified {@link
   * Object target object}. In accordance with {@link Field#get(Object)} semantics, the returned
   * value is automatically wrapped if the underlying field has a primitive type.
   *
   * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
   *
   * @param field the field to get
   * @param target the target object from which to get the field
   * @return the field's current value
   */
  public static Object getField(Field field, Object target) {
    try {
      return field.get(target);
    } catch (IllegalAccessException ex) {
      handleReflectionException(ex);
      throw new IllegalStateException(
          "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
    }
  }

  /**
   * Attempt to find a {@link Method} on the supplied class with the supplied name and no
   * parameters. Searches all superclasses up to {@code Object}.
   *
   * <p>Returns {@code null} if no {@link Method} can be found.
   *
   * @param clazz the class to introspect
   * @param name the name of the method
   * @return the Method object, or {@code null} if none found
   */
  public static Method findMethod(Class<?> clazz, String name) {
    return findMethod(clazz, name, new Class<?>[0]);
  }

  /**
   * Attempt to find a {@link Method} on the supplied class with the supplied name and parameter
   * types. Searches all superclasses up to {@code Object}.
   *
   * <p>Returns {@code null} if no {@link Method} can be found.
   *
   * @param clazz the class to introspect
   * @param name the name of the method
   * @param paramTypes the parameter types of the method (may be {@code null} to indicate any
   *     signature)
   * @return the Method object, or {@code null} if none found
   */
  public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(name, "Method name must not be null");
    Class<?> searchType = clazz;
    while (searchType != null) {
      Method[] methods =
          (searchType.isInterface() ? searchType.getMethods() : getDeclaredMethods(searchType));
      for (Method method : methods) {
        if (name.equals(method.getName())
            && (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
          return method;
        }
      }
      searchType = searchType.getSuperclass();
    }
    return null;
  }

  /**
   * Invoke the specified {@link Method} against the supplied target object with no arguments. The
   * target object can be {@code null} when invoking a static {@link Method}.
   *
   * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException}.
   *
   * @param method the method to invoke
   * @param target the target object to invoke the method on
   * @return the invocation result, if any
   * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
   */
  public static Object invokeMethod(Method method, Object target) {
    return invokeMethod(method, target, new Object[0]);
  }

  /**
   * Invoke the specified {@link Method} against the supplied target object with the supplied
   * arguments. The target object can be {@code null} when invoking a static {@link Method}.
   *
   * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException}.
   *
   * @param method the method to invoke
   * @param target the target object to invoke the method on
   * @param args the invocation arguments (may be {@code null})
   * @return the invocation result, if any
   */
  public static Object invokeMethod(Method method, Object target, Object... args) {
    try {
      return method.invoke(target, args);
    } catch (Exception ex) {
      handleReflectionException(ex);
    }
    throw new IllegalStateException("Should never get here");
  }

  /**
   * Invoke the specified JDBC API {@link Method} against the supplied target object with no
   * arguments.
   *
   * @param method the method to invoke
   * @param target the target object to invoke the method on
   * @return the invocation result, if any
   * @throws SQLException the JDBC API SQLException to rethrow (if any)
   * @see #invokeJdbcMethod(java.lang.reflect.Method, Object, Object[])
   */
  public static Object invokeJdbcMethod(Method method, Object target) throws SQLException {
    return invokeJdbcMethod(method, target, new Object[0]);
  }

  /**
   * Invoke the specified JDBC API {@link Method} against the supplied target object with the
   * supplied arguments.
   *
   * @param method the method to invoke
   * @param target the target object to invoke the method on
   * @param args the invocation arguments (may be {@code null})
   * @return the invocation result, if any
   * @throws SQLException the JDBC API SQLException to rethrow (if any)
   * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
   */
  public static Object invokeJdbcMethod(Method method, Object target, Object... args)
      throws SQLException {
    try {
      return method.invoke(target, args);
    } catch (IllegalAccessException ex) {
      handleReflectionException(ex);
    } catch (InvocationTargetException ex) {
      if (ex.getTargetException() instanceof SQLException) {
        throw (SQLException) ex.getTargetException();
      }
      handleInvocationTargetException(ex);
    }
    throw new IllegalStateException("Should never get here");
  }

  /**
   * Handle the given reflection exception. Should only be called if no checked exception is
   * expected to be thrown by the target method.
   *
   * <p>Throws the underlying RuntimeException or Error in case of an InvocationTargetException with
   * such a root cause. Throws an IllegalStateException with an appropriate message or
   * UndeclaredThrowableException otherwise.
   *
   * @param ex the reflection exception to handle
   */
  public static void handleReflectionException(Exception ex) {
    if (ex instanceof NoSuchMethodException) {
      throw new IllegalStateException("Method not found: " + ex.getMessage());
    }
    if (ex instanceof IllegalAccessException) {
      throw new IllegalStateException("Could not access method: " + ex.getMessage());
    }
    if (ex instanceof InvocationTargetException) {
      handleInvocationTargetException((InvocationTargetException) ex);
    }
    if (ex instanceof RuntimeException) {
      throw (RuntimeException) ex;
    }
    throw new UndeclaredThrowableException(ex);
  }

  /**
   * Handle the given invocation target exception. Should only be called if no checked exception is
   * expected to be thrown by the target method.
   *
   * <p>Throws the underlying RuntimeException or Error in case of such a root cause. Throws an
   * UndeclaredThrowableException otherwise.
   *
   * @param ex the invocation target exception to handle
   */
  public static void handleInvocationTargetException(InvocationTargetException ex) {
    rethrowRuntimeException(ex.getTargetException());
  }

  /**
   * Rethrow the given {@link Throwable exception}, which is presumably the <em>target
   * exception</em> of an {@link InvocationTargetException}. Should only be called if no checked
   * exception is expected to be thrown by the target method.
   *
   * <p>Rethrows the underlying exception cast to a {@link RuntimeException} or {@link Error} if
   * appropriate; otherwise, throws an {@link UndeclaredThrowableException}.
   *
   * @param ex the exception to rethrow
   * @throws RuntimeException the rethrown exception
   */
  public static void rethrowRuntimeException(Throwable ex) {
    if (ex instanceof RuntimeException) {
      throw (RuntimeException) ex;
    }
    if (ex instanceof Error) {
      throw (Error) ex;
    }
    throw new UndeclaredThrowableException(ex);
  }

  /**
   * Rethrow the given {@link Throwable exception}, which is presumably the <em>target
   * exception</em> of an {@link InvocationTargetException}. Should only be called if no checked
   * exception is expected to be thrown by the target method.
   *
   * <p>Rethrows the underlying exception cast to an {@link Exception} or {@link Error} if
   * appropriate; otherwise, throws an {@link UndeclaredThrowableException}.
   *
   * @param ex the exception to rethrow
   * @throws Exception the rethrown exception (in case of a checked exception)
   */
  public static void rethrowException(Throwable ex) throws Exception {
    if (ex instanceof Exception) {
      throw (Exception) ex;
    }
    if (ex instanceof Error) {
      throw (Error) ex;
    }
    throw new UndeclaredThrowableException(ex);
  }

  /**
   * Determine whether the given method explicitly declares the given exception or one of its
   * superclasses, which means that an exception of that type can be propagated as-is within a
   * reflective invocation.
   *
   * @param method the declaring method
   * @param exceptionType the exception to throw
   * @return {@code true} if the exception can be thrown as-is; {@code false} if it needs to be
   *     wrapped
   */
  public static boolean declaresException(Method method, Class<?> exceptionType) {
    Assert.notNull(method, "Method must not be null");
    Class<?>[] declaredExceptions = method.getExceptionTypes();
    for (Class<?> declaredException : declaredExceptions) {
      if (declaredException.isAssignableFrom(exceptionType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determine whether the given field is a "public static final" constant.
   *
   * @param field the field to check
   */
  public static boolean isPublicStaticFinal(Field field) {
    int modifiers = field.getModifiers();
    return (Modifier.isPublic(modifiers)
        && Modifier.isStatic(modifiers)
        && Modifier.isFinal(modifiers));
  }

  /**
   * Determine whether the given method is an "equals" method.
   *
   * @see java.lang.Object#equals(Object)
   */
  public static boolean isEqualsMethod(Method method) {
    if (method == null || !method.getName().equals("equals")) {
      return false;
    }
    Class<?>[] paramTypes = method.getParameterTypes();
    return (paramTypes.length == 1 && paramTypes[0] == Object.class);
  }

  /**
   * Determine whether the given method is a "hashCode" method.
   *
   * @see java.lang.Object#hashCode()
   */
  public static boolean isHashCodeMethod(Method method) {
    return (method != null
        && method.getName().equals("hashCode")
        && method.getParameterTypes().length == 0);
  }

  /**
   * Determine whether the given method is a "toString" method.
   *
   * @see java.lang.Object#toString()
   */
  public static boolean isToStringMethod(Method method) {
    return (method != null
        && method.getName().equals("toString")
        && method.getParameterTypes().length == 0);
  }

  /** Determine whether the given method is originally declared by {@link java.lang.Object}. */
  public static boolean isObjectMethod(Method method) {
    if (method == null) {
      return false;
    }
    try {
      Object.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  /**
   * Determine whether the given method is a CGLIB 'renamed' method, following the pattern
   * "CGLIB$methodName$0".
   *
   * @param renamedMethod the method to check
   * @see org.springframework.cglib.proxy.Enhancer#rename
   */
  public static boolean isCglibRenamedMethod(Method renamedMethod) {
    String name = renamedMethod.getName();
    if (name.startsWith(CGLIB_RENAMED_METHOD_PREFIX)) {
      int i = name.length() - 1;
      while (i >= 0 && Character.isDigit(name.charAt(i))) {
        i--;
      }
      return ((i > CGLIB_RENAMED_METHOD_PREFIX.length())
          && (i < name.length() - 1)
          && name.charAt(i) == '$');
    }
    return false;
  }

  /**
   * Make the given field accessible, explicitly setting it accessible if necessary. The {@code
   * setAccessible(true)} method is only called when actually necessary, to avoid unnecessary
   * conflicts with a JVM SecurityManager (if active).
   *
   * @param field the field to make accessible
   * @see java.lang.reflect.Field#setAccessible
   */
  public static void makeAccessible(Field field) {
    if ((!Modifier.isPublic(field.getModifiers())
            || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
            || Modifier.isFinal(field.getModifiers()))
        && !field.isAccessible()) {
      field.setAccessible(true);
    }
  }

  /**
   * Make the given method accessible, explicitly setting it accessible if necessary. The {@code
   * setAccessible(true)} method is only called when actually necessary, to avoid unnecessary
   * conflicts with a JVM SecurityManager (if active).
   *
   * @param method the method to make accessible
   * @see java.lang.reflect.Method#setAccessible
   */
  public static void makeAccessible(Method method) {
    if ((!Modifier.isPublic(method.getModifiers())
            || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
        && !method.isAccessible()) {
      method.setAccessible(true);
    }
  }

  /**
   * Make the given constructor accessible, explicitly setting it accessible if necessary. The
   * {@code setAccessible(true)} method is only called when actually necessary, to avoid unnecessary
   * conflicts with a JVM SecurityManager (if active).
   *
   * @param ctor the constructor to make accessible
   * @see java.lang.reflect.Constructor#setAccessible
   */
  public static void makeAccessible(Constructor<?> ctor) {
    if ((!Modifier.isPublic(ctor.getModifiers())
            || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers()))
        && !ctor.isAccessible()) {
      ctor.setAccessible(true);
    }
  }

  /**
   * Perform the given callback operation on all matching methods of the given class, as locally
   * declared or equivalent thereof (such as default methods on Java 8 based interfaces that the
   * given class implements).
   *
   * @param clazz the class to introspect
   * @param mc the callback to invoke for each method
   * @since 4.2
   * @see #doWithMethods
   */
  public static void doWithLocalMethods(Class<?> clazz, MethodCallback mc) {
    Method[] methods = getDeclaredMethods(clazz);
    for (Method method : methods) {
      try {
        mc.doWith(method);
      } catch (IllegalAccessException ex) {
        throw new IllegalStateException(
            "Not allowed to access method '" + method.getName() + "': " + ex);
      }
    }
  }

  /**
   * Perform the given callback operation on all matching methods of the given class and
   * superclasses.
   *
   * <p>The same named method occurring on subclass and superclass will appear twice, unless
   * excluded by a {@link MethodFilter}.
   *
   * @param clazz the class to introspect
   * @param mc the callback to invoke for each method
   * @see #doWithMethods(Class, MethodCallback, MethodFilter)
   */
  public static void doWithMethods(Class<?> clazz, MethodCallback mc) {
    doWithMethods(clazz, mc, null);
  }

  /**
   * Perform the given callback operation on all matching methods of the given class and
   * superclasses (or given interface and super-interfaces).
   *
   * <p>The same named method occurring on subclass and superclass will appear twice, unless
   * excluded by the specified {@link MethodFilter}.
   *
   * @param clazz the class to introspect
   * @param mc the callback to invoke for each method
   * @param mf the filter that determines the methods to apply the callback to
   */
  public static void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf) {
    // Keep backing up the inheritance hierarchy.
    Method[] methods = getDeclaredMethods(clazz);
    for (Method method : methods) {
      if (mf != null && !mf.matches(method)) {
        continue;
      }
      try {
        mc.doWith(method);
      } catch (IllegalAccessException ex) {
        throw new IllegalStateException(
            "Not allowed to access method '" + method.getName() + "': " + ex);
      }
    }
    if (clazz.getSuperclass() != null) {
      doWithMethods(clazz.getSuperclass(), mc, mf);
    } else if (clazz.isInterface()) {
      for (Class<?> superIfc : clazz.getInterfaces()) {
        doWithMethods(superIfc, mc, mf);
      }
    }
  }

  /**
   * Get all declared methods on the leaf class and all superclasses. Leaf class methods are
   * included first.
   *
   * @param leafClass the class to introspect
   */
  public static Method[] getAllDeclaredMethods(Class<?> leafClass) {
    final List<Method> methods = new ArrayList<Method>(32);
    doWithMethods(
        leafClass,
        new MethodCallback() {
          @Override
          public void doWith(Method method) {
            methods.add(method);
          }
        });
    return methods.toArray(new Method[methods.size()]);
  }

  /**
   * Get the unique set of declared methods on the leaf class and all superclasses. Leaf class
   * methods are included first and while traversing the superclass hierarchy any methods found with
   * signatures matching a method already included are filtered out.
   *
   * @param leafClass the class to introspect
   */
  public static Method[] getUniqueDeclaredMethods(Class<?> leafClass) {
    final List<Method> methods = new ArrayList<Method>(32);
    doWithMethods(
        leafClass,
        new MethodCallback() {
          @Override
          public void doWith(Method method) {
            boolean knownSignature = false;
            Method methodBeingOverriddenWithCovariantReturnType = null;
            for (Method existingMethod : methods) {
              if (method.getName().equals(existingMethod.getName())
                  && Arrays.equals(
                      method.getParameterTypes(), existingMethod.getParameterTypes())) {
                // Is this a covariant return type situation?
                if (existingMethod.getReturnType() != method.getReturnType()
                    && existingMethod.getReturnType().isAssignableFrom(method.getReturnType())) {
                  methodBeingOverriddenWithCovariantReturnType = existingMethod;
                } else {
                  knownSignature = true;
                }
                break;
              }
            }
            if (methodBeingOverriddenWithCovariantReturnType != null) {
              methods.remove(methodBeingOverriddenWithCovariantReturnType);
            }
            if (!knownSignature && !isCglibRenamedMethod(method)) {
              methods.add(method);
            }
          }
        });
    return methods.toArray(new Method[methods.size()]);
  }

  /**
   * This variant retrieves {@link Class#getDeclaredMethods()} from a local cache in order to avoid
   * the JVM's SecurityManager check and defensive array copying. In addition, it also includes Java
   * 8 default methods from locally implemented interfaces, since those are effectively to be
   * treated just like declared methods.
   *
   * @param clazz the class to introspect
   * @return the cached array of methods
   * @see Class#getDeclaredMethods()
   */
  private static Method[] getDeclaredMethods(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    Method[] result = declaredMethodsCache.get(clazz);
    if (result == null) {
      Method[] declaredMethods = clazz.getDeclaredMethods();
      List<Method> defaultMethods = findConcreteMethodsOnInterfaces(clazz);
      if (defaultMethods != null) {
        result = new Method[declaredMethods.length + defaultMethods.size()];
        System.arraycopy(declaredMethods, 0, result, 0, declaredMethods.length);
        int index = declaredMethods.length;
        for (Method defaultMethod : defaultMethods) {
          result[index] = defaultMethod;
          index++;
        }
      } else {
        result = declaredMethods;
      }
      declaredMethodsCache.put(clazz, (result.length == 0 ? NO_METHODS : result));
    }
    return result;
  }

  private static List<Method> findConcreteMethodsOnInterfaces(Class<?> clazz) {
    List<Method> result = null;
    for (Class<?> ifc : clazz.getInterfaces()) {
      for (Method ifcMethod : ifc.getMethods()) {
        if (!Modifier.isAbstract(ifcMethod.getModifiers())) {
          if (result == null) {
            result = new ArrayList<Method>();
          }
          result.add(ifcMethod);
        }
      }
    }
    return result;
  }

  /**
   * Invoke the given callback on all locally declared fields in the given class.
   *
   * @param clazz the target class to analyze
   * @param fc the callback to invoke for each field
   * @since 4.2
   * @see #doWithFields
   */
  public static void doWithLocalFields(Class<?> clazz, FieldCallback fc) {
    for (Field field : getDeclaredFields(clazz)) {
      try {
        fc.doWith(field);
      } catch (IllegalAccessException ex) {
        throw new IllegalStateException(
            "Not allowed to access field '" + field.getName() + "': " + ex);
      }
    }
  }

  /**
   * Invoke the given callback on all fields in the target class, going up the class hierarchy to
   * get all declared fields.
   *
   * @param clazz the target class to analyze
   * @param fc the callback to invoke for each field
   */
  public static void doWithFields(Class<?> clazz, FieldCallback fc) {
    doWithFields(clazz, fc, null);
  }

  /**
   * Invoke the given callback on all fields in the target class, going up the class hierarchy to
   * get all declared fields.
   *
   * @param clazz the target class to analyze
   * @param fc the callback to invoke for each field
   * @param ff the filter that determines the fields to apply the callback to
   */
  public static void doWithFields(Class<?> clazz, FieldCallback fc, FieldFilter ff) {
    // Keep backing up the inheritance hierarchy.
    Class<?> targetClass = clazz;
    do {
      Field[] fields = getDeclaredFields(targetClass);
      for (Field field : fields) {
        if (ff != null && !ff.matches(field)) {
          continue;
        }
        try {
          fc.doWith(field);
        } catch (IllegalAccessException ex) {
          throw new IllegalStateException(
              "Not allowed to access field '" + field.getName() + "': " + ex);
        }
      }
      targetClass = targetClass.getSuperclass();
    } while (targetClass != null && targetClass != Object.class);
  }

  /**
   * This variant retrieves {@link Class#getDeclaredFields()} from a local cache in order to avoid
   * the JVM's SecurityManager check and defensive array copying.
   *
   * @param clazz the class to introspect
   * @return the cached array of fields
   * @see Class#getDeclaredFields()
   */
  private static Field[] getDeclaredFields(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    Field[] result = declaredFieldsCache.get(clazz);
    if (result == null) {
      result = clazz.getDeclaredFields();
      declaredFieldsCache.put(clazz, (result.length == 0 ? NO_FIELDS : result));
    }
    return result;
  }

  /**
   * Given the source object and the destination, which must be the same class or a subclass, copy
   * all fields, including inherited fields. Designed to work on objects with public no-arg
   * constructors.
   */
  public static void shallowCopyFieldState(final Object src, final Object dest) {
    Assert.notNull(src, "Source for field copy cannot be null");
    Assert.notNull(dest, "Destination for field copy cannot be null");
    if (!src.getClass().isAssignableFrom(dest.getClass())) {
      throw new IllegalArgumentException(
          "Destination class ["
              + dest.getClass().getName()
              + "] must be same or subclass as source class ["
              + src.getClass().getName()
              + "]");
    }
    doWithFields(
        src.getClass(),
        new FieldCallback() {
          @Override
          public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            makeAccessible(field);
            Object srcValue = field.get(src);
            field.set(dest, srcValue);
          }
        },
        COPYABLE_FIELDS);
  }

  /**
   * Clear the internal method/field cache.
   *
   * @since 4.2.4
   */
  public static void clearCache() {
    declaredMethodsCache.clear();
    declaredFieldsCache.clear();
  }

  /** Action to take on each method. */
  public interface MethodCallback {

    /**
     * Perform an operation using the given method.
     *
     * @param method the method to operate on
     */
    void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
  }

  /** Callback optionally used to filter methods to be operated on by a method callback. */
  public interface MethodFilter {

    /**
     * Determine whether the given method matches.
     *
     * @param method the method to check
     */
    boolean matches(Method method);
  }

  /** Callback interface invoked on each field in the hierarchy. */
  public interface FieldCallback {

    /**
     * Perform an operation using the given field.
     *
     * @param field the field to operate on
     */
    void doWith(Field field) throws IllegalArgumentException, IllegalAccessException;
  }

  /** Callback optionally used to filter fields to be operated on by a field callback. */
  public interface FieldFilter {

    /**
     * Determine whether the given field matches.
     *
     * @param field the field to check
     */
    boolean matches(Field field);
  }

  /**
   * Pre-built MethodFilter that matches all non-bridge methods.
   *
   * @since 3.0
   */
  public static final MethodFilter NON_BRIDGED_METHODS =
      new MethodFilter() {

        @Override
        public boolean matches(Method method) {
          return !method.isBridge();
        }
      };

  /**
   * Pre-built MethodFilter that matches all non-bridge methods which are not declared on {@code
   * java.lang.Object}.
   *
   * @since 3.0.5
   */
  public static final MethodFilter USER_DECLARED_METHODS =
      new MethodFilter() {

        @Override
        public boolean matches(Method method) {
          return (!method.isBridge() && method.getDeclaringClass() != Object.class);
        }
      };

  /** Pre-built FieldFilter that matches all non-static, non-final fields. */
  public static final FieldFilter COPYABLE_FIELDS =
      new FieldFilter() {

        @Override
        public boolean matches(Field field) {
          return !(Modifier.isStatic(field.getModifiers())
              || Modifier.isFinal(field.getModifiers()));
        }
      };

  /**
   * Modes in which a hierarchy can be traversed &mdash; for example, when searching for methods or
   * fields within a class hierarchy.
   */
  public enum HierarchyTraversalMode {

    /** Traverse the hierarchy using top-down semantics. */
    TOP_DOWN,

    /** Traverse the hierarchy using bottom-up semantics. */
    BOTTOM_UP;
  }

  // Pattern: "[Ljava.lang.String;", "[[[[Ljava.lang.String;", etc.
  private static final Pattern VM_INTERNAL_OBJECT_ARRAY_PATTERN = Pattern.compile("^(\\[+)L(.+);$");

  /**
   * Pattern: "[x", "[[[[x", etc., where x is Z, B, C, D, F, I, J, S, etc.
   *
   * <p>The pattern intentionally captures the last bracket with the capital letter so that the
   * combination can be looked up via {@link #classNameToTypeMap}. For example, the last matched
   * group will contain {@code "[I"} instead of {@code "I"}.
   *
   * @see Class#getName()
   */
  private static final Pattern VM_INTERNAL_PRIMITIVE_ARRAY_PATTERN =
      Pattern.compile("^(\\[+)(\\[[ZBCDFIJS])$");

  // Pattern: "java.lang.String[]", "int[]", "int[][][][]", etc.
  private static final Pattern SOURCE_CODE_SYNTAX_ARRAY_PATTERN =
      Pattern.compile("^([^\\[\\]]+)((\\[\\])+)+$");

  private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];

  private static final ClasspathScanner classpathScanner =
      new ClasspathScanner(
          ClassLoaderUtils::getDefaultClassLoader, ReflectionUtils::tryToLoadClass);

  /**
   * Set of fully qualified class names for which no cycles have been detected in inner class
   * hierarchies.
   *
   * <p>This serves as a cache to avoid repeated cycle detection for classes that have already been
   * checked.
   *
   * @since 1.6
   * @see #detectInnerClassCycle(Class)
   */
  private static final Set<String> noCyclesDetectedCache = ConcurrentHashMap.newKeySet();

  /** Internal cache of common class names mapped to their types. */
  private static final Map<String, Class<?>> classNameToTypeMap;

  /** Internal cache of primitive types mapped to their wrapper types. */
  private static final Map<Class<?>, Class<?>> primitiveToWrapperMap;

  static {
    // @formatter:off
    List<Class<?>> commonTypes =
        Arrays.asList(
            boolean.class,
            byte.class,
            char.class,
            short.class,
            int.class,
            long.class,
            float.class,
            double.class,
            boolean[].class,
            byte[].class,
            char[].class,
            short[].class,
            int[].class,
            long[].class,
            float[].class,
            double[].class,
            boolean[][].class,
            byte[][].class,
            char[][].class,
            short[][].class,
            int[][].class,
            long[][].class,
            float[][].class,
            double[][].class,
            Boolean.class,
            Byte.class,
            Character.class,
            Short.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            String.class,
            Boolean[].class,
            Byte[].class,
            Character[].class,
            Short[].class,
            Integer[].class,
            Long[].class,
            Float[].class,
            Double[].class,
            String[].class,
            Boolean[][].class,
            Byte[][].class,
            Character[][].class,
            Short[][].class,
            Integer[][].class,
            Long[][].class,
            Float[][].class,
            Double[][].class,
            String[][].class);
    // @formatter:on

    Map<String, Class<?>> classNamesToTypes = new HashMap<>(64);

    commonTypes.forEach(
        type -> {
          classNamesToTypes.put(type.getName(), type);
          classNamesToTypes.put(type.getCanonicalName(), type);
        });

    classNameToTypeMap = Collections.unmodifiableMap(classNamesToTypes);

    Map<Class<?>, Class<?>> primitivesToWrappers = new IdentityHashMap<>(8);

    primitivesToWrappers.put(boolean.class, Boolean.class);
    primitivesToWrappers.put(byte.class, Byte.class);
    primitivesToWrappers.put(char.class, Character.class);
    primitivesToWrappers.put(short.class, Short.class);
    primitivesToWrappers.put(int.class, Integer.class);
    primitivesToWrappers.put(long.class, Long.class);
    primitivesToWrappers.put(float.class, Float.class);
    primitivesToWrappers.put(double.class, Double.class);

    primitiveToWrapperMap = Collections.unmodifiableMap(primitivesToWrappers);
  }

  public static boolean isPublic(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return Modifier.isPublic(clazz.getModifiers());
  }

  public static boolean isPublic(Member member) {
    CoreUtils.checkNotNull(member, "Member must not be null");
    return Modifier.isPublic(member.getModifiers());
  }

  public static boolean isPrivate(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return Modifier.isPrivate(clazz.getModifiers());
  }

  public static boolean isPrivate(Member member) {
    CoreUtils.checkNotNull(member, "Member must not be null");
    return Modifier.isPrivate(member.getModifiers());
  }

  public static boolean isNotPrivate(Class<?> clazz) {
    return !isPrivate(clazz);
  }

  public static boolean isNotPrivate(Member member) {
    return !isPrivate(member);
  }

  public static boolean isAbstract(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return Modifier.isAbstract(clazz.getModifiers());
  }

  public static boolean isAbstract(Member member) {
    CoreUtils.checkNotNull(member, "Member must not be null");
    return Modifier.isAbstract(member.getModifiers());
  }

  public static boolean isStatic(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return Modifier.isStatic(clazz.getModifiers());
  }

  public static boolean isNotStatic(Class<?> clazz) {
    return !isStatic(clazz);
  }

  public static boolean isStatic(Member member) {
    CoreUtils.checkNotNull(member, "Member must not be null");
    return Modifier.isStatic(member.getModifiers());
  }

  public static boolean isNotStatic(Member member) {
    return !isStatic(member);
  }

  public static boolean isFinal(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return Modifier.isFinal(clazz.getModifiers());
  }

  public static boolean isNotFinal(Class<?> clazz) {
    return !isFinal(clazz);
  }

  public static boolean isFinal(Member member) {
    CoreUtils.checkNotNull(member, "Member must not be null");
    return Modifier.isFinal(member.getModifiers());
  }

  public static boolean isNotFinal(Member member) {
    return !isFinal(member);
  }

  /**
   * Determine if the supplied class is an <em>inner class</em> (i.e., a non-static member class).
   *
   * <p>Technically speaking (i.e., according to the Java Language Specification), "an inner class
   * may be a non-static member class, a local class, or an anonymous class." However, this method
   * does not return {@code true} for a local or anonymous class.
   *
   * @param clazz the class to check; never {@code null}
   * @return {@code true} if the class is an <em>inner class</em>
   */
  public static boolean isInnerClass(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    return !isStatic(clazz) && clazz.isMemberClass();
  }

  public static boolean returnsVoid(Method method) {
    return method.getReturnType().equals(Void.TYPE);
  }

  /**
   * Determine if the supplied object is an array.
   *
   * @param obj the object to test; potentially {@code null}
   * @return {@code true} if the object is an array
   */
  public static boolean isArray(Object obj) {
    return (obj != null && obj.getClass().isArray());
  }

  public static boolean isMultidimensionalArray(Object obj) {
    return (obj != null && obj.getClass().isArray() && obj.getClass().getComponentType().isArray());
  }

  /**
   * Determine if an object of the supplied source type can be assigned to the supplied target type
   * for the purpose of reflective method invocations.
   *
   * <p>In contrast to {@link Class#isAssignableFrom(Class)}, this method returns {@code true} if
   * the target type represents a primitive type whose wrapper matches the supplied source type. In
   * addition, this method also supports <a
   * href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.2">widening
   * conversions</a> for primitive target types.
   *
   * @param sourceType the non-primitive target type; never {@code null}
   * @param targetType the target type; never {@code null}
   * @return {@code true} if an object of the source type is assignment compatible with the target
   *     type
   * @since 1.8
   * @see Class#isInstance(Object)
   * @see Class#isAssignableFrom(Class)
   * @see #isAssignableTo(Object, Class)
   */
  public static boolean isAssignableTo(Class<?> sourceType, Class<?> targetType) {
    CoreUtils.checkNotNull(sourceType, "source type must not be null");
    CoreUtils.checkState(!sourceType.isPrimitive(), "source type must not be a primitive type");
    CoreUtils.checkNotNull(targetType, "target type must not be null");

    if (targetType.isAssignableFrom(sourceType)) {
      return true;
    }

    if (targetType.isPrimitive()) {
      return sourceType == primitiveToWrapperMap.get(targetType)
          || isWideningConversion(sourceType, targetType);
    }

    return false;
  }

  /**
   * Determine if the supplied object can be assigned to the supplied target type for the purpose of
   * reflective method invocations.
   *
   * <p>In contrast to {@link Class#isInstance(Object)}, this method returns {@code true} if the
   * target type represents a primitive type whose wrapper matches the supplied object's type. In
   * addition, this method also supports <a
   * href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.2">widening
   * conversions</a> for primitive types and their corresponding wrapper types.
   *
   * <p>If the supplied object is {@code null} and the supplied type does not represent a primitive
   * type, this method returns {@code true}.
   *
   * @param obj the object to test for assignment compatibility; potentially {@code null}
   * @param targetType the type to check against; never {@code null}
   * @return {@code true} if the object is assignment compatible
   * @see Class#isInstance(Object)
   * @see Class#isAssignableFrom(Class)
   * @see #isAssignableTo(Class, Class)
   */
  public static boolean isAssignableTo(Object obj, Class<?> targetType) {
    CoreUtils.checkNotNull(targetType, "target type must not be null");

    if (obj == null) {
      return !targetType.isPrimitive();
    }

    if (targetType.isInstance(obj)) {
      return true;
    }

    if (targetType.isPrimitive()) {
      Class<?> sourceType = obj.getClass();
      return sourceType == primitiveToWrapperMap.get(targetType)
          || isWideningConversion(sourceType, targetType);
    }

    return false;
  }

  /**
   * Determine if Java supports a <em>widening primitive conversion</em> from the supplied source
   * type to the supplied <strong>primitive</strong> target type.
   */
  static boolean isWideningConversion(Class<?> sourceType, Class<?> targetType) {
    CoreUtils.checkState(targetType.isPrimitive(), "targetType must be primitive");

    boolean isPrimitive = sourceType.isPrimitive();
    boolean isWrapper = primitiveToWrapperMap.containsValue(sourceType);

    // Neither a primitive nor a wrapper?
    if (!isPrimitive && !isWrapper) {
      return false;
    }

    if (isPrimitive) {
      sourceType = primitiveToWrapperMap.get(sourceType);
    }

    // @formatter:off
    if (sourceType == Byte.class) {
      return targetType == short.class
          || targetType == int.class
          || targetType == long.class
          || targetType == float.class
          || targetType == double.class;
    }

    if (sourceType == Short.class || sourceType == Character.class) {
      return targetType == int.class
          || targetType == long.class
          || targetType == float.class
          || targetType == double.class;
    }

    if (sourceType == Integer.class) {
      return targetType == long.class || targetType == float.class || targetType == double.class;
    }

    if (sourceType == Long.class) {
      return targetType == float.class || targetType == double.class;
    }

    if (sourceType == Float.class) {
      return targetType == double.class;
    }
    // @formatter:on

    return false;
  }

  /**
   * Get the wrapper type for the supplied primitive type.
   *
   * @param type the primitive type for which to retrieve the wrapper type
   * @return the corresponding wrapper type or {@code null} if the supplied type is {@code null} or
   *     not a primitive type
   */
  public static Class<?> getWrapperType(Class<?> type) {
    return primitiveToWrapperMap.get(type);
  }

  public static <T> T newInstance(Class<T> clazz, Object... args) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(args, "Argument array must not be null");
    CoreUtils.checkContainsNoNullElements(args, "Individual arguments must not be null");

    try {
      Class<?>[] parameterTypes = Arrays.stream(args).map(Object::getClass).toArray(Class[]::new);
      return newInstance(clazz.getDeclaredConstructor(parameterTypes), args);
    } catch (Throwable t) {
      throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t));
    }
  }

  /**
   * Create a new instance of type {@code T} by invoking the supplied constructor with the supplied
   * arguments.
   *
   * <p>The constructor will be made accessible if necessary, and any checked exception will be
   * {@linkplain ExceptionUtils#throwAsUncheckedException masked} as an unchecked exception.
   *
   * @param constructor the constructor to invoke; never {@code null}
   * @param args the arguments to pass to the constructor
   * @return the new instance; never {@code null}
   * @see #newInstance(Class, Object...)
   * @see ExceptionUtils#throwAsUncheckedException(Throwable)
   */
  public static <T> T newInstance(Constructor<T> constructor, Object... args) {
    CoreUtils.checkNotNull(constructor, "Constructor must not be null");

    try {
      return makeAccessibleObject(constructor).newInstance(args);
    } catch (Throwable t) {
      throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t));
    }
  }

  public static <T> Optional<Object> readFieldValue(Class<T> clazz, String fieldName, T instance) {
    return tryToReadFieldValue(clazz, fieldName, instance).toOptional();
  }

  public static <T> Try<Object> tryToReadFieldValue(Class<T> clazz, String fieldName, T instance) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotBlank(fieldName, "Field name must not be null or blank");

    // @formatter:off
    return Try.call(() -> clazz.getDeclaredField(fieldName))
        .andThen(field -> tryToReadFieldValue(field, instance));
    // @formatter:on
  }

  public static Optional<Object> readFieldValue(Field field) {
    return tryToReadFieldValue(field).toOptional();
  }

  public static Try<Object> tryToReadFieldValue(Field field) {
    return tryToReadFieldValue(field, null);
  }

  public static Optional<Object> readFieldValue(Field field, Object instance) {
    return tryToReadFieldValue(field, instance).toOptional();
  }

  public static Try<Object> tryToReadFieldValue(Field field, Object instance) {
    CoreUtils.checkNotNull(field, "Field must not be null");
    CoreUtils.checkState(
        (instance != null || isStatic(field)),
        "Cannot read non-static field [%s] on a null instance.",
        field);
    return Try.call(() -> makeAccessibleObject(field).get(instance));
  }

  /**
   * Read the values of the supplied fields, making each field accessible if necessary and
   * {@linkplain ExceptionUtils#throwAsUncheckedException masking} any checked exception as an
   * unchecked exception.
   *
   * @param fields the list of fields to read; never {@code null}
   * @param instance the instance from which the values are to be read; may be {@code null} for
   *     static fields
   * @return an immutable list of the values of the specified fields; never {@code null} but may be
   *     empty or contain {@code null} entries
   */
  public static List<Object> readFieldValues(List<Field> fields, Object instance) {
    return readFieldValues(fields, instance, field -> true);
  }

  /**
   * Read the values of the supplied fields, making each field accessible if necessary, {@linkplain
   * ExceptionUtils#throwAsUncheckedException masking} any checked exception as an unchecked
   * exception, and filtering out fields that do not pass the supplied {@code predicate}.
   *
   * @param fields the list of fields to read; never {@code null}
   * @param instance the instance from which the values are to be read; may be {@code null} for
   *     static fields
   * @param predicate the field filter; never {@code null}
   * @return an immutable list of the values of the specified fields; never {@code null} but may be
   *     empty or contain {@code null} entries
   */
  public static List<Object> readFieldValues(
      List<Field> fields, Object instance, Predicate<Field> predicate) {
    CoreUtils.checkNotNull(fields, "fields list must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    // @formatter:off
    return fields.stream()
        .filter(predicate)
        .map(
            field ->
                tryToReadFieldValue(field, instance)
                    .getOrThrow(ExceptionUtils::throwAsUncheckedException))
        .collect(CollectionUtils.toUnmodifiableList());
    // @formatter:on
  }

  public static Object invokeMethodArgs(Method method, Object target, Object... args) {
    CoreUtils.checkNotNull(method, "Method must not be null");
    CoreUtils.checkState(
        (target != null || isStatic(method)),
        "Cannot invoke non-static method [%s] on a null target.",
        method.toGenericString());

    try {
      return makeAccessibleObject(method).invoke(target, args);
    } catch (Throwable t) {
      throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t));
    }
  }

  public static Optional<Class<?>> loadClass(String name) {
    return tryToLoadClass(name).toOptional();
  }

  public static Try<Class<?>> tryToLoadClass(String name) {
    return tryToLoadClass(name, ClassLoaderUtils.getDefaultClassLoader());
  }

  public static Optional<Class<?>> loadClass(String name, ClassLoader classLoader) {
    return tryToLoadClass(name, classLoader).toOptional();
  }

  public static Try<Class<?>> tryToLoadClass(String name, ClassLoader classLoader) {
    CoreUtils.checkNotBlank(name, "Class name must not be null or blank");
    CoreUtils.checkNotNull(classLoader, "ClassLoader must not be null");
    String trimmedName = name.trim();

    if (classNameToTypeMap.containsKey(trimmedName)) {
      return Try.success(classNameToTypeMap.get(trimmedName));
    }

    return Try.call(
        () -> {
          Matcher matcher;

          // Primitive arrays such as "[I", "[[[[D", etc.
          matcher = VM_INTERNAL_PRIMITIVE_ARRAY_PATTERN.matcher(trimmedName);
          if (matcher.matches()) {
            String brackets = matcher.group(1);
            String componentTypeName = matcher.group(2);
            // Calculate dimensions by counting brackets.
            int dimensions = brackets.length();

            return loadArrayType(classLoader, componentTypeName, dimensions);
          }

          // Object arrays such as "[Ljava.lang.String;", "[[[[Ljava.lang.String;", etc.
          matcher = VM_INTERNAL_OBJECT_ARRAY_PATTERN.matcher(trimmedName);
          if (matcher.matches()) {
            String brackets = matcher.group(1);
            String componentTypeName = matcher.group(2);
            // Calculate dimensions by counting brackets.
            int dimensions = brackets.length();

            return loadArrayType(classLoader, componentTypeName, dimensions);
          }

          // Arrays such as "java.lang.String[]", "int[]", "int[][][][]", etc.
          matcher = SOURCE_CODE_SYNTAX_ARRAY_PATTERN.matcher(trimmedName);
          if (matcher.matches()) {
            String componentTypeName = matcher.group(1);
            String bracketPairs = matcher.group(2);
            // Calculate dimensions by counting bracket pairs.
            int dimensions = bracketPairs.length() / 2;

            return loadArrayType(classLoader, componentTypeName, dimensions);
          }

          // Fallback to standard VM class loading
          return classLoader.loadClass(trimmedName);
        });
  }

  private static Class<?> loadArrayType(
      ClassLoader classLoader, String componentTypeName, int dimensions)
      throws ClassNotFoundException {

    Class<?> componentType =
        classNameToTypeMap.containsKey(componentTypeName)
            ? classNameToTypeMap.get(componentTypeName)
            : classLoader.loadClass(componentTypeName);

    return Array.newInstance(componentType, new int[dimensions]).getClass();
  }

  /**
   * Build the <em>fully qualified method name</em> for the method described by the supplied class
   * and method.
   *
   * <p>Note that the class is not necessarily the class in which the method is declared.
   *
   * @param clazz the class from which the method should be referenced; never {@code null}
   * @param method the method; never {@code null}
   * @return fully qualified method name; never {@code null}
   * @since 1.4
   * @see #getFullyQualifiedMethodName(Class, String, Class...)
   */
  public static String getFullyQualifiedMethodName(Class<?> clazz, Method method) {
    CoreUtils.checkNotNull(method, "Method must not be null");

    return getFullyQualifiedMethodName(clazz, method.getName(), method.getParameterTypes());
  }

  /**
   * Build the <em>fully qualified method name</em> for the method described by the supplied class,
   * method name, and parameter types.
   *
   * <p>Note that the class is not necessarily the class in which the method is declared.
   *
   * @param clazz the class from which the method should be referenced; never {@code null}
   * @param methodName the name of the method; never {@code null} or blank
   * @param parameterTypes the parameter types of the method; may be {@code null} or empty
   * @return fully qualified method name; never {@code null}
   * @see #getFullyQualifiedMethodName(Class, Method)
   */
  public static String getFullyQualifiedMethodName(
      Class<?> clazz, String methodName, Class<?>... parameterTypes) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotBlank(methodName, "Method name must not be null or blank");

    return String.format(
        "%s#%s(%s)", clazz.getName(), methodName, ClassUtils.nullSafeToString(parameterTypes));
  }

  /**
   * Parse the supplied <em>fully qualified method name</em> into a 3-element {@code String[]} with
   * the following content.
   *
   * <ul>
   *   <li>index {@code 0}: the fully qualified class name
   *   <li>index {@code 1}: the name of the method
   *   <li>index {@code 2}: a comma-separated list of parameter types, or a blank string if the
   *       method does not declare any formal parameters
   * </ul>
   *
   * @param fullyQualifiedMethodName a <em>fully qualified method name</em>, never {@code null} or
   *     blank
   * @return a 3-element array of strings containing the parsed values
   */
  public static String[] parseFullyQualifiedMethodName(String fullyQualifiedMethodName) {
    CoreUtils.checkNotBlank(
        fullyQualifiedMethodName, "fullyQualifiedMethodName must not be null or blank");

    int indexOfFirstHashtag = fullyQualifiedMethodName.indexOf('#');
    boolean validSyntax =
        (indexOfFirstHashtag > 0) && (indexOfFirstHashtag < fullyQualifiedMethodName.length() - 1);

    CoreUtils.checkState(
        validSyntax,
        "["
            + fullyQualifiedMethodName
            + "] is not a valid fully qualified method name: "
            + "it must start with a fully qualified class name followed by a '#' "
            + "and then the method name, optionally followed by a parameter list enclosed in parentheses.");

    String className = fullyQualifiedMethodName.substring(0, indexOfFirstHashtag);
    String methodPart = fullyQualifiedMethodName.substring(indexOfFirstHashtag + 1);
    String methodName = methodPart;
    String methodParameters = "";

    if (methodPart.endsWith("()")) {
      methodName = methodPart.substring(0, methodPart.length() - 2);
    } else if (methodPart.endsWith(")")) {
      int indexOfLastOpeningParenthesis = methodPart.lastIndexOf('(');
      if ((indexOfLastOpeningParenthesis > 0)
          && (indexOfLastOpeningParenthesis < methodPart.length() - 1)) {
        methodName = methodPart.substring(0, indexOfLastOpeningParenthesis);
        methodParameters =
            methodPart.substring(indexOfLastOpeningParenthesis + 1, methodPart.length() - 1);
      }
    }
    return new String[] {className, methodName, methodParameters};
  }

  public static Optional<Object> getOutermostInstance(Object inner, Class<?> requiredType) {
    CoreUtils.checkNotNull(inner, "inner object must not be null");
    CoreUtils.checkNotNull(requiredType, "requiredType must not be null");

    if (requiredType.isInstance(inner)) {
      return Optional.of(inner);
    }

    Optional<Object> candidate = getOuterInstance(inner);
    if (candidate.isPresent()) {
      return getOutermostInstance(candidate.get(), requiredType);
    }

    return Optional.empty();
  }

  private static Optional<Object> getOuterInstance(Object inner) {
    // This is risky since it depends on the name of the field which is nowhere guaranteed
    // but has been stable so far in all JDKs

    // @formatter:off
    return Arrays.stream(inner.getClass().getDeclaredFields())
        .filter(field -> field.getName().startsWith("this$"))
        .findFirst()
        .map(
            field -> {
              try {
                return makeAccessibleObject(field).get(inner);
              } catch (Throwable t) {
                throw ExceptionUtils.throwAsUncheckedException(t);
              }
            });
    // @formatter:on
  }

  public static Set<Path> getAllClasspathRootDirectories() {
    // This is quite a hack, since sometimes the classpath is quite different
    String fullClassPath = System.getProperty("java.class.path");
    // @formatter:off
    return Arrays.stream(fullClassPath.split(File.pathSeparator))
        .map(Paths::get)
        .filter(Files::isDirectory)
        .collect(toSet());
    // @formatter:on
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findAllClassesInClasspathRoot(URI,
   *     Predicate, Predicate)
   */
  public static List<Class<?>> findAllClassesInClasspathRoot(
      URI root, Predicate<Class<?>> classFilter, Predicate<String> classNameFilter) {
    // unmodifiable since returned by public, non-internal method(s)
    return findAllClassesInClasspathRoot(root, ClassFilter.of(classNameFilter, classFilter));
  }

  /**
   * @since 1.1
   */
  public static List<Class<?>> findAllClassesInClasspathRoot(URI root, ClassFilter classFilter) {
    return Collections.unmodifiableList(
        classpathScanner.scanForClassesInClasspathRoot(root, classFilter));
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findAllClassesInPackage(String,
   *     Predicate, Predicate)
   */
  public static List<Class<?>> findAllClassesInPackage(
      String basePackageName, Predicate<Class<?>> classFilter, Predicate<String> classNameFilter) {
    // unmodifiable since returned by public, non-internal method(s)
    return findAllClassesInPackage(basePackageName, ClassFilter.of(classNameFilter, classFilter));
  }

  /**
   * @since 1.1
   */
  public static List<Class<?>> findAllClassesInPackage(
      String basePackageName, ClassFilter classFilter) {
    return Collections.unmodifiableList(
        classpathScanner.scanForClassesInPackage(basePackageName, classFilter));
  }

  /**
   * @since 1.1.1
   * @see org.junit.platform.commons.support.ReflectionSupport#findAllClassesInModule(String,
   *     Predicate, Predicate)
   */
  public static List<Class<?>> findAllClassesInModule(
      String moduleName, Predicate<Class<?>> classFilter, Predicate<String> classNameFilter) {
    // unmodifiable since returned by public, non-internal method(s)
    return findAllClassesInModule(moduleName, ClassFilter.of(classNameFilter, classFilter));
  }

  /**
   * @since 1.1.1
   */
  public static List<Class<?>> findAllClassesInModule(String moduleName, ClassFilter classFilter) {
    return Collections.unmodifiableList(
        ModuleUtils.findAllClassesInModule(moduleName, classFilter));
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findNestedClasses(Class, Predicate)
   */
  public static List<Class<?>> findNestedClasses(Class<?> clazz, Predicate<Class<?>> predicate) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    Set<Class<?>> candidates = new LinkedHashSet<>();
    findNestedClasses(clazz, predicate, candidates);
    return Collections.unmodifiableList(new ArrayList<>(candidates));
  }

  private static void findNestedClasses(
      Class<?> clazz, Predicate<Class<?>> predicate, Set<Class<?>> candidates) {
    if (!isSearchable(clazz)) {
      return;
    }

    if (isInnerClass(clazz) && predicate.test(clazz)) {
      detectInnerClassCycle(clazz);
    }

    try {
      // Candidates in current class
      for (Class<?> nestedClass : clazz.getDeclaredClasses()) {
        if (predicate.test(nestedClass)) {
          detectInnerClassCycle(nestedClass);
          candidates.add(nestedClass);
        }
      }
    } catch (NoClassDefFoundError error) {
      logger.debug("Failed to retrieve declared classes for {}", clazz.getName(), error);
    }

    // Search class hierarchy
    findNestedClasses(clazz.getSuperclass(), predicate, candidates);

    // Search interface hierarchy
    for (Class<?> ifc : clazz.getInterfaces()) {
      findNestedClasses(ifc, predicate, candidates);
    }
  }

  /**
   * Detect a cycle in the inner class hierarchy in which the supplied class resides &mdash; from
   * the supplied class up to the outermost enclosing class &mdash; and throw a {@link
   * RuntimeException} if a cycle is detected.
   *
   * <p>This method does <strong>not</strong> detect cycles within inner class hierarchies
   * <em>below</em> the supplied class.
   *
   * <p>If the supplied class is not an inner class and does not have a searchable superclass, this
   * method is effectively a no-op.
   *
   * @since 1.6
   * @see #isInnerClass(Class)
   * @see #isSearchable(Class)
   */
  private static void detectInnerClassCycle(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    String className = clazz.getName();

    if (noCyclesDetectedCache.contains(className)) {
      return;
    }

    Class<?> superclass = clazz.getSuperclass();
    if (isInnerClass(clazz) && isSearchable(superclass)) {
      for (Class<?> enclosing = clazz.getEnclosingClass();
          enclosing != null;
          enclosing = enclosing.getEnclosingClass()) {
        if (superclass.equals(enclosing)) {
          throw new RuntimeException(
              String.format(
                  "Detected cycle in inner class hierarchy between %s and %s",
                  className, enclosing.getName()));
        }
      }
    }

    noCyclesDetectedCache.add(className);
  }

  /**
   * Get the sole declared, non-synthetic {@link Constructor} for the supplied class.
   *
   * <p>Throws a {@link org.junit.platform.commons.PreconditionViolationException} if the supplied
   * class declares more than one non-synthetic constructor.
   *
   * @param clazz the class to get the constructor for
   * @return the sole declared constructor; never {@code null}
   * @see Class#getDeclaredConstructors()
   * @see Class#isSynthetic()
   */
  @SuppressWarnings("unchecked")
  public static <T> Constructor<T> getDeclaredConstructor(Class<T> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    try {
      List<Constructor<?>> constructors =
          Arrays.stream(clazz.getDeclaredConstructors()) //
              .filter(ctor -> !ctor.isSynthetic()) //
              .collect(toList());

      CoreUtils.checkState(
          constructors.size() == 1,
          String.format("Class [%s] must declare a single constructor", clazz.getName()));
      return (Constructor<T>) constructors.get(0);
    } catch (Throwable t) {
      throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t));
    }
  }

  /**
   * Find all constructors in the supplied class that match the supplied predicate.
   *
   * <p>Note that this method may return {@linkplain Class#isSynthetic() synthetic} constructors. If
   * you wish to ignore synthetic constructors, you may filter them out with the supplied {@code
   * predicate} or filter them out of the list returned by this method.
   *
   * @param clazz the class in which to search for constructors; never {@code null}
   * @param predicate the predicate to use to test for a match; never {@code null}
   * @return an immutable list of all such constructors found; never {@code null} but potentially
   *     empty
   * @see Class#getDeclaredConstructors()
   * @see Class#isSynthetic()
   */
  public static List<Constructor<?>> findConstructors(
      Class<?> clazz, Predicate<Constructor<?>> predicate) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    try {
      // @formatter:off
      return Arrays.stream(clazz.getDeclaredConstructors())
          .filter(predicate)
          .collect(CollectionUtils.toUnmodifiableList());
      // @formatter:on
    } catch (Throwable t) {
      throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t));
    }
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findFields(Class, Predicate,
   *     org.junit.platform.commons.support.HierarchyTraversalMode)
   */
  public static List<Field> findFields(
      Class<?> clazz, Predicate<Field> predicate, HierarchyTraversalMode traversalMode) {

    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");
    CoreUtils.checkNotNull(traversalMode, "HierarchyTraversalMode must not be null");

    return findAllFieldsInHierarchy(clazz, traversalMode).stream()
        .filter(predicate)
        // unmodifiable since returned by public, non-internal method(s)
        .collect(CollectionUtils.toUnmodifiableList());
  }

  private static List<Field> findAllFieldsInHierarchy(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(traversalMode, "HierarchyTraversalMode must not be null");

    List<Field> localFields =
        Arrays.asList(getDeclaredFields(clazz)).stream()
            .filter(field -> !field.isSynthetic())
            .collect(toList());
    List<Field> superclassFields =
        getSuperclassFields(clazz, traversalMode).stream()
            .filter(field -> !isFieldShadowedByLocalFields(field, localFields))
            .collect(toList());
    List<Field> interfaceFields =
        getInterfaceFields(clazz, traversalMode).stream()
            .filter(field -> !isFieldShadowedByLocalFields(field, localFields))
            .collect(toList());

    List<Field> fields = new ArrayList<>();
    if (traversalMode == HierarchyTraversalMode.TOP_DOWN) {
      fields.addAll(superclassFields);
      fields.addAll(interfaceFields);
    }
    fields.addAll(localFields);
    if (traversalMode == HierarchyTraversalMode.BOTTOM_UP) {
      fields.addAll(interfaceFields);
      fields.addAll(superclassFields);
    }
    return fields;
  }

  /**
   * Determine if a {@link Method} matching the supplied {@link Predicate} is present within the
   * type hierarchy of the specified class, beginning with the specified class or interface and
   * traversing up the type hierarchy until such a method is found or the type hierarchy is
   * exhausted.
   *
   * @param clazz the class or interface in which to find the method; never {@code null}
   * @param predicate the predicate to use to test for a match; never {@code null}
   * @return {@code true} if such a method is present
   * @see #findMethod(Class, String, String)
   * @see #findMethod(Class, String, Class...)
   */
  public static boolean isMethodPresent(Class<?> clazz, Predicate<Method> predicate) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    return findMethod(clazz, predicate).isPresent();
  }

  static Optional<Method> getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
    return tryToGetMethod(clazz, methodName, parameterTypes).toOptional();
  }

  public static Try<Method> tryToGetMethod(
      Class<?> clazz, String methodName, Class<?>... parameterTypes) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotBlank(methodName, "Method name must not be null or blank");

    return Try.call(() -> clazz.getMethod(methodName, parameterTypes));
  }

  public static Optional<Method> findMethod(
      Class<?> clazz, String methodName, String parameterTypeNames) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotBlank(methodName, "Method name must not be null or blank");
    return findMethodOptional(
        clazz, methodName, resolveParameterTypes(clazz, methodName, parameterTypeNames));
  }

  private static Class<?>[] resolveParameterTypes(
      Class<?> clazz, String methodName, String parameterTypeNames) {
    if (StringUtils.isBlank(parameterTypeNames)) {
      return EMPTY_CLASS_ARRAY;
    }

    return Arrays.stream(parameterTypeNames.split(","))
        .map(String::trim)
        .map(typeName -> loadRequiredParameterType(clazz, methodName, typeName))
        .toArray(Class[]::new);
  }

  private static Class<?> loadRequiredParameterType(
      Class<?> clazz, String methodName, String typeName) {
    return tryToLoadClass(typeName)
        .getOrThrow(
            cause ->
                new RuntimeException(
                    String.format(
                        "Failed to load parameter type [%s] for method [%s] in class [%s].",
                        typeName, methodName, clazz.getName()),
                    cause));
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findMethod(Class, String, Class...)
   */
  public static Optional<Method> findMethodOptional(
      Class<?> clazz, String methodName, Class<?>... parameterTypes) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkState(CoreUtils.isNotBlank(methodName), "Method name must not be null or blank");
    CoreUtils.checkNotNull(parameterTypes, "Parameter types array must not be null");
    CoreUtils.checkContainsNoNullElements(
        parameterTypes, "Individual parameter types must not be null");

    return findMethod(clazz, method -> hasCompatibleSignature(method, methodName, parameterTypes));
  }

  private static Optional<Method> findMethod(Class<?> clazz, Predicate<Method> predicate) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    for (Class<?> current = clazz; isSearchable(current); current = current.getSuperclass()) {
      // Search for match in current type
      List<Method> methods =
          current.isInterface()
              ? getMethods(current)
              : getDeclaredMethods(current, HierarchyTraversalMode.BOTTOM_UP);
      for (Method method : methods) {
        if (predicate.test(method)) {
          return Optional.of(method);
        }
      }

      // Search for match in interfaces implemented by current type
      for (Class<?> ifc : current.getInterfaces()) {
        Optional<Method> optional = findMethod(ifc, predicate);
        if (optional.isPresent()) {
          return optional;
        }
      }
    }

    return Optional.empty();
  }

  /**
   * Find the first {@link Method} of the supplied class or interface that meets the specified
   * criteria, beginning with the specified class or interface and traversing up the type hierarchy
   * until such a method is found or the type hierarchy is exhausted.
   *
   * <p>Use this method as an alternative to {@link #findMethod(Class, String, Class...)} for use
   * cases in which the method is required to be present.
   *
   * @param clazz the class or interface in which to find the method; never {@code null}
   * @param methodName the name of the method to find; never {@code null} or empty
   * @param parameterTypes the types of parameters accepted by the method, if any; never {@code
   *     null}
   * @return the {@code Method} found; never {@code null}
   * @throws RuntimeException if no method is found
   * @since 1.7
   * @see #findMethod(Class, String, Class...)
   */
  public static Method getRequiredMethod(
      Class<?> clazz, String methodName, Class<?>... parameterTypes) {
    return ReflectionUtils.findMethodOptional(clazz, methodName, parameterTypes)
        .orElseThrow(
            () ->
                new RuntimeException(
                    format(
                        "Could not find method [%s] in class [%s]", methodName, clazz.getName())));
  }

  /**
   * Find all {@linkplain Method methods} of the supplied class or interface that match the
   * specified {@code predicate}, using top-down search semantics within the type hierarchy.
   *
   * <p>The results will not contain instance methods that are <em>overridden</em> or {@code static}
   * methods that are <em>hidden</em>.
   *
   * @param clazz the class or interface in which to find the methods; never {@code null}
   * @param predicate the method filter; never {@code null}
   * @return an immutable list of all such methods found; never {@code null}
   * @see HierarchyTraversalMode#TOP_DOWN
   * @see #findMethods(Class, Predicate, HierarchyTraversalMode)
   */
  public static List<Method> findMethods(Class<?> clazz, Predicate<Method> predicate) {
    return findMethods(clazz, predicate, HierarchyTraversalMode.TOP_DOWN);
  }

  /**
   * @see org.junit.platform.commons.support.ReflectionSupport#findMethods(Class, Predicate,
   *     org.junit.platform.commons.support.HierarchyTraversalMode)
   */
  public static List<Method> findMethods(
      Class<?> clazz, Predicate<Method> predicate, HierarchyTraversalMode traversalMode) {

    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");
    CoreUtils.checkNotNull(traversalMode, "HierarchyTraversalMode must not be null");

    // @formatter:off
    return findAllMethodsInHierarchy(clazz, traversalMode).stream()
        .filter(predicate)
        // unmodifiable since returned by public, non-internal method(s)
        .collect(CollectionUtils.toUnmodifiableList());
    // @formatter:on
  }

  /** Find all non-synthetic methods in the superclass and interface hierarchy, excluding Object. */
  private static List<Method> findAllMethodsInHierarchy(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(traversalMode, "HierarchyTraversalMode must not be null");

    // @formatter:off
    List<Method> localMethods =
        getDeclaredMethods(clazz, traversalMode).stream()
            .filter(method -> !method.isSynthetic())
            .collect(toList());
    List<Method> superclassMethods =
        getSuperclassMethods(clazz, traversalMode).stream()
            .filter(method -> !isMethodShadowedByLocalMethods(method, localMethods))
            .collect(toList());
    List<Method> interfaceMethods =
        getInterfaceMethods(clazz, traversalMode).stream()
            .filter(method -> !isMethodShadowedByLocalMethods(method, localMethods))
            .collect(toList());
    // @formatter:on

    List<Method> methods = new ArrayList<>();
    if (traversalMode == HierarchyTraversalMode.TOP_DOWN) {
      methods.addAll(superclassMethods);
      methods.addAll(interfaceMethods);
    }
    methods.addAll(localMethods);
    if (traversalMode == HierarchyTraversalMode.BOTTOM_UP) {
      methods.addAll(interfaceMethods);
      methods.addAll(superclassMethods);
    }
    return methods;
  }

  /**
   * Custom alternative to {@link Class#getFields()} that sorts the fields and converts them to a
   * mutable list.
   */
  private static List<Field> getFields(Class<?> clazz) {
    return toSortedMutableList(clazz.getFields());
  }

  /**
   * Custom alternative to {@link Class#getMethods()} that sorts the methods and converts them to a
   * mutable list.
   */
  private static List<Method> getMethods(Class<?> clazz) {
    return toSortedMutableList(clazz.getMethods());
  }

  /**
   * Custom alternative to {@link Class#getDeclaredMethods()} that sorts the methods and converts
   * them to a mutable list.
   *
   * <p>In addition, the list returned by this method includes interface default methods which are
   * either prepended or appended to the list of declared methods depending on the supplied
   * traversal mode.
   */
  private static List<Method> getDeclaredMethods(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    // Note: getDefaultMethods() already sorts the methods,
    List<Method> defaultMethods = getDefaultMethods(clazz);
    List<Method> declaredMethods = toSortedMutableList(clazz.getDeclaredMethods());

    // Take the traversal mode into account in order to retain the inherited
    // nature of interface default methods.
    if (traversalMode == HierarchyTraversalMode.BOTTOM_UP) {
      declaredMethods.addAll(defaultMethods);
      return declaredMethods;
    } else {
      defaultMethods.addAll(declaredMethods);
      return defaultMethods;
    }
  }

  /**
   * Get a sorted, mutable list of all default methods present in interfaces implemented by the
   * supplied class which are also <em>visible</em> within the supplied class.
   *
   * @see <a href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-6.html#d5e9652">Method
   *     Visibility</a> in the Java Language Specification
   */
  private static List<Method> getDefaultMethods(Class<?> clazz) {
    // @formatter:off
    // Visible default methods are interface default methods that have not
    // been overridden.
    List<Method> visibleDefaultMethods =
        Arrays.stream(clazz.getMethods())
            .filter(Method::isDefault)
            .collect(toCollection(ArrayList::new));
    if (visibleDefaultMethods.isEmpty()) {
      return visibleDefaultMethods;
    }
    return Arrays.stream(clazz.getInterfaces())
        .map(ReflectionUtils::getMethods)
        .flatMap(List::stream)
        .filter(visibleDefaultMethods::contains)
        .collect(toCollection(ArrayList::new));
    // @formatter:on
  }

  private static List<Field> toSortedMutableList(Field[] fields) {
    // @formatter:off
    return Arrays.stream(fields)
        .sorted(ReflectionUtils::defaultFieldSorter)
        // Use toCollection() instead of toList() to ensure list is mutable.
        .collect(toCollection(ArrayList::new));
    // @formatter:on
  }

  private static List<Method> toSortedMutableList(Method[] methods) {
    // @formatter:off
    return Arrays.stream(methods)
        .sorted(ReflectionUtils::defaultMethodSorter)
        // Use toCollection() instead of toList() to ensure list is mutable.
        .collect(toCollection(ArrayList::new));
    // @formatter:on
  }

  /**
   * Field comparator inspired by JUnit 4's {@code org.junit.internal.MethodSorter} implementation.
   */
  private static int defaultFieldSorter(Field field1, Field field2) {
    return Integer.compare(field1.getName().hashCode(), field2.getName().hashCode());
  }

  /**
   * Method comparator based upon JUnit 4's {@code org.junit.internal.MethodSorter} implementation.
   */
  private static int defaultMethodSorter(Method method1, Method method2) {
    String name1 = method1.getName();
    String name2 = method2.getName();
    int comparison = Integer.compare(name1.hashCode(), name2.hashCode());
    if (comparison == 0) {
      comparison = name1.compareTo(name2);
      if (comparison == 0) {
        comparison = method1.toString().compareTo(method2.toString());
      }
    }
    return comparison;
  }

  private static List<Method> getInterfaceMethods(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    List<Method> allInterfaceMethods = new ArrayList<>();
    for (Class<?> ifc : clazz.getInterfaces()) {

      // @formatter:off
      List<Method> localInterfaceMethods =
          getMethods(ifc).stream().filter(m -> !isAbstract(m)).collect(toList());

      List<Method> superinterfaceMethods =
          getInterfaceMethods(ifc, traversalMode).stream()
              .filter(method -> !isMethodShadowedByLocalMethods(method, localInterfaceMethods))
              .collect(toList());
      // @formatter:on

      if (traversalMode == HierarchyTraversalMode.TOP_DOWN) {
        allInterfaceMethods.addAll(superinterfaceMethods);
      }
      allInterfaceMethods.addAll(localInterfaceMethods);
      if (traversalMode == HierarchyTraversalMode.BOTTOM_UP) {
        allInterfaceMethods.addAll(superinterfaceMethods);
      }
    }
    return allInterfaceMethods;
  }

  private static List<Field> getInterfaceFields(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    List<Field> allInterfaceFields = new ArrayList<>();
    for (Class<?> ifc : clazz.getInterfaces()) {
      List<Field> localInterfaceFields = getFields(ifc);

      // @formatter:off
      List<Field> superinterfaceFields =
          getInterfaceFields(ifc, traversalMode).stream()
              .filter(field -> !isFieldShadowedByLocalFields(field, localInterfaceFields))
              .collect(toList());
      // @formatter:on

      if (traversalMode == HierarchyTraversalMode.TOP_DOWN) {
        allInterfaceFields.addAll(superinterfaceFields);
      }
      allInterfaceFields.addAll(localInterfaceFields);
      if (traversalMode == HierarchyTraversalMode.BOTTOM_UP) {
        allInterfaceFields.addAll(superinterfaceFields);
      }
    }
    return allInterfaceFields;
  }

  private static List<Field> getSuperclassFields(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    Class<?> superclass = clazz.getSuperclass();
    if (!isSearchable(superclass)) {
      return Collections.emptyList();
    }
    return findAllFieldsInHierarchy(superclass, traversalMode);
  }

  private static boolean isFieldShadowedByLocalFields(Field field, List<Field> localFields) {
    return localFields.stream().anyMatch(local -> local.getName().equals(field.getName()));
  }

  private static List<Method> getSuperclassMethods(
      Class<?> clazz, HierarchyTraversalMode traversalMode) {
    Class<?> superclass = clazz.getSuperclass();
    if (!isSearchable(superclass)) {
      return Collections.emptyList();
    }
    return findAllMethodsInHierarchy(superclass, traversalMode);
  }

  private static boolean isMethodShadowedByLocalMethods(Method method, List<Method> localMethods) {
    return localMethods.stream().anyMatch(local -> isMethodShadowedBy(method, local));
  }

  private static boolean isMethodShadowedBy(Method upper, Method lower) {
    return hasCompatibleSignature(upper, lower.getName(), lower.getParameterTypes());
  }

  /**
   * Determine if the supplied candidate method (typically a method higher in the type hierarchy)
   * has a signature that is compatible with a method that has the supplied name and parameter
   * types, taking method sub-signatures and generics into account.
   */
  private static boolean hasCompatibleSignature(
      Method candidate, String methodName, Class<?>[] parameterTypes) {
    if (!methodName.equals(candidate.getName())) {
      return false;
    }
    if (parameterTypes.length != candidate.getParameterCount()) {
      return false;
    }
    // trivial case: parameter types exactly match
    if (Arrays.equals(parameterTypes, candidate.getParameterTypes())) {
      return true;
    }
    // param count is equal, but types do not match exactly: check for method sub-signatures
    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.2
    for (int i = 0; i < parameterTypes.length; i++) {
      Class<?> lowerType = parameterTypes[i];
      Class<?> upperType = candidate.getParameterTypes()[i];
      if (!upperType.isAssignableFrom(lowerType)) {
        return false;
      }
    }
    // lower is sub-signature of upper: check for generics in upper method
    if (isGeneric(candidate)) {
      return true;
    }
    return false;
  }

  static boolean isGeneric(Method method) {
    return isGeneric(method.getGenericReturnType())
        || Arrays.stream(method.getGenericParameterTypes()).anyMatch(ReflectionUtils::isGeneric);
  }

  private static boolean isGeneric(Type type) {
    return type instanceof TypeVariable || type instanceof GenericArrayType;
  }

  @SuppressWarnings("deprecation") // "AccessibleObject.isAccessible()" is deprecated in Java 9
  public static <T extends AccessibleObject> T makeAccessibleObject(T object) {
    if (!object.isAccessible()) {
      object.setAccessible(true);
    }
    return object;
  }

  /**
   * Return all classes and interfaces that can be used as assignment types for instances of the
   * specified {@link Class}, including itself.
   *
   * @param clazz the {@code Class} to look up
   * @see Class#isAssignableFrom
   */
  public static Set<Class<?>> getAllAssignmentCompatibleClasses(Class<?> clazz) {
    CoreUtils.checkNotNull(clazz, "Class must not be null");

    Set<Class<?>> result = new LinkedHashSet<>();
    getAllAssignmentCompatibleClasses(clazz, result);
    return result;
  }

  private static void getAllAssignmentCompatibleClasses(Class<?> clazz, Set<Class<?>> result) {
    for (Class<?> current = clazz; current != null; current = current.getSuperclass()) {
      result.add(current);
      for (Class<?> interfaceClass : current.getInterfaces()) {
        if (!result.contains(interfaceClass)) {
          getAllAssignmentCompatibleClasses(interfaceClass, result);
        }
      }
    }
  }

  /**
   * Determine if the supplied class is <em>searchable</em>: is non-null and is not equal to the
   * class reference for {@code java.lang.Object}.
   *
   * <p>This method is often used to determine if a superclass should be searched but may be
   * applicable for other use cases as well.
   *
   * @since 1.6
   */
  private static boolean isSearchable(Class<?> clazz) {
    return (clazz != null && clazz != Object.class);
  }

  /**
   * Get the underlying cause of the supplied {@link Throwable}.
   *
   * <p>If the supplied {@code Throwable} is an instance of {@link InvocationTargetException}, this
   * method will be invoked recursively with the underlying {@linkplain
   * InvocationTargetException#getTargetException() target exception}; otherwise, this method
   * returns the supplied {@code Throwable}.
   */
  private static Throwable getUnderlyingCause(Throwable t) {
    if (t instanceof InvocationTargetException) {
      return getUnderlyingCause(((InvocationTargetException) t).getTargetException());
    }
    return t;
  }
}
