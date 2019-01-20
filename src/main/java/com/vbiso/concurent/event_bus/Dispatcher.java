package com.vbiso.concurent.event_bus;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:26 PM 2019/1/5
 * @Modified By:
 */
public class Dispatcher {

  private final Executor executorService;

  private final EventExceptionHandler exceptionHandler;

  public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

  public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

  private Dispatcher(Executor executorService, EventExceptionHandler exceptionHandler) {
    this.executorService = executorService;
    this.exceptionHandler = exceptionHandler;
  }

  public void dispatch(Bus bus, Registry registry, Object event, String topic) {
    ConcurrentLinkedQueue<Subscriber> subscribers =
        registry.scanSubscriber(topic);
    if (Objects.isNull(subscribers)) {
      if (exceptionHandler != null) {
        exceptionHandler.handle(new IllegalArgumentException("The topic" + topic + "not bind yet"),
            new BaseEventContext(bus.getBusName(), null, event));
      }
      return;
    }
    subscribers.stream().filter(subscriber -> !subscriber.isDiable())
        .filter(subscriber -> {
          Method subscribeMethod = subscriber.getSubscribeMethod();
          Class<?> aClass = subscribeMethod.getParameterTypes()[0];
          return (aClass.isAssignableFrom(event.getClass()));
        }).forEach(subscriber -> readInvokeSubscribe(subscriber, event, bus));
  }

  private void readInvokeSubscribe(Subscriber subscriber, Object event, Bus bus) {
    Method subscribeMethod = subscriber.getSubscribeMethod();
    Object subscribeObject = subscriber.getSubscribeObject();
    executorService.execute(() -> {
      try {
        subscribeMethod.invoke(subscribeObject, event);
      } catch (Exception e) {
        if (Objects.nonNull(exceptionHandler)) {
          exceptionHandler.handle(e, new BaseEventContext(bus.getBusName(), subscriber, event));
        }
      }
    });
  }

  public void close() {
    if (executorService instanceof ExecutorService) {
      ((ExecutorService) executorService).shutdown();
    }
  }

  static Dispatcher newDispatcher(EventExceptionHandler exceptionHandler, Executor executor) {
    return new Dispatcher(executor, exceptionHandler);
  }

  static Dispatcher preThreadDispatcher(EventExceptionHandler exceptionHandler) {
    return new Dispatcher(PRE_THREAD_EXECUTOR_SERVICE, exceptionHandler);
  }


  private static class SeqExecutorService implements Executor {

    private final static SeqExecutorService INSTANCE = new SeqExecutorService();

    @Override
    public void execute(Runnable command) {
      command.run();
    }
  }

  private static class PreThreadExecutorService implements Executor {

    private final static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

    @Override
    public void execute(Runnable command) {
      new Thread(command).start();
    }
  }

  private static class BaseEventContext implements EventContext {

    private final String eventBusName;

    private final Subscriber subscriber;

    private final Object event;

    public BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
      this.eventBusName = eventBusName;
      this.subscriber = subscriber;
      this.event = event;
    }

    @Override
    public String getSource() {
      return this.eventBusName;
    }

    @Override
    public Object getSubscriber() {
      return this.subscriber != null ? subscriber.getSubscribeObject() : null;
    }

    @Override
    public Method getSubscribe() {
      return subscriber != null ? subscriber.getSubscribeMethod() : null;
    }

    @Override
    public Object getEvent() {
      return this.event;
    }
  }

}
