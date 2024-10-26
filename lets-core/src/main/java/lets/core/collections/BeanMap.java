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
package lets.core.collections;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jodd.bean.BeanUtil;
import jodd.bean.BeanWalker;
import jodd.bean.BeanWalker.BeanWalkerCallback;
import lets.core.collections.keyvalue.AbstractMapEntry;
import lets.core.collections.list.UnmodifiableList;
import lets.core.collections.set.UnmodifiableSet;

/**
 * An implementation of Map for JavaBeans which uses introspection to get and put properties in the
 * bean.
 *
 * <p>If an exception occurs during attempts to get or set a property then the property is
 * considered non existent in the Map
 *
 * @since Commons Collections 1.0
 * @version $Revision: 646777 $ $Date: 2008-04-10 14:33:15 +0200 (Thu, 10 Apr 2008) $
 * @author James Strachan
 * @author Stephen Colebourne
 * @author Dimiter Dimitrov
 */
public class BeanMap extends AbstractMap<String, Object> implements Cloneable, BeanWalkerCallback {

  /**
   * Replace for (net.sf.cglib.beans.BeanMap.create)
   *
   * @param bean
   * @return
   */
  public static BeanMap create(Object bean) {
    BeanMap gen = new BeanMap(bean);
    return gen;
  }

  private transient Object bean;

  /** An empty array. Used to invoke accessors via reflection. */
  public static final Object[] NULL_ARGUMENTS = {};

  // Constructors
  // -------------------------------------------------------------------------

  /** Constructs a new empty <code>BeanMap</code>. */
  public BeanMap() {}

  /**
   * Constructs a new <code>BeanMap</code> that operates on the specified bean. If the given bean is
   * <code>null</code>, then this map will be empty.
   *
   * @param bean the bean for this map to operate on
   */
  public BeanMap(Object bean) {
    this.bean = bean;
    initialise();
  }

  // Map interface
  // -------------------------------------------------------------------------

  public String toString() {
    return "BeanMap<" + String.valueOf(bean) + ">";
  }

  /**
   * Clone this bean map using the following process:
   *
   * <ul>
   *   <li>If there is no underlying bean, return a cloned BeanMap without a bean.
   *   <li>Since there is an underlying bean, try to instantiate a new bean of the same type using
   *       Class.newInstance().
   *   <li>If the instantiation fails, throw a CloneNotSupportedException
   *   <li>Clone the bean map and set the newly instantiated bean as the underlying bean for the
   *       bean map.
   *   <li>Copy each property that is both readable and writable from the existing object to a
   *       cloned bean map.
   *   <li>If anything fails along the way, throw a CloneNotSupportedException.
   *       <ul>
   */
  public Object clone() throws CloneNotSupportedException {
    BeanMap newMap = (BeanMap) super.clone();

    if (bean == null) {
      // no bean, just an empty bean map at the moment. return a newly
      // cloned and empty bean map.
      return newMap;
    }

    Object newBean = null;
    Class beanClass = null;
    try {
      beanClass = bean.getClass();
      newBean = beanClass.newInstance();
    } catch (Exception e) {
      // unable to instantiate
      throw new CloneNotSupportedException(
          "Unable to instantiate the underlying bean \"" + beanClass.getName() + "\": " + e);
    }

    try {
      newMap.setBean(newBean);
    } catch (Exception exception) {
      throw new CloneNotSupportedException(
          "Unable to set bean in the cloned bean map: " + exception);
    }
    return newMap;
  }

  /**
   * This method reinitializes the bean map to have default values for the bean's properties. This
   * is accomplished by constructing a new instance of the bean which the map uses as its underlying
   * data source. This behavior for <code>clear()</code> differs from the Map contract in that the
   * mappings are not actually removed from the map (the mappings for a BeanMap are fixed).
   */
  public void clear() {
    if (bean == null) return;

    Class beanClass = null;
    try {
      beanClass = bean.getClass();
      bean = beanClass.newInstance();
    } catch (Exception e) {
      throw new UnsupportedOperationException(
          "Could not create new instance of class: " + beanClass);
    }
  }

