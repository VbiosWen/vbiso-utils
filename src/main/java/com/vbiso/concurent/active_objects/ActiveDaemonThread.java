package com.vbiso.concurent.active_objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:31 PM 2018/12/29
 * @Modified By:
 */
public class ActiveDaemonThread extends Thread {


  private final ActivityMessageQueue queue;

  public ActiveDaemonThread(
      ActivityMessageQueue queue) {
    super("ActiveDaemonThread");
    this.queue = queue;
    setDaemon(true);
  }

  @Override
  public void run() {
    for(;;){
      MethodMessage take = this.queue.take();
      take.execute();
    }
  }
}
