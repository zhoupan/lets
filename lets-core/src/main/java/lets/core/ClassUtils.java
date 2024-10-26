/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

import java.beans.Introspector;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import lets.core.collections.CollectionUtils;

/**
 * Operates on classes without using reflection.
 *
 * <p>This class handles invalid {@code null} inputs as best it can. Each method documents its
 * behavior in more detail.
 *
 * <p>The notion of a {@code canonical name} includes the human readable name for the type, for
 * example {@code int[]}. The non-canonical method variants work with the JVM names, such as {@code
 * [I}.
 *
 * @since 2.0
 */
public class ClassUtils {

  /** Suffix for array class names: "[]" */
  public static final String ARRAY_SUFFIX = "[]";

  /** Prefix for internal array class names: "[" */
  private static final String INTERNAL_ARRAY_PREFIX = "[";

  /** Prefix for internal non-primitive array class names: "[L" */
  private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";

  /** The path separator character: '/' */
  private static final char PATH_SEPARATOR_CHAR = '/';

  /** The CGLIB class separator: "$$" */
  public static final String CGLIB_CLASS_SEPARATOR = "$$";

  /** The ".class" file suffix */
  public static final String CLASS_FILE_SUFFIX = ".class";

  /**
   * Map with primitive wrapper type as key and corresponding primitive type as value, for example:
   * Integer.class -> int.class.
   */
  private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap =
      new IdentityHashMap<Class<?>, Class<?>>(8);

  /**
   * Map with primitive type as key and corresponding wrapper type as value, for example: int.class
   * -> Integer.class.
   */
  private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap =
      new IdentityHashMap<Class<?>, Class<?>>(8);

  /**
   * Map with primitive type name as key and corresponding primitive type as value, for example:
   * "int" -> "int.class".
   */
  private static final Map<String, Class<?>> primitiveTypeNameMap =
      new HashMap<String, Class<?>>(32);

  /**
   * Map with common "java.lang" class name as key and corresponding Class as value. Primarily for
   * efficient deserialization of remote invocations.
   */
  private static final Map<String, Class<?>> commonClassCache = new HashMap<String, Class<?>>(32);

  static {
    primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
    primitiveWrapperTypeMap.put(Byte.class, byte.class);
    primitiveWrapperTypeMap.put(Character.class, char.class);
    primitiveWrapperTypeMap.put(Double.class, double.class);
    primitiveWrapperTypeMap.put(Float.class, float.class);
    primitiveWrapperTypeMap.put(Integer.class, int.class);
    primitiveWrapperTypeMap.put(Long.class, long.class);
    primitiveWrapperTypeMap.put(Short.class, short.class);

    for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperTypeMap.entrySet()) {
      primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
      registerCommonClasses(entry.getKey());
    }

    Set<Class<?>> primitiveTypes = new HashSet<Class<?>>(64);
    primitiveTypes.addAll(primitiveWrapperTypeMap.values());
    primitiveTypes.addAll(
        Arrays.asList(
            new Class<?>[] {
              boolean[].class, byte[].class, char[].class, double[].class,
              float[].class, int[].class, long[].class, short[].class
            }));
    primitiveTypes.add(void.class);
    for (Class<?> primitiveType : primitiveTypes) {
      primitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
    }

