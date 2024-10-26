/*
 * Copyright (c) 2017 zhoupan (https://github.com/zhoupan).
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
package lets.core.datatree.dom.builtin;

import java.nio.charset.StandardCharsets;

/**
 * Text (JSON, XML, YAML, TOML, etc.) reader / writer.
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public abstract class AbstractTextAdapter extends AbstractAdapter {

  // --- NAME OF THE FORMAT ---

  @Override
  public String getFormat() {
    return "json";
  }

  // --- CONVERT OBJECT TO BYTE ARRAY ---

  @Override
  public byte[] toBinary(Object value, Object meta, boolean insertMeta) {
    return toString(value, meta, false, insertMeta).getBytes(StandardCharsets.UTF_8);
  }

  // --- PARSE BYTE ARRAY ---

  @Override
  public Object parse(byte[] source) throws Exception {
    return parse(new String(source, StandardCharsets.UTF_8));
  }
}
