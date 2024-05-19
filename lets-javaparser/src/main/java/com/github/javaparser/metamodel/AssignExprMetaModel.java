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
package com.github.javaparser.metamodel;

import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.expr.AssignExpr;
import java.util.Optional;

/**
 * This file, class, and its contents are completely generated based on:
 *
 * <ul>
 *   <li>The contents and annotations within the package `com.github.javaparser.ast`, and
 *   <li>`ALL_NODE_CLASSES` within the class
 *       `com.github.javaparser.generator.metamodel.MetaModelGenerator`.
 * </ul>
 *
 * For this reason, any changes made directly to this file will be overwritten the next time
 * generators are run.
 */
@Generated("com.github.javaparser.generator.metamodel.NodeMetaModelGenerator")
public class AssignExprMetaModel extends ExpressionMetaModel {

  @Generated("com.github.javaparser.generator.metamodel.NodeMetaModelGenerator")
  AssignExprMetaModel(Optional<BaseNodeMetaModel> superBaseNodeMetaModel) {
    super(
        superBaseNodeMetaModel,
        AssignExpr.class,
        "AssignExpr",
        "com.github.javaparser.ast.expr",
        false,
        false);
  }

  public PropertyMetaModel operatorPropertyMetaModel;

  public PropertyMetaModel targetPropertyMetaModel;

  public PropertyMetaModel valuePropertyMetaModel;
}
