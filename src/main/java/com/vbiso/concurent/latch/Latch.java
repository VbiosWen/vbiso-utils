package com.vbiso.concurent.latch;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:15 PM 2018/12/16
 * @Modified By:
 */
public abstract class Latch {

  protected int limit;

  public Latch(int limit){
    this.limit=limit;
  }

  public abstract void await() throws InterruptedException;

  public abstract void await(TimeUnit unit,long time) throws InterruptedException,WaitTimeOutException;

  public abstract void countDown();

  public abstract int getUnarrived();


}
