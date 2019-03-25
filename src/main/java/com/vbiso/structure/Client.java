package com.vbiso.structure;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:56 PM 2019/3/4
 * @Modified By:
 */
public class Client {


  public static void main(String[] args) throws InterruptedException {
    Client client = new Client();
    new Thread(()->{
      try {
        client.printf();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(()-> client.printLn()).start();
  }

  public static synchronized void printf() throws InterruptedException {
    TimeUnit.SECONDS.sleep(100);
    System.out.println("hahahhah");
  }

  public static synchronized void printLn(){
    System.out.println("hahadfdfd");
  }

}
