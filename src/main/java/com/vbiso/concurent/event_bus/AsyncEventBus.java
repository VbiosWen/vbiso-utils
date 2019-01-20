package com.vbiso.concurent.event_bus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:08 PM 2019/1/6
 * @Modified By:
 */
public class AsyncEventBus extends EventBus {


  private AsyncEventBus(String busName,
      EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
    super(busName, exceptionHandler, executor);
  }

  public AsyncEventBus(String busName,ThreadPoolExecutor executor){
    this(busName,null,executor);
  }

  public AsyncEventBus(ThreadPoolExecutor executor){
    this("default-async",null,executor);
  }

  public AsyncEventBus(EventExceptionHandler exceptionHandler,ThreadPoolExecutor executor) {
    this("default-async",exceptionHandler,executor);
  }
}
