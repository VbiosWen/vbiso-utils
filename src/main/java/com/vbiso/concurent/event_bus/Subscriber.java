package com.vbiso.concurent.event_bus;

import java.lang.reflect.Method;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:52 PM 2019/1/6
 * @Modified By:
 */
public class Subscriber {

  private final Object subscribeObject;

  private final Method subscribeMethod;

  private boolean diable=false;

  public Subscriber(Object subscribeObject, Method subscribeMethod) {
    this.subscribeObject = subscribeObject;
    this.subscribeMethod = subscribeMethod;
  }

  public Object getSubscribeObject() {
    return subscribeObject;
  }

  public Method getSubscribeMethod() {
    return subscribeMethod;
  }

  public boolean isDiable() {
    return diable;
  }

  public void setDiable(boolean diable) {
    this.diable = diable;
  }
}
