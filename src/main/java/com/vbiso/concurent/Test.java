package com.vbiso.concurent;

import com.vbiso.concurent.future.Future;
import com.vbiso.concurent.future.FutureService;
import com.vbiso.concurent.guarded.GuardedSuspensionQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:51 AM 2018/12/12
 * @Modified By:
 */
public class Test {


  public static void main(String[] args) throws InterruptedException {

//    FutureService<Void,Void> futureService=FutureService.newService();
//
//    Future<?> future = futureService
//        .submit(() -> System.out.println("test no return result"));
//
//    Object o = future.get();
//    System.out.println(o);
//
//    FutureService<String,Integer> futureService1=FutureService.newService();
//    Future<Integer> future1 = futureService1.submit(input -> {
//      try {
//        TimeUnit.SECONDS.sleep(0);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      return input.length();
//    }, "test");
//    Integer integer = future1.get(TimeUnit.SECONDS.toSeconds(3));

    GuardedSuspensionQueue<String> queue=new GuardedSuspensionQueue<>(10);
    new Thread(()->{
      for(;;)
        try {
          queue.offer("test:");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }).start();
    new Thread(()->{
      for(;;){
        String take = null;
        try {
          take = queue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(take);
      }
    }).start();
  }

}
