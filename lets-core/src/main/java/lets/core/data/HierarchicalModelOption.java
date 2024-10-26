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
package lets.core.data;

/**
 * 树结构模型配置.
 *
 * @author zhoupan
 */
public class HierarchicalModelOption {

  private String idField = "id";
  private String parentIdField = "parentId";
  private String hasChildrenField = "hasChildren";
  private String rootId = "0";

  public String getIdField() {
    return idField;
  }

  public void setIdField(String idField) {
    this.idField = idField;
  }

  public String getHasChildrenField() {
    return hasChildrenField;
  }

  public void setHasChildrenField(String hasChildrenField) {
    this.hasChildrenField = hasChildrenField;
  }

  public String getParentIdField() {
    return parentIdField;
  }

  public void setParentIdField(String parentIdField) {
    this.parentIdField = parentIdField;
  }

  public String getRootId() {
    return rootId;
  }

  public void setRootId(String rootId) {
    this.rootId = rootId;
  }
}
