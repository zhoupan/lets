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
package lets.core.uid;

import lets.core.Sequence;

/**
 * DefaultUidGenerator
 *
 * @author zhoupan
 */
public class DefaultUidGenerator implements UidGenerator {

  protected final Sequence sequence;

  public DefaultUidGenerator() {
    this(new Sequence(0, 0));
  }

  public DefaultUidGenerator(Sequence sequence) {
    super();
    this.sequence = sequence;
  }

  @Override
  public Long nextId() {
    return this.sequence.nextId();
  }
}
