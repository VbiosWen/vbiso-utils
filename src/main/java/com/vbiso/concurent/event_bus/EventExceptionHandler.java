package com.vbiso.concurent.event_bus;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:44 PM 2019/1/6
 * @Modified By:
 */
@FunctionalInterface
public interface EventExceptionHandler {

  void handle(Throwable cause,EventContext eventContext);

}
