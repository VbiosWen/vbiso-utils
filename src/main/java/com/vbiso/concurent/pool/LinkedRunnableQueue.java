package com.vbiso.concurent.pool;

import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:07 PM 2019/1/23
 * @Modified By:
 */
public class LinkedRunnableQueue implements VRunnableQueue {

  //任务队列的最大容量
  private final int limit;

  private final VDenyPolicy denyPolicy;

  private final LinkedList<Runnable> runnables;

  private final VThreadPool threadPool;

  public LinkedRunnableQueue(int limit, VDenyPolicy denyPolicy,
      LinkedList<Runnable> runnables, VThreadPool threadPool) {
    this.limit = limit;
    this.denyPolicy = denyPolicy;
    this.runnables = runnables;
    this.threadPool = threadPool;
  }

  @Override
  public void offer(Runnable runnable) {
    synchronized (runnables) {
      if (runnables.size() > limit) {
        denyPolicy.reject(runnable, threadPool);
      } else {
        runnables.addLast(runnable);
        runnables.notifyAll();
      }
    }

  }

  @Override
  public Runnable take() throws InterruptedException {

    synchronized (runnables) {
      while (runnables.isEmpty()) {
        try {
          runnables.wait();
        } catch (InterruptedException e) {
          throw e;
        }
      }
      return runnables.removeFirst();
    }
  }

  @Override
  public int size() {
    synchronized (runnables) {
      return runnables.size();
    }
  }
}