  /**
   * Returns true if the bean defines a property with the given name.
   *
   * <p>The given name must be a <code>String</code>; if not, this method returns false. This method
   * will also return false if the bean does not define a property with that name.
   *
   * <p>Write-only properties will not be matched as the test operates against property read
   * methods.
   *
   * @param name the name of the property to check
   * @return false if the given name is null or is not a <code>String</code>; false if the bean does
   *     not define a property with that name; or true if the bean does define a property with that
   *     name
   */
  public boolean containsKey(Object name) {
    if (name == null) {
      return false;
    }
    return this.holder.containsKey(name);
  }

  /**
   * Returns true if the bean defines a property whose current value is the given object.
   *
   * @param value the value to check
   * @return false true if the bean has at least one property whose current value is that object,
   *     false otherwise
   */
  public boolean containsValue(Object value) {
    return this.holder.containsValue(value);
  }

  /**
   * Returns the value of the bean's property with the given name.
   *
   * <p>The given name must be a {@link String} and must not be null; otherwise, this method returns
   * <code>null</code>. If the bean defines a property with the given name, the value of that
   * property is returned. Otherwise, <code>null</code> is returned.
   *
   * <p>Write-only properties will not be matched as the test operates against property read
   * methods.
   *
   * @param name the name of the property whose value to return
   * @return the value of the property with that name
   */
  public Object get(Object name) {
    return BeanUtil.silent.getProperty(this.bean, name.toString());
  }

  /**
   * Sets the bean property with the given name to the given value.
   *
   * @param name the name of the property to set
   * @param value the value to set that property to
   * @return the previous value of that property
   * @throws IllegalArgumentException if the given name is null; if the given name is not a {@link
   *     String}; if the bean doesn't define a property with that name; or if the bean property with
   *     that name is read-only
   */
  public Object put(String name, Object value) throws IllegalArgumentException, ClassCastException {
    if (bean != null) {
      Object oldValue = get(name);
      try {
        BeanUtil.pojo.setProperty(this.bean, name.toString(), value);
        return oldValue;
      } catch (Throwable e) {
        // ignore
      }
      throw new IllegalArgumentException(
          "The bean of type: " + bean.getClass().getName() + " has no property called: " + name);
    }
    return null;
  }

  /**
   * Returns the number of properties defined by the bean.
   *
   * @return the number of properties defined by the bean
   */
  public int size() {
    return this.holder.size();
  }

  /**
   * Get the keys for this BeanMap.
   *
   * <p>Write-only properties are <b>not</b> included in the returned set of property names,
   * although it is possible to set their value and to get their type.
   *
   * @return BeanMap keys. The Set returned by this method is not modifiable.
   */
  public Set<String> keySet() {
    return UnmodifiableSet.decorate(this.holder.keySet());
  }

  /**
   * Gets a Set of MapEntry objects that are the mappings for this BeanMap.
   *
   * <p>Each MapEntry can be set but not removed.
   *
   * @return the unmodifiable set of mappings
   */
  public Set entrySet() {
    return UnmodifiableSet.decorate(
        new AbstractSet() {
          public Iterator iterator() {
            return entryIterator();
          }

          public int size() {
            return BeanMap.this.holder.size();
          }
        });
  }

  /**
   * Returns the values for the BeanMap.
   *
   * @return values for the BeanMap. The returned collection is not modifiable.
   */
  public Collection values() {
    ArrayList answer = new ArrayList(this.holder.values());
    return UnmodifiableList.decorate(answer);
  }

  // Helper methods
  // -------------------------------------------------------------------------

  /**
   * Returns the type of the property with the given name.
   *
   * @param name the name of the property
   * @return the type of the property, or <code>null</code> if no such property exists
   */
  public Class getType(String name) {
    return (Class) BeanUtil.pojo.getPropertyType(this.bean, name);
  }

  /**
   * Convenience method for getting an iterator over the keys.
   *
   * <p>Write-only properties will not be returned in the iterator.
   *
   * @return an iterator over the keys
   */
  public Iterator<String> keyIterator() {
    return this.holder.keySet().iterator();
  }

