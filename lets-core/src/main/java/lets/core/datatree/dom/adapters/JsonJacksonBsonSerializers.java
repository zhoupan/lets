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

import static lets.core.datatree.dom.adapters.JsonJackson.addSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
 * <b>JACKSON BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class JsonJacksonBsonSerializers implements Consumer<ObjectMapper> {

  @Override
  public void accept(ObjectMapper mapper) {
    SimpleModule module = new SimpleModule();

    addSerializer(
        module,
        BsonBoolean.class,
        (value, gen) -> {
          gen.writeBoolean(value.getValue());
        });

    addSerializer(
        module,
        BsonDateTime.class,
        (value, gen) -> {
          if (Config.USE_TIMESTAMPS) {
            gen.writeString(
                DataConverterRegistry.convert(String.class, new Date(value.getValue())));
          } else {
            gen.writeNumber(value.getValue());
          }
        });

    addSerializer(
        module,
        BsonDouble.class,
        (value, gen) -> {
          gen.writeNumber(value.getValue());
        });

    addSerializer(
        module,
        BsonInt32.class,
        (value, gen) -> {
          gen.writeNumber(value.getValue());
        });

    addSerializer(
        module,
        BsonInt64.class,
        (value, gen) -> {
          gen.writeNumber(value.getValue());
        });

    addSerializer(
        module,
        BsonNull.class,
        (value, gen) -> {
          gen.writeNull();
        });

    addSerializer(
        module,
        BsonRegularExpression.class,
        (value, gen) -> {
          gen.writeString(value.getPattern());
        });

    addSerializer(
        module,
        BsonString.class,
        (value, gen) -> {
          gen.writeString(value.getValue());
        });

    addSerializer(
        module,
        BsonTimestamp.class,
        (value, gen) -> {
          if (Config.USE_TIMESTAMPS) {
            gen.writeString(
                DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L)));
          } else {
            gen.writeNumber(value.getTime());
          }
        });

    addSerializer(
        module,
        BsonUndefined.class,
        (value, gen) -> {
          gen.writeNull();
        });

    addSerializer(
        module,
        Binary.class,
        (value, gen) -> {
          gen.writeString(BASE64.encode(value.getData()));
        });

    addSerializer(
        module,
        Code.class,
        (value, gen) -> {
          gen.writeString(value.getCode());
        });

    addSerializer(
        module,
        Decimal128.class,
        (value, gen) -> {
          gen.writeNumber(value.bigDecimalValue());
        });

    addSerializer(
        module,
        ObjectId.class,
        (value, gen) -> {
          gen.writeString(value.toHexString());
        });

    addSerializer(
        module,
        Symbol.class,
        (value, gen) -> {
          gen.writeString(value.getSymbol());
        });

    mapper.registerModule(module);
  }
}
