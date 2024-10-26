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

import java.util.Map;
import java.util.function.Consumer;
import lets.core.datatree.dom.Config;
import lets.core.datatree.dom.TreeReader;
import lets.core.datatree.dom.TreeWriter;
import lets.core.datatree.dom.WriterFunction;

/**
 * Reader / writer class.
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public abstract class AbstractAdapter implements TreeReader, TreeWriter {

  @SafeVarargs
  @SuppressWarnings({"unchecked"})
  protected static final <T> boolean tryToAddSerializers(String consumerClass, T... factories) {
    boolean allInstalled = true;
    for (T factory : factories) {
      try {
        ((Consumer<T>) Class.forName(consumerClass).newInstance()).accept(factory);
      } catch (Throwable ignored) {

        // Classes aren't available
        allInstalled = false;
      }
    }
    return allInstalled;
  }

  protected static final byte[] toBinary(
      Object value,
      Object meta,
      boolean insertMeta,
      WriterFunction<Object, byte[]> implementation) {
    if (value == null) {
      return new byte[0];
    }
    Map<Object, Object> map = insertMeta(value, meta, insertMeta);
    try {
      return implementation.apply(value);
    } catch (Exception cause) {
      throw new IllegalArgumentException("Unable to deserialize object!", cause);
    } finally {
      removeMeta(map);
    }
  }

  protected static final String toString(
      Object value,
      Object meta,
      boolean insertMeta,
      WriterFunction<Object, String> implementation) {
    if (value == null) {
      return "";
    }
    Map<Object, Object> map = insertMeta(value, meta, insertMeta);
    try {
      return implementation.apply(value);
    } catch (Exception cause) {
      cause.printStackTrace();
      throw new IllegalArgumentException("Unable to deserialize object!", cause);
    } finally {
      removeMeta(map);
    }
  }

  @SuppressWarnings("unchecked")
  protected static final Map<Object, Object> insertMeta(
      Object value, Object meta, boolean insertMeta) {
    if (!insertMeta || value == null || meta == null) {
      return null;
    }
    if (!(value instanceof Map)) {
      return null;
    }
    Map<Object, Object> map = (Map<Object, Object>) value;
    map.put(Config.META, meta);
    return map;
  }

  protected static final void removeMeta(Map<Object, Object> map) {
    if (map != null) {
      map.remove(Config.META);
    }
  }
}
