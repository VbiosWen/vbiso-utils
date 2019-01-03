package com.vbiso.concurent.active_objects;

import com.vbiso.concurent.future.Future;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:46 PM 2018/12/29
 * @Modified By:
 */
public class OrderServiceProxy implements OrderService {

  private final OrderService orderService;

  private final ActivityMessageQueue activityMessageQueue;

  public OrderServiceProxy(OrderService orderService,
      ActivityMessageQueue activityMessageQueue) {
    this.orderService = orderService;
    this.activityMessageQueue = activityMessageQueue;
  }

  @Override
  public Future<String> findOrderDetails(long orderId) {
    final ActiveFuture<String> activeFuture = new ActiveFuture<>();
    Map<String, Object> params = new HashMap<>();
    params.put("orderId", orderId);
    params.put("activeFuture", activeFuture);
    MethodMessage message = new FindOrderDetailsMessage(params, orderService);
    activityMessageQueue.offer(message);
    return activeFuture;
  }

  @Override
  public void order(String account, long orderId) {
    Map<String, Object> params = new HashMap<>();
    params.put("account", account);
    params.put("orderId", orderId);
    MethodMessage message = new OrderMessage(params, orderService);
    activityMessageQueue.offer(message);
  }
}
