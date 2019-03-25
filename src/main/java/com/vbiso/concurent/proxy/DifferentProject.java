package com.vbiso.concurent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:06 PM 2019/3/24
 * @Modified By:
 */
public class DifferentProject implements InvocationHandler {

  private final String message;

  public DifferentProject(String message) {
    this.message = message;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(message);
    //method.invoke(proxy,args);
    return "SUCCESS";
  }

  @SuppressWarnings("unchecked")
  public static <T> T newInstance(Class<?> clazz){
    ClassLoader classLoader = clazz.getClassLoader();
    Class[] interfaceClassses = new Class[]{clazz};
    DifferentProject project = new DifferentProject(list.get(ThreadLocalRandom.current().nextInt(4)));
    return (T) Proxy.newProxyInstance(classLoader,interfaceClassses,project);
  }

  private static final List<String> list = Arrays.asList("123","2321","456","678");


  public static void main(String[] args){
    GoodJob goodJob = newInstance(GoodJob.class);

    goodJob.printHello();

    GoodJob goodJob1 = newInstance(GoodJob.class);
    goodJob1.printHello();
  }

}
