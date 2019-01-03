package com.vbiso.concurent.new_active_objects;

import com.vbiso.concurent.active_objects.ActiveFuture;
import com.vbiso.concurent.active_objects.OrderService;
import com.vbiso.concurent.active_objects.OrderServiceImpl;
import com.vbiso.concurent.future.Future;
import com.vbiso.concurent.new_active_objects.ActiveMessage.Builder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:50 PM 2019/1/3
 * @Modified By:
 */
public class ActiveServiceFactory {

  private final static ActiveMessageQueue queue = new ActiveMessageQueue();

  @SuppressWarnings("unchecked")
  public static <T> T active(T instance) {
    Object proxy = Proxy
        .newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(),
            new ActiveInvocationHandler<>(instance));
    return (T) proxy;
  }


  private static class ActiveInvocationHandler<T> implements InvocationHandler {

    private final T instance;

    ActiveInvocationHandler(T instance) {
      this.instance = instance;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if(method.isAnnotationPresent(ActiveMethod.class)){
        this.checkMethod(method);
        ActiveMessage.Builder builder=new Builder();
        builder.useMethod(method).withObjects(args).forService(instance);
        Object result=null;
        if(this.isReturnFutureType(method)){
          result=new ActiveFuture<>();

          builder.returnFuture((ActiveFuture<Object>) result);
        }
        queue.offer(builder.build());
        return result;
      }else{
        return method.invoke(instance,args);
      }
    }

    private void checkMethod(Method method) throws IllegalActiveMethodException {
      if(!isReturnFutureType(method)&& ! isReturnVoidType(method)){
        throw new IllegalActiveMethodException("the method ["+method.getName()+" return type must be void/future");
      }
    }

    private boolean isReturnVoidType(Method method){
      return method.getReturnType().equals(Void.TYPE);
    }

    private boolean isReturnFutureType(Method method){
      return method.getReturnType().isAssignableFrom(Future.class);
    }
  }


  public static void main(String[] args) throws InterruptedException {
    OrderService orderService=active(new OrderServiceImpl());
    orderService.order("test",22222L);
    System.out.println("i will be returned immediately");
    System.out.println();
  }
}
