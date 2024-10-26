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
package com.github.javaparser.ast.validator.language_level_validations.chunks;

import static com.github.javaparser.ast.Modifier.Keyword.*;
import static java.util.Arrays.asList;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.modules.ModuleRequiresDirective;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;
import com.github.javaparser.ast.nodeTypes.NodeWithTokenRange;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.validator.ProblemReporter;
import com.github.javaparser.ast.validator.VisitorValidator;
import com.github.javaparser.utils.SeparatedItemStringBuilder;
import java.util.ArrayList;
import java.util.List;

/** Verifies that only allowed modifiers are used where modifiers are expected. */
public class ModifierValidator extends VisitorValidator {

  private final Modifier.Keyword[] interfaceWithNothingSpecial =
      new Modifier.Keyword[] {PUBLIC, PROTECTED, ABSTRACT, FINAL, SYNCHRONIZED, NATIVE, STRICTFP};

  private final Modifier.Keyword[] interfaceWithStaticAndDefault =
      new Modifier.Keyword[] {
        PUBLIC, PROTECTED, ABSTRACT, STATIC, FINAL, SYNCHRONIZED, NATIVE, STRICTFP, DEFAULT
      };

  private final Modifier.Keyword[] interfaceWithStaticAndDefaultAndPrivate =
      new Modifier.Keyword[] {
        PUBLIC, PROTECTED, PRIVATE, ABSTRACT, STATIC, FINAL, SYNCHRONIZED, NATIVE, STRICTFP, DEFAULT
      };

  private final boolean hasStrictfp;

  private final boolean hasDefaultAndStaticInterfaceMethods;

  private final boolean hasPrivateInterfaceMethods;

  public ModifierValidator(
      boolean hasStrictfp,
      boolean hasDefaultAndStaticInterfaceMethods,
      boolean hasPrivateInterfaceMethods) {
    this.hasStrictfp = hasStrictfp;
    this.hasDefaultAndStaticInterfaceMethods = hasDefaultAndStaticInterfaceMethods;
    this.hasPrivateInterfaceMethods = hasPrivateInterfaceMethods;
  }

  @Override
  public void visit(ClassOrInterfaceDeclaration n, ProblemReporter reporter) {
    if (n.isInterface()) {
      validateInterfaceModifiers(n, reporter);
    } else {
      validateClassModifiers(n, reporter);
    }
    super.visit(n, reporter);
  }

  private void validateClassModifiers(ClassOrInterfaceDeclaration n, ProblemReporter reporter) {
    if (n.isTopLevelType()) {
      validateModifiers(n, reporter, PUBLIC, ABSTRACT, FINAL, STRICTFP, SEALED, NON_SEALED);
    } else if (n.isNestedType()) {
      validateModifiers(
          n,
          reporter,
          PUBLIC,
          PROTECTED,
          PRIVATE,
          ABSTRACT,
          STATIC,
          FINAL,
          STRICTFP,
          SEALED,
          NON_SEALED);
    } else if (n.isLocalClassDeclaration()) {
      validateModifiers(n, reporter, ABSTRACT, FINAL, STRICTFP, SEALED, NON_SEALED);
    }
  }

  private void validateInterfaceModifiers(TypeDeclaration<?> n, ProblemReporter reporter) {
    if (n.isTopLevelType()) {
      validateModifiers(n, reporter, PUBLIC, ABSTRACT, STRICTFP, SEALED, NON_SEALED);
    } else if (n.isNestedType()) {
      validateModifiers(
          n, reporter, PUBLIC, PROTECTED, PRIVATE, ABSTRACT, STATIC, STRICTFP, SEALED, NON_SEALED);
    }
  }

  @Override
  public void visit(EnumDeclaration n, ProblemReporter reporter) {
    if (n.isTopLevelType()) {
      validateModifiers(n, reporter, PUBLIC, STRICTFP);
    } else if (n.isNestedType()) {
      validateModifiers(n, reporter, PUBLIC, PROTECTED, PRIVATE, STATIC, STRICTFP);
    }
    super.visit(n, reporter);
  }

  @Override
  public void visit(AnnotationDeclaration n, ProblemReporter reporter) {
    validateInterfaceModifiers(n, reporter);
    super.visit(n, reporter);
  }

  @Override
  public void visit(AnnotationMemberDeclaration n, ProblemReporter reporter) {
    validateModifiers(n, reporter, PUBLIC, ABSTRACT);
    super.visit(n, reporter);
  }

  @Override
  public void visit(ConstructorDeclaration n, ProblemReporter reporter) {
    validateModifiers(n, reporter, PUBLIC, PROTECTED, PRIVATE);
    n.getParameters().forEach(p -> validateModifiers(p, reporter, FINAL));
    super.visit(n, reporter);
  }

