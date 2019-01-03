package com.vbiso.concurent.active_objects;


import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:47 PM 2018/12/29
 * @Modified By:
 */
public class ActivityMessageQueue {

  private final LinkedList<MethodMessage> messages=new LinkedList<>();

  public ActivityMessageQueue() {
    new ActiveDaemonThread(this).start();
  }

  public void offer(MethodMessage methodMessage){
    synchronized (this){
      messages.addLast(methodMessage);
      this.notify();
    }
  }

  protected MethodMessage take(){
    synchronized (this){
      while (messages.isEmpty()){
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      return messages.removeFirst();
    }
  }
}
