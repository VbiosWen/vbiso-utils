package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:30 AM 2018/12/12
 * @Modified By:
 */
public class FutureTask<T> implements Future<T> {

  private T result;

  private boolean isDone = false;

  private final Object LOCK = new Object();


  @Override
  public T get() throws InterruptedException {
    synchronized (LOCK) {
      while (!isDone) {
       LOCK.wait();
      }
      return result;
    }
  }

  protected void finish(T result) {
    synchronized (LOCK) {
      if (isDone) {
        return;
      }
      this.result = result;
      this.isDone = true;
      LOCK.notifyAll();
    }
  }

  @Override
  public T get(long timeout) throws InterruptedException {
    synchronized (LOCK) {
      while (!isDone) {
       wait(timeout);
      }
    }
    return result;
  }

  @Override
  public T get(long timeout, ErrCallBack<? super Exception> callBack) {
    synchronized (LOCK) {
      while (!isDone) {
        try {
          wait(timeout);
        } catch (InterruptedException e) {
          callBack.callBack(e);
          return null;
        }
      }
      return result;
    }
  }

  @Override
  public boolean isDone() {
    return isDone;
  }

  @Override
  public boolean isDone(long timeout, ErrCallBack<? super Exception> callBack) {
    if (!isDone) {
      callBack.callBack(new InterruptedException());
      Thread.currentThread().interrupt();
    }
    return isDone;
  }
}
