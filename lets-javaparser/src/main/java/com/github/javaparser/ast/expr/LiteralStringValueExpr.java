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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.LiteralStringValueExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/** Any literal value that is stored internally as a String. */
public abstract class LiteralStringValueExpr extends LiteralExpr {

  protected String value;

  @AllFieldsConstructor
  public LiteralStringValueExpr(final String value) {
    this(null, value);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public LiteralStringValueExpr(TokenRange tokenRange, String value) {
    super(tokenRange);
    setValue(value);
    customInitialization();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public String getValue() {
    return value;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LiteralStringValueExpr setValue(final String value) {
    assertNotNull(value);
    if (value == this.value) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.VALUE, this.value, value);
    this.value = value;
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public LiteralStringValueExpr clone() {
    return (LiteralStringValueExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public LiteralStringValueExprMetaModel getMetaModel() {
    return JavaParserMetaModel.literalStringValueExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isLiteralStringValueExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public LiteralStringValueExpr asLiteralStringValueExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifLiteralStringValueExpr(Consumer<LiteralStringValueExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<LiteralStringValueExpr> toLiteralStringValueExpr() {
    return Optional.of(this);
  }
}
