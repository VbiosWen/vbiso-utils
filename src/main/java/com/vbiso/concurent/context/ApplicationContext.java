package com.vbiso.concurent.context;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:26 PM 2018/12/16
 * @Modified By:
 */
public final class ApplicationContext {


  private ApplicationConfiguration configuration;

  private RuntimeInfo runtimeInfo;

  private ConcurrentHashMap<Thread,ActionContext> contexts=new ConcurrentHashMap<>();


  public ActionContext getActionContext() {
    ActionContext actionContext = contexts.get(Thread.currentThread());
    if(actionContext==null){
      actionContext=new ActionContext();
      contexts.put(Thread.currentThread(),actionContext);
    }
    return actionContext;
  }



  private static class Holder {

    private static ApplicationContext instance = new ApplicationContext();
  }

  public static ApplicationContext getInstance() {
    return Holder.instance;
  }

  public void setConfiguration() {
    this.configuration = configuration;
  }

  public ApplicationConfiguration getConfiguration() {
    return configuration;
  }

  public void setRuntimeInfo(RuntimeInfo runtimeInfo) {
    this.runtimeInfo = runtimeInfo;
  }

  public RuntimeInfo getRuntimeInfo() {
    return runtimeInfo;
  }
}
