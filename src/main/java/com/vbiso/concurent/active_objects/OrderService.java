package com.vbiso.concurent.active_objects;

import com.vbiso.concurent.future.Future;
import com.vbiso.concurent.new_active_objects.ActiveMethod;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:33 PM 2018/12/29
 * @Modified By:
 */
public interface OrderService {

  /**
   * 根据订单编号查询订单明细,有入参有返回值,但是返回类型必须是future
   * @param orderId
   * @return
   */
  @ActiveMethod
  Future<String> findOrderDetails(long orderId);

  /**
   * 提交订单,没有返回值
   */

  @ActiveMethod
  void order(String account,long orderId);



}
