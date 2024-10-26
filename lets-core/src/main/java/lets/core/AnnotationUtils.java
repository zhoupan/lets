/*
 * Copyright (c) 2023 zhoupan (https://github.com/zhoupan).
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

import static java.util.Arrays.asList;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import lets.core.ReflectionUtils.HierarchyTraversalMode;
import lets.core.collections.CollectionUtils;

/** Collection of utilities for working with {@linkplain Annotation annotations}. */
public final class AnnotationUtils {

  /** Instantiates a new annotation utils. */
  private AnnotationUtils() {
    /* no-op */
  }

  /** The Constant repeatableAnnotationContainerCache. */
  private static final ConcurrentHashMap<Class<? extends Annotation>, Boolean>
      repeatableAnnotationContainerCache = //
      new ConcurrentHashMap<>(16);

  /**
   * Determine if an annotation of {@code annotationType} is either <em>present</em> or
   * <em>meta-present</em> on the supplied optional {@code element}.
   *
   * @param element the element
   * @param annotationType the annotation type
   * @return true, if is annotated
   * @see #findAnnotation(Optional, Class)
   */
  public static boolean isAnnotated(
      Optional<? extends AnnotatedElement> element, Class<? extends Annotation> annotationType) {

    return findAnnotation(element, annotationType).isPresent();
  }

  /**
   * Checks if is annotated.
   *
   * @param parameter the parameter
   * @param index the index
   * @param annotationType the annotation type
   * @return true, if is annotated
   * @see #findAnnotation(Parameter, int, Class)
   * @since 1.8
   */
  public static boolean isAnnotated(
      Parameter parameter, int index, Class<? extends Annotation> annotationType) {
    return findAnnotation(parameter, index, annotationType).isPresent();
  }

  /**
   * Determine if an annotation of {@code annotationType} is either <em>present</em> or
   * <em>meta-present</em> on the supplied {@code element}.
   *
   * @param element the element on which to search for the annotation; may be {@code null}
   * @param annotationType the annotation type to search for; never {@code null}
   * @return {@code true} if the annotation is present or meta-present
   * @see #findAnnotation(AnnotatedElement, Class)
   */
  public static boolean isAnnotated(
      AnnotatedElement element, Class<? extends Annotation> annotationType) {
    return findAnnotation(element, annotationType).isPresent();
  }

  /**
   * Find annotation.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @return the optional
   */
  public static <A extends Annotation> Optional<A> findAnnotation(
      Optional<? extends AnnotatedElement> element, Class<A> annotationType) {

    if (element == null || !element.isPresent()) {
      return Optional.empty();
    }

    return findAnnotation(element.get(), annotationType);
  }

  /**
   * Find annotation.
   *
   * @param <A> the generic type
   * @param parameter the parameter
   * @param index the index
   * @param annotationType the annotation type
   * @return the optional
   * @see #findAnnotation(AnnotatedElement, Class)
   * @since 1.8
   */
  public static <A extends Annotation> Optional<A> findAnnotation(
      Parameter parameter, int index, Class<A> annotationType) {

    return findAnnotation(getEffectiveAnnotatedParameter(parameter, index), annotationType);
  }

  /**
   * Find annotation.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @return the optional
   */
  public static <A extends Annotation> Optional<A> findAnnotation(
      AnnotatedElement element, Class<A> annotationType) {
    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");
    boolean inherited = annotationType.isAnnotationPresent(Inherited.class);
    return findAnnotation(element, annotationType, inherited, new HashSet<>());
  }

