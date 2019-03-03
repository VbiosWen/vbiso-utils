package com.vbiso.concurent.pool;

/**
 * @Author: wenliujie
 * @Description: 等待任务队列
 * @Date: Created in 9:58 PM 2019/1/23
 * @Modified By:
 */
public interface VRunnableQueue {

  /**
   * 新的任务进来时,先放入队列中
   * @param runnable
   */
  void offer(Runnable runnable);

  /**
   * 获取一个任务去执行
   * @return
   */
  Runnable take() throws InterruptedException;

  /**
   * 获取任务队列中的等待任务的数量
   * @return
   */
  int size();

}
