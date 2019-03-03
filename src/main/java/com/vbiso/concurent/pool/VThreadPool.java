package com.vbiso.concurent.pool;

/**
 * @Author: wenliujie
 * @Description: 提供线程池的基本方法
 * @Date: Created in 9:57 PM 2019/1/23
 * @Modified By:
 */
public interface VThreadPool {

  void execute(Runnable runnable);

  void shutdown();

  int getInitSize();

  int getMaxSize();

  int getCoreSize();

  int getQueueSize();

  int getActiveCount();

  boolean isShutdown();

}
