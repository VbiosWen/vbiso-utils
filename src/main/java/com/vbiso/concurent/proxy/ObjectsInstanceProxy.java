package com.vbiso.concurent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:44 PM 2019/1/3
 * @Modified By:
 */
public class ObjectsInstanceProxy<T> implements InvocationHandler {

  private final T subject;

  public ObjectsInstanceProxy(T subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println(method.getName());
    return "1";
  }

  public static void main(String[] args) throws InterruptedException {

    Message message = new TestMessage("test");

    message = (Message) Proxy
        .newProxyInstance(message.getClass().getClassLoader(), message.getClass().getInterfaces(),
            new ObjectsInstanceProxy<>(message));
    //  TimeUnit.SECONDS.sleep(10);
    String take = message.take();
    System.out.println(take);
    message.offer();

  }
}
