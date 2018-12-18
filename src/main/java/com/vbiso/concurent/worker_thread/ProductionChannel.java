package com.vbiso.concurent.worker_thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:36 PM 2018/12/17
 * @Modified By:
 */
public class ProductionChannel {

  private final static int MAX_PROD=100;

  private final Production[] productions;

  private int tail;

  private int head;

  private int total;

  private final Worker[] workers;

  public ProductionChannel(int wokerSize) {
    this.workers = new Worker[wokerSize];
    this.productions=new Production[MAX_PROD];
    for(int i=0;i<wokerSize;i++){
      workers[i]=new Worker(this,"Woker-"+i);
      workers[i].start();
    }
  }

  public void offerProduction(Production production){
    synchronized (this){
      while (total > productions.length){
        try {
          this.wait();
        } catch (InterruptedException e) {

        }
      }
      productions[tail] =production;
      tail=(tail+1) % productions.length;
      total++;
      this.notifyAll();
    }
  }

  public Production takeProduction(){
    synchronized (this){
      while (total <= 0){
        try {
          this.wait();
        }catch (InterruptedException ex){

        }
      }
      Production prod=productions[head];
      head=(head+1)%productions.length;
      total--;
      this.notifyAll();
      return prod;
    }
  }

  public static void main(String[] args){
    final ProductionChannel channel=new ProductionChannel(5);
    AtomicInteger productionNo=new AtomicInteger();
    IntStream.range(1,8).forEach(i-> new Thread(()->{
      while (true){
        channel.offerProduction(new Production(productionNo.getAndIncrement()));
        try {
          TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        }catch (InterruptedException ie){

        }
      }
    }).start());
  }
}
