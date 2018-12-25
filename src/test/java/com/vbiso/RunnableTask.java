package com.vbiso;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:23 PM 2018/12/19
 * @Modified By:
 */
public class RunnableTask implements Runnable {

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(10);
      System.out.println("run success");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    for(int i=0;i<10;i++){
      new RunnableTask().run();
    }
  }
}
