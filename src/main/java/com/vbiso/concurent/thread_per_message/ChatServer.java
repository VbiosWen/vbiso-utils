package com.vbiso.concurent.thread_per_message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:01 PM 2018/12/17
 * @Modified By:
 */
public class ChatServer {

  private final int port;

  private ExecutorService executorService;


  private ServerSocket serverSocket;

  public ChatServer(int port) {
    this.port = port;
  }

  public ChatServer() {
    this(13312);
  }

  public void startServer() throws IOException {
    this.executorService=Executors.newCachedThreadPool();
    this.serverSocket=new ServerSocket(port);
    this.serverSocket.setReuseAddress(true);
    System.out.println("Chat server is started and listen at port: "+ port);
    this.listen();
  }

  private void listen() throws IOException {
    for(;;){
      Socket accept = serverSocket.accept();
      this.executorService.execute(new ClientHandler(accept));
    }
  }

  public static void main(String[] args) throws IOException {
    new ChatServer().startServer();
  }
}
