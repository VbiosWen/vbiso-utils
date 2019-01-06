package com.vbiso.concurent.event_bus;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:41 PM 2019/1/6
 * @Modified By:
 */
public class DirectoryTargetMonitor {

  private WatchService watchService;

  private final EventBus eventBus;

  private final Path path;

  private volatile boolean start = false;

  public DirectoryTargetMonitor(final EventBus eventBus, final String targetPath) {
    this(eventBus, targetPath, "");
  }

  public DirectoryTargetMonitor(final EventBus eventBus, final String targetPath,
      final String... morePaths) {
    this.eventBus = eventBus;
    this.path = Paths.get(targetPath, morePaths);
  }

  public void startMonitor() throws IOException {
    this.watchService = FileSystems.getDefault().newWatchService();
    this.path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
    System.out.printf("The directory [%s] is monitoring.... \n",path);
    this.start=true;
    while (start){
      WatchKey watchKey=null;
      try {
        watchKey = watchService.take();
        watchKey.pollEvents().forEach(event->{
          Kind<?> kind = event.kind();
          Path path = (Path) event.context();
          Path child = DirectoryTargetMonitor.this.path.resolve(path);
          eventBus.post(new FileChangeEvent(child,kind));
        });
      } catch (InterruptedException e) {
       this.start=false;
      }finally {
        if(Objects.nonNull(watchKey)){
          watchKey.reset();
        }
      }
    }
  }

  public void stopMonitor() throws IOException {
    System.out.printf("The directory [%s] monitor will be stop...\n",path);
    Thread.currentThread().interrupt();
    this.start=false;
    this.watchService.close();
    System.out.printf("The directory [%s] monitor will be stop done.\n",path);
  }


}
