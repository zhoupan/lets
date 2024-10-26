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
package lets.core.image.resizers.configurations;

import java.awt.RenderingHints;
import lets.core.image.resizers.Resizer;

/**
 * An interface which are implemented by classes and enums which provide configuration information
 * for {@link Resizer}s.
 *
 * @author coobird
 */
public interface ResizerConfiguration {
  /**
   * Returns a rendering hint key.
   *
   * @return Rendering hint key.
   */
  public RenderingHints.Key getKey();

  /**
   * Returns a rendering hint value.
   *
   * @return Rendering hint value.
   */
  public Object getValue();
}
