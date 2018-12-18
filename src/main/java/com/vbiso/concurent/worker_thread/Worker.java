package com.vbiso.concurent.worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:38 PM 2018/12/17
 * @Modified By:
 */
public class Worker  extends Thread{

  private final ProductionChannel channel;

  private final static Random random=new Random(System.currentTimeMillis());

  public Worker(ProductionChannel channel,String wokerName) {
    super(wokerName);
    this.channel = channel;
  }

  @Override
  public void run() {
    while (true){
      try {
        Production production=channel.takeProduction();
        System.out.println(getName()+" process the "+ production);
        production.create();
        TimeUnit.SECONDS.sleep(random.nextInt(10));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
