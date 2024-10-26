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
package lets.core.rolling;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import jodd.format.Printf;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.MutableValue;
import lets.core.Range;
import lets.core.ResultSupport;
import lets.core.StringUtils;
import lets.core.io.FileUtils;
import lets.core.io.comparator.NameFileComparator;
import lets.core.io.filefilter.AndFileFilter;
import lets.core.io.filefilter.FileFileFilter;
import lets.core.io.filefilter.SuffixFileFilter;

/**
 * RollingFileSupport.
 *
 * @author zhoupan.
 */
public class RollingFileSupport {

  /** The dir. */
  private final MutableValue<File> dir = new MutableValue<File>();

  /** The base name. */
  private final MutableValue<String> baseName = new MutableValue<String>();

  /** The file ext. */
  private final MutableValue<String> fileExt = new MutableValue<String>();

  /** The range. */
  private final MutableValue<Range<Long>> range = new MutableValue<Range<Long>>();

  /** The rolling max file size. */
  private final MutableValue<Long> rollingMaxFileSize =
      new MutableValue<Long>().set(10 * FileUtils.ONE_MB);

  /** The current format. */
  private String currentFormat;

  /** The id generator. */
  private AtomicLong idGenerator = new AtomicLong(1);

  /**
   * With dir.
   *
   * @param dir the dir
   * @return the rolling file support
   */
  public RollingFileSupport withDir(File dir) {
    this.dir.set(dir);
    return this;
  }

  /**
   * With base name.
   *
   * @param baseName the base name
   * @return the rolling file support
   */
  public RollingFileSupport withBaseName(String baseName) {
    this.baseName.set(baseName);
    return this;
  }

  /**
   * With file ext.
   *
   * @param ext the ext
   * @return the rolling file support
   */
  public RollingFileSupport withFileExt(String ext) {
    this.fileExt.set(ext);
    return this;
  }

  /**
   * With rolling max file size.
   *
   * @param fileSize the file size
   * @return the rolling file support
   */
  public RollingFileSupport withRollingMaxFileSize(long fileSize) {
    this.rollingMaxFileSize.set(fileSize);
    return this;
  }

  /**
   * With range.
   *
   * @param min the min
   * @param to the to
   * @return the rolling file support
   */
  public RollingFileSupport withRange(long min, long to) {
    this.range.set(Range.between(min, to));
    String max = Printf.str("%i", to);
    int maxLength = StringUtils.length(max);
    StringBuilder sb = new StringBuilder();
    sb.append("%0").append(maxLength).append("i");
    this.currentFormat = sb.toString();
    this.currentId(min);
    return this;
  }

  /**
   * Next id.
   *
   * @return the data result support
   */
  protected DataResultSupport<Long> currentIdIncrementAndGet() {
    DataResultSupport<Long> result = new DataResultSupport<Long>();
    try {
      // 处理超出最大范围
      if (this.range.isPresent()) {
        Range<Long> r = range.get();
        if (this.idGenerator.get() >= r.getMaximum()) {
          this.idGenerator.set(r.getMinimum());
          result.setData(this.idGenerator.get());
          return result;
        }
      }
      result.setData(this.idGenerator.incrementAndGet());
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Current id.
   *
   * @return the long
   */
  public long currentId() {
    return this.idGenerator.get();
  }

  /**
   * Current id.
   *
   * @param id the id
   */
  public void currentId(long id) {
    this.idGenerator.set(id);
  }

  /**
   * On start.
   *
   * @return the result support
   */
  public ResultSupport onStart() {
    ResultSupport result = new ResultSupport();
    try {
      CoreUtils.checkState(this.dir.isPresent(), "dir should present.");
      CoreUtils.checkState(this.fileExt.isPresent(), "fileExt should present.");
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Current.
   *
   * @return the data result support
   */
  public DataResultSupport<File> current() {
    DataResultSupport<File> result = new DataResultSupport<File>();
    try {
      CoreUtils.checkState(this.dir.isPresent(), "dir should present.");
      CoreUtils.checkState(this.fileExt.isPresent(), "fileExt should present.");
      String ext = this.fileExt.get();
      if (StringUtils.isNotBlank(ext) && (!StringUtils.startsWith(ext, "."))) {
        ext = "." + ext;
      }
      if (!this.dir.get().exists()) {
        this.dir.get().mkdirs();
      }
      File file = new File(this.dir.get(), this.onResolveFileName(this.currentId(), ext));
      result.setData(file);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Format current id.
   *
   * @param currentId the current id
   * @return the string
   */
  public String formatCurrentId(long currentId) {
    try {
      if (StringUtils.isNotEmpty(this.currentFormat)) {
        return Printf.str(this.currentFormat, currentId);
      }
    } catch (Throwable e) {
    }
    return currentId + "";
  }

  /**
   * On resolve file name.
   *
   * @param currentId the current id
   * @param ext the ext
   * @return the string
   */
  public String onResolveFileName(long currentId, String ext) {
    if (!StringUtils.startsWith(ext, ".")) {
      ext = "." + ext;
    }
    if (this.baseName.isPresent()) {
      return String.format("%s.%s%s", this.baseName.get(), this.formatCurrentId(currentId), ext);
    }
    return String.format("%s%s", this.formatCurrentId(currentId), ext);
  }

  /**
   * On resolve file name.
   *
   * @param ext the ext
   * @return the string
   */
  public String onResolveFileName(String ext) {
    return this.onResolveFileName(this.currentId(), ext);
  }

  /**
   * Next.
   *
   * @return the data result support
   */
  public DataResultSupport<File> next() {
    DataResultSupport<File> result = new DataResultSupport<File>();
    try {
      DataResultSupport<Long> in = this.currentIdIncrementAndGet();
      in.checkState();
      return this.current();
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Files.
   *
   * @return the data result support
   */
  public DataResultSupport<List<File>> files() {
    DataResultSupport<List<File>> result = new DataResultSupport<List<File>>();
    try {
      CoreUtils.checkState(this.dir.isPresent(), "dir should present.");
      CoreUtils.checkState(this.fileExt.isPresent(), "fileExt should present.");
      String ext = this.fileExt.get();
      AndFileFilter filter =
          new AndFileFilter().and(FileFileFilter.FILE).and(new SuffixFileFilter(ext));
      File[] files = this.dir.get().listFiles((FileFilter) filter);
      result.setData(new ArrayList<File>());
      if (files != null) {
        Collections.addAll(result.getData(), files);
        Collections.sort(result.getData(), NameFileComparator.NAME_COMPARATOR);
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Gets the rolling max file size.
   *
   * @return the rolling max file size
   */
  public MutableValue<Long> getRollingMaxFileSize() {
    return rollingMaxFileSize;
  }
}
