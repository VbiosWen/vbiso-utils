package com.vbiso.concurent.mq;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:23 PM 2019/4/3
 * @Modified By:
 */
public class MessageQueue {

  private SynchronousQueue<MessageContext> messageContexts = new SynchronousQueue<>();

  private final ReentrantLock lock = new ReentrantLock();

  private final Condition condition = lock.newCondition();

  public  void put(MessageContext messageContext){
    lock.lock();
    try {

      messageContexts.put(messageContext);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public synchronized MessageContext take(MessageContext messageContext){
    try {
      return messageContexts.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }

}
