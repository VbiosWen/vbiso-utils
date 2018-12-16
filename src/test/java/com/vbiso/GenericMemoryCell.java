package com.vbiso;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:55 PM 2018/11/30
 * @Modified By:
 */
public class GenericMemoryCell<AnyType> {


  private AnyType storedValue;


  public AnyType read(){
    return storedValue;
  }

  public void write(AnyType x){
    this.storedValue=x;
  }

}
