package com.vbiso.concurent.event_bus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:25 PM 2019/1/5
 * @Modified By:
 */
public class Registry {

  private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

  void bind(Object subscriber) {

    List<Method> subscribeMethods = getSubscribeMethods(subscriber);
    subscribeMethods.forEach(method -> tierSubscriber(subscriber, method));
  }

  void unbind(Object subscriber) {
    subscriberContainer.forEach((key, queue) -> queue.forEach(s -> {
      if (s.getSubscribeObject() == subscriber) {
        s.setDiable(true);
      }
    }));
  }

  ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic) {
    return subscriberContainer.get(topic);
  }

  private void tierSubscriber(Object subscriber, Method method) {
    final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
    String topic = subscribe.topic();
    subscriberContainer.computeIfAbsent(topic, key -> new ConcurrentLinkedQueue<>());
    subscriberContainer.get(topic).add(new Subscriber(subscriber, method));
  }

  private List<Method> getSubscribeMethods(Object subscriber) {
    final List<Method> methods = new ArrayList<>();
    Class<?> temp = subscriber.getClass();
    while (null != temp) {
      Method[] declaredMethods = temp.getDeclaredMethods();
      Arrays.stream(declaredMethods).filter(method -> method.isAnnotationPresent(Subscribe.class)
          && method.getParameterCount() == 1
          && method.getModifiers() == Modifier.PUBLIC)
          .forEach(methods::add);
      temp = temp.getSuperclass();
    }
    return methods;
  }


}
