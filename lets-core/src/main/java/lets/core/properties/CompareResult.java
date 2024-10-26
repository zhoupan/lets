/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.core.properties;

import java.util.ArrayList;
import java.util.List;

public class CompareResult<TItem> {
  private List<TItem> added = new ArrayList<TItem>();
  private List<TItem> removed = new ArrayList<TItem>();

  private List<TItem> changed = new ArrayList<TItem>();

  public List<TItem> getAdded() {
    return added;
  }

  public void setAdded(List<TItem> added) {
    this.added = added;
  }

  public List<TItem> getRemoved() {
    return removed;
  }

  public void setRemoved(List<TItem> removed) {
    this.removed = removed;
  }

  public List<TItem> getChanged() {
    return changed;
  }

  public void setChanged(List<TItem> changed) {
    this.changed = changed;
  }

  public CompareResult<TItem> withAdded(TItem item) {
    this.added.add(item);
    return this;
  }

  public CompareResult<TItem> withRemoved(TItem item) {
    this.removed.add(item);
    return this;
  }

  public CompareResult<TItem> withChanged(TItem item) {
    this.changed.add(item);
    return this;
  }
}
