package com.vbiso.concurent.event_bus;

import java.lang.reflect.Method;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:44 PM 2019/1/6
 * @Modified By:
 */
public interface EventContext {

  String getSource();

  Object getSubscriber();

  Method getSubscribe();

  Object getEvent();

}
