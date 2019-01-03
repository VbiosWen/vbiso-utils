package com.vbiso.concurent.new_active_objects;


import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:51 PM 2019/1/3
 * @Modified By:
 */
public class ActiveMessageQueue {

  private final LinkedList<ActiveMessage> messages=new LinkedList<>();

  public ActiveMessageQueue() {
    new ActiveDaemonThread(this).start();
  }

  public void offer(ActiveMessage activeMessage){
    synchronized (this){
      messages.addLast(activeMessage);
      this.notify();
    }
  }

  public ActiveMessage take(){
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

  class ActiveDaemonThread extends Thread{

    private final ActiveMessageQueue messageQueue;

    public ActiveDaemonThread(ActiveMessageQueue messageQueue) {
      this.messageQueue=messageQueue;
    }

    @Override
    public void run() {
      for(;;){
        ActiveMessage activeMessage=this.messageQueue.take();
        activeMessage.execute();
      }
    }
  }
}
