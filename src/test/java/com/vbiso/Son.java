package com.vbiso;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:01 PM 2018/12/6
 * @Modified By:
 */
public class Son extends Father implements Grand{


  public Son(String key) {
    super(key);
  }


  public static void main(String[] args){
    Grand grand=new Son("test");
    grand.sout();
  }
}
