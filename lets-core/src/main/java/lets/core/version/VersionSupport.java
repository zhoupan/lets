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
package lets.core.version;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import lets.core.CoreUtils;
import lets.core.StringUtils;

/**
 * This class represents a single version object. It supports 4 elements: major version (integer),
 * minor version (integer), micro version (integer) and a qualifier (string).
 *
 * @author Philip Helger
 * @author zhoupan
 */
@Immutable
public final class VersionSupport implements Comparable<VersionSupport> {
  /** default version if nothing is specified. */
  public static final String DEFAULT_VERSION_STRING = "0";

  /** The Constant DEFAULT_VERSION. */
  public static final VersionSupport DEFAULT_VERSION = new VersionSupport(0, 0, 0, null);

  /** Default value for printing zero elements in getAsString. */
  public static final boolean DEFAULT_PRINT_ZERO_ELEMENTS = false;

  /** major version. */
  private final int m_nMajor;

  /** minor version. */
  private final int m_nMinor;

  /** micro version. */
  private final int m_nMicro;

  /** version build qualifier. */
  private final String m_sQualifier;

  /**
   * Create a new version with major version only.
   *
   * @param nMajor major version
   * @throws IllegalArgumentException if the parameter is &lt; 0
   */
  public VersionSupport(@Nonnegative final int nMajor) {
    this(nMajor, 0, 0, null);
  }

  /**
   * Create a new version with major and minor version only.
   *
   * @param nMajor major version
   * @param nMinor minor version
   * @throws IllegalArgumentException if any of the parameters is &lt; 0
   */
  public VersionSupport(@Nonnegative final int nMajor, @Nonnegative final int nMinor) {
    this(nMajor, nMinor, 0, null);
  }

  /**
   * Create a new version with major, minor and micro version number. The qualifier remains null.
   *
   * @param nMajor major version
   * @param nMinor minor version
   * @param nMicro micro version
   * @throws IllegalArgumentException if any of the parameters is &lt; 0
   */
  public VersionSupport(
      @Nonnegative final int nMajor, @Nonnegative final int nMinor, @Nonnegative final int nMicro) {
    this(nMajor, nMinor, nMicro, null);
  }

  /**
   * Create a new version with 3 integer values and a qualifier.
   *
   * @param nMajor major version
   * @param nMinor minor version
   * @param nMicro micro version
   * @param sQualifier the version qualifier - may be null. If a qualifier is supplied, it may
   *     neither contain the "." or the "," character since they are used to determine the fields of
   *     a version and to separate 2 versions in a VersionRange.
   * @throws IllegalArgumentException if any of the numeric parameters is &lt; 0 or if the qualifier
   *     contains a forbidden character
   */
  public VersionSupport(
      @Nonnegative final int nMajor,
      @Nonnegative final int nMinor,
      @Nonnegative final int nMicro,
      @Nullable final String sQualifier) {
    CoreUtils.checkState(nMajor >= 0, "Major should greater or equals 0");
    CoreUtils.checkState(nMinor >= 0, "Minor should greater or equals 0");
    CoreUtils.checkState(nMicro >= 0, "Micro should greater or equals 0");
    m_nMajor = nMajor;
    m_nMinor = nMinor;
    m_nMicro = nMicro;
    m_sQualifier = StringUtils.isBlank(sQualifier) ? null : sQualifier;
  }

  /**
   * Gets the major.
   *
   * @return the major
   */
  @Nonnegative
  public int getMajor() {
    return m_nMajor;
  }

  /**
   * Gets the minor.
   *
   * @return the minor
   */
  @Nonnegative
  public int getMinor() {
    return m_nMinor;
  }

  /**
   * Gets the micro.
   *
   * @return the micro
   */
  @Nonnegative
  public int getMicro() {
    return m_nMicro;
  }

  /**
   * Gets the qualifier.
   *
   * @return the qualifier
   */
  @Nullable public String getQualifier() {
    return m_sQualifier;
  }

