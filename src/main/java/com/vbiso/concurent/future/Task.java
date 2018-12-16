package com.vbiso.concurent.future;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:25 AM 2018/12/12
 * @Modified By:
 */
@FunctionalInterface
public interface Task<I, O> {

  O get(I input);

}
