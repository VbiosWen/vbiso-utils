package com.vbiso.concurent.message_queue;

import java.util.TreeSet;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:20 AM 2018/12/19
 * @Modified By:
 */
public class MessageQueue<T extends Comparable<T>> implements Queue<T>{

  private TreeSet<T> treeSet = new TreeSet<>();


  @Override
  public int getSize() {
    return treeSet.size();
  }

  @Override
  public void offer(T t) {
    treeSet.add(t);
  }

  @Override
  public T take() {
    return treeSet.first();
  }
}
