package com.vbiso.concurent.new_active_objects;

import com.vbiso.concurent.active_objects.ActiveFuture;
import com.vbiso.concurent.future.Future;
import java.lang.reflect.Method;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:50 PM 2019/1/3
 * @Modified By:
 */
public class ActiveMessage {

  private final Object[] objects;

  private final Method method;

  private final ActiveFuture<Object> future;

  private final Object service;

  public ActiveMessage(Builder builder) {
    this.objects = builder.objects;
    this.method = builder.method;
    this.future = builder.future;
    this.service = builder.service;
  }

  public void execute(){
    try {
      Object result = method.invoke(service, objects);
      if(future!=null){
        Future<?> realFuture= (Future<?>) result;
        Object realResult = realFuture.get();
        future.finish(realResult);
      }
    } catch (Exception e) {
      if(future!=null){
        future.finish(null);
      }
    }
  }


  static class Builder{
    private Object[] objects;

    private Method method;

    private ActiveFuture<Object> future;

    private Object service;

    public Builder useMethod(Method method){
      this.method=method;
      return this;
    }

    public Builder returnFuture(ActiveFuture<Object> future){
      this.future=future;
      return this;
    }

    public Builder withObjects(Object[] objects){
      this.objects=objects;
      return this;
    }
    public Builder forService(Object service){
      this.service=service;
      return this;
    }

    public ActiveMessage build(){
      return new ActiveMessage(this);
    }
  }
}
