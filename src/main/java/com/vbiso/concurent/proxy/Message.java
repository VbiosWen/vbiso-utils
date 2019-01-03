package com.vbiso.concurent.proxy;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:48 PM 2019/1/3
 * @Modified By:
 */
public interface Message {

   void offer();

   String take();

}
