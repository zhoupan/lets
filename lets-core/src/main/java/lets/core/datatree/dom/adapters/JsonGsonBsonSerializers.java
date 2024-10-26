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

import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
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
 * <b>GSON BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class JsonGsonBsonSerializers implements Consumer<GsonBuilder> {

  @Override
  public void accept(GsonBuilder builder) {

    JsonGson.addSerializer(
        builder,
        BsonBoolean.class,
        (value) -> {
          return new JsonPrimitive(value.getValue());
        });

    JsonGson.addSerializer(
        builder,
        BsonDateTime.class,
        (value) -> {
          if (Config.USE_TIMESTAMPS) {
            return new JsonPrimitive(
                DataConverterRegistry.convert(String.class, new Date(value.getValue())));
          } else {
            return new JsonPrimitive(value.getValue());
          }
        });

    JsonGson.addSerializer(
        builder,
        BsonDouble.class,
        (value) -> {
          return new JsonPrimitive(value.getValue());
        });

    JsonGson.addSerializer(
        builder,
        BsonInt32.class,
        (value) -> {
          return new JsonPrimitive(value.getValue());
        });

    JsonGson.addSerializer(
        builder,
        BsonInt64.class,
        (value) -> {
          return new JsonPrimitive(value.getValue());
        });

    JsonGson.addSerializer(
        builder,
        BsonNull.class,
        (value) -> {
          return JsonNull.INSTANCE;
        });

    JsonGson.addSerializer(
        builder,
        BsonRegularExpression.class,
        (value) -> {
          return new JsonPrimitive(value.getPattern());
        });

    JsonGson.addSerializer(
        builder,
        BsonString.class,
        (value) -> {
          return new JsonPrimitive(value.getValue());
        });

    JsonGson.addSerializer(
        builder,
        BsonTimestamp.class,
        (value) -> {
          if (Config.USE_TIMESTAMPS) {
            return new JsonPrimitive(
                DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L)));
          } else {
            return new JsonPrimitive(value.getTime());
          }
        });

    JsonGson.addSerializer(
        builder,
        BsonUndefined.class,
        (value) -> {
          return JsonNull.INSTANCE;
        });

    JsonGson.addSerializer(
        builder,
        Binary.class,
        (value) -> {
          return new JsonPrimitive(BASE64.encode(value.getData()));
        });

    JsonGson.addSerializer(
        builder,
        Code.class,
        (value) -> {
          return new JsonPrimitive(value.getCode());
        });

    JsonGson.addSerializer(
        builder,
        Decimal128.class,
        (value) -> {
          return new JsonPrimitive(value.bigDecimalValue());
        });

    JsonGson.addSerializer(
        builder,
        ObjectId.class,
        (value) -> {
          return new JsonPrimitive(value.toHexString());
        });

    JsonGson.addSerializer(
        builder,
        Symbol.class,
        (value) -> {
          return new JsonPrimitive(value.getSymbol());
        });
  }
}
