package com.vbiso.concurent.event_bus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:48 PM 2019/1/6
 * @Modified By:
 */
public class SimpleSubscriber {

  @Subscribe
  public void method1(String message) {
    System.out.println("==SimpleSubscriber1==method1==" + message);
  }

  @Subscribe(topic = "test")
  public void method2(String message) {
    System.out.println("==SimpleSubscriber1==method2==" + message);
  }

  public static void main(String[] args){
    Bus bus=new EventBus("TestBus");
    bus.register(new SimpleSubscriber());
    bus.post("hello");
    System.out.println("----------");
    bus.post("hello","test");

    Bus bus1=new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));

    bus1.register(new SimpleSubscriber());
    bus1.post("Hello");
    System.out.println("-----------------------");
    bus1.post("hello","test");
    bus1.close();

  }

}
