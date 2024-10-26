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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A post processor that will call a collection of post processors. */
public class PostProcessors {

  private final List<Processor> postProcessors = new ArrayList<>();

  public PostProcessors(Processor... postProcessors) {
    this.postProcessors.addAll(Arrays.asList(postProcessors));
  }

  public List<Processor> getPostProcessors() {
    return postProcessors;
  }

  public PostProcessors remove(Processor postProcessor) {
    if (!postProcessors.remove(postProcessor)) {
      throw new AssertionError("Trying to remove a post processor that isn't there.");
    }
    return this;
  }

  public PostProcessors replace(Processor oldProcessor, Processor newProcessor) {
    remove(oldProcessor);
    add(newProcessor);
    return this;
  }

  public PostProcessors add(Processor newProcessor) {
    postProcessors.add(newProcessor);
    return this;
  }

  public void postProcess(ParseResult<? extends Node> result, ParserConfiguration configuration) {
    postProcessors.forEach(pp -> pp.postProcess(result, configuration));
  }
}
