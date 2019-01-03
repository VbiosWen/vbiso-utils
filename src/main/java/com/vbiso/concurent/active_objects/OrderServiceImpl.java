package com.vbiso.concurent.active_objects;

import com.vbiso.concurent.future.Future;
import com.vbiso.concurent.future.FutureService;
import com.vbiso.concurent.new_active_objects.ActiveMethod;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:43 PM 2018/12/29
 * @Modified By:
 */
public class OrderServiceImpl implements OrderService {

  @ActiveMethod
  @Override
  public Future<String> findOrderDetails(long orderId) {
    return FutureService.<Long, String>newService().submit(input -> {
      try {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("process the orderID:" + orderId);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "The order details information";
    }, orderId);
  }

  @ActiveMethod
  @Override
  public void order(String account, long orderId) {
    try {
      TimeUnit.SECONDS.sleep(10);
      System.out.println("process the order for account " + account + ",orderId " + orderId);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
