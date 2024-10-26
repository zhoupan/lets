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

/**
 * Implementation of {@link VersionFetcher} that holds a list of other {@link VersionFetcher} and
 * calls them sequentially until any of them manages to find version.
 *
 * @author alexr
 */
public class SequentialVersionFetcher implements VersionFetcher {
  private final VersionFetcher[] fetchers;

  public SequentialVersionFetcher(VersionFetcher first, VersionFetcher... others) {
    fetchers = new VersionFetcher[others.length + 1];
    fetchers[0] = first;
    for (int i = 0; i < others.length; i++) {
      fetchers[i + 1] = others[i];
    }
  }

  @Override
  public Version version(String str) {
    for (VersionFetcher fetcher : fetchers) {
      Version version = fetcher.version(str);
      if (version != null) {
        return version;
      }
    }
    return null;
  }
}
