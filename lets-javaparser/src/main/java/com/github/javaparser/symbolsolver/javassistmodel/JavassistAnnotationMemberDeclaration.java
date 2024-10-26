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
package com.github.javaparser.symbolsolver.javassistmodel;

import com.github.javaparser.ast.expr.*;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationMemberDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javassist.CtMethod;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.annotation.*;

/**
 * @author Malte Skoruppa
 */
public class JavassistAnnotationMemberDeclaration implements ResolvedAnnotationMemberDeclaration {

  private static Map<Class<? extends MemberValue>, Function<MemberValue, ? extends Expression>>
      memberValueAsExressionConverter = new HashMap<>();

  static {
    memberValueAsExressionConverter.put(
        BooleanMemberValue.class,
        (memberValue) ->
            new BooleanLiteralExpr(BooleanMemberValue.class.cast(memberValue).getValue()));
    memberValueAsExressionConverter.put(
        CharMemberValue.class,
        (memberValue) -> new CharLiteralExpr(CharMemberValue.class.cast(memberValue).getValue()));
    memberValueAsExressionConverter.put(
        DoubleMemberValue.class,
        (memberValue) ->
            new DoubleLiteralExpr(DoubleMemberValue.class.cast(memberValue).getValue()));
    memberValueAsExressionConverter.put(
        IntegerMemberValue.class,
        (memberValue) ->
            new IntegerLiteralExpr(IntegerMemberValue.class.cast(memberValue).getValue()));
    memberValueAsExressionConverter.put(
        LongMemberValue.class,
        (memberValue) -> new LongLiteralExpr(LongMemberValue.class.cast(memberValue).getValue()));
    memberValueAsExressionConverter.put(
        StringMemberValue.class,
        (memberValue) ->
            new StringLiteralExpr(StringMemberValue.class.cast(memberValue).getValue()));
  }

  private CtMethod annotationMember;

  private TypeSolver typeSolver;

  public JavassistAnnotationMemberDeclaration(CtMethod annotationMember, TypeSolver typeSolver) {
    this.annotationMember = annotationMember;
    this.typeSolver = typeSolver;
  }

  @Override
  public Expression getDefaultValue() {
    AnnotationDefaultAttribute defaultAttribute =
        (AnnotationDefaultAttribute)
            annotationMember.getMethodInfo().getAttribute(AnnotationDefaultAttribute.tag);
    if (defaultAttribute == null) return null;
    MemberValue memberValue = defaultAttribute.getDefaultValue();
    Function<MemberValue, ? extends Expression> fn =
        memberValueAsExressionConverter.get(memberValue.getClass());
    if (fn == null)
      throw new UnsupportedOperationException(
          String.format(
              "Obtaining the type of the annotation member %s is not supported yet.",
              annotationMember.getName()));
    return fn.apply(memberValue);
  }

  @Override
  public ResolvedType getType() {
    try {
      String descriptor = annotationMember.getMethodInfo().getDescriptor();
      SignatureAttribute.MethodSignature signature =
          SignatureAttribute.toMethodSignature(descriptor);
      SymbolReference<ResolvedReferenceTypeDeclaration> returnType =
          typeSolver.tryToSolveType(signature.getReturnType().jvmTypeName());
      if (returnType.isSolved()) {
        return new ReferenceTypeImpl(returnType.getCorrespondingDeclaration());
      }
    } catch (BadBytecode e) {
      // We don't expect this to happen, but we handle it anyway.
      throw new IllegalStateException("An invalid descriptor was received from JavaAssist.", e);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Obtaining the type of the annotation member %s is not supported yet.",
            annotationMember.getLongName()));
  }

  @Override
  public String getName() {
    return annotationMember.getName();
  }
}
