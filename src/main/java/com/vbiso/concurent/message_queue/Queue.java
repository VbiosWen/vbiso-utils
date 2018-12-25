package com.vbiso.concurent.message_queue;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:35 AM 2018/12/19
 * @Modified By:
 */
public interface Queue<T extends Comparable<T>> {

  int getSize();

  void offer(T t);

  T take();

}
