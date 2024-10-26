/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.javaparsermodel.contexts;

import static com.github.javaparser.resolution.Navigator.demandParentNode;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.TypePatternExpr;
import com.github.javaparser.ast.nodeTypes.SwitchNode;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.resolution.SymbolDeclarator;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserPatternDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
import java.util.List;

/**
 * @author Federico Tomassetti
 */
public class SwitchEntryContext extends AbstractJavaParserContext<SwitchEntry> {

  public SwitchEntryContext(SwitchEntry wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    SwitchNode switchNode = (SwitchNode) demandParentNode(wrappedNode);
    ResolvedType type = JavaParserFacade.get(typeSolver).getType(switchNode.getSelector());
    if (type.isReferenceType() && type.asReferenceType().getTypeDeclaration().isPresent()) {
      ResolvedReferenceTypeDeclaration typeDeclaration =
          type.asReferenceType().getTypeDeclaration().get();
      if (typeDeclaration.isEnum()) {
        if (type instanceof ReferenceTypeImpl) {
          ReferenceTypeImpl referenceType = (ReferenceTypeImpl) type;
          if (referenceType.getTypeDeclaration().isPresent()) {
            ResolvedReferenceTypeDeclaration typeUsageTypeDeclaration =
                referenceType.getTypeDeclaration().get();
            if (typeUsageTypeDeclaration.asEnum().hasEnumConstant(name)) {
              return SymbolReference.solved(
                  typeUsageTypeDeclaration.asEnum().getEnumConstant(name));
            }
            if (typeUsageTypeDeclaration.hasField(name)) {
              return SymbolReference.solved(typeUsageTypeDeclaration.getField(name));
            }
          } else {
            // Consider IllegalStateException or similar?
          }
        } else {
          throw new UnsupportedOperationException();
        }
      }
    }
    // look for declaration in a pattern label for this entry
    for (Expression e : wrappedNode.getLabels()) {
      if (!e.isTypePatternExpr()) {
        continue;
      }
      TypePatternExpr typePatternExpr = e.asTypePatternExpr();
      if (typePatternExpr.getNameAsString().equals(name)) {
        JavaParserPatternDeclaration decl =
            JavaParserSymbolDeclaration.patternVar(typePatternExpr, typeSolver);
        return SymbolReference.solved(decl);
      }
    }
    // look for declaration in this and previous switch entry statements
    for (SwitchEntry seStmt : switchNode.getEntries()) {
      for (Statement stmt : seStmt.getStatements()) {
        SymbolDeclarator symbolDeclarator = JavaParserFactory.getSymbolDeclarator(stmt, typeSolver);
        SymbolReference<? extends ResolvedValueDeclaration> symbolReference =
            solveWith(symbolDeclarator, name);
        if (symbolReference.isSolved()) {
          return symbolReference;
        }
      }
      // once we reach this switch entry statement, stop: we do not want to look in later switch
      // entry statements
      if (seStmt == wrappedNode) {
        break;
      }
    }
    return solveSymbolInParentContext(name);
  }

  @Override
  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    // TODO: Document why staticOnly is forced to be false.
    return solveMethodInParentContext(name, argumentsTypes, false);
  }
}