  /**
   * Convenience method for getting an iterator over the values.
   *
   * @return an iterator over the values
   */
  public Iterator<Object> valueIterator() {
    final Iterator iter = keyIterator();
    return new Iterator() {
      public boolean hasNext() {
        return iter.hasNext();
      }

      public Object next() {
        Object key = iter.next();
        return get(key);
      }

      public void remove() {
        throw new UnsupportedOperationException("remove() not supported for BeanMap");
      }
    };
  }

  /**
   * Convenience method for getting an iterator over the entries.
   *
   * @return an iterator over the entries
   */
  public Iterator entryIterator() {
    final Iterator iter = keyIterator();
    return new Iterator() {
      public boolean hasNext() {
        return iter.hasNext();
      }

      public Object next() {
        Object key = iter.next();
        Object value = get(key);
        return new MyMapEntry(BeanMap.this, key, value);
      }

      public void remove() {
        throw new UnsupportedOperationException("remove() not supported for BeanMap");
      }
    };
  }

  // Properties
  // -------------------------------------------------------------------------

  /**
   * Returns the bean currently being operated on. The return value may be null if this map is
   * empty.
   *
   * @return the bean being operated on by this map
   */
  public Object getBean() {
    return bean;
  }

  /**
   * Sets the bean to be operated on by this map. The given value may be null, in which case this
   * map will be empty.
   *
   * @param newBean the new bean to operate on
   */
  public void setBean(Object newBean) {
    bean = newBean;
    reinitialise();
  }

  /**
   * Reinitializes this bean. Called during {@link #setBean(Object)}. Does introspection to find
   * properties.
   */
  protected void reinitialise() {
    initialise();
  }

  private void initialise() {
    if (getBean() == null) return;
    this.holder.clear();
    BeanWalker walker = BeanWalker.walk(this);
    walker.bean(this.getBean());
  }

  /**
   * Called during a successful {@link #put(Object,Object)} operation. Default implementation does
   * nothing. Override to be notified of property changes in the bean caused by this map.
   *
   * @param key the name of the property that changed
   * @param oldValue the old value for that property
   * @param newValue the new value for that property
   */
  protected void firePropertyChange(Object key, Object oldValue, Object newValue) {}

  // Implementation classes
  // -------------------------------------------------------------------------

  /** Map entry used by {@link BeanMap}. */
  protected static class MyMapEntry extends AbstractMapEntry {
    private BeanMap owner;

    /**
     * Constructs a new <code>MyMapEntry</code>.
     *
     * @param owner the BeanMap this entry belongs to
     * @param key the key for this entry
     * @param value the value for this entry
     */
    protected MyMapEntry(BeanMap owner, Object key, Object value) {
      super(key, value);
      this.owner = owner;
    }

    /**
     * Sets the value.
     *
     * @param value the new value for the entry
     * @return the old value for the entry
     */
    public Object setValue(Object value) {
      String key = getKey().toString();
      Object oldValue = owner.get(key);
      owner.put(key, value);
      Object newValue = owner.get(key);
      super.setValue(newValue);
      return oldValue;
    }
  }

  /**
   * Logs the given exception to <code>System.out</code>. Used to display warnings while
   * accessing/mutating the bean.
   *
   * @param ex the exception to log
   */
  protected void logInfo(Exception ex) {
    // Deliberately do not use LOG4J or Commons Logging to avoid dependencies
    System.out.println("INFO: Exception: " + ex);
  }

  /**
   * Logs the given exception to <code>System.err</code>. Used to display errors while
   * accessing/mutating the bean.
   *
   * @param ex the exception to log
   */
  protected void logWarn(Exception ex) {
    // Deliberately do not use LOG4J or Commons Logging to avoid dependencies
    System.out.println("WARN: Exception: " + ex);
    ex.printStackTrace();
  }

  private Map<String, Object> holder = new HashMap<String, Object>();

  @Override
  public void visitProperty(String name, Object value) {
    holder.put(name, value);
  }

  public Set<Entry<String, Object>> entry() {
    return this.holder.entrySet();
  }
}
