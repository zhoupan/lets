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

import static lets.core.datatree.dom.adapters.JsonJsonIO.addSerializer;

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
 * <b>JSONIO BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class JsonJsonIOBsonSerializers implements Consumer<Object> {

  @Override
  public void accept(Object f) {

    addSerializer(
        BsonBoolean.class,
        (value, output) -> {
          output.write(Boolean.toString(value.getValue()));
        });

    addSerializer(
        BsonDateTime.class,
        (value, output) -> {
          if (Config.USE_TIMESTAMPS) {
            output.write('\"');
            output.write(DataConverterRegistry.convert(String.class, new Date(value.getValue())));
            output.write('\"');
          } else {
            output.write(Long.toString(value.getValue()));
          }
        });

    addSerializer(
        BsonDouble.class,
        (value, output) -> {
          output.write(Double.toString(value.getValue()));
        });

    addSerializer(
        BsonInt32.class,
        (value, output) -> {
          output.write(Integer.toString(value.getValue()));
        });

    addSerializer(
        BsonInt64.class,
        (value, output) -> {
          output.write(Long.toString(value.getValue()));
        });

    addSerializer(
        BsonNull.class,
        (value, output) -> {
          output.write("null");
        });

    addSerializer(
        BsonRegularExpression.class,
        (value, output) -> {
          output.write('\"');
          output.write(DataConverterRegistry.convert(String.class, value.getPattern()));
          output.write('\"');
        });

    addSerializer(
        BsonString.class,
        (value, output) -> {
          output.write('\"');
          output.write(DataConverterRegistry.convert(String.class, value.getValue()));
          output.write('\"');
        });

    addSerializer(
        BsonTimestamp.class,
        (value, output) -> {
          if (Config.USE_TIMESTAMPS) {
            output.write('\"');
            output.write(
                DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L)));
            output.write('\"');
          } else {
            output.write(Integer.toString(value.getTime()));
          }
        });

    addSerializer(
        BsonUndefined.class,
        (value, output) -> {
          output.write("null");
        });

    addSerializer(
        Binary.class,
        (value, output) -> {
          output.write('\"');
          output.write(BASE64.encode(value.getData()));
          output.write('\"');
        });

    addSerializer(
        Code.class,
        (value, output) -> {
          output.write('\"');
          output.write(DataConverterRegistry.convert(String.class, value.getCode()));
          output.write('\"');
        });

    addSerializer(
        Decimal128.class,
        (value, output) -> {
          output.write(value.bigDecimalValue().toPlainString());
        });

    addSerializer(
        ObjectId.class,
        (value, output) -> {
          output.write('\"');
          output.write(value.toHexString());
          output.write('\"');
        });

    addSerializer(
        Symbol.class,
        (value, output) -> {
          output.write('\"');
          output.write(DataConverterRegistry.convert(String.class, value.getSymbol()));
          output.write('\"');
        });
  }
}
