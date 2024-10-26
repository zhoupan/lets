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
package lets.core.useragent;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sometimes version of something is not written clearly in User-Agent string. However it is
 * possible to extract version of other component that can be mapped to needed version. Concrete
 * example is discovery of version of Safari browser by version of Webkit.
 *
 * @author alexr
 */
class VersionFetcherFromMap extends PatternBasedVersionFetcher {
  private final Map<String, Version> versions;

  VersionFetcherFromMap(Pattern pattern, Map<String, Version> versions) {
    super(pattern);
    this.versions = Collections.unmodifiableMap(versions);
  }

  protected Version createVersion(Matcher matcher) {
    return versions.get(matcher.group(1));
  }
}