  @Override
  public void visit(FieldDeclaration n, ProblemReporter reporter) {
    validateModifiers(n, reporter, PUBLIC, PROTECTED, PRIVATE, STATIC, FINAL, TRANSIENT, VOLATILE);
    super.visit(n, reporter);
  }

  @Override
  public void visit(MethodDeclaration n, ProblemReporter reporter) {
    if (n.isAbstract()) {
      final SeparatedItemStringBuilder builder =
          new SeparatedItemStringBuilder("Cannot be 'abstract' and also '", "', '", "'.");
      for (Modifier.Keyword m : asList(PRIVATE, STATIC, FINAL, NATIVE, STRICTFP, SYNCHRONIZED)) {
        if (n.hasModifier(m)) {
          builder.append(m.asString());
        }
      }
      if (builder.hasItems()) {
        reporter.report(n, builder.toString());
      }
    }
    if (n.getParentNode().isPresent()) {
      if (n.getParentNode().get() instanceof ClassOrInterfaceDeclaration) {
        if (((ClassOrInterfaceDeclaration) n.getParentNode().get()).isInterface()) {
          if (hasDefaultAndStaticInterfaceMethods) {
            if (hasPrivateInterfaceMethods) {
              validateModifiers(n, reporter, interfaceWithStaticAndDefaultAndPrivate);
            } else {
              validateModifiers(n, reporter, interfaceWithStaticAndDefault);
            }
          } else {
            validateModifiers(n, reporter, interfaceWithNothingSpecial);
          }
        } else {
          validateModifiers(
              n,
              reporter,
              PUBLIC,
              PROTECTED,
              PRIVATE,
              ABSTRACT,
              STATIC,
              FINAL,
              SYNCHRONIZED,
              NATIVE,
              STRICTFP);
        }
      }
    }
    n.getParameters().forEach(p -> validateModifiers(p, reporter, FINAL));
    super.visit(n, reporter);
  }

  @Override
  public void visit(LambdaExpr n, ProblemReporter reporter) {
    n.getParameters()
        .forEach(
            p -> {
              // Final is not allowed on inferred parameters, but those get caught by the parser.
              validateModifiers(p, reporter, FINAL);
            });
    super.visit(n, reporter);
  }

  @Override
  public void visit(CatchClause n, ProblemReporter reporter) {
    validateModifiers(n.getParameter(), reporter, FINAL);
    super.visit(n, reporter);
  }

  @Override
  public void visit(VariableDeclarationExpr n, ProblemReporter reporter) {
    validateModifiers(n, reporter, FINAL);
    super.visit(n, reporter);
  }

  @Override
  public void visit(ModuleRequiresDirective n, ProblemReporter reporter) {
    validateModifiers(n, reporter, TRANSITIVE, STATIC);
    super.visit(n, reporter);
  }

  private <T extends NodeWithModifiers<?> & NodeWithTokenRange<?>> void validateModifiers(
      T n, ProblemReporter reporter, Modifier.Keyword... allowedModifiers) {
    validateAtMostOneOf(n, reporter, PUBLIC, PROTECTED, PRIVATE);
    validateAtMostOneOf(n, reporter, FINAL, ABSTRACT);
    if (hasStrictfp) {
      validateAtMostOneOf(n, reporter, NATIVE, STRICTFP);
    } else {
      allowedModifiers = removeModifierFromArray(STRICTFP, allowedModifiers);
    }
    for (Modifier m : n.getModifiers()) {
      if (!arrayContains(allowedModifiers, m.getKeyword())) {
        reporter.report(n, "'%s' is not allowed here.", m.getKeyword().asString());
      }
    }
  }

  private Modifier.Keyword[] removeModifierFromArray(
      Modifier.Keyword m, Modifier.Keyword[] allowedModifiers) {
    final List<Modifier.Keyword> newModifiers = new ArrayList<>(asList(allowedModifiers));
    newModifiers.remove(m);
    allowedModifiers = newModifiers.toArray(new Modifier.Keyword[0]);
    return allowedModifiers;
  }

  private boolean arrayContains(Object[] items, Object searchItem) {
    for (Object o : items) {
      if (o == searchItem) {
        return true;
      }
    }
    return false;
  }

  private <T extends NodeWithModifiers<?> & NodeWithTokenRange<?>> void validateAtMostOneOf(
      T t, ProblemReporter reporter, Modifier.Keyword... modifiers) {
    List<Modifier.Keyword> foundModifiers = new ArrayList<>();
    for (Modifier.Keyword m : modifiers) {
      if (t.hasModifier(m)) {
        foundModifiers.add(m);
      }
    }
    if (foundModifiers.size() > 1) {
      SeparatedItemStringBuilder builder =
          new SeparatedItemStringBuilder("Can have only one of '", "', '", "'.");
      for (Modifier.Keyword m : foundModifiers) {
        builder.append(m.asString());
      }
      reporter.report(t, builder.toString());
    }
  }
}
