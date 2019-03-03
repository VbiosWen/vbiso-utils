package com.vbiso.concurent.latch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:09 PM 2018/12/16
 * @Modified By:
 */
public class ProgrammerTravel extends Thread {

  private final Latch latch;

  private final String programer;

  private final String transportation;

  public ProgrammerTravel(Latch latch, String programer, String transportation) {
    this.latch = latch;
    this.programer = programer;
    this.transportation = transportation;
  }

  @Override
  public void run() {
    System.out.println(programer+ "start take the transportation[" + transportation+ "]");
    try{
      TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(programer + " arrived by "+ transportation);
    latch.countDown();
  }

  public static void main(String[] args) throws InterruptedException {
    Latch latch=new CountDownLatch(4);
    new ProgrammerTravel(latch,"Alex","bus").start();
    new ProgrammerTravel(latch,"gavin","walking").start();
    new ProgrammerTravel(latch,"jack","subway").start();
    new ProgrammerTravel(latch,"dillon","bicycle").start();
    try {
      latch.await(TimeUnit.SECONDS,5);
      System.out.println("=== all of programmer arrived ===");
    } catch (WaitTimeOutException e) {
      e.printStackTrace();
    }
  }
}
