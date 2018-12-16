package com.vbiso.concurent.balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:45 PM 2018/12/16
 * @Modified By:
 */
public class AutoSaveThread extends Thread {

  private final Document document;

  public AutoSaveThread(Document document) {
    super("DocumentAutoSaveThread");
    this.document = document;
  }

  @Override
  public void run() {
    while (true){
      try {
        document.save();
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException | IOException e) {
        break;
      }
    }
  }
}