  /**
   * Find annotation.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @param inherited the inherited
   * @param visited the visited
   * @return the optional
   */
  private static <A extends Annotation> Optional<A> findAnnotation(
      AnnotatedElement element,
      Class<A> annotationType,
      boolean inherited,
      Set<Annotation> visited) {

    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");

    if (element == null) {
      return Optional.empty();
    }

    // Directly present?
    A annotation = element.getDeclaredAnnotation(annotationType);
    if (annotation != null) {
      return Optional.of(annotation);
    }

    // Meta-present on directly present annotations?
    Optional<A> directMetaAnnotation =
        findMetaAnnotation(annotationType, element.getDeclaredAnnotations(), inherited, visited);
    if (directMetaAnnotation.isPresent()) {
      return directMetaAnnotation;
    }

    if (element instanceof Class) {
      Class<?> clazz = (Class<?>) element;

      // Search on interfaces
      for (Class<?> ifc : clazz.getInterfaces()) {
        if (ifc != Annotation.class) {
          Optional<A> annotationOnInterface =
              findAnnotation(ifc, annotationType, inherited, visited);
          if (annotationOnInterface.isPresent()) {
            return annotationOnInterface;
          }
        }
      }

      // Indirectly present?
      // Search in class hierarchy
      if (inherited) {
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
          Optional<A> annotationOnSuperclass =
              findAnnotation(superclass, annotationType, inherited, visited);
          if (annotationOnSuperclass.isPresent()) {
            return annotationOnSuperclass;
          }
        }
      }
    }