    registerCommonClasses(
        Boolean[].class,
        Byte[].class,
        Character[].class,
        Double[].class,
        Float[].class,
        Integer[].class,
        Long[].class,
        Short[].class);
    registerCommonClasses(
        Number.class,
        Number[].class,
        String.class,
        String[].class,
        Class.class,
        Class[].class,
        Object.class,
        Object[].class);
    registerCommonClasses(
        Throwable.class,
        Exception.class,
        RuntimeException.class,
        Error.class,
        StackTraceElement.class,
        StackTraceElement[].class);
    registerCommonClasses(Enum.class, Iterable.class, Cloneable.class, Comparable.class);
  }

  /** Register the given common classes with the ClassUtils cache. */
  private static void registerCommonClasses(Class<?>... commonClasses) {
    for (Class<?> clazz : commonClasses) {
      commonClassCache.put(clazz.getName(), clazz);
    }
  }

  /**
   * Inclusivity literals for {@link #hierarchy(Class, Interfaces)}.
   *
   * @since 3.2
   */
  public enum Interfaces {

    /** Includes interfaces. */
    INCLUDE,

    /** Excludes interfaces. */
    EXCLUDE
  }

  /** The package separator character: {@code '&#x2e;' == {@value}}. */
  public static final char PACKAGE_SEPARATOR_CHAR = '.';

  /** The package separator String: {@code "&#x2e;"}. */
  public static final String PACKAGE_SEPARATOR = String.valueOf(PACKAGE_SEPARATOR_CHAR);

  /** The inner class separator character: {@code '$' == {@value}}. */
  public static final char INNER_CLASS_SEPARATOR_CHAR = '$';

  /** The inner class separator String: {@code "$"}. */
  public static final String INNER_CLASS_SEPARATOR = String.valueOf(INNER_CLASS_SEPARATOR_CHAR);

  /** Maps names of primitives to their corresponding primitive {@code Class}es. */
  private static final Map<String, Class<?>> namePrimitiveMap = new HashMap<>();

  static {
    namePrimitiveMap.put("boolean", Boolean.TYPE);
    namePrimitiveMap.put("byte", Byte.TYPE);
    namePrimitiveMap.put("char", Character.TYPE);
    namePrimitiveMap.put("short", Short.TYPE);
    namePrimitiveMap.put("int", Integer.TYPE);
    namePrimitiveMap.put("long", Long.TYPE);
    namePrimitiveMap.put("double", Double.TYPE);
    namePrimitiveMap.put("float", Float.TYPE);
    namePrimitiveMap.put("void", Void.TYPE);
  }

  /** Maps primitive {@code Class}es to their corresponding wrapper {@code Class}. */
  private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<>();

  static {
    primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
    primitiveWrapperMap.put(Byte.TYPE, Byte.class);
    primitiveWrapperMap.put(Character.TYPE, Character.class);
    primitiveWrapperMap.put(Short.TYPE, Short.class);
    primitiveWrapperMap.put(Integer.TYPE, Integer.class);
    primitiveWrapperMap.put(Long.TYPE, Long.class);
    primitiveWrapperMap.put(Double.TYPE, Double.class);
    primitiveWrapperMap.put(Float.TYPE, Float.class);
    primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
  }

  /** Maps wrapper {@code Class}es to their corresponding primitive types. */
  private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();

  static {
    for (final Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
      final Class<?> primitiveClass = entry.getKey();
      final Class<?> wrapperClass = entry.getValue();
      if (!primitiveClass.equals(wrapperClass)) {
        wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
      }
    }
  }

  /** Maps a primitive class name to its corresponding abbreviation used in array class names. */
  private static final Map<String, String> abbreviationMap;

  /** Maps an abbreviation used in array class names to corresponding primitive class name. */
  private static final Map<String, String> reverseAbbreviationMap;

  // Feed abbreviation maps
  static {
    final Map<String, String> m = new HashMap<>();
    m.put("int", "I");
    m.put("boolean", "Z");
    m.put("float", "F");
    m.put("long", "J");
    m.put("short", "S");
    m.put("byte", "B");
    m.put("double", "D");
    m.put("char", "C");
    final Map<String, String> r = new HashMap<>();
    for (final Map.Entry<String, String> e : m.entrySet()) {
      r.put(e.getValue(), e.getKey());
    }
    abbreviationMap = Collections.unmodifiableMap(m);
    reverseAbbreviationMap = Collections.unmodifiableMap(r);
  }

  /**
   * ClassUtils instances should NOT be constructed in standard programming. Instead, the class
   * should be used as {@code ClassUtils.getShortClassName(cls)}.
   *
   * <p>This constructor is public to permit tools that require a JavaBean instance to operate.
   */
  public ClassUtils() {
    super();
  }

  // Short class name
  // ----------------------------------------------------------------------
  /**
   * Gets the class name of the {@code object} without the package name or names.
   *
   * <p>The method looks up the class of the object and then converts the name of the class invoking
   * {@link #getShortClassName(Class)} (see relevant notes there).
   *
   * @param object the class to get the short name for, may be {@code null}
   * @param valueIfNull the value to return if the object is {@code null}
   * @return the class name of the object without the package name, or {@code valueIfNull} if the
   *     argument {@code object} is {@code null}
   */
  public static String getShortClassName(final Object object, final String valueIfNull) {
    if (object == null) {
      return valueIfNull;
    }
    return getShortClassName(object.getClass());
  }

  /**
   * Gets the class name minus the package name from a {@code Class}.
   *
   * <p>This method simply gets the name using {@code Class.getName()} and then calls {@link
   * #getShortClassName(Class)}. See relevant notes there.
   *
   * @param cls the class to get the short name for.
   * @return the class name without the package name or an empty string. If the class is an inner
   *     class then the returned value will contain the outer class or classes separated with {@code
   *     .} (dot) character.
   */
  public static String getShortClassName(final Class<?> cls) {
    if (cls == null) {
      return StringUtils.EMPTY;
    }
    return getShortClassName(cls.getName());
  }

  /**
   * Gets the class name minus the package name from a String.
   *
   * <p>The string passed in is assumed to be a class name - it is not checked. The string has to be
   * formatted the way as the JDK method {@code Class.getName()} returns it, and not the usual way
   * as we write it, for example in import statements, or as it is formatted by {@code
   * Class.getCanonicalName()}.
   *
   * <p>The difference is is significant only in case of classes that are inner classes of some
   * other classes. In this case the separator between the outer and inner class (possibly on
   * multiple hierarchy level) has to be {@code $} (dollar sign) and not {@code .} (dot), as it is
   * returned by {@code Class.getName()}
   *
   * <p>Note that this method is called from the {@link #getShortClassName(Class)} method using the
   * string returned by {@code Class.getName()}.
   *
   * <p>Note that this method differs from {@link #getSimpleName(Class)} in that this will return,
   * for example {@code "Map.Entry"} whilst the {@code java.lang.Class} variant will simply return
   * {@code "Entry"}. In this example the argument {@code className} is the string {@code
   * java.util.Map$Entry} (note the {@code $} sign.
   *
   * @param className the className to get the short name for. It has to be formatted as returned by
   *     {@code Class.getName()} and not {@code Class.getCanonicalName()}
   * @return the class name of the class without the package name or an empty string. If the class
   *     is an inner class then value contains the outer class or classes and the separator is
   *     replaced to be {@code .} (dot) character.
   */
  public static String getShortClassName(String className) {
    if (StringUtils.isEmpty(className)) {
      return StringUtils.EMPTY;
    }

    final StringBuilder arrayPrefix = new StringBuilder();

    // Handle array encoding
    if (className.startsWith("[")) {
      while (className.charAt(0) == '[') {
        className = className.substring(1);
        arrayPrefix.append("[]");
      }
      // Strip Object type encoding
      if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
        className = className.substring(1, className.length() - 1);
      }

      if (reverseAbbreviationMap.containsKey(className)) {
        className = reverseAbbreviationMap.get(className);
      }
    }

    final int lastDotIdx = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
    final int innerIdx =
        className.indexOf(INNER_CLASS_SEPARATOR_CHAR, lastDotIdx == -1 ? 0 : lastDotIdx + 1);
    String out = className.substring(lastDotIdx + 1);
    if (innerIdx != -1) {
      out = out.replace(INNER_CLASS_SEPARATOR_CHAR, PACKAGE_SEPARATOR_CHAR);
    }
    return out + arrayPrefix;
  }

  /**
   * Null-safe version of {@code cls.getSimpleName()}
   *
   * @param cls the class for which to get the simple name; may be null
   * @return the simple class name or the empty string in case the argument is {@code null}
   * @since 3.0
   * @see Class#getSimpleName()
   */
  public static String getSimpleName(final Class<?> cls) {
    return getSimpleName(cls, StringUtils.EMPTY);
  }

  /**
   * Null-safe version of {@code cls.getSimpleName()}
   *
   * @param cls the class for which to get the simple name; may be null
   * @param valueIfNull the value to return if null
   * @return the simple class name or {@code valueIfNull} if the argument {@code cls} is {@code
   *     null}
   * @since 3.0
   * @see Class#getSimpleName()
   */
  public static String getSimpleName(final Class<?> cls, final String valueIfNull) {
    return cls == null ? valueIfNull : cls.getSimpleName();
  }

  /**
   * Null-safe version of {@code object.getClass().getSimpleName()}
   *
   * <p>It is to note that this method is overloaded and in case the argument {@code object} is a
   * {@code Class} object then the {@link #getSimpleName(Class)} will be invoked. If this is a
   * significant possibility then the caller should check this case and call {@code
   * getSimpleName(Class.class)} or just simply use the string literal {@code "Class"}, which is the
   * result of the method in that case.
   *
   * @param object the object for which to get the simple class name; may be null
   * @return the simple class name or the empty string in case the argument is {@code null}
   * @since 3.7
   * @see Class#getSimpleName()
   */
  public static String getSimpleName(final Object object) {
    return getSimpleName(object, StringUtils.EMPTY);
  }

  /**
   * Null-safe version of {@code object.getClass().getSimpleName()}
   *
   * @param object the object for which to get the simple class name; may be null
   * @param valueIfNull the value to return if {@code object} is {@code null}
   * @return the simple class name or {@code valueIfNull} if the argument {@code object} is {@code
   *     null}
   * @since 3.0
   * @see Class#getSimpleName()
   */
  public static String getSimpleName(final Object object, final String valueIfNull) {
    return object == null ? valueIfNull : object.getClass().getSimpleName();
  }

  /**
   * Null-safe version of {@code cls.getName()}
   *
   * @param cls the class for which to get the class name; may be null
   * @return the class name or the empty string in case the argument is {@code null}
   * @since 3.7
   * @see Class#getSimpleName()
   */
  public static String getName(final Class<?> cls) {
    return getName(cls, StringUtils.EMPTY);
  }

  /**
   * Null-safe version of {@code cls.getName()}
   *
   * @param cls the class for which to get the class name; may be null
   * @param valueIfNull the return value if the argument {@code cls} is {@code null}
   * @return the class name or {@code valueIfNull}
   * @since 3.7
   * @see Class#getName()
   */
  public static String getName(final Class<?> cls, final String valueIfNull) {
    return cls == null ? valueIfNull : cls.getName();
  }

  /**
   * Null-safe version of {@code object.getClass().getName()}
   *
   * @param object the object for which to get the class name; may be null
   * @return the class name or the empty String
   * @since 3.7
   * @see Class#getSimpleName()
   */
  public static String getName(final Object object) {
    return getName(object, StringUtils.EMPTY);
  }

  /**
   * Null-safe version of {@code object.getClass().getSimpleName()}
   *
   * @param object the object for which to get the class name; may be null
   * @param valueIfNull the value to return if {@code object} is {@code null}
   * @return the class name or {@code valueIfNull}
   * @since 3.0
   * @see Class#getName()
   */
  public static String getName(final Object object, final String valueIfNull) {
    return object == null ? valueIfNull : object.getClass().getName();
  }

  // Package name
  // ----------------------------------------------------------------------
  /**
   * Gets the package name of an {@code Object}.
   *
   * @param object the class to get the package name for, may be null
   * @param valueIfNull the value to return if null
   * @return the package name of the object, or the null value
   */
  public static String getPackageName(final Object object, final String valueIfNull) {
    if (object == null) {
      return valueIfNull;
    }
    return getPackageName(object.getClass());
  }

  /**
   * Gets the package name of a {@code Class}.
   *
   * @param cls the class to get the package name for, may be {@code null}.
   * @return the package name or an empty string
   */
  public static String getPackageName(final Class<?> cls) {
    if (cls == null) {
      return StringUtils.EMPTY;
    }
    return getPackageName(cls.getName());
  }

  /**
   * Gets the package name from a {@code String}.
   *
   * <p>The string passed in is assumed to be a class name - it is not checked.
   *
   * <p>If the class is unpackaged, return an empty string.
   *
   * @param className the className to get the package name for, may be {@code null}
   * @return the package name or an empty string
   */
  public static String getPackageName(String className) {
    if (StringUtils.isEmpty(className)) {
      return StringUtils.EMPTY;
    }

    // Strip array encoding
    while (className.charAt(0) == '[') {
      className = className.substring(1);
    }
    // Strip Object type encoding
    if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
      className = className.substring(1);
    }

    final int i = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);
    if (i == -1) {
      return StringUtils.EMPTY;
    }
    return className.substring(0, i);
  }

  // Abbreviated name
  // ----------------------------------------------------------------------
  /**
   * Gets the abbreviated name of a {@code Class}.
   *
   * @param cls the class to get the abbreviated name for, may be {@code null}
   * @param lengthHint the desired length of the abbreviated name
   * @return the abbreviated name or an empty string
   * @throws IllegalArgumentException if len &lt;= 0
   * @see #getAbbreviatedName(String, int)
   * @since 3.4
   */
  public static String getAbbreviatedName(final Class<?> cls, final int lengthHint) {
    if (cls == null) {
      return StringUtils.EMPTY;
    }
    return getAbbreviatedName(cls.getName(), lengthHint);
  }

  /**
   * Gets the abbreviated class name from a {@code String}.
   *
   * <p>The string passed in is assumed to be a class name - it is not checked.
   *
   * <p>The abbreviation algorithm will shorten the class name, usually without significant loss of
   * meaning.
   *
   * <p>The abbreviated class name will always include the complete package hierarchy. If enough
   * space is available, rightmost sub-packages will be displayed in full length. The abbreviated
   * package names will be shortened to a single character.
   *
   * <p>Only package names are shortened, the class simple name remains untouched. (See examples.)
   *
   * <p>The result will be longer than the desired length only if all the package names shortened to
   * a single character plus the class simple name with the separating dots together are longer than
   * the desired length. In other words, when the class name cannot be shortened to the desired
   * length.
   *
   * <p>If the class name can be shortened then the final length will be at most {@code lengthHint}
   * characters.
   *
   * <p>If the {@code lengthHint} is zero or negative then the method throws exception. If you want
   * to achieve the shortest possible version then use {@code 1} as a {@code lengthHint}.
   *
   * <table>
   * <caption>Examples</caption>
   * <tr>
   * <td>className</td>
   * <td>len</td>
   * <td>return</td>
   * </tr>
   * <tr>
   * <td>null</td>
   * <td>1</td>
   * <td>""</td>
   * </tr>
   * <tr>
   * <td>"java.lang.String"</td>
   * <td>5</td>
   * <td>"j.l.String"</td>
   * </tr>
   * <tr>
   * <td>"java.lang.String"</td>
   * <td>15</td>
   * <td>"j.lang.String"</td>
   * </tr>
   * <tr>
   * <td>"java.lang.String"</td>
   * <td>30</td>
   * <td>"java.lang.String"</td>
   * </tr>
   * <tr>
   * <td>"org.apache.commons.lang3.ClassUtils"</td>
   * <td>18</td>
   * <td>"o.a.c.l.ClassUtils"</td>
   * </tr>
   * </table>
   *
   * @param className the className to get the abbreviated name for, may be {@code null}
   * @param lengthHint the desired length of the abbreviated name
   * @return the abbreviated name or an empty string if the specified class name is {@code null} or
   *     empty string. The abbreviated name may be longer than the desired length if it cannot be
   *     abbreviated to the desired length.
   * @throws IllegalArgumentException if {@code len <= 0}
   * @since 3.4
   */
  public static String getAbbreviatedName(final String className, final int lengthHint) {
    if (lengthHint <= 0) {
      throw new IllegalArgumentException("len must be > 0");
    }
    if (className == null) {
      return StringUtils.EMPTY;
    }
    if (className.length() <= lengthHint) {
      return className;
    }
    final char[] abbreviated = className.toCharArray();
    int target = 0;
    int source = 0;
    while (source < abbreviated.length) {
      // copy the next part
      int runAheadTarget = target;
      while (source < abbreviated.length && abbreviated[source] != '.') {
        abbreviated[runAheadTarget++] = abbreviated[source++];
      }

      ++target;
      if (useFull(runAheadTarget, source, abbreviated.length, lengthHint)
          || target > runAheadTarget) {
        target = runAheadTarget;
      }

      // copy the '.' unless it was the last part
      if (source < abbreviated.length) {
        abbreviated[target++] = abbreviated[source++];
      }
    }
    return new String(abbreviated, 0, target);
  }

  /**
   * Decides if the part that was just copied to its destination location in the work array can be
   * kept as it was copied or must be abbreviated. It must be kept when the part is the last one,
   * which is the simple name of the class. In this case the {@code source} index, from where the
   * characters are copied points one position after the last character, a.k.a. {@code source ==
   * originalLength}
   *
   * <p>If the part is not the last one then it can be kept unabridged if the number of the
   * characters copied so far plus the character that are to be copied is less than or equal to the
   * desired length.
   *
   * @param runAheadTarget the target index (where the characters were copied to) pointing after the
   *     last character copied when the current part was copied
   * @param source the source index (where the characters were copied from) pointing after the last
   *     character copied when the current part was copied
   * @param originalLength the original length of the class full name, which is abbreviated
   * @param desiredLength the desired length of the abbreviated class name
   * @return {@code true} if it can be kept in its original length {@code false} if the current part
   *     has to be abbreviated and
   */
  private static boolean useFull(
      final int runAheadTarget,
      final int source,
      final int originalLength,
      final int desiredLength) {
    return source >= originalLength || runAheadTarget + originalLength - source <= desiredLength;
  }

  // Superclasses/Superinterfaces
  // ----------------------------------------------------------------------
  /**
   * Gets a {@code List} of superclasses for the given class.
   *
   * @param cls the class to look up, may be {@code null}
   * @return the {@code List} of superclasses in order going up from this one {@code null} if null
   *     input
   */
  public static List<Class<?>> getAllSuperclasses(final Class<?> cls) {
    if (cls == null) {
      return null;
    }
    final List<Class<?>> classes = new ArrayList<>();
    Class<?> superclass = cls.getSuperclass();
    while (superclass != null) {
      classes.add(superclass);
      superclass = superclass.getSuperclass();
    }
    return classes;
  }

  /**
   * Gets a {@code List} of all interfaces implemented by the given class and its superclasses.
   *
   * <p>The order is determined by looking through each interface in turn as declared in the source
   * file and following its hierarchy up. Then each superclass is considered in the same way. Later
   * duplicates are ignored, so the order is maintained.
   *
   * @param cls the class to look up, may be {@code null}
   * @return the {@code List} of interfaces in order, {@code null} if null input
   */
  public static List<Class<?>> getAllInterfaces(final Class<?> cls) {
    if (cls == null) {
      return null;
    }

    final LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
    getAllInterfaces(cls, interfacesFound);

    return new ArrayList<>(interfacesFound);
  }

  /**
   * Gets the interfaces for the specified class.
   *
   * @param cls the class to look up, may be {@code null}
   * @param interfacesFound the {@code Set} of interfaces for the class
   */
  private static void getAllInterfaces(Class<?> cls, final HashSet<Class<?>> interfacesFound) {
    while (cls != null) {
      final Class<?>[] interfaces = cls.getInterfaces();

      for (final Class<?> i : interfaces) {
        if (interfacesFound.add(i)) {
          getAllInterfaces(i, interfacesFound);
        }
      }

      cls = cls.getSuperclass();
    }
  }

  // Convert list
  // ----------------------------------------------------------------------
  /**
   * Given a {@code List} of class names, this method converts them into classes.
   *
   * <p>A new {@code List} is returned. If the class name cannot be found, {@code null} is stored in
   * the {@code List}. If the class name in the {@code List} is {@code null}, {@code null} is stored
   * in the output {@code List}.
   *
   * @param classNames the classNames to change
   * @return a {@code List} of Class objects corresponding to the class names, {@code null} if null
   *     input
   * @throws ClassCastException if classNames contains a non String entry
   */
  public static List<Class<?>> convertClassNamesToClasses(final List<String> classNames) {
    if (classNames == null) {
      return null;
    }
    final List<Class<?>> classes = new ArrayList<>(classNames.size());
    for (final String className : classNames) {
      try {
        classes.add(Class.forName(className));
      } catch (final Exception ex) {
        classes.add(null);
      }
    }
    return classes;
  }

  /**
   * Given a {@code List} of {@code Class} objects, this method converts them into class names.
   *
   * <p>A new {@code List} is returned. {@code null} objects will be copied into the returned list
   * as {@code null}.
   *
   * @param classes the classes to change
   * @return a {@code List} of class names corresponding to the Class objects, {@code null} if null
   *     input
   * @throws ClassCastException if {@code classes} contains a non-{@code Class} entry
   */
  public static List<String> convertClassesToClassNames(final List<Class<?>> classes) {
    if (classes == null) {
      return null;
    }
    final List<String> classNames = new ArrayList<>(classes.size());
    for (final Class<?> cls : classes) {
      if (cls == null) {
        classNames.add(null);
      } else {
        classNames.add(cls.getName());
      }
    }
    return classNames;
  }

  // Is assignable
  // ----------------------------------------------------------------------
  /**
   * Checks if an array of Classes can be assigned to another array of Classes.
   *
   * <p>This method calls {@link #isAssignable(Class, Class) isAssignable} for each Class pair in
   * the input arrays. It can be used to check if a set of arguments (the first parameter) are
   * suitably compatible with a set of method parameter types (the second parameter).
   *
   * <p>Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this method takes into
   * account widenings of primitive classes and {@code null}s.
   *
   * <p>Primitive widenings allow an int to be assigned to a {@code long}, {@code float} or {@code
   * double}. This method returns the correct result for these cases.
   *
   * <p>{@code Null} may be assigned to any reference type. This method will return {@code true} if
   * {@code null} is passed in and the toClass is non-primitive.
   *
   * <p>Specifically, this method tests whether the type represented by the specified {@code Class}
   * parameter can be converted to the type represented by this {@code Class} object via an identity
   * conversion widening primitive or widening reference conversion. See <em><a
   * href="http://docs.oracle.com/javase/specs/">The Java Language Specification</a></em>, sections
   * 5.1.1, 5.1.2 and 5.1.4 for details.
   *
   * <p><strong>Since Lang 3.0,</strong> this method will default behavior for calculating
   * assignability between primitive and wrapper types <em>corresponding to the running Java
   * version</em>; i.e. autoboxing will be the default behavior in VMs running Java versions &gt;
   * 1.5.
   *
   * @param classArray the array of Classes to check, may be {@code null}
   * @param toClassArray the array of Classes to try to assign into, may be {@code null}
   * @return {@code true} if assignment possible
   */
  public static boolean isAssignable(final Class<?>[] classArray, final Class<?>... toClassArray) {
    return isAssignable(classArray, toClassArray, true);
  }

  /**
   * Checks if an array of Classes can be assigned to another array of Classes.
   *
   * <p>This method calls {@link #isAssignable(Class, Class) isAssignable} for each Class pair in
   * the input arrays. It can be used to check if a set of arguments (the first parameter) are
   * suitably compatible with a set of method parameter types (the second parameter).
   *
   * <p>Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this method takes into
   * account widenings of primitive classes and {@code null}s.
   *
   * <p>Primitive widenings allow an int to be assigned to a {@code long}, {@code float} or {@code
   * double}. This method returns the correct result for these cases.
   *
   * <p>{@code Null} may be assigned to any reference type. This method will return {@code true} if
   * {@code null} is passed in and the toClass is non-primitive.
   *
   * <p>Specifically, this method tests whether the type represented by the specified {@code Class}
   * parameter can be converted to the type represented by this {@code Class} object via an identity
   * conversion widening primitive or widening reference conversion. See <em><a
   * href="http://docs.oracle.com/javase/specs/">The Java Language Specification</a></em>, sections
   * 5.1.1, 5.1.2 and 5.1.4 for details.
   *
   * @param classArray the array of Classes to check, may be {@code null}
   * @param toClassArray the array of Classes to try to assign into, may be {@code null}
   * @param autoboxing whether to use implicit autoboxing/unboxing between primitives and wrappers
   * @return {@code true} if assignment possible
   */
  public static boolean isAssignable(
      Class<?>[] classArray, Class<?>[] toClassArray, final boolean autoboxing) {
    if (!ArrayUtils.isSameLength(classArray, toClassArray)) {
      return false;
    }
    if (classArray == null) {
      classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    if (toClassArray == null) {
      toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    for (int i = 0; i < classArray.length; i++) {
      if (!isAssignable(classArray[i], toClassArray[i], autoboxing)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns whether the given {@code type} is a primitive or primitive wrapper ({@link Boolean},
   * {@link Byte}, {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link Double},
   * {@link Float}).
   *
   * @param type The class to query or null.
   * @return true if the given {@code type} is a primitive or primitive wrapper ({@link Boolean},
   *     {@link Byte}, {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
   *     Double}, {@link Float}).
   * @since 3.1
   */
  public static boolean isPrimitiveOrWrapper(final Class<?> type) {
    if (type == null) {
      return false;
    }
    return type.isPrimitive() || isPrimitiveWrapper(type);
  }

  /**
   * Returns whether the given {@code type} is a primitive wrapper ({@link Boolean}, {@link Byte},
   * {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link Double}, {@link
   * Float}).
   *
   * @param type The class to query or null.
   * @return true if the given {@code type} is a primitive wrapper ({@link Boolean}, {@link Byte},
   *     {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link Double}, {@link
   *     Float}).
   * @since 3.1
   */
  public static boolean isPrimitiveWrapper(final Class<?> type) {
    return wrapperPrimitiveMap.containsKey(type);
  }

  /**
   * Checks if one {@code Class} can be assigned to a variable of another {@code Class}.
   *
   * <p>Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this method takes into
   * account widenings of primitive classes and {@code null}s.
   *
   * <p>Primitive widenings allow an int to be assigned to a long, float or double. This method
   * returns the correct result for these cases.
   *
   * <p>{@code Null} may be assigned to any reference type. This method will return {@code true} if
   * {@code null} is passed in and the toClass is non-primitive.
   *
   * <p>Specifically, this method tests whether the type represented by the specified {@code Class}
   * parameter can be converted to the type represented by this {@code Class} object via an identity
   * conversion widening primitive or widening reference conversion. See <em><a
   * href="http://docs.oracle.com/javase/specs/">The Java Language Specification</a></em>, sections
   * 5.1.1, 5.1.2 and 5.1.4 for details.
   *
   * <p><strong>Since Lang 3.0,</strong> this method will default behavior for calculating
   * assignability between primitive and wrapper types <em>corresponding to the running Java
   * version</em>; i.e. autoboxing will be the default behavior in VMs running Java versions &gt;
   * 1.5.
   *
   * @param cls the Class to check, may be null
   * @param toClass the Class to try to assign into, returns false if null
   * @return {@code true} if assignment possible
   */
  public static boolean isAssignable(final Class<?> cls, final Class<?> toClass) {
    return isAssignable(cls, toClass, true);
  }

  /**
   * Checks if one {@code Class} can be assigned to a variable of another {@code Class}.
   *
   * <p>Unlike the {@link Class#isAssignableFrom(java.lang.Class)} method, this method takes into
   * account widenings of primitive classes and {@code null}s.
   *
   * <p>Primitive widenings allow an int to be assigned to a long, float or double. This method
   * returns the correct result for these cases.
   *
   * <p>{@code Null} may be assigned to any reference type. This method will return {@code true} if
   * {@code null} is passed in and the toClass is non-primitive.
   *
   * <p>Specifically, this method tests whether the type represented by the specified {@code Class}
   * parameter can be converted to the type represented by this {@code Class} object via an identity
   * conversion widening primitive or widening reference conversion. See <em><a
   * href="http://docs.oracle.com/javase/specs/">The Java Language Specification</a></em>, sections
   * 5.1.1, 5.1.2 and 5.1.4 for details.
   *
   * @param cls the Class to check, may be null
   * @param toClass the Class to try to assign into, returns false if null
   * @param autoboxing whether to use implicit autoboxing/unboxing between primitives and wrappers
   * @return {@code true} if assignment possible
   */
  public static boolean isAssignable(
      Class<?> cls, final Class<?> toClass, final boolean autoboxing) {
    if (toClass == null) {
      return false;
    }
    // have to check for null, as isAssignableFrom doesn't
    if (cls == null) {
      return !toClass.isPrimitive();
    }
    // autoboxing:
    if (autoboxing) {
      if (cls.isPrimitive() && !toClass.isPrimitive()) {
        cls = primitiveToWrapper(cls);
        if (cls == null) {
          return false;
        }
      }
      if (toClass.isPrimitive() && !cls.isPrimitive()) {
        cls = wrapperToPrimitive(cls);
        if (cls == null) {
          return false;
        }
      }
    }
    if (cls.equals(toClass)) {
      return true;
    }
    if (cls.isPrimitive()) {
      if (!toClass.isPrimitive()) {
        return false;
      }
      if (Integer.TYPE.equals(cls)) {
        return Long.TYPE.equals(toClass)
            || Float.TYPE.equals(toClass)
            || Double.TYPE.equals(toClass);
      }
      if (Long.TYPE.equals(cls)) {
        return Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
      }
      if (Boolean.TYPE.equals(cls)) {
        return false;
      }
      if (Double.TYPE.equals(cls)) {
        return false;
      }
      if (Float.TYPE.equals(cls)) {
        return Double.TYPE.equals(toClass);
      }
      if (Character.TYPE.equals(cls)) {
        return Integer.TYPE.equals(toClass)
            || Long.TYPE.equals(toClass)
            || Float.TYPE.equals(toClass)
            || Double.TYPE.equals(toClass);
      }
      if (Short.TYPE.equals(cls)) {
        return Integer.TYPE.equals(toClass)
            || Long.TYPE.equals(toClass)
            || Float.TYPE.equals(toClass)
            || Double.TYPE.equals(toClass);
      }
      if (Byte.TYPE.equals(cls)) {
        return Short.TYPE.equals(toClass)
            || Integer.TYPE.equals(toClass)
            || Long.TYPE.equals(toClass)
            || Float.TYPE.equals(toClass)
            || Double.TYPE.equals(toClass);
      }
      // should never get here
      return false;
    }
    return toClass.isAssignableFrom(cls);
  }

  /**
   * Converts the specified primitive Class object to its corresponding wrapper Class object.
   *
   * <p>NOTE: From v2.2, this method handles {@code Void.TYPE}, returning {@code Void.TYPE}.
   *
   * @param cls the class to convert, may be null
   * @return the wrapper class for {@code cls} or {@code cls} if {@code cls} is not a primitive.
   *     {@code null} if null input.
   * @since 2.1
   */
  public static Class<?> primitiveToWrapper(final Class<?> cls) {
    Class<?> convertedClass = cls;
    if (cls != null && cls.isPrimitive()) {
      convertedClass = primitiveWrapperMap.get(cls);
    }
    return convertedClass;
  }

  /**
   * Converts the specified array of primitive Class objects to an array of its corresponding
   * wrapper Class objects.
   *
   * @param classes the class array to convert, may be null or empty
   * @return an array which contains for each given class, the wrapper class or the original class
   *     if class is not a primitive. {@code null} if null input. Empty array if an empty array
   *     passed in.
   * @since 2.1
   */
  public static Class<?>[] primitivesToWrappers(final Class<?>... classes) {
    if (classes == null) {
      return null;
    }

    if (classes.length == 0) {
      return classes;
    }

    final Class<?>[] convertedClasses = new Class[classes.length];
    for (int i = 0; i < classes.length; i++) {
      convertedClasses[i] = primitiveToWrapper(classes[i]);
    }
    return convertedClasses;
  }

  /**
   * Converts the specified wrapper class to its corresponding primitive class.
   *
   * <p>This method is the counter part of {@code primitiveToWrapper()}. If the passed in class is a
   * wrapper class for a primitive type, this primitive type will be returned (e.g. {@code
   * Integer.TYPE} for {@code Integer.class}). For other classes, or if the parameter is
   * <b>null</b>, the return value is <b>null</b>.
   *
   * @param cls the class to convert, may be <b>null</b>
   * @return the corresponding primitive type if {@code cls} is a wrapper class, <b>null</b>
   *     otherwise
   * @see #primitiveToWrapper(Class)
   * @since 2.4
   */
  public static Class<?> wrapperToPrimitive(final Class<?> cls) {
    return wrapperPrimitiveMap.get(cls);
  }

  /**
   * Converts the specified array of wrapper Class objects to an array of its corresponding
   * primitive Class objects.
   *
   * <p>This method invokes {@code wrapperToPrimitive()} for each element of the passed in array.
   *
   * @param classes the class array to convert, may be null or empty
   * @return an array which contains for each given class, the primitive class or <b>null</b> if the
   *     original class is not a wrapper class. {@code null} if null input. Empty array if an empty
   *     array passed in.
   * @see #wrapperToPrimitive(Class)
   * @since 2.4
   */
  public static Class<?>[] wrappersToPrimitives(final Class<?>... classes) {
    if (classes == null) {
      return null;
    }

    if (classes.length == 0) {
      return classes;
    }

    final Class<?>[] convertedClasses = new Class[classes.length];
    for (int i = 0; i < classes.length; i++) {
      convertedClasses[i] = wrapperToPrimitive(classes[i]);
    }
    return convertedClasses;
  }

  // Inner class
  // ----------------------------------------------------------------------
  /**
   * Is the specified class an inner class or static nested class.
   *
   * @param cls the class to check, may be null
   * @return {@code true} if the class is an inner or static nested class, false if not or {@code
   *     null}
   */
  public static boolean isInnerClass(final Class<?> cls) {
    return cls != null && cls.getEnclosingClass() != null;
  }

  // Class loading
  // ----------------------------------------------------------------------
  /**
   * Returns the class represented by {@code className} using the {@code classLoader}. This
   * implementation supports the syntaxes "{@code java.util.Map.Entry[]}", "{@code
   * java.util.Map$Entry[]}", "{@code [Ljava.util.Map.Entry;}", and "{@code
   * [Ljava.util.Map$Entry;}".
   *
   * @param classLoader the class loader to use to load the class
   * @param className the class name
   * @param initialize whether the class must be initialized
   * @return the class represented by {@code className} using the {@code classLoader}
   * @throws ClassNotFoundException if the class is not found
   */
  public static Class<?> getClass(
      final ClassLoader classLoader, final String className, final boolean initialize)
      throws ClassNotFoundException {
    try {
      Class<?> clazz;
      if (namePrimitiveMap.containsKey(className)) {
        clazz = namePrimitiveMap.get(className);
      } else {
        clazz = Class.forName(toCanonicalName(className), initialize, classLoader);
      }
      return clazz;
    } catch (final ClassNotFoundException ex) {
      // allow path separators (.) as inner class name separators
      final int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR_CHAR);

      if (lastDotIndex != -1) {
        try {
          return getClass(
              classLoader,
              className.substring(0, lastDotIndex)
                  + INNER_CLASS_SEPARATOR_CHAR
                  + className.substring(lastDotIndex + 1),
              initialize);
        } catch (final ClassNotFoundException ex2) { // NOPMD
          // ignore exception
        }
      }

      throw ex;
    }
  }

  /**
   * Returns the (initialized) class represented by {@code className} using the {@code classLoader}.
   * This implementation supports the syntaxes "{@code java.util.Map.Entry[]}", "{@code
   * java.util.Map$Entry[]}", "{@code [Ljava.util.Map.Entry;}", and "{@code
   * [Ljava.util.Map$Entry;}".
   *
   * @param classLoader the class loader to use to load the class
   * @param className the class name
   * @return the class represented by {@code className} using the {@code classLoader}
   * @throws ClassNotFoundException if the class is not found
   */
  public static Class<?> getClass(final ClassLoader classLoader, final String className)
      throws ClassNotFoundException {
    return getClass(classLoader, className, true);
  }

  /**
   * Returns the (initialized) class represented by {@code className} using the current thread's
   * context class loader. This implementation supports the syntaxes "{@code
   * java.util.Map.Entry[]}", "{@code java.util.Map$Entry[]}", "{@code [Ljava.util.Map.Entry;}", and
   * "{@code [Ljava.util.Map$Entry;}".
   *
   * @param className the class name
   * @return the class represented by {@code className} using the current thread's context class
   *     loader
   * @throws ClassNotFoundException if the class is not found
   */
  public static Class<?> getClass(final String className) throws ClassNotFoundException {
    return getClass(className, true);
  }

  /**
   * Returns the class represented by {@code className} using the current thread's context class
   * loader. This implementation supports the syntaxes "{@code java.util.Map.Entry[]}", "{@code
   * java.util.Map$Entry[]}", "{@code [Ljava.util.Map.Entry;}", and "{@code
   * [Ljava.util.Map$Entry;}".
   *
   * @param className the class name
   * @param initialize whether the class must be initialized
   * @return the class represented by {@code className} using the current thread's context class
   *     loader
   * @throws ClassNotFoundException if the class is not found
   */
  public static Class<?> getClass(final String className, final boolean initialize)
      throws ClassNotFoundException {
    final ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
    final ClassLoader loader = contextCL == null ? ClassUtils.class.getClassLoader() : contextCL;
    return getClass(loader, className, initialize);
  }

  // Public method
  // ----------------------------------------------------------------------
  /**
   * Returns the desired Method much like {@code Class.getMethod}, however it ensures that the
   * returned Method is from a public class or interface and not from an anonymous inner class. This
   * means that the Method is invokable and doesn't fall foul of Java bug <a
   * href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4071957">4071957</a>).
   *
   * <pre>
   *  <code>Set set = Collections.unmodifiableSet(...);
   *  Method method = ClassUtils.getPublicMethod(set.getClass(), "isEmpty",  new Class[0]);
   *  Object result = method.invoke(set, new Object[]);</code>
   * </pre>
   *
   * @param cls the class to check, not null
   * @param methodName the name of the method
   * @param parameterTypes the list of parameters
   * @return the method
   * @throws NullPointerException if the class is null
   * @throws SecurityException if a security violation occurred
   * @throws NoSuchMethodException if the method is not found in the given class or if the method
   *     doesn't conform with the requirements
   */
  public static Method getPublicMethod(
      final Class<?> cls, final String methodName, final Class<?>... parameterTypes)
      throws NoSuchMethodException {

    final Method declaredMethod = cls.getMethod(methodName, parameterTypes);
    if (Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
      return declaredMethod;
    }

    final List<Class<?>> candidateClasses = new ArrayList<>();
    candidateClasses.addAll(getAllInterfaces(cls));
    candidateClasses.addAll(getAllSuperclasses(cls));

    for (final Class<?> candidateClass : candidateClasses) {
      if (!Modifier.isPublic(candidateClass.getModifiers())) {
        continue;
      }
      Method candidateMethod;
      try {
        candidateMethod = candidateClass.getMethod(methodName, parameterTypes);
      } catch (final NoSuchMethodException ex) {
        continue;
      }
      if (Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) {
        return candidateMethod;
      }
    }

    throw new NoSuchMethodException(
        "Can't find a public method for " + methodName + " " + ArrayUtils.toString(parameterTypes));
  }

  // ----------------------------------------------------------------------
  /**
   * Converts a class name to a JLS style class name.
   *
   * @param className the class name
   * @return the converted name
   */
  private static String toCanonicalName(String className) {
    className = StringUtils.deleteWhitespace(className);
    Validate.notNull(className, "className must not be null.");
    if (className.endsWith("[]")) {
      final StringBuilder classNameBuffer = new StringBuilder();
      while (className.endsWith("[]")) {
        className = className.substring(0, className.length() - 2);
        classNameBuffer.append("[");
      }
      final String abbreviation = abbreviationMap.get(className);
      if (abbreviation != null) {
        classNameBuffer.append(abbreviation);
      } else {
        classNameBuffer.append("L").append(className).append(";");
      }
      className = classNameBuffer.toString();
    }
    return className;
  }

  /**
   * Converts an array of {@code Object} in to an array of {@code Class} objects. If any of these
   * objects is null, a null element will be inserted into the array.
   *
   * <p>This method returns {@code null} for a {@code null} input array.
   *
   * @param array an {@code Object} array
   * @return a {@code Class} array, {@code null} if null array input
   * @since 2.4
   */
  public static Class<?>[] toClass(final Object... array) {
    if (array == null) {
      return null;
    } else if (array.length == 0) {
      return ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    final Class<?>[] classes = new Class[array.length];
    for (int i = 0; i < array.length; i++) {
      classes[i] = array[i] == null ? null : array[i].getClass();
    }
    return classes;
  }

  // Short canonical name
  // ----------------------------------------------------------------------
  /**
   * Gets the canonical name minus the package name for an {@code Object}.
   *
   * @param object the class to get the short name for, may be null
   * @param valueIfNull the value to return if null
   * @return the canonical name of the object without the package name, or the null value
   * @since 2.4
   */
  public static String getShortCanonicalName(final Object object, final String valueIfNull) {
    if (object == null) {
      return valueIfNull;
    }
    return getShortCanonicalName(object.getClass().getName());
  }

  /**
   * Gets the canonical class name for a {@code Class}.
   *
   * @param cls the class for which to get the canonical class name; may be null
   * @return the canonical name of the class, or the empty String
   * @since 3.7
   * @see Class#getCanonicalName()
   */
  public static String getCanonicalName(final Class<?> cls) {
    return getCanonicalName(cls, StringUtils.EMPTY);
  }

  /**
   * Gets the canonical name for a {@code Class}.
   *
   * @param cls the class for which to get the canonical class name; may be null
   * @param valueIfNull the return value if null
   * @return the canonical name of the class, or {@code valueIfNull}
   * @since 3.7
   * @see Class#getCanonicalName()
   */
  public static String getCanonicalName(final Class<?> cls, final String valueIfNull) {
    if (cls == null) {
      return valueIfNull;
    }
    final String canonicalName = cls.getCanonicalName();
    return canonicalName == null ? valueIfNull : canonicalName;
  }

  /**
   * Gets the canonical name for an {@code Object}.
   *
   * @param object the object for which to get the canonical class name; may be null
   * @return the canonical name of the object, or the empty String
   * @since 3.7
   * @see Class#getCanonicalName()
   */
  public static String getCanonicalName(final Object object) {
    return getCanonicalName(object, StringUtils.EMPTY);
  }

  /**
   * Gets the canonical name for an {@code Object}.
   *
   * @param object the object for which to get the canonical class name; may be null
   * @param valueIfNull the return value if null
   * @return the canonical name of the object or {@code valueIfNull}
   * @since 3.7
   * @see Class#getCanonicalName()
   */
  public static String getCanonicalName(final Object object, final String valueIfNull) {
    if (object == null) {
      return valueIfNull;
    }
    final String canonicalName = object.getClass().getCanonicalName();
    return canonicalName == null ? valueIfNull : canonicalName;
  }

  /**
   * Gets the canonical name minus the package name from a {@code Class}.
   *
   * @param cls the class for which to get the short canonical class name; may be null
   * @return the canonical name without the package name or an empty string
   * @since 2.4
   */
  public static String getShortCanonicalName(final Class<?> cls) {
    if (cls == null) {
      return StringUtils.EMPTY;
    }
    return getShortCanonicalName(cls.getName());
  }

  /**
   * Gets the canonical name minus the package name from a String.
   *
   * <p>The string passed in is assumed to be a class name - it is not checked.
   *
   * <p>Note that this method is mainly designed to handle the arrays and primitives properly. If
   * the class is an inner class then the result value will not contain the outer classes. This way
   * the behavior of this method is different from {@link #getShortClassName(String)}. The argument
   * in that case is class name and not canonical name and the return value retains the outer
   * classes.
   *
   * <p>Note that there is no way to reliably identify the part of the string representing the
   * package hierarchy and the part that is the outer class or classes in case of an inner class.
   * Trying to find the class would require reflective call and the class itself may not even be on
   * the class path. Relying on the fact that class names start with capital letter and packages
   * with lower case is heuristic.
   *
   * <p>It is recommended to use {@link #getShortClassName(String)} for cases when the class is an
   * inner class and use this method for cases it is designed for.
   *
   * <table>
   * <caption>Examples</caption>
   * <tr>
   * <td>return value</td>
   * <td>input</td>
   * </tr>
   * <tr>
   * <td>{@code ""}</td>
   * <td>{@code (String)null}</td>
   * </tr>
   * <tr>
   * <td>{@code "Map.Entry"}</td>
   * <td>{@code java.util.Map.Entry.class.getName()}</td>
   * </tr>
   * <tr>
   * <td>{@code "Entry"}</td>
   * <td>{@code java.util.Map.Entry.class.getCanonicalName()}</td>
   * </tr>
   * <tr>
   * <td>{@code "ClassUtils"}</td>
   * <td>{@code "org.apache.commons.lang3.ClassUtils"}</td>
   * </tr>
   * <tr>
   * <td>{@code "ClassUtils[]"}</td>
   * <td>{@code "[Lorg.apache.commons.lang3.ClassUtils;"}</td>
   * </tr>
   * <tr>
   * <td>{@code "ClassUtils[][]"}</td>
   * <td>{@code "[[Lorg.apache.commons.lang3.ClassUtils;"}</td>
   * </tr>
   * <tr>
   * <td>{@code "ClassUtils[]"}</td>
   * <td>{@code "org.apache.commons.lang3.ClassUtils[]"}</td>
   * </tr>
   * <tr>
   * <td>{@code "ClassUtils[][]"}</td>
   * <td>{@code "org.apache.commons.lang3.ClassUtils[][]"}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[]"}</td>
   * <td>{@code "[I"}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[]"}</td>
   * <td>{@code int[].class.getCanonicalName()}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[]"}</td>
   * <td>{@code int[].class.getName()}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[][]"}</td>
   * <td>{@code "[[I"}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[]"}</td>
   * <td>{@code "int[]"}</td>
   * </tr>
   * <tr>
   * <td>{@code "int[][]"}</td>
   * <td>{@code "int[][]"}</td>
   * </tr>
   * </table>
   *
   * @param canonicalName the class name to get the short name for
   * @return the canonical name of the class without the package name or an empty string
   * @since 2.4
   */
  public static String getShortCanonicalName(final String canonicalName) {
    return getShortClassName(getCanonicalName(canonicalName));
  }

  // Package name
  // ----------------------------------------------------------------------
  /**
   * Gets the package name from the class name of an {@code Object}.
   *
   * @param object the class to get the package name for, may be null
   * @param valueIfNull the value to return if null
   * @return the package name of the object, or the null value
   * @since 2.4
   */
  public static String getPackageCanonicalName(final Object object, final String valueIfNull) {
    if (object == null) {
      return valueIfNull;
    }
    return getPackageCanonicalName(object.getClass().getName());
  }

  /**
   * Gets the package name from the canonical name of a {@code Class}.
   *
   * @param cls the class to get the package name for, may be {@code null}.
   * @return the package name or an empty string
   * @since 2.4
   */
  public static String getPackageCanonicalName(final Class<?> cls) {
    if (cls == null) {
      return StringUtils.EMPTY;
    }
    return getPackageCanonicalName(cls.getName());
  }

  /**
   * Gets the package name from the class name.
   *
   * <p>The string passed in is assumed to be a class name - it is not checked.
   *
   * <p>If the class is in the default package, return an empty string.
   *
   * @param name the name to get the package name for, may be {@code null}
   * @return the package name or an empty string
   * @since 2.4
   */
  public static String getPackageCanonicalName(final String name) {
    return getPackageName(getCanonicalName(name));
  }

  /**
   * Converts a given name of class into canonical format. If name of class is not a name of array
   * class it returns unchanged name.
   *
   * <p>The method does not change the {@code $} separators in case the class is inner class.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>{@code getCanonicalName("[I") = "int[]"}
   *   <li>{@code getCanonicalName("[Ljava.lang.String;") = "java.lang.String[]"}
   *   <li>{@code getCanonicalName("java.lang.String") = "java.lang.String"}
   * </ul>
   *
   * @param className the name of class
   * @return canonical form of class name
   * @since 2.4
   */
  private static String getCanonicalName(String className) {
    className = StringUtils.deleteWhitespace(className);
    if (className == null) {
      return null;
    }
    int dim = 0;
    while (className.startsWith("[")) {
      dim++;
      className = className.substring(1);
    }
    if (dim < 1) {
      return className;
    }
    if (className.startsWith("L")) {
      className =
          className.substring(
              1, className.endsWith(";") ? className.length() - 1 : className.length());
    } else {
      if (!className.isEmpty()) {
        className = reverseAbbreviationMap.get(className.substring(0, 1));
      }
    }
    final StringBuilder canonicalClassNameBuffer = new StringBuilder(className);
    for (int i = 0; i < dim; i++) {
      canonicalClassNameBuffer.append("[]");
    }
    return canonicalClassNameBuffer.toString();
  }

  /**
   * Gets an {@link Iterable} that can iterate over a class hierarchy in ascending (subclass to
   * superclass) order, excluding interfaces.
   *
   * @param type the type to get the class hierarchy from
   * @return Iterable an Iterable over the class hierarchy of the given class
   * @since 3.2
   */
  public static Iterable<Class<?>> hierarchy(final Class<?> type) {
    return hierarchy(type, Interfaces.EXCLUDE);
  }

  /**
   * Gets an {@link Iterable} that can iterate over a class hierarchy in ascending (subclass to
   * superclass) order.
   *
   * @param type the type to get the class hierarchy from
   * @param interfacesBehavior switch indicating whether to include or exclude interfaces
   * @return Iterable an Iterable over the class hierarchy of the given class
   * @since 3.2
   */
  public static Iterable<Class<?>> hierarchy(
      final Class<?> type, final Interfaces interfacesBehavior) {
    final Iterable<Class<?>> classes =
        () -> {
          final MutableObject<Class<?>> next = new MutableObject<>(type);
          return new Iterator<Class<?>>() {

            @Override
            public boolean hasNext() {
              return next.getValue() != null;
            }

            @Override
            public Class<?> next() {
              final Class<?> result = next.getValue();
              next.setValue(result.getSuperclass());
              return result;
            }

            @Override
            public void remove() {
              throw new UnsupportedOperationException();
            }
          };
        };
    if (interfacesBehavior != Interfaces.INCLUDE) {
      return classes;
    }
    return () -> {
      final Set<Class<?>> seenInterfaces = new HashSet<>();
      final Iterator<Class<?>> wrapped = classes.iterator();

      return new Iterator<Class<?>>() {
        Iterator<Class<?>> interfaces = Collections.<Class<?>>emptySet().iterator();

        @Override
        public boolean hasNext() {
          return interfaces.hasNext() || wrapped.hasNext();
        }

        @Override
        public Class<?> next() {
          if (interfaces.hasNext()) {
            final Class<?> nextInterface = interfaces.next();
            seenInterfaces.add(nextInterface);
            return nextInterface;
          }
          final Class<?> nextSuperclass = wrapped.next();
          final Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
          walkInterfaces(currentInterfaces, nextSuperclass);
          interfaces = currentInterfaces.iterator();
          return nextSuperclass;
        }

        private void walkInterfaces(final Set<Class<?>> addTo, final Class<?> c) {
          for (final Class<?> iface : c.getInterfaces()) {
            if (!seenInterfaces.contains(iface)) {
              addTo.add(iface);
            }
            walkInterfaces(addTo, iface);
          }
        }

        @Override
        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
    };
  }

  /**
   * Creates a new instance of this class.
   *
   * @param clazz The class to instantiate.
   * @param <T> The type of the new instance.
   * @return The new instance.
   */
  public static synchronized <T> T instantiate(Class<T> clazz) {
    try {
      return clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new IllegalStateException(
          "Unable to instantiate class " + clazz.getName() + " : " + e.getMessage(), e);
    }
  }

  public static synchronized <T> T instantiate(Class<T> clazz, Class<?>[] types, Object[] args) {
    try {
      return clazz.getDeclaredConstructor(types).newInstance(args);
    } catch (Exception e) {
      throw new IllegalStateException(
          "Unable to instantiate class " + clazz.getName() + " : " + e.getMessage(), e);
    }
  }

  /**
   * Return the default ClassLoader to use: typically the thread context ClassLoader, if available;
   * the ClassLoader that loaded the ClassUtils class will be used as fallback.
   *
   * <p>Call this method if you intend to use the thread context ClassLoader in a scenario where you
   * clearly prefer a non-null ClassLoader reference: for example, for class path resource loading
   * (but not necessarily for {@code Class.forName}, which accepts a {@code null} ClassLoader
   * reference as well).
   *
   * @return the default ClassLoader (only {@code null} if even the system ClassLoader isn't
   *     accessible)
   * @see Thread#getContextClassLoader()
   * @see ClassLoader#getSystemClassLoader()
   */
  public static ClassLoader getDefaultClassLoader() {
    ClassLoader cl = null;
    try {
      cl = Thread.currentThread().getContextClassLoader();
    } catch (Throwable ex) {
      // Cannot access thread context ClassLoader - falling back...
    }
    if (cl == null) {
      // No thread context class loader -> use class loader of this class.
      cl = ClassUtils.class.getClassLoader();
      if (cl == null) {
        // getClassLoader() returning null indicates the bootstrap ClassLoader
        try {
          cl = ClassLoader.getSystemClassLoader();
        } catch (Throwable ex) {
          // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
        }
      }
    }
    return cl;
  }

  /**
   * Override the thread context ClassLoader with the environment's bean ClassLoader if necessary,
   * i.e. if the bean ClassLoader is not equivalent to the thread context ClassLoader already.
   *
   * @param classLoaderToUse the actual ClassLoader to use for the thread context
   * @return the original thread context ClassLoader, or {@code null} if not overridden
   */
  public static ClassLoader overrideThreadContextClassLoader(ClassLoader classLoaderToUse) {
    Thread currentThread = Thread.currentThread();
    ClassLoader threadContextClassLoader = currentThread.getContextClassLoader();
    if (classLoaderToUse != null && !classLoaderToUse.equals(threadContextClassLoader)) {
      currentThread.setContextClassLoader(classLoaderToUse);
      return threadContextClassLoader;
    } else {
      return null;
    }
  }

  /**
   * Replacement for {@code Class.forName()} that also returns Class instances for primitives (e.g.
   * "int") and array class names (e.g. "String[]"). Furthermore, it is also capable of resolving
   * inner class names in Java source style (e.g. "java.lang.Thread.State" instead of
   * "java.lang.Thread$State").
   *
   * @param name the name of the Class
   * @param classLoader the class loader to use (may be {@code null}, which indicates the default
   *     class loader)
   * @return Class instance for the supplied name
   * @throws ClassNotFoundException if the class was not found
   * @throws LinkageError if the class file could not be loaded
   * @see Class#forName(String, boolean, ClassLoader)
   */
  public static Class<?> forName(String name, ClassLoader classLoader)
      throws ClassNotFoundException, LinkageError {
    Assert.notNull(name, "Name must not be null");

    Class<?> clazz = resolvePrimitiveClassName(name);
    if (clazz == null) {
      clazz = commonClassCache.get(name);
    }
    if (clazz != null) {
      return clazz;
    }

    // "java.lang.String[]" style arrays
    if (name.endsWith(ARRAY_SUFFIX)) {
      String elementClassName = name.substring(0, name.length() - ARRAY_SUFFIX.length());
      Class<?> elementClass = forName(elementClassName, classLoader);
      return Array.newInstance(elementClass, 0).getClass();
    }

    // "[Ljava.lang.String;" style arrays
    if (name.startsWith(NON_PRIMITIVE_ARRAY_PREFIX) && name.endsWith(";")) {
      String elementName = name.substring(NON_PRIMITIVE_ARRAY_PREFIX.length(), name.length() - 1);
      Class<?> elementClass = forName(elementName, classLoader);
      return Array.newInstance(elementClass, 0).getClass();
    }

    // "[[I" or "[[Ljava.lang.String;" style arrays
    if (name.startsWith(INTERNAL_ARRAY_PREFIX)) {
      String elementName = name.substring(INTERNAL_ARRAY_PREFIX.length());
      Class<?> elementClass = forName(elementName, classLoader);
      return Array.newInstance(elementClass, 0).getClass();
    }

    ClassLoader clToUse = classLoader;
    if (clToUse == null) {
      clToUse = getDefaultClassLoader();
    }
    try {
      return (clToUse != null ? clToUse.loadClass(name) : Class.forName(name));
    } catch (ClassNotFoundException ex) {
      int lastDotIndex = name.lastIndexOf(PACKAGE_SEPARATOR);
      if (lastDotIndex != -1) {
        String innerClassName =
            name.substring(0, lastDotIndex)
                + INNER_CLASS_SEPARATOR
                + name.substring(lastDotIndex + 1);
        try {
          return (clToUse != null
              ? clToUse.loadClass(innerClassName)
              : Class.forName(innerClassName));
        } catch (ClassNotFoundException ex2) {
          // Swallow - let original exception get through
        }
      }
      throw ex;
    }
  }

  /**
   * Resolve the given class name into a Class instance. Supports primitives (like "int") and array
   * class names (like "String[]").
   *
   * <p>This is effectively equivalent to the {@code forName} method with the same arguments, with
   * the only difference being the exceptions thrown in case of class loading failure.
   *
   * @param className the name of the Class
   * @param classLoader the class loader to use (may be {@code null}, which indicates the default
   *     class loader)
   * @return Class instance for the supplied name
   * @throws IllegalArgumentException if the class name was not resolvable (that is, the class could
   *     not be found or the class file could not be loaded)
   * @see #forName(String, ClassLoader)
   */
  public static Class<?> resolveClassName(String className, ClassLoader classLoader)
      throws IllegalArgumentException {
    try {
      return forName(className, classLoader);
    } catch (ClassNotFoundException ex) {
      throw new IllegalArgumentException("Could not find class [" + className + "]", ex);
    } catch (LinkageError err) {
      throw new IllegalArgumentException(
          "Unresolvable class definition for class [" + className + "]", err);
    }
  }

  /**
   * Determine whether the {@link Class} identified by the supplied name is present and can be
   * loaded. Will return {@code false} if either the class or one of its dependencies is not present
   * or cannot be loaded.
   *
   * @param className the name of the class to check
   * @param classLoader the class loader to use (may be {@code null} which indicates the default
   *     class loader)
   * @return whether the specified class is present
   */
  public static boolean isPresent(String className, ClassLoader classLoader) {
    try {
      forName(className, classLoader);
      return true;
    } catch (Throwable ex) {
      // Class or one of its dependencies is not present...
      return false;
    }
  }

  /**
   * Check whether the given class is visible in the given ClassLoader.
   *
   * @param clazz the class to check (typically an interface)
   * @param classLoader the ClassLoader to check against (may be {@code null} in which case this
   *     method will always return {@code true})
   */
  public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
    if (classLoader == null) {
      return true;
    }
    try {
      return (clazz == classLoader.loadClass(clazz.getName()));
      // Else: different class with same name found
    } catch (ClassNotFoundException ex) {
      // No corresponding class found at all
      return false;
    }
  }

  /**
   * Check whether the given class is cache-safe in the given context, i.e. whether it is loaded by
   * the given ClassLoader or a parent of it.
   *
   * @param clazz the class to analyze
   * @param classLoader the ClassLoader to potentially cache metadata in (may be {@code null} which
   *     indicates the system class loader)
   */
  public static boolean isCacheSafe(Class<?> clazz, ClassLoader classLoader) {
    Assert.notNull(clazz, "Class must not be null");
    try {
      ClassLoader target = clazz.getClassLoader();
      // Common cases
      if (target == classLoader || target == null) {
        return true;
      }
      if (classLoader == null) {
        return false;
      }
      // Check for match in ancestors -> positive
      ClassLoader current = classLoader;
      while (current != null) {
        current = current.getParent();
        if (current == target) {
          return true;
        }
      }
      // Check for match in children -> negative
      while (target != null) {
        target = target.getParent();
        if (target == classLoader) {
          return false;
        }
      }
    } catch (SecurityException ex) {
      // Fall through to Class reference comparison below
    }

    // Fallback for ClassLoaders without parent/child relationship:
    // safe if same Class can be loaded from given ClassLoader
    return (classLoader != null && isVisible(clazz, classLoader));
  }

  /**
   * Resolve the given class name as primitive class, if appropriate, according to the JVM's naming
   * rules for primitive classes.
   *
   * <p>Also supports the JVM's internal class names for primitive arrays. Does <i>not</i> support
   * the "[]" suffix notation for primitive arrays; this is only supported by {@link
   * #forName(String, ClassLoader)}.
   *
   * @param name the name of the potentially primitive class
   * @return the primitive class, or {@code null} if the name does not denote a primitive class or
   *     primitive array class
   */
  public static Class<?> resolvePrimitiveClassName(String name) {
    Class<?> result = null;
    // Most class names will be quite long, considering that they
    // SHOULD sit in a package, so a length check is worthwhile.
    if (name != null && name.length() <= 8) {
      // Could be a primitive - likely.
      result = primitiveTypeNameMap.get(name);
    }
    return result;
  }

  /**
   * Check if the given class represents an array of primitives, i.e. boolean, byte, char, short,
   * int, long, float, or double.
   *
   * @param clazz the class to check
   * @return whether the given class is a primitive array class
   */
  public static boolean isPrimitiveArray(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    return (clazz.isArray() && clazz.getComponentType().isPrimitive());
  }

  /**
   * Check if the given class represents an array of primitive wrappers, i.e. Boolean, Byte,
   * Character, Short, Integer, Long, Float, or Double.
   *
   * @param clazz the class to check
   * @return whether the given class is a primitive wrapper array class
   */
  public static boolean isPrimitiveWrapperArray(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    return (clazz.isArray() && isPrimitiveWrapper(clazz.getComponentType()));
  }

  /**
   * Resolve the given class if it is a primitive class, returning the corresponding primitive
   * wrapper type instead.
   *
   * @param clazz the class to check
   * @return the original class, or a primitive wrapper for the original primitive type
   */
  public static Class<?> resolvePrimitiveIfNecessary(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    return (clazz.isPrimitive() && clazz != void.class
        ? primitiveTypeToWrapperMap.get(clazz)
        : clazz);
  }

  /**
   * Determine if the given type is assignable from the given value, assuming setting by reflection.
   * Considers primitive wrapper classes as assignable to the corresponding primitive types.
   *
   * @param type the target type
   * @param value the value that should be assigned to the type
   * @return if the type is assignable from the value
   */
  public static boolean isAssignableValue(Class<?> type, Object value) {
    Assert.notNull(type, "Type must not be null");
    return (value != null ? isAssignable(type, value.getClass()) : !type.isPrimitive());
  }

  /**
   * Convert a "/"-based resource path to a "."-based fully qualified class name.
   *
   * @param resourcePath the resource path pointing to a class
   * @return the corresponding fully qualified class name
   */
  public static String convertResourcePathToClassName(String resourcePath) {
    Assert.notNull(resourcePath, "Resource path must not be null");
    return resourcePath.replace(PATH_SEPARATOR_CHAR, PACKAGE_SEPARATOR_CHAR);
  }

  /**
   * Convert a "."-based fully qualified class name to a "/"-based resource path.
   *
   * @param className the fully qualified class name
   * @return the corresponding resource path, pointing to the class
   */
  public static String convertClassNameToResourcePath(String className) {
    Assert.notNull(className, "Class name must not be null");
    return className.replace(PACKAGE_SEPARATOR_CHAR, PATH_SEPARATOR_CHAR);
  }

  /**
   * Return a path suitable for use with {@code ClassLoader.getResource} (also suitable for use with
   * {@code Class.getResource} by prepending a slash ('/') to the return value). Built by taking the
   * package of the specified class file, converting all dots ('.') to slashes ('/'), adding a
   * trailing slash if necessary, and concatenating the specified resource name to this. <br>
   * As such, this function may be used to build a path suitable for loading a resource file that is
   * in the same package as a class file, although {@link
   * org.springframework.core.io.ClassPathResource} is usually even more convenient.
   *
   * @param clazz the Class whose package will be used as the base
   * @param resourceName the resource name to append. A leading slash is optional.
   * @return the built-up resource path
   * @see ClassLoader#getResource
   * @see Class#getResource
   */
  public static String addResourcePathToPackagePath(Class<?> clazz, String resourceName) {
    Assert.notNull(resourceName, "Resource name must not be null");
    if (!resourceName.startsWith("/")) {
      return classPackageAsResourcePath(clazz) + '/' + resourceName;
    }
    return classPackageAsResourcePath(clazz) + resourceName;
  }

  /**
   * Given an input class object, return a string which consists of the class's package name as a
   * pathname, i.e., all dots ('.') are replaced by slashes ('/'). Neither a leading nor trailing
   * slash is added. The result could be concatenated with a slash and the name of a resource and
   * fed directly to {@code ClassLoader.getResource()}. For it to be fed to {@code
   * Class.getResource} instead, a leading slash would also have to be prepended to the returned
   * value.
   *
   * @param clazz the input class. A {@code null} value or the default (empty) package will result
   *     in an empty string ("") being returned.
   * @return a path which represents the package name
   * @see ClassLoader#getResource
   * @see Class#getResource
   */
  public static String classPackageAsResourcePath(Class<?> clazz) {
    if (clazz == null) {
      return "";
    }
    String className = clazz.getName();
    int packageEndIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
    if (packageEndIndex == -1) {
      return "";
    }
    String packageName = className.substring(0, packageEndIndex);
    return packageName.replace(PACKAGE_SEPARATOR_CHAR, PATH_SEPARATOR_CHAR);
  }

  /**
   * Build a String that consists of the names of the classes/interfaces in the given array.
   *
   * <p>Basically like {@code AbstractCollection.toString()}, but stripping the "class "/"interface
   * " prefix before every class name.
   *
   * @param classes an array of Class objects
   * @return a String of form "[com.foo.Bar, com.foo.Baz]"
   * @see java.util.AbstractCollection#toString()
   */
  public static String classNamesToString(Class<?>... classes) {
    return classNamesToString(Arrays.asList(classes));
  }

  /**
   * Build a String that consists of the names of the classes/interfaces in the given collection.
   *
   * <p>Basically like {@code AbstractCollection.toString()}, but stripping the "class "/"interface
   * " prefix before every class name.
   *
   * @param classes a Collection of Class objects (may be {@code null})
   * @return a String of form "[com.foo.Bar, com.foo.Baz]"
   * @see java.util.AbstractCollection#toString()
   */
  public static String classNamesToString(Collection<Class<?>> classes) {
    if (CollectionUtils.isEmpty(classes)) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    for (Iterator<Class<?>> it = classes.iterator(); it.hasNext(); ) {
      Class<?> clazz = it.next();
      sb.append(clazz.getName());
      if (it.hasNext()) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  /**
   * Copy the given {@code Collection} into a {@code Class} array.
   *
   * <p>The {@code Collection} must contain {@code Class} elements only.
   *
   * @param collection the {@code Collection} to copy
   * @return the {@code Class} array
   * @since 3.1
   * @see StringUtils#toStringArray
   */
  public static Class<?>[] toClassArray(Collection<Class<?>> collection) {
    if (collection == null) {
      return null;
    }
    return collection.toArray(new Class<?>[collection.size()]);
  }

  /**
   * Return all interfaces that the given instance implements as an array, including ones
   * implemented by superclasses.
   *
   * @param instance the instance to analyze for interfaces
   * @return all interfaces that the given instance implements as an array
   */
  public static Class<?>[] getAllInterfaces(Object instance) {
    Assert.notNull(instance, "Instance must not be null");
    return getAllInterfacesForClass(instance.getClass());
  }

  /**
   * Return all interfaces that the given class implements as an array, including ones implemented
   * by superclasses.
   *
   * <p>If the class itself is an interface, it gets returned as sole interface.
   *
   * @param clazz the class to analyze for interfaces
   * @return all interfaces that the given object implements as an array
   */
  public static Class<?>[] getAllInterfacesForClass(Class<?> clazz) {
    return getAllInterfacesForClass(clazz, null);
  }

  /**
   * Return all interfaces that the given class implements as an array, including ones implemented
   * by superclasses.
   *
   * <p>If the class itself is an interface, it gets returned as sole interface.
   *
   * @param clazz the class to analyze for interfaces
   * @param classLoader the ClassLoader that the interfaces need to be visible in (may be {@code
   *     null} when accepting all declared interfaces)
   * @return all interfaces that the given object implements as an array
   */
  public static Class<?>[] getAllInterfacesForClass(Class<?> clazz, ClassLoader classLoader) {
    return toClassArray(getAllInterfacesForClassAsSet(clazz, classLoader));
  }

  /**
   * Return all interfaces that the given instance implements as a Set, including ones implemented
   * by superclasses.
   *
   * @param instance the instance to analyze for interfaces
   * @return all interfaces that the given instance implements as a Set
   */
  public static Set<Class<?>> getAllInterfacesAsSet(Object instance) {
    Assert.notNull(instance, "Instance must not be null");
    return getAllInterfacesForClassAsSet(instance.getClass());
  }

  /**
   * Return all interfaces that the given class implements as a Set, including ones implemented by
   * superclasses.
   *
   * <p>If the class itself is an interface, it gets returned as sole interface.
   *
   * @param clazz the class to analyze for interfaces
   * @return all interfaces that the given object implements as a Set
   */
  public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz) {
    return getAllInterfacesForClassAsSet(clazz, null);
  }

  /**
   * Return all interfaces that the given class implements as a Set, including ones implemented by
   * superclasses.
   *
   * <p>If the class itself is an interface, it gets returned as sole interface.
   *
   * @param clazz the class to analyze for interfaces
   * @param classLoader the ClassLoader that the interfaces need to be visible in (may be {@code
   *     null} when accepting all declared interfaces)
   * @return all interfaces that the given object implements as a Set
   */
  public static Set<Class<?>> getAllInterfacesForClassAsSet(
      Class<?> clazz, ClassLoader classLoader) {
    Assert.notNull(clazz, "Class must not be null");
    if (clazz.isInterface() && isVisible(clazz, classLoader)) {
      return Collections.<Class<?>>singleton(clazz);
    }
    Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
    Class<?> current = clazz;
    while (current != null) {
      Class<?>[] ifcs = current.getInterfaces();
      for (Class<?> ifc : ifcs) {
        interfaces.addAll(getAllInterfacesForClassAsSet(ifc, classLoader));
      }
      current = current.getSuperclass();
    }
    return interfaces;
  }

  /**
   * Create a composite interface Class for the given interfaces, implementing the given interfaces
   * in one single Class.
   *
   * <p>This implementation builds a JDK proxy class for the given interfaces.
   *
   * @param interfaces the interfaces to merge
   * @param classLoader the ClassLoader to create the composite Class in
   * @return the merged interface as Class
   * @throws IllegalArgumentException if the specified interfaces expose conflicting method
   *     signatures (or a similar constraint is violated)
   * @see java.lang.reflect.Proxy#getProxyClass
   */
  public static Class<?> createCompositeInterface(Class<?>[] interfaces, ClassLoader classLoader) {
    Assert.notEmpty(interfaces, "Interface array must not be empty");
    return Proxy.getProxyClass(classLoader, interfaces);
  }

  /**
   * Determine the common ancestor of the given classes, if any.
   *
   * @param clazz1 the class to introspect
   * @param clazz2 the other class to introspect
   * @return the common ancestor (i.e. common superclass, one interface extending the other), or
   *     {@code null} if none found. If any of the given classes is {@code null}, the other class
   *     will be returned.
   * @since 3.2.6
   */
  public static Class<?> determineCommonAncestor(Class<?> clazz1, Class<?> clazz2) {
    if (clazz1 == null) {
      return clazz2;
    }
    if (clazz2 == null) {
      return clazz1;
    }
    if (clazz1.isAssignableFrom(clazz2)) {
      return clazz1;
    }
    if (clazz2.isAssignableFrom(clazz1)) {
      return clazz2;
    }
    Class<?> ancestor = clazz1;
    do {
      ancestor = ancestor.getSuperclass();
      if (ancestor == null || Object.class == ancestor) {
        return null;
      }
    } while (!ancestor.isAssignableFrom(clazz2));
    return ancestor;
  }

  /**
   * Check whether the given object is a CGLIB proxy.
   *
   * @param object the object to check
   * @see #isCglibProxyClass(Class)
   * @see org.springframework.aop.support.AopUtils#isCglibProxy(Object)
   */
  public static boolean isCglibProxy(Object object) {
    return isCglibProxyClass(object.getClass());
  }

  /**
   * Check whether the specified class is a CGLIB-generated class.
   *
   * @param clazz the class to check
   * @see #isCglibProxyClassName(String)
   */
  public static boolean isCglibProxyClass(Class<?> clazz) {
    return (clazz != null && isCglibProxyClassName(clazz.getName()));
  }

  /**
   * Check whether the specified class name is a CGLIB-generated class.
   *
   * @param className the class name to check
   */
  public static boolean isCglibProxyClassName(String className) {
    return (className != null && className.contains(CGLIB_CLASS_SEPARATOR));
  }

  /**
   * Return the user-defined class for the given instance: usually simply the class of the given
   * instance, but the original class in case of a CGLIB-generated subclass.
   *
   * @param instance the instance to check
   * @return the user-defined class
   */
  public static Class<?> getUserClass(Object instance) {
    Assert.notNull(instance, "Instance must not be null");
    return getUserClass(instance.getClass());
  }

  /**
   * Return the user-defined class for the given class: usually simply the given class, but the
   * original class in case of a CGLIB-generated subclass.
   *
   * @param clazz the class to check
   * @return the user-defined class
   */
  public static Class<?> getUserClass(Class<?> clazz) {
    if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
      Class<?> superclass = clazz.getSuperclass();
      if (superclass != null && Object.class != superclass) {
        return superclass;
      }
    }
    return clazz;
  }

  /**
   * Return a descriptive name for the given object's type: usually simply the class name, but
   * component type class name + "[]" for arrays, and an appended list of implemented interfaces for
   * JDK proxies.
   *
   * @param value the value to introspect
   * @return the qualified name of the class
   */
  public static String getDescriptiveType(Object value) {
    if (value == null) {
      return null;
    }
    Class<?> clazz = value.getClass();
    if (Proxy.isProxyClass(clazz)) {
      StringBuilder result = new StringBuilder(clazz.getName());
      result.append(" implementing ");
      Class<?>[] ifcs = clazz.getInterfaces();
      for (int i = 0; i < ifcs.length; i++) {
        result.append(ifcs[i].getName());
        if (i < ifcs.length - 1) {
          result.append(',');
        }
      }
      return result.toString();
    } else if (clazz.isArray()) {
      return getQualifiedNameForArray(clazz);
    } else {
      return clazz.getName();
    }
  }

  /**
   * Check whether the given class matches the user-specified type name.
   *
   * @param clazz the class to check
   * @param typeName the type name to match
   */
  public static boolean matchesTypeName(Class<?> clazz, String typeName) {
    return (typeName != null
        && (typeName.equals(clazz.getName())
            || typeName.equals(clazz.getSimpleName())
            || (clazz.isArray() && typeName.equals(getQualifiedNameForArray(clazz)))));
  }

  /**
   * Get the class name without the qualified package name.
   *
   * @param className the className to get the short name for
   * @return the class name of the class without the package name
   * @throws IllegalArgumentException if the className is empty
   */
  public static String getShortName(String className) {
    Assert.hasLength(className, "Class name must not be empty");
    int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
    int nameEndIndex = className.indexOf(CGLIB_CLASS_SEPARATOR);
    if (nameEndIndex == -1) {
      nameEndIndex = className.length();
    }
    String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
    shortName = shortName.replace(INNER_CLASS_SEPARATOR, PACKAGE_SEPARATOR);
    return shortName;
  }

  /**
   * Get the class name without the qualified package name.
   *
   * @param clazz the class to get the short name for
   * @return the class name of the class without the package name
   */
  public static String getShortName(Class<?> clazz) {
    return getShortName(getQualifiedName(clazz));
  }

  /**
   * Return the short string name of a Java class in uncapitalized JavaBeans property format. Strips
   * the outer class name in case of an inner class.
   *
   * @param clazz the class
   * @return the short name rendered in a standard JavaBeans property format
   * @see java.beans.Introspector#decapitalize(String)
   */
  public static String getShortNameAsProperty(Class<?> clazz) {
    String shortName = getShortName(clazz);
    int dotIndex = shortName.lastIndexOf(PACKAGE_SEPARATOR);
    shortName = (dotIndex != -1 ? shortName.substring(dotIndex + 1) : shortName);
    return Introspector.decapitalize(shortName);
  }

  /**
   * Determine the name of the class file, relative to the containing package: e.g. "String.class"
   *
   * @param clazz the class
   * @return the file name of the ".class" file
   */
  public static String getClassFileName(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    String className = clazz.getName();
    int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
    return className.substring(lastDotIndex + 1) + CLASS_FILE_SUFFIX;
  }

  /**
   * Return the qualified name of the given class: usually simply the class name, but component type
   * class name + "[]" for arrays.
   *
   * @param clazz the class
   * @return the qualified name of the class
   */
  public static String getQualifiedName(Class<?> clazz) {
    Assert.notNull(clazz, "Class must not be null");
    if (clazz.isArray()) {
      return getQualifiedNameForArray(clazz);
    } else {
      return clazz.getName();
    }
  }

  /**
   * Build a nice qualified name for an array: component type class name + "[]".
   *
   * @param clazz the array class
   * @return a qualified name for the array class
   */
  private static String getQualifiedNameForArray(Class<?> clazz) {
    StringBuilder result = new StringBuilder();
    while (clazz.isArray()) {
      clazz = clazz.getComponentType();
      result.append(ARRAY_SUFFIX);
    }
    result.insert(0, clazz.getName());
    return result.toString();
  }

  /**
   * Return the qualified name of the given method, consisting of fully qualified interface/class
   * name + "." + method name.
   *
   * @param method the method
   * @return the qualified name of the method
   */
  public static String getQualifiedMethodName(Method method) {
    return getQualifiedMethodName(method, null);
  }

  /**
   * Return the qualified name of the given method, consisting of fully qualified interface/class
   * name + "." + method name.
   *
   * @param method the method
   * @param clazz the clazz that the method is being invoked on (may be {@code null} to indicate the
   *     method's declaring class)
   * @return the qualified name of the method
   * @since 4.3.4
   */
  public static String getQualifiedMethodName(Method method, Class<?> clazz) {
    Assert.notNull(method, "Method must not be null");
    return (clazz != null ? clazz : method.getDeclaringClass()).getName() + '.' + method.getName();
  }

  /**
   * Determine whether the given class has a public constructor with the given signature.
   *
   * <p>Essentially translates {@code NoSuchMethodException} to "false".
   *
   * @param clazz the clazz to analyze
   * @param paramTypes the parameter types of the method
   * @return whether the class has a corresponding constructor
   * @see Class#getMethod
   */
  public static boolean hasConstructor(Class<?> clazz, Class<?>... paramTypes) {
    return (getConstructorIfAvailable(clazz, paramTypes) != null);
  }

  /**
   * Determine whether the given class has a public constructor with the given signature, and return
   * it if available (else return {@code null}).
   *
   * <p>Essentially translates {@code NoSuchMethodException} to {@code null}.
   *
   * @param clazz the clazz to analyze
   * @param paramTypes the parameter types of the method
   * @return the constructor, or {@code null} if not found
   * @see Class#getConstructor
   */
  public static <T> Constructor<T> getConstructorIfAvailable(
      Class<T> clazz, Class<?>... paramTypes) {
    Assert.notNull(clazz, "Class must not be null");
    try {
      return clazz.getConstructor(paramTypes);
    } catch (NoSuchMethodException ex) {
      return null;
    }
  }

  /**
   * Determine whether the given class has a public method with the given signature.
   *
   * <p>Essentially translates {@code NoSuchMethodException} to "false".
   *
   * @param clazz the clazz to analyze
   * @param methodName the name of the method
   * @param paramTypes the parameter types of the method
   * @return whether the class has a corresponding method
   * @see Class#getMethod
   */
  public static boolean hasMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
    return (getMethodIfAvailable(clazz, methodName, paramTypes) != null);
  }

  /**
   * Determine whether the given class has a public method with the given signature, and return it
   * if available (else throws an {@code IllegalStateException}).
   *
   * <p>In case of any signature specified, only returns the method if there is a unique candidate,
   * i.e. a single public method with the specified name.
   *
   * <p>Essentially translates {@code NoSuchMethodException} to {@code IllegalStateException}.
   *
   * @param clazz the clazz to analyze
   * @param methodName the name of the method
   * @param paramTypes the parameter types of the method (may be {@code null} to indicate any
   *     signature)
   * @return the method (never {@code null})
   * @throws IllegalStateException if the method has not been found
   * @see Class#getMethod
   */
  public static Method getMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(methodName, "Method name must not be null");
    if (paramTypes != null) {
      try {
        return clazz.getMethod(methodName, paramTypes);
      } catch (NoSuchMethodException ex) {
        throw new IllegalStateException("Expected method not found: " + ex);
      }
    } else {
      Set<Method> candidates = new HashSet<Method>(1);
      Method[] methods = clazz.getMethods();
      for (Method method : methods) {
        if (methodName.equals(method.getName())) {
          candidates.add(method);
        }
      }
      if (candidates.size() == 1) {
        return candidates.iterator().next();
      } else if (candidates.isEmpty()) {
        throw new IllegalStateException(
            "Expected method not found: " + clazz.getName() + '.' + methodName);
      } else {
        throw new IllegalStateException(
            "No unique method found: " + clazz.getName() + '.' + methodName);
      }
    }
  }

  /**
   * Determine whether the given class has a public method with the given signature, and return it
   * if available (else return {@code null}).
   *
   * <p>In case of any signature specified, only returns the method if there is a unique candidate,
   * i.e. a single public method with the specified name.
   *
   * <p>Essentially translates {@code NoSuchMethodException} to {@code null}.
   *
   * @param clazz the clazz to analyze
   * @param methodName the name of the method
   * @param paramTypes the parameter types of the method (may be {@code null} to indicate any
   *     signature)
   * @return the method, or {@code null} if not found
   * @see Class#getMethod
   */
  public static Method getMethodIfAvailable(
      Class<?> clazz, String methodName, Class<?>... paramTypes) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(methodName, "Method name must not be null");
    if (paramTypes != null) {
      try {
        return clazz.getMethod(methodName, paramTypes);
      } catch (NoSuchMethodException ex) {
        return null;
      }
    } else {
      Set<Method> candidates = new HashSet<Method>(1);
      Method[] methods = clazz.getMethods();
      for (Method method : methods) {
        if (methodName.equals(method.getName())) {
          candidates.add(method);
        }
      }
      if (candidates.size() == 1) {
        return candidates.iterator().next();
      }
      return null;
    }
  }

  /**
   * Return the number of methods with a given name (with any argument types), for the given class
   * and/or its superclasses. Includes non-public methods.
   *
   * @param clazz the clazz to check
   * @param methodName the name of the method
   * @return the number of methods with the given name
   */
  public static int getMethodCountForName(Class<?> clazz, String methodName) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(methodName, "Method name must not be null");
    int count = 0;
    Method[] declaredMethods = clazz.getDeclaredMethods();
    for (Method method : declaredMethods) {
      if (methodName.equals(method.getName())) {
        count++;
      }
    }
    Class<?>[] ifcs = clazz.getInterfaces();
    for (Class<?> ifc : ifcs) {
      count += getMethodCountForName(ifc, methodName);
    }
    if (clazz.getSuperclass() != null) {
      count += getMethodCountForName(clazz.getSuperclass(), methodName);
    }
    return count;
  }

  /**
   * Does the given class or one of its superclasses at least have one or more methods with the
   * supplied name (with any argument types)? Includes non-public methods.
   *
   * @param clazz the clazz to check
   * @param methodName the name of the method
   * @return whether there is at least one method with the given name
   */
  public static boolean hasAtLeastOneMethodWithName(Class<?> clazz, String methodName) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(methodName, "Method name must not be null");
    Method[] declaredMethods = clazz.getDeclaredMethods();
    for (Method method : declaredMethods) {
      if (method.getName().equals(methodName)) {
        return true;
      }
    }
    Class<?>[] ifcs = clazz.getInterfaces();
    for (Class<?> ifc : ifcs) {
      if (hasAtLeastOneMethodWithName(ifc, methodName)) {
        return true;
      }
    }
    return (clazz.getSuperclass() != null
        && hasAtLeastOneMethodWithName(clazz.getSuperclass(), methodName));
  }

  /**
   * Given a method, which may come from an interface, and a target class used in the current
   * reflective invocation, find the corresponding target method if there is one. E.g. the method
   * may be {@code IFoo.bar()} and the target class may be {@code DefaultFoo}. In this case, the
   * method may be {@code DefaultFoo.bar()}. This enables attributes on that method to be found.
   *
   * <p><b>NOTE:</b> In contrast to {@link
   * org.springframework.aop.support.AopUtils#getMostSpecificMethod}, this method does <i>not</i>
   * resolve Java 5 bridge methods automatically. Call {@link
   * org.springframework.core.BridgeMethodResolver#findBridgedMethod} if bridge method resolution is
   * desirable (e.g. for obtaining metadata from the original method definition).
   *
   * <p><b>NOTE:</b> Since Spring 3.1.1, if Java security settings disallow reflective access (e.g.
   * calls to {@code Class#getDeclaredMethods} etc, this implementation will fall back to returning
   * the originally provided method.
   *
   * @param method the method to be invoked, which may come from an interface
   * @param targetClass the target class for the current invocation. May be {@code null} or may not
   *     even implement the method.
   * @return the specific target method, or the original method if the {@code targetClass} doesn't
   *     implement it or is {@code null}
   */
  public static Method getMostSpecificMethod(Method method, Class<?> targetClass) {
    if (method != null
        && isOverridable(method, targetClass)
        && targetClass != null
        && targetClass != method.getDeclaringClass()) {
      try {
        if (Modifier.isPublic(method.getModifiers())) {
          try {
            return targetClass.getMethod(method.getName(), method.getParameterTypes());
          } catch (NoSuchMethodException ex) {
            return method;
          }
        } else {
          Method specificMethod =
              ReflectionUtils.findMethod(targetClass, method.getName(), method.getParameterTypes());
          return (specificMethod != null ? specificMethod : method);
        }
      } catch (SecurityException ex) {
        // Security settings are disallowing reflective access; fall back to 'method' below.
      }
    }
    return method;
  }

  /**
   * Determine whether the given method is declared by the user or at least pointing to a
   * user-declared method.
   *
   * <p>Checks {@link Method#isSynthetic()} (for implementation methods) as well as the {@code
   * GroovyObject} interface (for interface methods; on an implementation class, implementations of
   * the {@code GroovyObject} methods will be marked as synthetic anyway). Note that, despite being
   * synthetic, bridge methods ({@link Method#isBridge()}) are considered as user-level methods
   * since they are eventually pointing to a user-declared generic method.
   *
   * @param method the method to check
   * @return {@code true} if the method can be considered as user-declared; [@code false} otherwise
   */
  public static boolean isUserLevelMethod(Method method) {
    Assert.notNull(method, "Method must not be null");
    return (method.isBridge() || (!method.isSynthetic() && !isGroovyObjectMethod(method)));
  }

  private static boolean isGroovyObjectMethod(Method method) {
    return method.getDeclaringClass().getName().equals("groovy.lang.GroovyObject");
  }

  /**
   * Determine whether the given method is overridable in the given target class.
   *
   * @param method the method to check
   * @param targetClass the target class to check against
   */
  private static boolean isOverridable(Method method, Class<?> targetClass) {
    if (Modifier.isPrivate(method.getModifiers())) {
      return false;
    }
    if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
      return true;
    }
    return getPackageName(method.getDeclaringClass()).equals(getPackageName(targetClass));
  }

  /**
   * Return a public static method of a class.
   *
   * @param clazz the class which defines the method
   * @param methodName the static method name
   * @param args the parameter types to the method
   * @return the static method, or {@code null} if no static method was found
   * @throws IllegalArgumentException if the method name is blank or the clazz is null
   */
  public static Method getStaticMethod(Class<?> clazz, String methodName, Class<?>... args) {
    Assert.notNull(clazz, "Class must not be null");
    Assert.notNull(methodName, "Method name must not be null");
    try {
      Method method = clazz.getMethod(methodName, args);
      return Modifier.isStatic(method.getModifiers()) ? method : null;
    } catch (NoSuchMethodException ex) {
      return null;
    }
  }

  /**
   * Get the fully qualified name of the supplied class.
   *
   * <p>This is a null-safe variant of {@link Class#getName()}.
   *
   * @param clazz the class whose name should be retrieved, potentially {@code null}
   * @return the fully qualified class name or {@code "null"} if the supplied class reference is
   *     {@code null}
   * @since 1.3
   * @see #nullSafeToString(Class...)
   * @see StringUtils#nullSafeToString(Object)
   */
  public static String nullSafeToString(Class<?> clazz) {
    return clazz == null ? "null" : clazz.getName();
  }

  /**
   * Generate a comma-separated list of fully qualified class names for the supplied classes.
   *
   * @param classes the classes whose names should be included in the generated string
   * @return a comma-separated list of fully qualified class names, or an empty string if the
   *     supplied class array is {@code null} or empty
   * @see #nullSafeToString(Function, Class...)
   * @see StringUtils#nullSafeToString(Object)
   */
  public static String nullSafeToString(Class<?>... classes) {
    return nullSafeToString(Class::getName, classes);
  }

  /**
   * Generate a comma-separated list of mapped values for the supplied classes.
   *
   * <p>The values are generated by the supplied {@code mapper} (e.g., {@code Class::getName},
   * {@code Class::getSimpleName}, etc.), unless a class reference is {@code null} in which case it
   * will be mapped to {@code "null"}.
   *
   * @param mapper the mapper to use; never {@code null}
   * @param classes the classes to map
   * @return a comma-separated list of mapped values, or an empty string if the supplied class array
   *     is {@code null} or empty
   * @see #nullSafeToString(Class...)
   * @see StringUtils#nullSafeToString(Object)
   */
  public static String nullSafeToString(
      Function<? super Class<?>, ? extends String> mapper, Class<?>... classes) {
    CoreUtils.checkNotNull(mapper, "Mapping function must not be null");

    if (classes == null || classes.length == 0) {
      return "";
    }
    return stream(classes)
        .map(clazz -> clazz == null ? "null" : mapper.apply(clazz))
        .collect(joining(", "));
  }
}
