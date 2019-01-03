package com.vbiso.concurent.active_objects;

import com.vbiso.concurent.future.FutureTask;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:19 PM 2018/12/29
 * @Modified By:
 */
public class ActiveFuture<T> extends FutureTask<T> {

  @Override
  public void finish(T result) {
    super.finish(result);
  }
}
