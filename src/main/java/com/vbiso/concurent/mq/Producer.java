package com.vbiso.concurent.mq;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:20 PM 2019/4/3
 * @Modified By:
 */
public interface Producer {

  void send(MessageContext context);

}
