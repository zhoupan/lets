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
package com.github.javaparser.ast.nodeTypes;

import static com.github.javaparser.StaticJavaParser.parseStatement;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;

/** A node that contains a list of statements. */
public interface NodeWithStatements<N extends Node> {

  NodeList<Statement> getStatements();

  default Statement getStatement(int i) {
    return getStatements().get(i);
  }

  @SuppressWarnings("unchecked")
  default N setStatement(int i, Statement statement) {
    getStatements().set(i, statement);
    return (N) this;
  }

  N setStatements(final NodeList<Statement> statements);

  @SuppressWarnings("unchecked")
  default N addStatement(Statement statement) {
    getStatements().add(statement);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N addStatement(int index, final Statement statement) {
    getStatements().add(index, statement);
    return (N) this;
  }

  default N addStatement(Expression expr) {
    return addStatement(new ExpressionStmt(expr));
  }

  /**
   * It will use {@link JavaParser#parseStatement(String)} inside, so it should end with a semicolon
   */
  default N addStatement(String statement) {
    return addStatement(parseStatement(statement));
  }

  default N addStatement(int index, final Expression expr) {
    Statement stmt = new ExpressionStmt(expr);
    return addStatement(index, stmt);
  }

  default <A extends Statement> A addAndGetStatement(A statement) {
    getStatements().add(statement);
    return statement;
  }

  default Statement addAndGetStatement(int index, final Statement statement) {
    getStatements().add(index, statement);
    return statement;
  }

  default ExpressionStmt addAndGetStatement(Expression expr) {
    ExpressionStmt statement = new ExpressionStmt(expr);
    return addAndGetStatement(statement);
  }

  default ExpressionStmt addAndGetStatement(String statement) {
    return addAndGetStatement(new NameExpr(statement));
  }

  /**
   * @return true if there are no statements contained in this node.
   */
  default boolean isEmpty() {
    return getStatements().isEmpty();
  }

  @SuppressWarnings("unchecked")
  default N copyStatements(NodeList<Statement> nodeList) {
    for (Statement n : nodeList) {
      addStatement(n.clone());
    }
    return (N) this;
  }

  default N copyStatements(NodeWithStatements<?> other) {
    return copyStatements(other.getStatements());
  }
}
