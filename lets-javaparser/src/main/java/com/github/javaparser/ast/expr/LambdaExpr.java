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
package com.github.javaparser.ast.expr;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.nodeTypes.NodeWithParameters;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.LambdaExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>A lambda expression</h1>
 *
 * <h2>Java 1-7</h2>
 *
 * Does not exist.
 *
 * <h2>Java 8+</h2>
 *
 * {@code (a, b) -> a + b} <br>
 * {@code a -> ...} <br>
 * {@code (Long a) -> { println(a); }}
 *
 * <p>The parameters are on the left side of the -&gt;. If a parameter uses type inference (it has
 * no type specified) then its type is set to {@code UnknownType}. If they are in ( ),
 * "isEnclosingParameters" is true. <br>
 * The body is to the right of the -&gt;. The body is either a BlockStmt when it is in { } braces,
 * or an ExpressionStmt when it is not in braces.
 *
 * @author Raquel Pau
 */
public class LambdaExpr extends Expression implements NodeWithParameters<LambdaExpr> {

  private NodeList<Parameter> parameters;

  private boolean isEnclosingParameters;

  private Statement body;

  public LambdaExpr() {
    this(null, new NodeList<>(), new ReturnStmt(), false);
  }

  /** Creates a single parameter lambda expression. */
  public LambdaExpr(Parameter parameter, BlockStmt body) {
    this(null, new NodeList<>(parameter), body, false);
  }

  /** Creates a zero or multi-parameter lambda expression with its parameters wrapped in ( ). */
  public LambdaExpr(NodeList<Parameter> parameters, BlockStmt body) {
    this(null, parameters, body, true);
  }

  /** Creates a single parameter lambda expression. */
  public LambdaExpr(Parameter parameter, Expression body) {
    this(null, new NodeList<>(parameter), new ExpressionStmt(body), false);
  }

  /** Creates a zero or multi-parameter lambda expression with its parameters wrapped in ( ). */
  public LambdaExpr(NodeList<Parameter> parameters, Expression body) {
    this(null, parameters, new ExpressionStmt(body), true);
  }

  @AllFieldsConstructor
  public LambdaExpr(NodeList<Parameter> parameters, Statement body, boolean isEnclosingParameters) {
    this(null, parameters, body, isEnclosingParameters);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public LambdaExpr(
      TokenRange tokenRange,
      NodeList<Parameter> parameters,
      Statement body,
      boolean isEnclosingParameters) {
    super(tokenRange);
    setParameters(parameters);
    setBody(body);
    setEnclosingParameters(isEnclosingParameters);
    customInitialization();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Parameter> getParameters() {
    return parameters;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LambdaExpr setParameters(final NodeList<Parameter> parameters) {
    assertNotNull(parameters);
    if (parameters == this.parameters) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.PARAMETERS, this.parameters, parameters);
    if (this.parameters != null) this.parameters.setParentNode(null);
    this.parameters = parameters;
    setAsParentNodeOf(parameters);
    return this;
  }

  /**
   * @return a BlockStatement or an ExpressionStatement. See class Javadoc.
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Statement getBody() {
    return body;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LambdaExpr setBody(final Statement body) {
    assertNotNull(body);
    if (body == this.body) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.BODY, this.body, body);
    if (this.body != null) this.body.setParentNode(null);
    this.body = body;
    setAsParentNodeOf(body);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
  public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
    return v.visit(this, arg);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
  public <A> void accept(final VoidVisitor<A> v, final A arg) {
    v.visit(this, arg);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public boolean isEnclosingParameters() {
    return isEnclosingParameters;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LambdaExpr setEnclosingParameters(final boolean isEnclosingParameters) {
    if (isEnclosingParameters == this.isEnclosingParameters) {
      return this;
    }
    notifyPropertyChange(
        ObservableProperty.ENCLOSING_PARAMETERS, this.isEnclosingParameters, isEnclosingParameters);
    this.isEnclosingParameters = isEnclosingParameters;
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < parameters.size(); i++) {
      if (parameters.get(i) == node) {
        parameters.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  /**
   * @return if the body of this lambda is a simple expression, return that expression. Otherwise
   *     (when the body is a block) return Optional.empty().
   */
  @DerivedProperty
  public Optional<Expression> getExpressionBody() {
    if (body.isExpressionStmt()) {
      return Optional.of(body.asExpressionStmt().getExpression());
    }
    return Optional.empty();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public LambdaExpr clone() {
    return (LambdaExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public LambdaExprMetaModel getMetaModel() {
    return JavaParserMetaModel.lambdaExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == body) {
      setBody((Statement) replacementNode);
      return true;
    }
    for (int i = 0; i < parameters.size(); i++) {
      if (parameters.get(i) == node) {
        parameters.set(i, (Parameter) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isLambdaExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public LambdaExpr asLambdaExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifLambdaExpr(Consumer<LambdaExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<LambdaExpr> toLambdaExpr() {
    return Optional.of(this);
  }

  /*
   * Lambda expressions are always poly expressions
   */
  @Override
  public boolean isPolyExpression() {
    return true;
  }

  /*
   * Returns true if no type parameter has been defined
   */
  public boolean isExplicitlyTyped() {
    return getParameters().stream().allMatch(p -> !(p.getType().isUnknownType()));
  }
}
