package com.vbiso.concurent.latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:17 PM 2018/12/16
 * @Modified By:
 */
public class CountDownLatch extends Latch {

  public CountDownLatch(int limit) {
    super(limit);
  }

  @Override
  public void await() throws InterruptedException {
    synchronized (this) {
      while (limit > 0) {
        this.wait();
      }
    }
  }

  @Override
  public void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeOutException {
    if (time < 0) {
      throw new IllegalArgumentException("the time is invalid");
    }
    long remainingNanos = unit.toNanos(time);
    final long endNanos = System.nanoTime() + remainingNanos;
    synchronized (this) {
      while (limit > 0) {
        if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0) {
          throw new WaitTimeOutException("the wait time over specify time.");
        }
        this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
        remainingNanos = endNanos - System.nanoTime();
      }
    }
  }

  @Override
  public void countDown() {
    synchronized (this) {
      if (limit < 0) {
        throw new IllegalStateException("all of task already arrived");
      }
      limit--;
      this.notifyAll();
    }
  }

  @Override
  public int getUnarrived() {
    return limit;
  }

  public static void main(String[] args){
    System.out.println(System.nanoTime());
  }
}
