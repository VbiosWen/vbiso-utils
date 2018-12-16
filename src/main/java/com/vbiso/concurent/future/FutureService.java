package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description: 单线程的future模式
 * @Date: Created in 11:24 AM 2018/12/12
 * @Modified By:
 */
public interface FutureService<I, O> {

  Future<?> submit(Runnable runnable);

  Future<O> submit(Task<I, O> task, I input);

  Future<O> submit(Task<I, O> task, I input, CallBack<O> callBack);


  static <I, O> FutureService<I, O> newService() {
    return new FutureServiceImpl<>();
  }

}
