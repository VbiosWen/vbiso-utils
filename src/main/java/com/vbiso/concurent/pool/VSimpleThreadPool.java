package com.vbiso.concurent.pool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:12 PM 2019/1/23
 * @Modified By:
 */
public class VSimpleThreadPool implements VThreadPool {

  private int initThreadSize;

  private int coreThreadSize;

  private int maxThreadSize;

  private int activeThreadSize;

  private final VThreadFactory threadFactory;

  private final VRunnableQueue runnableQueue;

  private volatile boolean isShutdown = false;

  private final Queue<ThreadTask> threadTaskQueue=new ArrayDeque<>();

  private final  VDenyPolicy denyPolicy;

  private final long keepAliveTime;

  private final TimeUnit timeUnit;

  public VSimpleThreadPool(VThreadFactory threadFactory,
      VRunnableQueue runnableQueue, VDenyPolicy denyPolicy, long keepAliveTime,
      TimeUnit timeUnit) {
    this.threadFactory = threadFactory;
    this.runnableQueue = runnableQueue;
    this.denyPolicy = denyPolicy;
    this.keepAliveTime = keepAliveTime;
    this.timeUnit = timeUnit;
  }

  public void init(){
    newThread();
  }

  private void newThread() {
    VInternalTask vInternalTask=new VInternalTask(runnableQueue);
    Thread thread = this.threadFactory.newThread(vInternalTask);
    ThreadTask threadTask=new ThreadTask(thread,vInternalTask);
    threadTaskQueue.offer(threadTask);
    this.activeThreadSize++;
    thread.start();
  }

  private void start() {

  }

  @Override
  public void execute(Runnable runnable) {

  }

  @Override
  public void shutdown() {

  }

  @Override
  public int getInitSize() {
    return 0;
  }

  @Override
  public int getMaxSize() {
    return 0;
  }

  @Override
  public int getCoreSize() {
    return 0;
  }

  @Override
  public int getQueueSize() {
    return 0;
  }

  @Override
  public int getActiveCount() {
    return 0;
  }

  @Override
  public boolean isShutdown() {
    return false;
  }


  private static class ThreadTask {

    Thread thread;

    VInternalTask vInternalTask;

    public ThreadTask(Thread thread, VInternalTask internalTask) {
      this.thread = thread;
      this.vInternalTask = internalTask;
    }
  }
}
