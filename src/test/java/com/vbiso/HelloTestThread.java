package com.vbiso;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:14 PM 2018/12/4
 * @Modified By:
 */
public class HelloTestThread {


  public static void main(String[] args) {
    new Thread(new HelloTestTask("vbiso-001")).start();
    new Thread(new HelloTestTask("vbiso-002")).start();

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1, 1, TimeUnit.SECONDS.toSeconds(1),
        TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadFactory() {
      private AtomicInteger atomicInteger = new AtomicInteger(0);
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "ThreadPool-" + atomicInteger.incrementAndGet());
      }
    }, (r, executor2) -> {
      try {
        executor2.getQueue().put(r);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

}
