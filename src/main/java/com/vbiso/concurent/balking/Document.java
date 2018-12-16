package com.vbiso.concurent.balking;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:43 PM 2018/12/16
 * @Modified By:
 */
public class Document {

  //如果文档发生变化,changed会变为true
  private boolean changed = false;

  private List<String> content = new ArrayList<>();

  private final FileWriter writer;

  private static AutoSaveThread autoSaveThread;

  private Document(String documentPath, String documentName) throws IOException {
    this.writer = new FileWriter(new File(documentPath, documentName));
  }

  public static Document create(String documentPath, String documentName) throws IOException {
    Document document = new Document(documentPath, documentName);
    autoSaveThread = new AutoSaveThread(document);
    autoSaveThread.start();
    return document;
  }

  public void edit(String content) {
    synchronized (this) {
      this.content.add(content);
      this.changed = true;
    }
  }

  public void close() throws IOException {
    autoSaveThread.interrupt();
    writer.close();
  }

  public void save() throws IOException {
    synchronized (this) {
      if (!changed) {
        return;
      }
      System.out.println(Thread.currentThread() + " execute the save action");
      for (String cacheLine : content) {
        this.writer.write(cacheLine);
        this.writer.write("\r\n");
      }
      this.writer.flush();
      this.changed = false;
      this.content.clear();
    }
  }

}
