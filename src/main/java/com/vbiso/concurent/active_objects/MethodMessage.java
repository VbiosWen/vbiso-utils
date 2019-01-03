package com.vbiso.concurent.active_objects;

import java.util.Map;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:21 PM 2018/12/29
 * @Modified By:
 */
public abstract class MethodMessage {

  protected final Map<String,Object> params;

  protected final OrderService orderService;

  public MethodMessage(Map<String, Object> params,
      OrderService orderService) {
    this.params = params;
    this.orderService = orderService;
  }


  public abstract void execute();
}
