/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.json;

import java.util.List;

/**
 * JsonService.
 *
 * @author zhoupan.
 */
public interface JsonService {

  /**
   * 将指定的对象序列化成json字符串.
   *
   * @param obj the obj
   * @return the string
   */
  public String toJson(Object obj);

  /**
   * 反序列json字符串到对象.
   *
   * @param <T> the generic type
   * @param json the json
   * @param classOfT the class of t
   * @return the t
   */
  public <T> T fromJson(String json, Class<T> classOfT);

  /**
   * List from json.
   *
   * @param <T> the generic type
   * @param json the json
   * @param classOfElement the class of element
   * @return the list
   */
  public <T> List<T> listFromJson(String json, Class<T> classOfElement);
}
