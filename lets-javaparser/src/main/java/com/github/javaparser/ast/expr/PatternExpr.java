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
import com.github.javaparser.ast.nodeTypes.NodeWithType;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.PatternExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>Pattern Matching in Java</h1>
 *
 * <h2>Java 1.0 to 13</h2>
 *
 * Not available. <br>
 *
 * <h2>Java 14</h2>
 *
 * Java 14 introduced TypePatterns with simple pattern matching in {@code instanceof} expressions.
 *
 * @see com.github.javaparser.ast.expr.TypePatternExpr
 *     <h2>Java 21</h2>
 *     In Java 21, support for pattern matching was extended to switch expressions and {@code Record
 *     Patterns} were introduced. Since {@code Record Patterns} and {@code TypePatterns} can be used
 *     interchangeably, the {@code PatternExpr} class is used as a common parent for both in the
 *     JavaParser AST.
 *     <h3>JDK21 Grammar</h3>
 *     <br>
 *     <pre><code>Pattern:
 *     TypePattern
 *     RecordPattern
 * TypePattern:
 *     LocalVariableDeclaration
 * RecordPattern:
 *     ReferenceType ( [PatternList] )
 * PatternList:
 *     Pattern {, Pattern }</code></pre>
 *
 * @author Johannes Coetzee
 * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8181287">JEP305:
 *     https://bugs.openjdk.java.net/browse/JDK-8181287</a>
 * @see <a
 *     href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.20">https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.20</a>
 */
public abstract class PatternExpr extends Expression
    implements NodeWithType<PatternExpr, ReferenceType> {

  private ReferenceType type;

  @AllFieldsConstructor
  public PatternExpr(final ReferenceType type) {}

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isPatternExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public PatternExpr asPatternExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<PatternExpr> toPatternExpr() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifPatternExpr(Consumer<PatternExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public PatternExpr clone() {
    return (PatternExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public PatternExprMetaModel getMetaModel() {
    return JavaParserMetaModel.patternExprMetaModel;
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public PatternExpr(TokenRange tokenRange) {
    super(tokenRange);
    customInitialization();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public PatternExpr setType(final ReferenceType type) {
    assertNotNull(type);
    if (type == this.type) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TYPE, this.type, type);
    if (this.type != null) this.type.setParentNode(null);
    this.type = type;
    setAsParentNodeOf(type);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ReferenceType getType() {
    return type;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == type) {
      setType((ReferenceType) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public PatternExpr(TokenRange tokenRange, ReferenceType type) {
    super(tokenRange);
    setType(type);
    customInitialization();
  }
}