  /**
   * Compares two Version objects.
   *
   * @param rhs the version to compare to
   * @return &lt; 0 if this is less than rhs; &gt; 0 if this is greater than rhs, and 0 if they are
   *     equal.
   * @throws IllegalArgumentException if the parameter is null
   */
  @Override
  public int compareTo(@Nonnull final VersionSupport rhs) {
    CoreUtils.checkNotNull(rhs, "Rhs");
    // compare major version
    int ret = m_nMajor - rhs.m_nMajor;
    if (ret == 0) {
      // compare minor version
      ret = m_nMinor - rhs.m_nMinor;
      if (ret == 0) {
        // compare micro version
        ret = m_nMicro - rhs.m_nMicro;
        if (ret == 0) {
          // check qualifier
          if (m_sQualifier != null) {
            if (rhs.m_sQualifier != null) {
              ret = m_sQualifier.compareTo(rhs.m_sQualifier);

              // convert to -1/0/+1
              if (ret < 0) {
                ret = -1;
              } else if (ret > 0) {
                ret = +1;
              }
            } else {
              ret = 1;
            }
          } else if (rhs.m_sQualifier != null) {
            // only this qualifier == null
            ret = -1;
          } else {
            // both qualifier are null
            ret = 0;
          }
        }
      }
    }
    return ret;
  }

  /**
   * Gets the as string.
   *
   * @param withQualifier the with qualifier
   * @param withQualifierSep the with qualifier sep
   * @return the as string
   */
  @Nonnull
  public String getAsString(boolean withQualifier, String withQualifierSep) {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getAsStringMajorMinorMicro());
    if (withQualifier && StringUtils.isNotBlank(this.m_sQualifier)) {
      sb.append(withQualifierSep).append(this.m_sQualifier);
    }
    return sb.toString();
  }

  /**
   * Gets the as string.
   *
   * @return the as string
   */
  public String getAsString() {
    return this.getAsString(true, "-");
  }

  /**
   * Get the string representation of the version number but only major and minor version number.
   *
   * @return Never <code>null</code>.
   */
  @Nonnull
  public String getAsStringMajorMinor() {
    return m_nMajor + "." + m_nMinor;
  }

  /**
   * Get the string representation of the version number but only major and minor and micro version
   * number.
   *
   * @return Never <code>null</code>.
   */
  @Nonnull
  public String getAsStringMajorMinorMicro() {
    return m_nMajor + "." + m_nMinor + "." + m_nMicro;
  }

  /**
   * Equals.
   *
   * @param o the o
   * @return true, if successful
   */
  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null) || !this.getClass().equals(o.getClass())) {
      return false;
    }
    final VersionSupport rhs = (VersionSupport) o;
    return (m_nMajor == rhs.m_nMajor)
        && (m_nMinor == rhs.m_nMinor)
        && (m_nMicro == rhs.m_nMicro)
        && StringUtils.equals(m_sQualifier, rhs.m_sQualifier);
  }

  /**
   * Construct a version object from a string.
   *
   * @param sVersionString the version string to be interpreted as a version
   * @return The parsed {@link VersionSupport} object.
   * @throws IllegalArgumentException if any of the parameters is &lt; 0
   */
  @Nonnull
  public static VersionSupport parse(@Nullable final String sVersionString) {
    String s = sVersionString == null ? "" : sVersionString.trim();
    if (s.length() == 0) {
      return DEFAULT_VERSION;
    }
    int nMajor;
    int nMinor;
    int nMicro;
    String sQualifier = null;
    if (StringUtils.contains(s, "-")) {
      sQualifier = StringUtils.substringAfterLast(s, "-");
      s = StringUtils.substringBeforeLast(s, "-");
    }
    final String[] aParts = StringUtils.split(s, '.');
    if ((aParts.length > 0) && (StringUtils.isNumeric(aParts[0]))) {
      nMajor = Integer.parseInt(aParts[0]);
    } else {
      nMajor = 0;
    }
    if ((aParts.length > 1) && (StringUtils.isNumeric(aParts[1]))) {
      nMinor = Integer.parseInt(aParts[1]);
    } else {
      nMinor = 0;
    }
    if ((aParts.length > 2) && (StringUtils.isNumeric(aParts[2]))) {
      nMicro = Integer.parseInt(aParts[2]);
    } else {
      nMicro = 0;
    }
    if ((sQualifier == null) && (aParts.length > 3) && (StringUtils.isNotBlank(aParts[3]))) {
      sQualifier = aParts[3];
    }
    return new VersionSupport(nMajor, nMinor, nMicro, sQualifier);
  }
}
