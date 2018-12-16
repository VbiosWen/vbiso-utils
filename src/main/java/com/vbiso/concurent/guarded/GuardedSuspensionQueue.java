package com.vbiso.concurent.guarded;


import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:49 PM 2018/12/12
 * @Modified By:
 */
public class GuardedSuspensionQueue<T> {

  private final LinkedList<T> queue = new LinkedList<>();

  private final int Limit;

  public GuardedSuspensionQueue(int limit) {
    Limit = limit;
  }

  public void offer(T data) throws InterruptedException {
    synchronized (this) {
      while (queue.size() >= Limit) {
        this.wait();
      }
      queue.addLast(data);
      this.notifyAll();
    }
  }

  public T take() throws InterruptedException {
    synchronized (this) {
      while (queue.isEmpty()) {
        this.wait();
      }
      this.notifyAll();
      return this.queue.removeLast();
    }
  }
}
