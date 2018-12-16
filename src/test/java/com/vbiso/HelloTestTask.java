package com.vbiso;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:11 PM 2018/12/4
 * @Modified By:
 */
public class HelloTestTask implements Runnable {

  static HelloTest helloTest=HelloTest.INSTANCE;

  private String message;

  public HelloTestTask(String message) {
    this.message = message;
  }

  @Override
  public void run() {
    helloTest.setMessage(message);
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Hello world"+helloTest.getMessage());
  }
}
