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

import static com.github.javaparser.utils.StringEscapeUtils.escapeJava;
import static com.github.javaparser.utils.StringEscapeUtils.unescapeJava;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.StringLiteralExprMetaModel;
import com.github.javaparser.utils.Utils;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A literal string. <br>
 * {@code "Hello World!"} <br>
 * {@code "\"\n"} <br>
 * {@code "\u2122"} <br>
 * {@code "™"} <br>
 * {@code "💩"}
 *
 * @author Julio Vilmar Gesser
 */
public class StringLiteralExpr extends LiteralStringValueExpr {

  public StringLiteralExpr() {
    this(null, "empty");
  }

  /**
   * Creates a string literal expression from given string. Escapes EOL characters.
   *
   * @param value the value of the literal
   */
  @AllFieldsConstructor
  public StringLiteralExpr(final String value) {
    this(null, Utils.escapeEndOfLines(value));
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public StringLiteralExpr(TokenRange tokenRange, String value) {
    super(tokenRange, value);
    customInitialization();
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
   * Sets the content of this expressions to given value. Escapes EOL characters.
   *
   * @param value the new literal value
   * @return self
   */
  public StringLiteralExpr setEscapedValue(String value) {
    this.value = Utils.escapeEndOfLines(value);
    return this;
  }

  /**
   * @return the unescaped literal value
   */
  public String asString() {
    return unescapeJava(value);
  }

  /**
   * Escapes the given string from special characters and uses it as the literal value.
   *
   * @param value unescaped string
   * @return this literal expression
   */
  public StringLiteralExpr setString(String value) {
    this.value = escapeJava(value);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public StringLiteralExpr clone() {
    return (StringLiteralExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public StringLiteralExprMetaModel getMetaModel() {
    return JavaParserMetaModel.stringLiteralExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isStringLiteralExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public StringLiteralExpr asStringLiteralExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifStringLiteralExpr(Consumer<StringLiteralExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<StringLiteralExpr> toStringLiteralExpr() {
    return Optional.of(this);
  }
}
