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
package lets.core.datatree.dom.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import lets.core.datatree.dom.Config;
import lets.core.datatree.dom.builtin.AbstractAdapter;

/**
 * Abstract class for all Jackson-based readers / writers.
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public abstract class AbstractJacksonAdapter extends AbstractAdapter {

  // --- OBJECT MAPPER INSTANCE ---

  public ObjectMapper mapper;

  // --- CONSTRUCTOR ---

  public AbstractJacksonAdapter(ObjectMapper mapper) {
    this.mapper = mapper;
    if (Config.USE_TIMESTAMPS) {
      this.mapper.setDateFormat(Config.TIMESTAMP_FORMATTER);
    }
  }

  // --- IMPLEMENTED WRITER METHODS ---

  public byte[] toBinary(Object value, Object meta, boolean insertMeta) {
    return toBinary(
        value,
        meta,
        insertMeta,
        (input) -> {
          return mapper.writeValueAsBytes(input);
        });
  }

  // --- IMPLEMENTED PARSER METHOD ---

  public Object parse(byte[] source) throws Exception {
    return mapper.readValue(source, LinkedHashMap.class);
  }
}
