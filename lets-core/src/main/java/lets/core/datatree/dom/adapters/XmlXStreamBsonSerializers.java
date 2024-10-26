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

import com.thoughtworks.xstream.XStream;
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
 * <b>XSTREAM BSON EXTENSIONS</b><br>
 * <br>
 * Install serializers for BSON / MongoDB types (BsonInt64, ObjectID, etc.).
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
public class XmlXStreamBsonSerializers implements Consumer<XStream> {

  @Override
  public void accept(XStream mapper) {

    XmlXStream.addSerializer(
        mapper,
        BsonBoolean.class,
        (value) -> {
          return Boolean.toString(value.getValue());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonDateTime.class,
        (value) -> {
          if (Config.USE_TIMESTAMPS) {
            return DataConverterRegistry.convert(String.class, new Date(value.getValue()));
          }
          return Long.toString(value.getValue());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonDouble.class,
        (value) -> {
          return Double.toString(value.getValue());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonInt32.class,
        (value) -> {
          return Integer.toString(value.getValue());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonInt64.class,
        (value) -> {
          return Long.toString(value.getValue());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonNull.class,
        (value) -> {
          return "null";
        });

    XmlXStream.addSerializer(
        mapper,
        BsonRegularExpression.class,
        (value) -> {
          return value.getPattern();
        });

    XmlXStream.addSerializer(
        mapper,
        BsonString.class,
        (value) -> {
          return value.getValue();
        });

    XmlXStream.addSerializer(
        mapper,
        BsonTimestamp.class,
        (value) -> {
          if (Config.USE_TIMESTAMPS) {
            return DataConverterRegistry.convert(String.class, new Date(value.getTime() * 1000L));
          }
          return Integer.toString(value.getTime());
        });

    XmlXStream.addSerializer(
        mapper,
        BsonUndefined.class,
        (value) -> {
          return "null";
        });

    XmlXStream.addSerializer(
        mapper,
        Binary.class,
        (value) -> {
          return BASE64.encode(value.getData());
        });

    XmlXStream.addSerializer(
        mapper,
        Code.class,
        (value) -> {
          return value.getCode();
        });

    XmlXStream.addSerializer(
        mapper,
        Decimal128.class,
        (value) -> {
          return value.bigDecimalValue().toPlainString();
        });

    XmlXStream.addSerializer(
        mapper,
        ObjectId.class,
        (value) -> {
          return value.toHexString();
        });

    XmlXStream.addSerializer(
        mapper,
        Symbol.class,
        (value) -> {
          return value.getSymbol();
        });
  }
}
