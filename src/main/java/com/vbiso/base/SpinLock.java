package com.vbiso.base;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:33 2019-06-17
 * @Modified By:
 */
public class SpinLock {

  private AtomicReference<Thread> sign = new AtomicReference<>();

  public void lock() {
    Thread thread = Thread.currentThread();
    while (!sign.compareAndSet(null, thread)) {

    }
  }

  public void unlock() {
    Thread thread = Thread.currentThread();
    sign.compareAndSet(thread, null);
  }

}
