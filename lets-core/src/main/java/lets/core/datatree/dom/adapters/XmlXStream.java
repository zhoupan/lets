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
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;
import lets.core.datatree.dom.BASE64;
import lets.core.datatree.dom.Config;
import lets.core.datatree.dom.Priority;
import lets.core.datatree.dom.builtin.AbstractTextAdapter;
import lets.core.datatree.dom.converters.DataConverterRegistry;

/**
 * <b>XSTREAM XML ADAPTER</b><br>
 * <br>
 * Description: XStream is a simple library to serialize objects to XML and back again.<br>
 * <br>
 * <b>Dependency:</b><br>
 * <br>
 * https://mvnrepository.com/artifact/xstream/xstream<br>
 * compile group: 'xstream', name: 'xstream', version: '1.2.2'<br>
 * <br>
 * <b>Set as default (using Java System Properties):</b><br>
 * <br>
 * If there is more than one XML implementation on classpath, the preferred implementation is
 * adjustable with the following System Properties.<br>
 * <br>
 * -Ddatatree.xml.reader=io.datatree.dom.adapters.XmlXStream<br>
 * -Ddatatree.xml.writer=io.datatree.dom.adapters.XmlXStream<br>
 * <br>
 * <b>Set as default (using static methods):</b><br>
 * <br>
 * XmlXStream xml = new XmlXStream();<br>
 * TreeReaderRegistry.setReader("xml", xml);<br>
 * TreeWriterRegistry.setWriter("xml", xml);<br>
 * <br>
 * <b>Invoke serializer and deserializer:</b><br>
 * <br>
 * Tree node = new Tree(inputString, "xml");<br>
 * String outputString = node.toString("xml");<br>
 * <br>
 * Innvoke this implementation directly:<br>
 * <br>
 * Tree node = new Tree(inputString, "XmlXStream");<br>
 * String outputString = node.toString("XmlXStream");
 *
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
@Priority(30)
public class XmlXStream extends AbstractTextAdapter {

  // --- COMMON MAPPER INSTANCE ---

  public XStream mapper;

  // --- NAME OF THE FORMAT ---

  @Override
  public String getFormat() {
    return "xml";
  }

  // --- MAPPER FACTORY ---

  public XStream newMapper() {
    return new XStream();
  }

  // --- CONSTRUCTOR ---

  public XmlXStream() {

    // Create mapper
    mapper = newMapper();

    // Install Java / Apache Cassandra serializers
    addDefaultSerializers();

    // Install MongoDB / BSON serializers
    tryToAddSerializers("io.datatree.dom.adapters.XmlXStreamBsonSerializers", mapper);
  }

  public void addDefaultSerializers() {

    // InetAddress
    addSerializer(
        mapper,
        InetAddress.class,
        (value) -> {
          return value.getCanonicalHostName();
        });
    addSerializer(
        mapper,
        Inet4Address.class,
        (value) -> {
          return value.getCanonicalHostName();
        });
    addSerializer(
        mapper,
        Inet6Address.class,
        (value) -> {
          return value.getCanonicalHostName();
        });

    // UUID
    addSerializer(
        mapper,
        UUID.class,
        (value) -> {
          return value.toString();
        });

    // BASE64
    addSerializer(
        mapper,
        byte[].class,
        (value) -> {
          return BASE64.encode(value);
        });

    // Date
    addSerializer(
        mapper,
        Date.class,
        (value) -> {
          if (Config.USE_TIMESTAMPS) {
            return DataConverterRegistry.convert(String.class, value);
          }
          return Long.toString(value.getTime());
        });
  }

  // --- IMPLEMENTED WRITER METHOD ---

  @Override
  public String toString(Object value, Object meta, boolean pretty, boolean insertMeta) {
    return toString(
        value,
        meta,
        insertMeta,
        (input) -> {
          return mapper.toXML(input);
        });
  }

  // --- IMPLEMENTED PARSER METHOD ---

  @Override
  public Object parse(String source) throws Exception {
    return mapper.fromXML(source);
  }

  // --- ADD CUSTOM SERIALIZER ---

  public static final <TYPE> void addSerializer(
      XStream mapper, Class<TYPE> type, Function<TYPE, String> function) {
    mapper.registerConverter(
        new Converter() {

          @SuppressWarnings("rawtypes")
          @Override
          public boolean canConvert(Class test) {
            return test != null && type.isAssignableFrom(test);
          }

          @SuppressWarnings("unchecked")
          @Override
          public void marshal(
              Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            writer.setValue(function.apply((TYPE) source));
          }

          @Override
          public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return reader.getValue();
          }
        });
  }
}
