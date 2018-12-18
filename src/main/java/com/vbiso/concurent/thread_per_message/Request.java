package com.vbiso.concurent.thread_per_message;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:47 PM 2018/12/17
 * @Modified By:
 */
public class Request {

  private final String business;

  public Request(String business) {
    this.business = business;
  }

  @Override
  public String toString() {
    return business;
  }
}
