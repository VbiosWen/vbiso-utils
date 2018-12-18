package com.vbiso.concurent.thread_per_message;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:48 PM 2018/12/17
 * @Modified By:
 */
public class TaskHandler implements Runnable {

  private final Request request;

  public TaskHandler(Request request) {
    this.request = request;
  }

  @Override
  public void run() {
    System.out.println("Begin handle: "+ request);
    slowly();
    System.out.println("End handle: " +request);
  }

  private void slowly() {
    try {
      TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
