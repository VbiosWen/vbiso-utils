package com.vbiso.concurent.pool;

/**
 * @Author: wenliujie
 * @Description: 拒绝策略
 * @Date: Created in 10:01 PM 2019/1/23
 * @Modified By:
 */
public interface VDenyPolicy {

  void reject(Runnable runnable,VThreadPool vThreadPool);
}
