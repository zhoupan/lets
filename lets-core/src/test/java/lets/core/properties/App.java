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

import java.util.List;

public class App {

  private String id;
  private String name;
  private Site site;

  private Developer[] developerArray;

  private List<Developer> developerList;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public Developer[] getDeveloperArray() {
    return developerArray;
  }

  public void setDeveloperArray(Developer[] developerArray) {
    this.developerArray = developerArray;
  }

  public List<Developer> getDeveloperList() {
    return developerList;
  }

  public void setDeveloperList(List<Developer> developerList) {
    this.developerList = developerList;
  }
}
