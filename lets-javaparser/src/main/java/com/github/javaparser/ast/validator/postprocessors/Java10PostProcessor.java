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
package com.github.javaparser.ast.validator.postprocessors;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.Processor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.VarType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Processes the generic AST into a Java 10 AST and validates it. */
public class Java10PostProcessor extends PostProcessors {

  // List of parent contexts in which a var type must not be detected.
  // for example: in this statement var.class.getCanonicalName(), var must not be considered as a
  // VarType
  private static List<Class> FORBIDEN_PARENT_CONTEXT_TO_DETECT_POTENTIAL_VAR_TYPE =
      new ArrayList<>();

  static {
    FORBIDEN_PARENT_CONTEXT_TO_DETECT_POTENTIAL_VAR_TYPE.addAll(Arrays.asList(ClassExpr.class));
  }

  protected final Processor varNodeCreator =
      new Processor() {

        @Override
        public void postProcess(
            ParseResult<? extends Node> result, ParserConfiguration configuration) {
          result
              .getResult()
              .ifPresent(
                  node -> {
                    node.findAll(ClassOrInterfaceType.class)
                        .forEach(
                            n -> {
                              if ("var".equals(n.getNameAsString()) && !matchForbiddenContext(n)) {
                                n.replace(new VarType(n.getTokenRange().orElse(null)));
                              }
                            });
                  });
        }

        private boolean matchForbiddenContext(ClassOrInterfaceType cit) {
          return cit.getParentNode().isPresent()
              && FORBIDEN_PARENT_CONTEXT_TO_DETECT_POTENTIAL_VAR_TYPE.stream()
                  .anyMatch(cl -> cl.isInstance(cit.getParentNode().get()));
        }
      };

  public Java10PostProcessor() {
    add(varNodeCreator);
  }
}
