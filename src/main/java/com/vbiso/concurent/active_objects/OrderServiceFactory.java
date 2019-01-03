package com.vbiso.concurent.active_objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:39 PM 2018/12/29
 * @Modified By:
 */
public final class OrderServiceFactory {

  private final static ActivityMessageQueue activeMessageQueue=new ActivityMessageQueue();


  private OrderServiceFactory(){}

  public static OrderService toActiveObject(OrderService orderService){
    return new OrderServiceProxy(orderService,activeMessageQueue);
  }

  public static void main(String[] args) throws InterruptedException {
    OrderService orderService=OrderServiceFactory.toActiveObject(new OrderServiceImpl());
    orderService.order("hello",453453L);
    System.out.println("Return immediately");
    Thread.currentThread().join();
  }

}
