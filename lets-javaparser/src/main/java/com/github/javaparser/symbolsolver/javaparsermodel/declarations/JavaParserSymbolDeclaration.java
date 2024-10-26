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
package com.github.javaparser.symbolsolver.javaparsermodel.declarations;

import static com.github.javaparser.resolution.Navigator.demandParentNode;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.TypePatternExpr;
import com.github.javaparser.resolution.TypeSolver;

/**
 * This should not be used to represent fields of parameters.
 *
 * <p>Eventually this should be renamed in JavaParserVariableDeclaration.
 *
 * @author Federico Tomassetti
 */
public final class JavaParserSymbolDeclaration {

  public static JavaParserFieldDeclaration field(
      VariableDeclarator wrappedNode, TypeSolver typeSolver) {
    return new JavaParserFieldDeclaration(wrappedNode, typeSolver);
  }

  public static JavaParserParameterDeclaration parameter(
      Parameter parameter, TypeSolver typeSolver) {
    return new JavaParserParameterDeclaration(parameter, typeSolver);
  }

  public static JavaParserVariableDeclaration localVar(
      VariableDeclarator variableDeclarator, TypeSolver typeSolver) {
    return new JavaParserVariableDeclaration(variableDeclarator, typeSolver);
  }

  public static JavaParserPatternDeclaration patternVar(
      TypePatternExpr typePatternExpr, TypeSolver typeSolver) {
    return new JavaParserPatternDeclaration(typePatternExpr, typeSolver);
  }

  public static int getParamPos(Parameter parameter) {
    int pos = 0;
    for (Node node : demandParentNode(parameter).getChildNodes()) {
      if (node == parameter) {
        return pos;
      }
      if (node instanceof Parameter) {
        pos++;
      }
    }
    return pos;
  }

  private JavaParserSymbolDeclaration() {
    // This private constructor is used to hide the public one
  }
}
