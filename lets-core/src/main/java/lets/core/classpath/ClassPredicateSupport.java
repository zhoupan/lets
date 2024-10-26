/*
 * Copyright (c) 2023 zhoupan (https://github.com/zhoupan).
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
package lets.core.classpath;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lets.core.AnnotationUtils;
import lets.core.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassPredicateSupport 1.支持包含注解和排除注解.
 *
 * @author zhoupan
 */
public class ClassPredicateSupport implements Predicate<Class<?>> {

  private List<Class<? extends Annotation>> includeAnnotations =
      new ArrayList<Class<? extends Annotation>>();

  private final Logger logger = LoggerFactory.getLogger(getClass());

  public ClassPredicateSupport includeAnnotations(List<Class<? extends Annotation>> annotations) {
    if (annotations != null) {
      for (Class<? extends Annotation> a : annotations) {
        if (a != null) {
          if (!this.includeAnnotations.contains(a)) {
            this.includeAnnotations.add(a);
          }
        }
      }
    }
    return this;
  }

  private List<Class<? extends Annotation>> excludeAnnotations =
      new ArrayList<Class<? extends Annotation>>();

  public ClassPredicateSupport excludeAnnotations(List<Class<? extends Annotation>> annotations) {
    if (annotations != null) {
      for (Class<? extends Annotation> a : annotations) {
        if (a != null) {
          if (!this.excludeAnnotations.contains(a)) {
            this.excludeAnnotations.add(a);
          }
        }
      }
    }
    return this;
  }

  @Override
  public boolean test(Class<?> cls) {
    List<Class<? extends Annotation>> annotationTypes = AnnotationUtils.getAnnotationTypes(cls);
    this.logger.debug(
        "test: class={} annotationTypes={} includeAnnotations={} excludeAnnotations={}",
        cls,
        annotationTypes,
        includeAnnotations,
        excludeAnnotations);
    // 排除注解
    if (CollectionUtils.isNotEmpty(this.excludeAnnotations)) {
      if (CollectionUtils.containsAny(this.excludeAnnotations, annotationTypes)) {
        this.logger.debug(
            "test: CollectionUtils.containsAny(this.excludeAnnotations, annotationTypes)=false");
        return false;
      }
    }
    // 包含注解
    if (CollectionUtils.isNotEmpty(this.includeAnnotations)) {
      if (CollectionUtils.containsAny(this.includeAnnotations, annotationTypes)) {
        this.logger.debug(
            "test: CollectionUtils.containsAny(this.includeAnnotations, annotationTypes)=true");
        return true;
      }
    }
    // 默认返回
    return false;
  }
}
