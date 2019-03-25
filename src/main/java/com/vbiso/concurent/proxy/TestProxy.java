package com.vbiso.concurent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:52 PM 2019/3/21
 * @Modified By:
 */
public class TestProxy implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("test");
    return "test";
  }


  public static void main(String[] args){

    ClassLoader classLoader = TestHaha.class.getClassLoader();
    Class[] aClass = new Class[]{TestHaha.class};

    TestHaha haha = (TestHaha) Proxy
        .newProxyInstance(classLoader, aClass,
            new TestProxy());
    haha.print();
  }
}
