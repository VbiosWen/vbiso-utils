package com.vbiso.concurent.thread_per_message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:05 PM 2018/12/17
 * @Modified By:
 */
public class ClientHandler implements Runnable {

  private final Socket socket;

  private final String clientIdentify;

  public ClientHandler(Socket socket, String clientIdentify) {
    this.socket = socket;
    this.clientIdentify = clientIdentify;
  }

  public ClientHandler(Socket socket) {
    this.socket = socket;
    this.clientIdentify=socket.getInetAddress().getHostAddress()+":"+socket.getPort();
  }

  @Override
  public void run() {
    try {
      this.chat();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void chat() throws IOException {
    BufferedReader reader=wrap2Reader(this.socket.getInputStream());
    PrintStream printStream = wrap2Print(this.socket.getOutputStream());
    String received;
    while ((received=reader.readLine())!=null){
      System.out.printf("client:%s-message:%s\n",clientIdentify,received);
      if("quit".equals(received)){
        write2Client(printStream,"client Will close");
        socket.close();
        break;
      }
      write2Client(printStream,"server:" + received);
    }
  }

  private void write2Client(PrintStream printStream, String msg) {
    printStream.println(msg);
    printStream.flush();
  }

  private PrintStream wrap2Print(OutputStream outputStream) {
    return new PrintStream(outputStream);
  }

  private BufferedReader wrap2Reader(InputStream inputStream) {
    return new BufferedReader(new InputStreamReader(inputStream));
  }
}
