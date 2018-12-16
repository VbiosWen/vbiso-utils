package com.vbiso.concurent.balking;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:55 PM 2018/12/16
 * @Modified By:
 */
public class BalkingTest {


  public static void main(String[] args){
    new DocumentEditThread("/Users/vbisowen/Desktop","test.txt").start();
  }

}
