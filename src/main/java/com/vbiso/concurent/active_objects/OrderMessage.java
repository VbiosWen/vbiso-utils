package com.vbiso.concurent.active_objects;

import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:26 PM 2018/12/29
 * @Modified By:
 */
public class OrderMessage extends MethodMessage {

  public OrderMessage(Map<String, Object> params,
      OrderService orderService) {
    super(params, orderService);
  }

  @Override
  public void execute() {
    String account= (String) params.get("account");
    long orderId= (long) params.get("orderId");
    orderService.order(account,orderId);
  }
}
