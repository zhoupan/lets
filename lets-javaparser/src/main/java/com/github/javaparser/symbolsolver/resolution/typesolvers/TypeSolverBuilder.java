/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.resolution.typesolvers;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.javaparser.resolution.TypeSolver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * TypeSolverBuilder was created with the objective of simplifying the process of creating new type
 * solved. Instead of invoking the constructor directly, the user can build it using the builder
 * pattern.
 *
 * <p><b>Example 1:</b> Solve JRE types: <br>
 *
 * <pre>
 *     new TypeSolverBuilder()
 *          .withCurrentJRE()
 *          .build()
 * </pre>
 *
 * <p><b>Example 2:</b> Solve JRE and types defined in foo.jar: <br>
 *
 * <pre>
 *     new TypeSolverBuilder()
 *          .withCurrentJRE()
 *          .withJAR("foo.jar")
 *          .build()
 * </pre>
 *
 * @author 4everTheOne
 */
public class TypeSolverBuilder {

  private final List<TypeSolver> typeSolvers = new ArrayList<>();

  /**
   * Append a costum type solver to the build.
   *
   * @param typeSolver The type solver to be added.
   * @return the current builder.
   */
  public TypeSolverBuilder with(@NonNull TypeSolver typeSolver) {
    checkNotNull(typeSolver, "The typeSolver can't be null!");

    typeSolvers.add(typeSolver);
    return this;
  }

  // Builders for Reflection

  /**
   * Allow the type solver to resolve types that are defined in the current Java Runtime Environment
   * (JRE).
   *
   * <p>Some examples of those types are:
   *
   * <ul>
   *   <li>java.lang.Object
   *   <li>java.lang.String
   *   <li>java.lang.Math
   *   <li>...
   * </ul>
   *
   * @return the current builder.
   * @see ReflectionTypeSolver
   */
  public TypeSolverBuilder withCurrentJRE() {
    TypeSolver javaRuntime = new ReflectionTypeSolver();
    return with(javaRuntime);
  }

  /**
   * Allow the type solver to resolve types that are defined in the current {@link ClassLoader}.
   *
   * <p>Some examples of those types are:
   *
   * <ul>
   *   <li>java.lang.Object
   *   <li>java.lang.String
   *   <li>java.lang.Math
   *   <li>com.github.javaparser.ast.Node
   *   <li>com.github.javaparser.symbolsolver.resolution.typesolvers.TypeSolverBuilder
   *   <li>...
   * </ul>
   *
   * @return the current builder.
   * @see ReflectionTypeSolver
   */
  public TypeSolverBuilder withCurrentClassloader() {
    TypeSolver classLoaderTypeSolver = new ReflectionTypeSolver(false);
    return with(classLoaderTypeSolver);
  }

  // Builders for JARS

  /**
   * Allow the type solver to resolve types that are defined in a JAR file.
   *
   * @param pathToJar The path to the jar file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the Jar.
   * @see JarTypeSolver
   */
  public TypeSolverBuilder withJAR(@NonNull Path pathToJar) throws IOException {
    TypeSolver jarTypeSolver = new JarTypeSolver(pathToJar);
    return with(jarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types that are defined in a JAR file.
   *
   * @param pathToJar The jar file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the Jar.
   * @see JarTypeSolver
   */
  public TypeSolverBuilder withJAR(@NonNull File pathToJar) throws IOException {
    TypeSolver jarTypeSolver = new JarTypeSolver(pathToJar);
    return with(jarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types that are defined in a JAR file.
   *
   * @param pathToJar The path to the jar file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the Jar.
   * @see JarTypeSolver
   */
  public TypeSolverBuilder withJAR(@NonNull String pathToJar) throws IOException {
    TypeSolver jarTypeSolver = new JarTypeSolver(pathToJar);
    return with(jarTypeSolver);
  }

  // Builders for AarTypeSolver

  /**
   * Allow the type solver to resolve types that are defined in a AAR file.
   *
   * @param pathToAar The path to the AAR file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the AAR.
   * @see AarTypeSolver
   */
  public TypeSolverBuilder withAAR(@NonNull Path pathToAar) throws IOException {
    TypeSolver aarTypeSolver = new AarTypeSolver(pathToAar);
    return with(aarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types that are defined in a AAR file.
   *
   * @param pathToAar The AAR file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the AAR.
   * @see AarTypeSolver
   */
  public TypeSolverBuilder withAAR(@NonNull File pathToAar) throws IOException {
    TypeSolver aarTypeSolver = new AarTypeSolver(pathToAar);
    return with(aarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types that are defined in a AAR file.
   *
   * @param pathToAar The path to the AAR file.
   * @return the current builder.
   * @throws IOException If an I/O exception occurs while reading the AAR.
   * @see AarTypeSolver
   */
  public TypeSolverBuilder withAAR(@NonNull String pathToAar) throws IOException {
    TypeSolver aarTypeSolver = new AarTypeSolver(pathToAar);
    return with(aarTypeSolver);
  }

  // Builders for JavaParserTypeSolver

  /**
   * Allow the type solver to resolve types using external source code.
   *
   * @param pathToSourceCode The path to the source code.
   * @return the current builder.
   * @see JavaParserTypeSolver
   */
  public TypeSolverBuilder withSourceCode(@NonNull Path pathToSourceCode) {
    TypeSolver aarTypeSolver = new JavaParserTypeSolver(pathToSourceCode);
    return with(aarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types using external source code.
   *
   * @param pathToSourceCode The source code file.
   * @return the current builder.
   * @see JavaParserTypeSolver
   */
  public TypeSolverBuilder withSourceCode(@NonNull File pathToSourceCode) {
    TypeSolver aarTypeSolver = new JavaParserTypeSolver(pathToSourceCode);
    return with(aarTypeSolver);
  }

  /**
   * Allow the type solver to resolve types using external source code.
   *
   * @param pathToSourceCode The path to the source code.
   * @return the current builder.
   * @see JavaParserTypeSolver
   */
  public TypeSolverBuilder withSourceCode(@NonNull String pathToSourceCode) {
    TypeSolver aarTypeSolver = new JavaParserTypeSolver(pathToSourceCode);
    return with(aarTypeSolver);
  }

  // Builders for ClassLoaderTypeSolver

  /**
   * Allow the type solver to resolve types using the provided {@link ClassLoader}.
   *
   * @param classLoader The class loader to be registered.
   * @return the current builder.
   * @see ClassLoaderTypeSolver
   */
  public TypeSolverBuilder withClassLoader(@NonNull ClassLoader classLoader) {
    TypeSolver classLoaderTypeSolver = new ClassLoaderTypeSolver(classLoader);
    return with(classLoaderTypeSolver);
  }

  // build

  /**
   * Convert the current build into a valid {@link TypeSolver}.
   *
   * @return The type solver with the requested configuration.
   * @throws IllegalStateException if no build configuration is provided.
   */
  public TypeSolver build() {
    int typeSolversCount = typeSolvers.size();

    // Check if at least one solver is present
    if (typeSolversCount == 0) {
      throw new IllegalStateException("At least a type solver is expected.");
    }

    // Check if only one exists
    if (typeSolversCount == 1) {
      return typeSolvers.get(0);
    }

    // Combine all type solver
    return new CombinedTypeSolver(typeSolvers);
  }
}
