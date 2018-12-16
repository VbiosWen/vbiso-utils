package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:51 AM 2018/12/12
 * @Modified By:
 */
public interface Future<T> {

  /**
   * 获取线程运行结果,阻塞
   * @return
   * @throws InterruptedException
   */
  T get() throws InterruptedException;

  /**
   * 获取线程运行结果,阻塞一定时间
   * @param timeout wait time
   * @return
   * @throws InterruptedException
   */
  T get(long timeout) throws InterruptedException;
  /**
   * 在规定时间内获取线程运行结果,阻塞,失败进行处理
   * @param timeout wait time
   * @param callBack err call back
   * @return
   */
  T get(long timeout,ErrCallBack<? super Exception> callBack);

  /**
   * 判断线程
   * @return
   */
  boolean isDone();

  boolean isDone(long timeout,ErrCallBack<? super Exception> callBack);



}
