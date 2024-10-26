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
import com.github.javaparser.metamodel.CharLiteralExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.utils.StringEscapeUtils;
import com.github.javaparser.utils.Utils;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A literal character. <br>
 * {@code 'a'} <br>
 * {@code '\t'} <br>
 * {@code 'Ω'} <br>
 * {@code '\177'} <br>
 * {@code '💩'}
 *
 * @author Julio Vilmar Gesser
 */
public class CharLiteralExpr extends LiteralStringValueExpr {

  public CharLiteralExpr() {
    this(null, "?");
  }

  @AllFieldsConstructor
  public CharLiteralExpr(String value) {
    this(null, value);
  }

  /**
   * Constructs a CharLiteralExpr with given escaped character.
   *
   * @param value a char
   */
  public CharLiteralExpr(char value) {
    this(null, StringEscapeUtils.escapeJava(String.valueOf(value)));
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public CharLiteralExpr(TokenRange tokenRange, String value) {
    super(tokenRange, value);
    customInitialization();
  }

  /** Utility method that creates a new StringLiteralExpr. Escapes EOL characters. */
  public static CharLiteralExpr escape(String string) {
    return new CharLiteralExpr(Utils.escapeEndOfLines(string));
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
   * @return the unescaped value character of this literal
   */
  public char asChar() {
    return StringEscapeUtils.unescapeJava(value).charAt(0);
  }

  /**
   * Sets the given char as the literal value
   *
   * @param value a char
   * @return this expression
   */
  public CharLiteralExpr setChar(char value) {
    this.value = String.valueOf(value);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public CharLiteralExpr clone() {
    return (CharLiteralExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public CharLiteralExprMetaModel getMetaModel() {
    return JavaParserMetaModel.charLiteralExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isCharLiteralExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public CharLiteralExpr asCharLiteralExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifCharLiteralExpr(Consumer<CharLiteralExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<CharLiteralExpr> toCharLiteralExpr() {
    return Optional.of(this);
  }
}
