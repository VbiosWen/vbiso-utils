package com.vbiso.concurent.event_bus;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:26 PM 2019/1/5
 * @Modified By:
 */
public interface Bus {

  void register(Object subscriber);

  void unregister(Object subscriber);

  void post(Object event);

  void post(Object event,String topic);

  void close();

  String getBusName();

}