    // Meta-present on indirectly present annotations?
    return findMetaAnnotation(annotationType, element.getAnnotations(), inherited, visited);
  }

  /**
   * Find meta annotation.
   *
   * @param <A> the generic type
   * @param annotationType the annotation type
   * @param candidates the candidates
   * @param inherited the inherited
   * @param visited the visited
   * @return the optional
   */
  private static <A extends Annotation> Optional<A> findMetaAnnotation(
      Class<A> annotationType,
      Annotation[] candidates,
      boolean inherited,
      Set<Annotation> visited) {

    for (Annotation candidateAnnotation : candidates) {
      Class<? extends Annotation> candidateAnnotationType = candidateAnnotation.annotationType();
      if (!isInJavaLangAnnotationPackage(candidateAnnotationType)
          && visited.add(candidateAnnotation)) {
        Optional<A> metaAnnotation =
            findAnnotation(candidateAnnotationType, annotationType, inherited, visited);
        if (metaAnnotation.isPresent()) {
          return metaAnnotation;
        }
      }
    }
    return Optional.empty();
  }

  /**
   * Find the first annotation of the specified type that is either <em>directly present</em>,
   * <em>meta-present</em>, or <em>indirectly present</em> on the supplied class, optionally
   * searching recursively through the enclosing class hierarchy if not found on the supplied class.
   *
   * <p>The enclosing class hierarchy will only be searched above an <em>inner class</em> (i.e., a
   * non-static member class).
   *
   * @param <A> the annotation type
   * @param clazz the class on which to search for the annotation; may be {@code null}
   * @param annotationType the annotation type to search for; never {@code null}
   * @param searchEnclosingClasses whether the enclosing class hierarchy should be searched
   * @return an {@code Optional} containing the annotation; never {@code null} but potentially empty
   * @see #findAnnotation(AnnotatedElement, Class)
   * @since 1.8
   */
  public static <A extends Annotation> Optional<A> findAnnotation(
      Class<?> clazz, Class<A> annotationType, boolean searchEnclosingClasses) {

    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");

    if (!searchEnclosingClasses) {
      return findAnnotation(clazz, annotationType);
    }

    Class<?> candidate = clazz;
    while (candidate != null) {
      Optional<A> annotation = findAnnotation(candidate, annotationType);
      if (annotation.isPresent()) {
        return annotation;
      }
      candidate = (ClassUtils.isInnerClass(candidate) ? candidate.getEnclosingClass() : null);
    }
    return Optional.empty();
  }

  /**
   * Find repeatable annotations.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @return the list
   */
  public static <A extends Annotation> List<A> findRepeatableAnnotations(
      Optional<? extends AnnotatedElement> element, Class<A> annotationType) {

    if (element == null || !element.isPresent()) {
      return Collections.emptyList();
    }

    return findRepeatableAnnotations(element.get(), annotationType);
  }

  /**
   * Find repeatable annotations.
   *
   * @param <A> the generic type
   * @param parameter the parameter
   * @param index the index
   * @param annotationType the annotation type
   * @return the list
   * @see #findRepeatableAnnotations(AnnotatedElement, Class)
   * @since 1.8
   */
  public static <A extends Annotation> List<A> findRepeatableAnnotations(
      Parameter parameter, int index, Class<A> annotationType) {

    return findRepeatableAnnotations(
        getEffectiveAnnotatedParameter(parameter, index), annotationType);
  }

  /**
   * Find repeatable annotations.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @return the list
   */
  public static <A extends Annotation> List<A> findRepeatableAnnotations(
      AnnotatedElement element, Class<A> annotationType) {

    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");
    Repeatable repeatable = annotationType.getAnnotation(Repeatable.class);
    CoreUtils.checkNotNull(repeatable, "%s must be @Repeatable", annotationType.getName());
    Class<? extends Annotation> containerType = repeatable.value();
    boolean inherited = containerType.isAnnotationPresent(Inherited.class);

    // Short circuit the search algorithm.
    if (element == null) {
      return Collections.emptyList();
    }

    // We use a LinkedHashSet because the search algorithm may discover
    // duplicates, but we need to maintain the original order.
    Set<A> found = new LinkedHashSet<>(16);
    findRepeatableAnnotations(
        element, annotationType, containerType, inherited, found, new HashSet<>(16));
    // unmodifiable since returned from public, non-internal method(s)
    return Collections.unmodifiableList(new ArrayList<>(found));
  }

  /**
   * Find repeatable annotations.
   *
   * @param <A> the generic type
   * @param element the element
   * @param annotationType the annotation type
   * @param containerType the container type
   * @param inherited the inherited
   * @param found the found
   * @param visited the visited
   */
  private static <A extends Annotation> void findRepeatableAnnotations(
      AnnotatedElement element,
      Class<A> annotationType,
      Class<? extends Annotation> containerType,
      boolean inherited,
      Set<A> found,
      Set<Annotation> visited) {

    if (element instanceof Class) {
      Class<?> clazz = (Class<?>) element;

      // Recurse first in order to support top-down semantics for inherited, repeatable annotations.
      if (inherited) {
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
          findRepeatableAnnotations(
              superclass, annotationType, containerType, inherited, found, visited);
        }
      }

      // Search on interfaces
      for (Class<?> ifc : clazz.getInterfaces()) {
        if (ifc != Annotation.class) {
          findRepeatableAnnotations(ifc, annotationType, containerType, inherited, found, visited);
        }
      }
    }

    // Find annotations that are directly present or meta-present on directly present annotations.
    findRepeatableAnnotations(
        element.getDeclaredAnnotations(), annotationType, containerType, inherited, found, visited);

    // Find annotations that are indirectly present or meta-present on indirectly present
    // annotations.
    findRepeatableAnnotations(
        element.getAnnotations(), annotationType, containerType, inherited, found, visited);
  }

  /**
   * Find repeatable annotations.
   *
   * @param <A> the generic type
   * @param candidates the candidates
   * @param annotationType the annotation type
   * @param containerType the container type
   * @param inherited the inherited
   * @param found the found
   * @param visited the visited
   */
  @SuppressWarnings("unchecked")
  private static <A extends Annotation> void findRepeatableAnnotations(
      Annotation[] candidates,
      Class<A> annotationType,
      Class<? extends Annotation> containerType,
      boolean inherited,
      Set<A> found,
      Set<Annotation> visited) {

    for (Annotation candidate : candidates) {
      Class<? extends Annotation> candidateAnnotationType = candidate.annotationType();
      if (!isInJavaLangAnnotationPackage(candidateAnnotationType) && visited.add(candidate)) {
        // Exact match?
        if (candidateAnnotationType.equals(annotationType)) {
          found.add(annotationType.cast(candidate));
        }
        // Container?
        else if (candidateAnnotationType.equals(containerType)) {
          // Note: it's not a legitimate containing annotation type if it doesn't declare
          // a 'value' attribute that returns an array of the contained annotation type.
          // See https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.6.3
          Method method =
              ReflectionUtils.tryToGetMethod(containerType, "value")
                  .getOrThrow(
                      cause ->
                          new RuntimeException(
                              String.format(
                                  "Container annotation type '%s' must declare a 'value' attribute of type %s[].",
                                  containerType, annotationType),
                              cause));

          Annotation[] containedAnnotations =
              (Annotation[]) ReflectionUtils.invokeMethod(method, candidate);
          found.addAll((Collection<? extends A>) asList(containedAnnotations));
        }
        // Nested container annotation?
        else if (isRepeatableAnnotationContainer(candidateAnnotationType)) {
          Method method =
              ReflectionUtils.tryToGetMethod(candidateAnnotationType, "value").toOptional().get();
          Annotation[] containedAnnotations =
              (Annotation[]) ReflectionUtils.invokeMethod(method, candidate);

          for (Annotation containedAnnotation : containedAnnotations) {
            findRepeatableAnnotations(
                containedAnnotation.getClass(),
                annotationType,
                containerType,
                inherited,
                found,
                visited);
          }
        }
        // Otherwise search recursively through the meta-annotation hierarchy...
        else {
          findRepeatableAnnotations(
              candidateAnnotationType, annotationType, containerType, inherited, found, visited);
        }
      }
    }
  }

  /**
   * Determine if the supplied annotation type is a container for a repeatable annotation.
   *
   * @param candidateContainerType the candidate container type
   * @return true, if is repeatable annotation container
   * @since 1.5
   */
  private static boolean isRepeatableAnnotationContainer(
      Class<? extends Annotation> candidateContainerType) {
    return repeatableAnnotationContainerCache.computeIfAbsent(
        candidateContainerType,
        candidate -> {
          // @formatter:off
          Repeatable repeatable =
              Arrays.stream(candidate.getMethods())
                  .filter(
                      attribute ->
                          attribute.getName().equals("value")
                              && attribute.getReturnType().isArray())
                  .findFirst()
                  .map(
                      attribute ->
                          attribute
                              .getReturnType()
                              .getComponentType()
                              .getAnnotation(Repeatable.class))
                  .orElse(null);
          // @formatter:on

          return repeatable != null && candidate.equals(repeatable.value());
        });
  }

  /**
   * Due to a bug in {@code javac} on JDK versions prior to JDK 9, looking up annotations directly
   * on a {@link Parameter} will fail for inner class constructors.
   *
   * <h4>Bug in {@code javac} on JDK versions prior to JDK 9</h4>
   *
   * <p>The parameter annotations array in the compiled byte code for the user's class excludes an
   * entry for the implicit <em>enclosing instance</em> parameter for an inner class constructor.
   *
   * <h4>Workaround</h4>
   *
   * <p>This method provides a workaround for this off-by-one error by helping JUnit maintainers and
   * extension authors to access annotations on the preceding {@link Parameter} object (i.e., {@code
   * index - 1}). If the supplied {@code index} is zero in such situations this method will return
   * {@code null} since the parameter for the implicit <em>enclosing instance</em> will never be
   * annotated.
   *
   * <h4>WARNING</h4>
   *
   * <p>The {@code AnnotatedElement} returned by this method should never be cast and treated as a
   * {@code Parameter} since the metadata (e.g., {@link Parameter#getName()}, {@link
   * Parameter#getType()}, etc.) will not match those for the declared parameter at the given index
   * in an inner class constructor for code compiled with JDK 8.
   *
   * @param parameter the parameter
   * @param index the index
   * @return the supplied {@code Parameter}, or the <em>effective</em> {@code Parameter} if the
   *     aforementioned bug is detected, or {@code null} if the bug is detected and the supplied
   *     {@code index} is {@code 0}
   * @since 1.8
   */
  private static AnnotatedElement getEffectiveAnnotatedParameter(Parameter parameter, int index) {
    CoreUtils.checkNotNull(parameter, "Parameter must not be null");
    Executable executable = parameter.getDeclaringExecutable();

    if (executable instanceof Constructor
        && ClassUtils.isInnerClass(executable.getDeclaringClass())
        && executable.getParameterAnnotations().length == executable.getParameterCount() - 1) {

      if (index == 0) {
        return null;
      }

      return executable.getParameters()[index - 1];
    }

    return parameter;
  }

  /**
   * Find public annotated fields.
   *
   * @param clazz the clazz
   * @param fieldType the field type
   * @param annotationType the annotation type
   * @return the list
   */
  public static List<Field> findPublicAnnotatedFields(
      Class<?> clazz, Class<?> fieldType, Class<? extends Annotation> annotationType) {

    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(fieldType, "fieldType must not be null");
    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");

    // @formatter:off
    return Arrays.stream(clazz.getFields())
        .filter(
            field ->
                fieldType.isAssignableFrom(field.getType()) && isAnnotated(field, annotationType))
        .collect(CollectionUtils.toUnmodifiableList());
    // @formatter:on
  }

  /**
   * Find all {@linkplain Field fields} of the supplied class or interface that are annotated or
   * <em>meta-annotated</em> with the specified {@code annotationType} and match the specified
   * {@code predicate}, using top-down search semantics within the type hierarchy.
   *
   * @param clazz the clazz
   * @param annotationType the annotation type
   * @param predicate the predicate
   * @return the list
   * @see #findAnnotatedFields(Class, Class, Predicate, HierarchyTraversalMode)
   */
  public static List<Field> findAnnotatedFields(
      Class<?> clazz, Class<? extends Annotation> annotationType, Predicate<Field> predicate) {

    return findAnnotatedFields(clazz, annotationType, predicate, HierarchyTraversalMode.TOP_DOWN);
  }

  /**
   * Find all {@linkplain Field fields} of the supplied class or interface that are annotated or
   * <em>meta-annotated</em> with the specified {@code annotationType} and match the specified
   * {@code predicate}.
   *
   * @param clazz the class or interface in which to find the fields; never {@code null}
   * @param annotationType the annotation type to search for; never {@code null}
   * @param predicate the field filter; never {@code null}
   * @param traversalMode the hierarchy traversal mode; never {@code null}
   * @return the list of all such fields found; neither {@code null} nor mutable
   */
  public static List<Field> findAnnotatedFields(
      Class<?> clazz,
      Class<? extends Annotation> annotationType,
      Predicate<Field> predicate,
      HierarchyTraversalMode traversalMode) {

    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");
    CoreUtils.checkNotNull(predicate, "Predicate must not be null");

    Predicate<Field> annotated = field -> isAnnotated(field, annotationType);

    return ReflectionUtils.findFields(clazz, annotated.and(predicate), traversalMode);
  }

  /**
   * Find annotated methods.
   *
   * @param clazz the clazz
   * @param annotationType the annotation type
   * @param traversalMode the traversal mode
   * @return the list
   */
  public static List<Method> findAnnotatedMethods(
      Class<?> clazz,
      Class<? extends Annotation> annotationType,
      HierarchyTraversalMode traversalMode) {

    CoreUtils.checkNotNull(clazz, "Class must not be null");
    CoreUtils.checkNotNull(annotationType, "annotationType must not be null");

    return ReflectionUtils.findMethods(
        clazz, method -> isAnnotated(method, annotationType), traversalMode);
  }

  /**
   * Checks if is in java lang annotation package.
   *
   * @param annotationType the annotation type
   * @return true, if is in java lang annotation package
   */
  private static boolean isInJavaLangAnnotationPackage(Class<? extends Annotation> annotationType) {
    return (annotationType != null && annotationType.getName().startsWith("java.lang.annotation"));
  }

  /**
   * Gets the annotation types.
   *
   * @param cls the cls
   * @return the annotation types
   */
  public static List<Class<? extends Annotation>> getAnnotationTypes(Class<?> cls) {
    List<Class<? extends Annotation>> types = new ArrayList<>();
    for (Annotation a : cls.getAnnotations()) {
      if (!types.contains(a.annotationType())) {
        types.add(a.annotationType());
      }
    }
    return types;
  }
}
