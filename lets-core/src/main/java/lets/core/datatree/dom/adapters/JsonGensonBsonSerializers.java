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

import com.owlike.genson.GensonBuilder;
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
 * <b>GENSON BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class JsonGensonBsonSerializers implements Consumer<GensonBuilder> {

  @Override
  public void accept(GensonBuilder builder) {

    JsonGenson.addSerializer(
        builder,
        BsonBoolean.class,
        (value, writer, ctx) -> {
          writer.writeBoolean(value.getValue());
        });

    JsonGenson.addSerializer(
        builder,
        BsonDateTime.class,
        (value, writer, ctx) -> {
          if (Config.USE_TIMESTAMPS) {
            writer.writeString(
                DataConverterRegistry.convert(String.class, new Date(value.getValue())));
          } else {
            writer.writeNumber(value.getValue());
          }
        });

    JsonGenson.addSerializer(
        builder,
        BsonDouble.class,
        (value, writer, ctx) -> {
          writer.writeNumber(value.getValue());
        });

    JsonGenson.addSerializer(
        builder,
        BsonInt32.class,
        (value, writer, ctx) -> {
          writer.writeNumber(value.getValue());
        });

    JsonGenson.addSerializer(
        builder,
        BsonInt64.class,
        (value, writer, ctx) -> {
          writer.writeNumber(value.getValue());
        });

    JsonGenson.addSerializer(
        builder,
        BsonNull.class,
        (value, writer, ctx) -> {
          writer.writeNull();
        });

    JsonGenson.addSerializer(
        builder,
        BsonRegularExpression.class,
        (value, writer, ctx) -> {
          writer.writeString(value.getPattern());
        });

    JsonGenson.addSerializer(
        builder,
        BsonString.class,
        (value, writer, ctx) -> {
          writer.writeString(value.getValue());
        });

    JsonGenson.addSerializer(
        builder,
        BsonTimestamp.class,
        (value, writer, ctx) -> {
          if (Config.USE_TIMESTAMPS) {
            writer.writeString(
                DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L)));
          } else {
            writer.writeNumber(value.getTime());
          }
        });

    JsonGenson.addSerializer(
        builder,
        BsonUndefined.class,
        (value, writer, ctx) -> {
          writer.writeNull();
        });

    JsonGenson.addSerializer(
        builder,
        Binary.class,
        (value, writer, ctx) -> {
          writer.writeString(BASE64.encode(value.getData()));
        });

    JsonGenson.addSerializer(
        builder,
        Code.class,
        (value, writer, ctx) -> {
          writer.writeString(value.getCode());
        });

    JsonGenson.addSerializer(
        builder,
        Decimal128.class,
        (value, writer, ctx) -> {
          writer.writeNumber(value.bigDecimalValue());
        });

    JsonGenson.addSerializer(
        builder,
        ObjectId.class,
        (value, writer, ctx) -> {
          writer.writeString(value.toHexString());
        });

    JsonGenson.addSerializer(
        builder,
        Symbol.class,
        (value, writer, ctx) -> {
          writer.writeString(value.getSymbol());
        });
  }
}
