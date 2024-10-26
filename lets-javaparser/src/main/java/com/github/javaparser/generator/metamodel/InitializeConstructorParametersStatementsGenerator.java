/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.generator.metamodel;

import static com.github.javaparser.StaticJavaParser.parseStatement;
import static com.github.javaparser.generator.metamodel.MetaModelGenerator.nodeMetaModelFieldName;
import static com.github.javaparser.generator.metamodel.MetaModelGenerator.propertyMetaModelFieldName;
import static com.github.javaparser.utils.CodeGenerationUtils.f;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.stmt.Statement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class InitializeConstructorParametersStatementsGenerator {

  void generate(
      Class<? extends Node> nodeClass,
      NodeList<Statement> initializeConstructorParametersStatements) {
    if (nodeClass == Node.class) {
      return;
    }
    Constructor<?> constructor = findAllFieldsConstructor(nodeClass);
    for (java.lang.reflect.Parameter parameter : constructor.getParameters()) {
      Field field = findFieldInClass(nodeClass, parameter.getName());
      String addFieldStatement =
          f(
              "%s.getConstructorParameters().add(%s.%s);",
              nodeMetaModelFieldName(nodeClass),
              nodeMetaModelFieldName(field.getDeclaringClass()),
              propertyMetaModelFieldName(field));
      initializeConstructorParametersStatements.add(parseStatement(addFieldStatement));
    }
  }

  private Field findFieldInClass(Class<?> nodeClass, String name) {
    Class<?> searchClass = nodeClass;
    do {
      for (Field field : searchClass.getDeclaredFields()) {
        if (field.getName().equals(name)) {
          return field;
        }
      }
      searchClass = searchClass.getSuperclass();
    } while (searchClass != null);
    throw new AssertionError(
        f(
            "Couldn't find constructor parameter %s as a field, class %s",
            name, nodeClass.getSimpleName()));
  }

  private Constructor<?> findAllFieldsConstructor(Class<? extends Node> nodeClass) {
    for (Constructor<?> constructor : nodeClass.getDeclaredConstructors()) {
      for (Annotation annotation : constructor.getAnnotations()) {
        if (annotation.annotationType() == AllFieldsConstructor.class) {
          return constructor;
        }
      }
    }
    throw new AssertionError(
        f(
            "Node class %s has no constructor annotated with @AllFieldsConstructor",
            nodeClass.getSimpleName()));
  }
}
