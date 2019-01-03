package com.vbiso.concurent.proxy;

import com.vbiso.concurent.new_active_objects.ActiveMethod;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:48 PM 2019/1/3
 * @Modified By:
 */
public class TestMessage implements Message {

  private String message;

  public TestMessage(String message) {
    this.message = message;
  }

  @ActiveMethod
  @Override
  public void offer() {
    System.out.println(message);
  }

  @Override
  public String take() {
    return "test";
  }
}
