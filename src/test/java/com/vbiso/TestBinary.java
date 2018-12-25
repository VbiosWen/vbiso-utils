package com.vbiso;

import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:49 PM 2018/12/23
 * @Modified By:
 */
public class TestBinary {

  @Test
  public void test(){
    //先定义 length =4;
    int length=4;

    //header length 假设为8
    length+=8;

    //body length 假设为16
    length+=16;
    //总的length length+
    length+=(4-16);
    System.out.println((318>>16)&0xFF);
    System.out.println((318>>8)&0xFF);
    System.out.println(318&0xFF);
    System.out.println();
    byte a=4;
    System.out.println((char) a);
  }

}
