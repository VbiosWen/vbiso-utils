package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:27 AM 2018/12/12
 * @Modified By:
 */
@FunctionalInterface
public interface CallBack<T> {

  void call(T t);
}
