package com.vbiso.concurent.proxy;

import com.vbiso.concurent.new_active_objects.ActiveMethod;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:02 PM 2019/1/3
 * @Modified By:
 */
public class CglibProxyIntercepter implements MethodInterceptor {

  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    System.out.println("run before");
    return proxy.invokeSuper(obj, args);
  }

  public static void main(String[] args){
    Enhancer enhancer=new Enhancer();
    enhancer.setSuperclass(TestMessage.class);
    enhancer.setCallbackFilter(new CglibProxyFilter());
    Callback noOP= NoOp.INSTANCE;
    Callback callback=new CglibProxyIntercepter();
    enhancer.setCallbacks(new Callback[]{callback,noOP});
    TestMessage message = (TestMessage) enhancer.create(new Class[]{String.class},new Object[]{"test"});
    message.offer();
    String take = message.take();
    System.out.println(take);
  }

  static class CglibProxyFilter implements CallbackFilter{

    @Override
    public int accept(Method method) {
      if(!method.isAnnotationPresent(ActiveMethod.class)) {
        return 0;
      }
      return 1;
    }
  }
}
