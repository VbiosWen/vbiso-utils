package com.vbiso.zookeeper;

import com.vbiso.base.Lock;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 09:59 2019-06-17
 * @Modified By:
 */
public class DistributedLock implements Lock {

  @Override
  public void lock(String key) {

  }

  @Override
  public void lock(String key, long expireTime, TimeUnit timeUnit) {

  }

  @Override
  public void unlock(String key) {

  }
}
