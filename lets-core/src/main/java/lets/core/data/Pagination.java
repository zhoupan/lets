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
package lets.core.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 分页支持泛型.
 *
 * @param <Item> the generic type
 * @author zhoupan.
 */
public final class Pagination<Item> implements java.io.Serializable {

  /** The Constant DEFAULT_PAGE_SIZE. */
  public static final int DEFAULT_PAGE_SIZE = 10;

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The page size. */
  private int pageSize;

  /** The total count. */
  private long totalCount;

  /** The current page no. */
  private int currentPageNo;

  /** The items. */
  private List<Item> items = Collections.emptyList();

  /** Instantiates a new pagination support. */
  public Pagination() {
    this.pageSize = DEFAULT_PAGE_SIZE;
    this.items = new ArrayList<Item>();
  }

  /**
   * Instantiates a new pagination support.
   *
   * @param currentPageNo the current page no
   */
  public Pagination(int currentPageNo) {
    this.pageSize = DEFAULT_PAGE_SIZE;
    this.items = new ArrayList<Item>();
    this.currentPageNo = currentPageNo;
  }

  /**
   * Instantiates a new pagination support.
   *
   * @param currentPageNo the current page no
   * @param totalCount the total count
   */
  public Pagination(int currentPageNo, long totalCount) {
    this(currentPageNo);
    this.totalCount = totalCount;
  }

  /**
   * Instantiates a new pagination support.
   *
   * @param currentPageNo the current page no
   * @param pageSize the page size
   */
  public Pagination(int currentPageNo, int pageSize) {
    this(currentPageNo);
    this.pageSize = pageSize;
  }

  /**
   * Instantiates a new pagination support.
   *
   * @param currentPageNo the current page no
   * @param pageSize the page size
   * @param totalCount the total count
   */
  public Pagination(int currentPageNo, int pageSize, long totalCount) {
    this(currentPageNo, pageSize);
    this.totalCount = totalCount;
  }

  /**
   * Checks for next page.
   *
   * @return true, if successful
   */
  public boolean hasNextPage() {
    return (this.currentPageNo < getPageCount());
  }

  /**
   * Checks for previous page.
   *
   * @return true, if successful
   */
  public boolean hasPreviousPage() {
    return (this.currentPageNo > 1);
  }

  /**
   * Checks for page.
   *
   * @return true, if successful
   */
  public boolean hasPage() {
    return (getPageCount() > 1);
  }

  /**
   * Gets the current page no.
   *
   * @return the current page no
   */
  public int getCurrentPageNo() {
    int pageCount = getPageCount();
    if (this.currentPageNo > pageCount) this.currentPageNo = pageCount;
    if (pageCount == 0) this.currentPageNo = 1;
    if (this.currentPageNo < 1) this.currentPageNo = 1;
    return this.currentPageNo;
  }

  /**
   * Checks for current page no.
   *
   * @return true, if successful
   */
  public boolean hasCurrentPageNo() {
    int pageCount = getPageCount();
    return (1 <= this.currentPageNo && this.currentPageNo <= pageCount);
  }

  /**
   * Gets the page count.
   *
   * @return the page count
   */
  public int getPageCount() {
    try {
      return (int) ((this.totalCount + this.pageSize - 1L) / this.pageSize);
    } catch (Throwable e) {
      return 0;
    }
  }

  /**
   * Gets the page size.
   *
   * @return the page size
   */
  public int getPageSize() {
    return this.pageSize;
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public List<Item> getItems() {
    return this.items;
  }

  /**
   * Sets the items.
   *
   * @param items the new items
   */
  public void setItems(List<Item> items) {
    this.items = items;
  }

  /**
   * Sets the total count.
   *
   * @param totalCount the new total count
   */
  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }

  /**
   * Gets the total count.
   *
   * @return the total count
   */
  public long getTotalCount() {
    return this.totalCount;
  }

  /**
   * Gets the start of page.
   *
   * @return the start of page
   */
  public int getStartOfPage() {
    return ((getCurrentPageNo() - 1) * this.pageSize);
  }

  /**
   * Checks for items.
   *
   * @return true, if checks for items
   */
  public boolean hasItems() {
    return (this.getItems() != null) && (!this.getItems().isEmpty());
  }
}
