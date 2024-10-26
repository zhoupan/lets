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
package lets.core.pool;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * PoolableObjectManagerTest
 *
 * @author zhoupan
 */
public class PoolableObjectManagerTest {

  public static final String KEY_LOOP = "loop";

  @Test
  public void testClaim() throws PoolException, InterruptedException {
    PoolableObjectManager<String> adapter =
        new PoolableObjectManager<String>() {

          @Override
          public String create(Properties props) {
            return props.getProperty(KEY_LOOP, "no");
          }
        };
    adapter.getConfig().setSize(1);
    ExecutorService executor = Executors.newFixedThreadPool(1);
    for (int i = 0; i < 10; i++) {
      final int loop = i;
      executor.execute(
          () -> {
            work(adapter, loop);
          });
    }
    executor.awaitTermination(1, TimeUnit.SECONDS);
  }

  private void work(PoolableObjectManager<String> mgr, int loop) {
    mgr.builder.with(KEY_LOOP, "" + loop);
    // 模拟修改配置,让对象过期
    mgr.expireAll();
    mgr.unitOfWork(
        1,
        TimeUnit.SECONDS,
        (object) -> {
          assertEquals("" + loop, object);
        });
  }
}
