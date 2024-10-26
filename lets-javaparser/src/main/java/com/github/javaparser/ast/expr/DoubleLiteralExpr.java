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

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.DoubleLiteralExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A float or a double constant. This value is stored exactly as found in the source. <br>
 * {@code 100.1f} <br>
 * {@code 23958D} <br>
 * {@code 0x4.5p1f}
 *
 * @author Julio Vilmar Gesser
 */
public class DoubleLiteralExpr extends LiteralStringValueExpr {

  public DoubleLiteralExpr() {
    this(null, "0");
  }

  @AllFieldsConstructor
  public DoubleLiteralExpr(final String value) {
    this(null, value);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public DoubleLiteralExpr(TokenRange tokenRange, String value) {
    super(tokenRange, value);
    customInitialization();
  }

  public DoubleLiteralExpr(final double value) {
    this(null, String.valueOf(value));
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

  /**
   * @return the literal value as a double
   */
  public double asDouble() {
    // Underscores are allowed in number literals for readability reasons but cause a
    // NumberFormatException if
    // passed along to Double#parseDouble. Hence, we apply a simple filter to remove all
    // underscores.
    // See https://github.com/javaparser/javaparser/issues/1980 for more information.
    String noUnderscoreValue = value.replaceAll("_", "");
    return Double.parseDouble(noUnderscoreValue);
  }

  public DoubleLiteralExpr setDouble(double value) {
    this.value = String.valueOf(value);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public DoubleLiteralExpr clone() {
    return (DoubleLiteralExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public DoubleLiteralExprMetaModel getMetaModel() {
    return JavaParserMetaModel.doubleLiteralExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isDoubleLiteralExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public DoubleLiteralExpr asDoubleLiteralExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifDoubleLiteralExpr(Consumer<DoubleLiteralExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<DoubleLiteralExpr> toDoubleLiteralExpr() {
    return Optional.of(this);
  }
}
