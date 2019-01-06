package com.vbiso.concurent.event_bus;

import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:48 PM 2019/1/6
 * @Modified By:
 */
public class FileChangeEvent {

  private final Path path;

  private final WatchEvent.Kind<?> kind;

  public FileChangeEvent(Path child, Kind<?> kind) {
    this.path=child;
    this.kind=kind;
  }

  public Path getPath() {
    return path;
  }

  public Kind<?> getKind() {
    return kind;
  }
}
