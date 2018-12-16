package com.vbiso;

import java.util.Arrays;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:47 PM 2018/12/2
 * @Modified By:
 */
public class VCollection<T> {

   Object[] elementData;


  public VCollection() {
    this.elementData=new Object[16];
  }

  public VCollection(T[] t) {
    Object[] temp=new Object[t.length+elementData.length];
    System.arraycopy(elementData,0,temp,0,elementData.length);
    this.elementData=temp;
  }

  public boolean isEmpty(){
    return elementData.length==0;
  }

  public void makeEmpty(){
    elementData=new Object[]{};
  }

  public void insert(T t){
    if(elementData==null || t==null){
      throw new NullPointerException();
    }
    for(Object obj:elementData){
      if(obj==null){
        obj=t;
      }
    }
  }

  public void remove(int index){
    if(index<0 || elementData==null){
      throw new IndexOutOfBoundsException();
    }
    int lenth=elementData.length;
    if(lenth-1<index){
      throw new IndexOutOfBoundsException();
    }
    Object[] temp=new Object[elementData.length-1];
    System.arraycopy(elementData,0,temp,0,index);
    System.arraycopy(elementData,index+1,temp,index,lenth-index-1);
    elementData=temp;
  }


  public boolean isPresent(T x){
    if (elementData==null || x==null){
      return false;
    }
    for (Object anElementData : elementData) {
      if (anElementData == x) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "VCollection{" +
        "elementData=" + Arrays.toString(elementData) +
        '}';
  }

  public static void main(String[] args){
    VCollection<String> vCollection=new VCollection<>();
    vCollection.insert("haha");
    System.out.println(vCollection);
  }

}
