package com.vbiso;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:14 PM 2018/12/4
 * @Modified By:
 */
public class HelloTestThread {


  public static void main(String[] args){
    new Thread(new HelloTestTask("vbiso-001")).start();
    new Thread(new HelloTestTask("vbiso-002")).start();
  }

}
