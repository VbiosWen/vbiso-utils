package com.vbiso.concurent.pool;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:04 PM 2019/1/23
 * @Modified By:
 */
public class VInternalTask implements Runnable {

  private final VRunnableQueue runnableQueue;

  private volatile boolean running = true;

  public VInternalTask(VRunnableQueue runnableQueue) {
    this.runnableQueue = runnableQueue;
  }

  @Override
  public void run() {
    while (running && !Thread.currentThread().isInterrupted()) {
      try {
        Runnable take = runnableQueue.take();
        take.run();
      } catch (Exception e) {
        running = false;
        break;
      }
    }
  }

  public void stop() {
    this.running = false;
  }

}
