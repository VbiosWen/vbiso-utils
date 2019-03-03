package com.vbiso.concurent.pool;

/**
 * @Author: wenliujie
 * @Description: 线程创建工厂类
 * @Date: Created in 10:00 PM 2019/1/23
 * @Modified By:
 */
@FunctionalInterface
public interface VThreadFactory {

  Thread newThread(Runnable runnable);

}
