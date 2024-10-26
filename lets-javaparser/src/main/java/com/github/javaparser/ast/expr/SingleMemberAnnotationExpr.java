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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.SingleMemberAnnotationExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An annotation that has a single value. <br>
 * {@code @Count(15)}
 *
 * @author Julio Vilmar Gesser
 */
public class SingleMemberAnnotationExpr extends AnnotationExpr {

  private Expression memberValue;

  public SingleMemberAnnotationExpr() {
    this(null, new Name(), new StringLiteralExpr());
  }

  @AllFieldsConstructor
  public SingleMemberAnnotationExpr(final Name name, final Expression memberValue) {
    this(null, name, memberValue);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public SingleMemberAnnotationExpr(TokenRange tokenRange, Name name, Expression memberValue) {
    super(tokenRange, name);
    setMemberValue(memberValue);
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getMemberValue() {
    return memberValue;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SingleMemberAnnotationExpr setMemberValue(final Expression memberValue) {
    assertNotNull(memberValue);
    if (memberValue == this.memberValue) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.MEMBER_VALUE, this.memberValue, memberValue);
    if (this.memberValue != null) this.memberValue.setParentNode(null);
    this.memberValue = memberValue;
    setAsParentNodeOf(memberValue);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public SingleMemberAnnotationExpr clone() {
    return (SingleMemberAnnotationExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public SingleMemberAnnotationExprMetaModel getMetaModel() {
    return JavaParserMetaModel.singleMemberAnnotationExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == memberValue) {
      setMemberValue((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isSingleMemberAnnotationExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public SingleMemberAnnotationExpr asSingleMemberAnnotationExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifSingleMemberAnnotationExpr(Consumer<SingleMemberAnnotationExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<SingleMemberAnnotationExpr> toSingleMemberAnnotationExpr() {
    return Optional.of(this);
  }
}
