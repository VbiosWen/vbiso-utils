package com.vbiso;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:01 PM 2018/12/6
 * @Modified By:
 */
public class Father implements Grand{


  private final String key;

  public Father(String key) {
    this.key = key;
  }

  public void sout(){
    System.out.println(key);
  }
}
