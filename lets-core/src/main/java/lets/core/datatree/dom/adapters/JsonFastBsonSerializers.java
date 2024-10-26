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

import com.alibaba.fastjson.serializer.SerializeConfig;
import java.util.Date;
import java.util.function.Consumer;
import lets.core.datatree.dom.BASE64;
import lets.core.datatree.dom.Config;
import lets.core.datatree.dom.converters.DataConverterRegistry;
import org.bson.BsonBoolean;
import org.bson.BsonDateTime;
import org.bson.BsonDouble;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonNull;
import org.bson.BsonRegularExpression;
import org.bson.BsonString;
import org.bson.BsonTimestamp;
import org.bson.BsonUndefined;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.bson.types.Symbol;

/**
 * <b>FASTJSON BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class JsonFastBsonSerializers implements Consumer<SerializeConfig> {

  @Override
  public void accept(SerializeConfig config) {

    JsonFast.addSerializer(
        config,
        BsonBoolean.class,
        (value, serializer) -> {
          serializer.write(value.getValue());
        });

    JsonFast.addSerializer(
        config,
        BsonDateTime.class,
        (value, serializer) -> {
          if (Config.USE_TIMESTAMPS) {
            serializer.write(
                DataConverterRegistry.convert(String.class, new Date(value.getValue())));
          } else {
            serializer.write(value.getValue());
          }
        });

    JsonFast.addSerializer(
        config,
        BsonDouble.class,
        (value, serializer) -> {
          serializer.write(value.getValue());
        });

    JsonFast.addSerializer(
        config,
        BsonInt32.class,
        (value, serializer) -> {
          serializer.write(value.getValue());
        });

    JsonFast.addSerializer(
        config,
        BsonInt64.class,
        (value, serializer) -> {
          serializer.write(value.getValue());
        });

    JsonFast.addSerializer(
        config,
        BsonNull.class,
        (value, serializer) -> {
          serializer.writeNull();
        });

    JsonFast.addSerializer(
        config,
        BsonRegularExpression.class,
        (value, serializer) -> {
          serializer.write(value.getPattern());
        });

    JsonFast.addSerializer(
        config,
        BsonString.class,
        (value, serializer) -> {
          serializer.write(value.getValue());
        });

    JsonFast.addSerializer(
        config,
        BsonTimestamp.class,
        (value, serializer) -> {
          if (Config.USE_TIMESTAMPS) {
            serializer.write(
                DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L)));
          } else {
            serializer.write(value.getTime());
          }
        });

    JsonFast.addSerializer(
        config,
        BsonUndefined.class,
        (value, serializer) -> {
          serializer.writeNull();
        });

    JsonFast.addSerializer(
        config,
        Binary.class,
        (value, serializer) -> {
          serializer.write(BASE64.encode(value.getData()));
        });

    JsonFast.addSerializer(
        config,
        Code.class,
        (value, serializer) -> {
          serializer.write(value.getCode());
        });

    JsonFast.addSerializer(
        config,
        Decimal128.class,
        (value, serializer) -> {
          serializer.write(value.bigDecimalValue());
        });

    JsonFast.addSerializer(
        config,
        ObjectId.class,
        (value, serializer) -> {
          serializer.write(value.toHexString());
        });

    JsonFast.addSerializer(
        config,
        Symbol.class,
        (value, serializer) -> {
          serializer.write(value.getSymbol());
        });
  }
}
