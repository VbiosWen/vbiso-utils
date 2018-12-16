package com.vbiso.concurent.future;

import com.vbiso.utils.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:28 AM 2018/12/12
 * @Modified By:
 */
public class FutureServiceImpl<I, O> implements FutureService<I, O> {

  private final static String FUTURE_THREAD_PREFIX = "FUTURE-%d";

  private final AtomicInteger nextCounter = new AtomicInteger(0);

  private String getNextName() {
    return StringUtil.format(FUTURE_THREAD_PREFIX, nextCounter.getAndIncrement());
  }

  @Override
  public Future<?> submit(Runnable runnable) {
    final FutureTask<?> future = new FutureTask<>();
    new Thread(() -> {
      runnable.run();
      future.finish(null);
    }, getNextName()).start();
    return future;
  }

  @Override
  public Future<O> submit(Task<I, O> task, I input) {
    final FutureTask<O> futureTask = new FutureTask<>();
    new Thread(() -> {
      O o = task.get(input);
      futureTask.finish(o);
    }, getNextName()).start();
    return futureTask;
  }

  @Override
  public Future<O> submit(Task<I, O> task, I input, CallBack<O> callBack) {
    final FutureTask<O> futureTask = new FutureTask<>();
    new Thread(() -> {
      O o = task.get(input);
      futureTask.finish(o);
      callBack.call(o);
    }, getNextName()).start();
    return futureTask;
  }
}
