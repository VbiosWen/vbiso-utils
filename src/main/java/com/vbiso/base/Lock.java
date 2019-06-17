package com.vbiso.base;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 09:59 2019-06-17
 * @Modified By:
 */
public interface Lock {


  void lock(String key);

  void lock(String key,long expireTime, TimeUnit timeUnit);

  void unlock(String key);

}
