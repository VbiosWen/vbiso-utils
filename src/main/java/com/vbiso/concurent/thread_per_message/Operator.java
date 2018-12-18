package com.vbiso.concurent.thread_per_message;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wenliujie
 * @Description: 单线程设计模式,因为jvm能创建的线程数有限,会导致资源浪费和导致内存溢出
 * @Date: Created in 6:49 PM 2018/12/17
 * @Modified By:
 */
public class Operator {

  private List<Runnable> runnables=new LinkedList<>();

  private ExecutorService executor= Executors.newCachedThreadPool();

  public void call(String business) {
    TaskHandler handler = new TaskHandler(new Request(business));
    executor.execute(handler);
  }

}
