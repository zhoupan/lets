/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.hash;

import java.io.File;
import java.io.InputStream;
import lets.core.DataResultSupport;
import lets.core.codec.digest.DigestUtils;

/**
 * Hasher.
 *
 * @author zhoupan
 */
public class Hasher {

  /**
   * Hash.
   *
   * @param algorithm the algorithm
   * @param input the input
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(String algorithm, File input) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), input);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Hash.
   *
   * @param algorithm the algorithm
   * @param input the input
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(String algorithm, InputStream input) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), input);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Hash.
   *
   * @param algorithm the algorithm
   * @param input the input
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(String algorithm, byte[] input) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), input);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Hash.
   *
   * @param hashType the hash type
   * @param file the file
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(HashType hashType, File file) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      String algorithm = hashType.jceId;
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), file);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Hash.
   *
   * @param hashType the hash algorithm
   * @param inputStream the input stream
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(HashType hashType, InputStream inputStream) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      String algorithm = hashType.jceId;
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), inputStream);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Hash.
   *
   * @param hashType the hash algorithm
   * @param bytes the bytes
   * @return the data result support
   */
  public DataResultSupport<Hash> hash(HashType hashType, byte[] bytes) {
    DataResultSupport<Hash> result = new DataResultSupport<Hash>();
    try {
      String algorithm = hashType.jceId;
      byte[] digested = DigestUtils.digest(DigestUtils.getDigest(algorithm), bytes);
      Hash hash = new Hash(algorithm, digested);
      result.setData(hash);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
