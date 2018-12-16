package com.vbiso.concurent.context;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:31 PM 2018/12/16
 * @Modified By:
 */
public class ActionContext {

  private static final ThreadLocal<Context> context = ThreadLocal.withInitial(Context::new);

  public static Context get() {
    return context.get();
  }

  static class Context {

    private ApplicationConfiguration configuration;

    private RuntimeInfo runtimeInfo;

    public RuntimeInfo getRuntimeInfo() {
      return runtimeInfo;
    }

    public ApplicationConfiguration getConfiguration() {
      return configuration;
    }

    public void setRuntimeInfo(RuntimeInfo runtimeInfo) {
      this.runtimeInfo = runtimeInfo;
    }

    public void setConfiguration(ApplicationConfiguration configuration) {
      this.configuration = configuration;
    }
  }

}
