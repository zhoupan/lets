/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.Vector;
import java.util.function.Function;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;
import lets.core.io.FileUtils;
import lets.core.io.IOUtils;

/** Sorted properties file. */
public class SortedProperties extends Properties {

  /** The Constant DEFAULT_ENCODING. */
  public static final String DEFAULT_ENCODING = "UTF-8";

  /** The Constant LINE_ENDS. */
  public static final String LINE_ENDS = "\r\n";

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Keys.
   *
   * @return the enumeration< object>
   */
  @Override
  public synchronized Enumeration<Object> keys() {
    Vector<String> v = new Vector<String>();
    for (Object o : this.keySet()) {
      v.add(o.toString());
    }
    Collections.sort(v);
    return new Vector<Object>(v).elements();
  }

  /**
   * Get a boolean property value from a properties object.
   *
   * @param prop the properties object
   * @param key the key
   * @param def the default value
   * @return the value if set, or the default value if not
   */
  public static boolean getBooleanProperty(Properties prop, String key, boolean def) {
    String value = prop.getProperty(key, "" + def);
    try {
      return Boolean.parseBoolean(value);
    } catch (Throwable e) {
      return def;
    }
  }

  /**
   * Get an int property value from a properties object.
   *
   * @param prop the properties object
   * @param key the key
   * @param def the default value
   * @return the value if set, or the default value if not
   */
  public static int getIntProperty(Properties prop, String key, int def) {
    String value = prop.getProperty(key, "" + def);
    try {
      return Integer.decode(value);
    } catch (Throwable e) {
      return def;
    }
  }

  /**
   * Load properties.
   *
   * @param file the file
   * @param encoding the encoding
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static synchronized SortedProperties loadProperties(File file, String encoding)
      throws IOException {
    return SortedProperties.fromLines(FileUtils.readFileToString(file, encoding));
  }

  /**
   * Load properties.
   *
   * @param file the file
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static synchronized SortedProperties loadProperties(File file) throws IOException {
    return SortedProperties.loadProperties(file, DEFAULT_ENCODING);
  }

  /**
   * Load properties.
   *
   * @param in the in
   * @param encoding the encoding
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static synchronized SortedProperties loadProperties(InputStream in, String encoding)
      throws IOException {
    try {
      return SortedProperties.fromLines(IOUtils.toString(in, encoding));
    } finally {
      CoreUtils.closeQuietly(in);
    }
  }

  /**
   * Load properties.
   *
   * @param in the in
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static synchronized SortedProperties loadProperties(InputStream in) throws IOException {
    return loadProperties(in, DEFAULT_ENCODING);
  }

  /**
   * Store a properties file. The header and the date is not written.
   *
   * @param file the file
   * @param encoding the encoding
   * @throws IOException the IO exception
   */
  public synchronized void store(File file, String encoding) throws IOException {
    FileUtils.writeStringToFile(file, this.toLines(), encoding);
  }

  /**
   * Store.
   *
   * @param file the file
   * @throws IOException the IO exception
   */
  public synchronized void store(File file) throws IOException {
    this.store(file, DEFAULT_ENCODING);
  }

  /**
   * Convert the map to a list of line in the form key=value.
   *
   * @param lineEnds the line ends
   * @return the lines
   */
  public synchronized String toLines(String lineEnds) {
    StringBuilder buff = new StringBuilder();
    for (Entry<Object, Object> e : new TreeMap<Object, Object>(this).entrySet()) {
      buff.append(e.getKey()).append('=').append(e.getValue()).append(lineEnds);
    }
    return buff.toString();
  }

  public synchronized String toLines(Function<Entry<Object, Object>, String> entryFormat) {
    StringBuilder buff = new StringBuilder();
    for (Entry<Object, Object> e : new TreeMap<Object, Object>(this).entrySet()) {
      buff.append(entryFormat.apply(e));
    }
    return buff.toString();
  }

  /**
   * To lines.
   *
   * @return the string
   */
  public synchronized String toLines() {
    return this.toLines(LINE_ENDS);
  }

  /**
   * Convert a String to a map.
   *
   * @param s the string
   * @param lindEnds the lind ends
   * @return the map
   */
  public static SortedProperties fromLines(String s, String lindEnds) {
    LoggerSupport.info("fromLines:{}", s);
    SortedProperties p = new SortedProperties();
    for (String line : CoreUtils.split(s, lindEnds)) {
      int idx = line.indexOf('=');
      if (idx > 0) {
        p.put(line.substring(0, idx), line.substring(idx + 1));
      }
    }
    return p;
  }

  /**
   * From lines.
   *
   * @param s the s
   * @return the sorted properties
   */
  public static SortedProperties fromLines(String s) {
    return fromLines(s, LINE_ENDS);
  }

  /**
   * From resource bundle.
   *
   * @param bundle the bundle
   * @return the sorted properties
   */
  public static SortedProperties fromResourceBundle(ResourceBundle bundle) {
    SortedProperties props = new SortedProperties();
    for (Iterator<String> eachKey = bundle.keySet().iterator(); eachKey.hasNext(); ) {
      String code = eachKey.next();
      String message = bundle.getString(code);
      LoggerSupport.info("fromResourceBundle: code={} message={}", code, message);
      props.put(code, message);
    }
    return props;
  }

  /**
   * From resource name.
   *
   * @param resourceName the resource name
   * @param encoding the encoding
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static SortedProperties fromResourceName(String resourceName, String encoding)
      throws IOException {
    return SortedProperties.fromLines(
        IOUtils.resourceToString(resourceName, Charset.forName(encoding)));
  }

  /**
   * From resource name.
   *
   * @param resourceName the resource name
   * @return the sorted properties
   * @throws IOException the IO exception
   */
  public static SortedProperties fromResourceName(String resourceName) throws IOException {
    return SortedProperties.fromResourceName(resourceName, DEFAULT_ENCODING);
  }
}
