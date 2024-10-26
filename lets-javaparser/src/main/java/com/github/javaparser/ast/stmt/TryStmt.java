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
package com.github.javaparser.ast.stmt;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.TryStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>The try statement</h1>
 *
 * <h2>Java 1.0-6</h2>
 *
 * <pre>
 * try {
 * // ...
 * } catch (IOException e) {
 * // ...
 * } finally {
 * // ...
 * }
 * </pre>
 *
 * In this code, "// do things" is the content of the tryBlock, there is one catch clause that
 * catches IOException e, and there is a finally block.
 *
 * <p>The catch and finally blocks are optional, but they should not be empty at the same time.
 *
 * <h2>Java 7-8</h2>
 *
 * <pre>
 * try (InputStream i = new FileInputStream("file")) {
 * // ...
 * } catch (IOException|NullPointerException e) {
 * // ...
 * } finally {
 * // ...
 * }
 * </pre>
 *
 * Java 7 introduced two things:
 *
 * <ul>
 *   <li>Resources can be specified after "try", but only variable declarations
 *       (VariableDeclarationExpr.)
 *   <li>A single catch can catch multiple exception types. This uses the IntersectionType.
 * </ul>
 *
 * <h2>Java 9+</h2>
 *
 * <pre>
 * try (r) {
 * // ...
 * } catch (IOException|NullPointerException e) {
 * // ...
 * } finally {
 * // ...
 * }
 * </pre>
 *
 * Java 9 finishes resources: you can now refer to a resource that was declared somewhere else. The
 * following types are allowed:
 *
 * <ul>
 *   <li>VariableDeclarationExpr: "X x = new X()" like in Java 7-8.
 *   <li>NameExpr: "a".
 *   <li>FieldAccessExpr: "x.y.z", "super.test" etc.
 * </ul>
 *
 * @author Julio Vilmar Gesser
 * @see CatchClause
 * @see com.github.javaparser.ast.type.IntersectionType
 * @see com.github.javaparser.ast.expr.FieldAccessExpr
 * @see com.github.javaparser.ast.expr.NameExpr
 */
public class TryStmt extends Statement {

  private NodeList<Expression> resources;

  private BlockStmt tryBlock;

  private NodeList<CatchClause> catchClauses;

  @OptionalProperty private BlockStmt finallyBlock;

  public TryStmt() {
    this(null, new NodeList<>(), new BlockStmt(), new NodeList<>(), null);
  }

  public TryStmt(
      final BlockStmt tryBlock,
      final NodeList<CatchClause> catchClauses,
      final BlockStmt finallyBlock) {
    this(null, new NodeList<>(), tryBlock, catchClauses, finallyBlock);
  }

  @AllFieldsConstructor
  public TryStmt(
      NodeList<Expression> resources,
      final BlockStmt tryBlock,
      final NodeList<CatchClause> catchClauses,
      final BlockStmt finallyBlock) {
    this(null, resources, tryBlock, catchClauses, finallyBlock);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public TryStmt(
      TokenRange tokenRange,
      NodeList<Expression> resources,
      BlockStmt tryBlock,
      NodeList<CatchClause> catchClauses,
      BlockStmt finallyBlock) {
    super(tokenRange);
    setResources(resources);
    setTryBlock(tryBlock);
    setCatchClauses(catchClauses);
    setFinallyBlock(finallyBlock);
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
  public NodeList<CatchClause> getCatchClauses() {
    return catchClauses;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<BlockStmt> getFinallyBlock() {
    return Optional.ofNullable(finallyBlock);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public BlockStmt getTryBlock() {
    return tryBlock;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Expression> getResources() {
    return resources;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TryStmt setCatchClauses(final NodeList<CatchClause> catchClauses) {
    assertNotNull(catchClauses);
    if (catchClauses == this.catchClauses) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.CATCH_CLAUSES, this.catchClauses, catchClauses);
    if (this.catchClauses != null) this.catchClauses.setParentNode(null);
    this.catchClauses = catchClauses;
    setAsParentNodeOf(catchClauses);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TryStmt setFinallyBlock(final BlockStmt finallyBlock) {
    if (finallyBlock == this.finallyBlock) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.FINALLY_BLOCK, this.finallyBlock, finallyBlock);
    if (this.finallyBlock != null) this.finallyBlock.setParentNode(null);
    this.finallyBlock = finallyBlock;
    setAsParentNodeOf(finallyBlock);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TryStmt setTryBlock(final BlockStmt tryBlock) {
    assertNotNull(tryBlock);
    if (tryBlock == this.tryBlock) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TRY_BLOCK, this.tryBlock, tryBlock);
    if (this.tryBlock != null) this.tryBlock.setParentNode(null);
    this.tryBlock = tryBlock;
    setAsParentNodeOf(tryBlock);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TryStmt setResources(final NodeList<Expression> resources) {
    assertNotNull(resources);
    if (resources == this.resources) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.RESOURCES, this.resources, resources);
    if (this.resources != null) this.resources.setParentNode(null);
    this.resources = resources;
    setAsParentNodeOf(resources);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < catchClauses.size(); i++) {
      if (catchClauses.get(i) == node) {
        catchClauses.remove(i);
        return true;
      }
    }
    if (finallyBlock != null) {
      if (node == finallyBlock) {
        removeFinallyBlock();
        return true;
      }
    }
    for (int i = 0; i < resources.size(); i++) {
      if (resources.get(i) == node) {
        resources.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public TryStmt removeFinallyBlock() {
    return setFinallyBlock((BlockStmt) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public TryStmt clone() {
    return (TryStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public TryStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.tryStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < catchClauses.size(); i++) {
      if (catchClauses.get(i) == node) {
        catchClauses.set(i, (CatchClause) replacementNode);
        return true;
      }
    }
    if (finallyBlock != null) {
      if (node == finallyBlock) {
        setFinallyBlock((BlockStmt) replacementNode);
        return true;
      }
    }
    for (int i = 0; i < resources.size(); i++) {
      if (resources.get(i) == node) {
        resources.set(i, (Expression) replacementNode);
        return true;
      }
    }
    if (node == tryBlock) {
      setTryBlock((BlockStmt) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isTryStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public TryStmt asTryStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifTryStmt(Consumer<TryStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<TryStmt> toTryStmt() {
    return Optional.of(this);
  }
}
