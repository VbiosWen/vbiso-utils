package com.vbiso;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:10 PM 2018/12/4
 * @Modified By:
 */
public class HelloTest {


  private String message;

  public static final HelloTest INSTANCE=new HelloTest();



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
