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
package lets.core.codec.language.bm;

import lets.core.codec.CharEncoding;

/**
 * Constants used to process resource files.
 *
 * <p>This class is immutable and thread-safe.
 *
 * @since 1.6
 */
class ResourceConstants {

  static final String CMT = "//";
  static final String ENCODING = CharEncoding.UTF_8;
  static final String EXT_CMT_END = "*/";
  static final String EXT_CMT_START = "/*";
}
