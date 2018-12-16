package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:53 AM 2018/12/12
 * @Modified By:
 */
@FunctionalInterface
public interface ErrCallBack <T extends Exception> {

  void callBack(T t);

  default void call(T t){
    callBack(t);
  }
}
