package com.vbiso.concurent.event_bus;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:50 PM 2019/1/6
 * @Modified By:
 */
public class FileChangeListener {

  @Subscribe
  public void onChange(FileChangeEvent event){
    System.out.printf("%s-%s\n",event.getPath(),event.getKind());
  }

  public static void main(String[] args) throws IOException {
    ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
    final EventBus eventBus=new AsyncEventBus(executor);
    eventBus.register(new FileChangeListener());
    DirectoryTargetMonitor monitor=new DirectoryTargetMonitor(eventBus,"/Users/vbisowen/vbiso");
    monitor.startMonitor();
  }

}
