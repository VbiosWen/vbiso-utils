package com.vbiso.concurent.active_objects;

import com.vbiso.concurent.future.Future;
import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:22 PM 2018/12/29
 * @Modified By:
 */
public class FindOrderDetailsMessage extends MethodMessage {

  public FindOrderDetailsMessage(Map<String, Object> params,
      OrderService orderService) {
    super(params, orderService);
  }

  @Override
  public void execute() {
    Future<String> realFuture = orderService.findOrderDetails((Long) params.get("orderId"));

    @SuppressWarnings("unchecked")
    ActiveFuture<String> activeFuture= (ActiveFuture<String>) params.get("activeFuture");
    try {
      String result = realFuture.get();
      activeFuture.finish(result);
    } catch (InterruptedException e) {
      activeFuture.finish(null);
    }
  }
}
