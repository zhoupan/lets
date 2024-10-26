/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.os.linux;

import java.io.Serializable;

public class DistroSpec implements Serializable {

  private static final long serialVersionUID = 6006116784555675971L;

  private final Distro d;
  private String release;
  private String codename;

  public DistroSpec(Distro d) {
    this.d = d;
  }

  public Distro getDistro() {
    return d;
  }

  public String getCodename() {
    return this.codename;
  }

  public void setCodename(String codename) {
    this.codename = codename;
  }

  public String getRelease() {
    return this.release;
  }

  public void setRelease(String release) {
    this.release = release;
  }
}
