package com.vbiso.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 15:15 2019-06-30
 * @Modified By:
 */
public class ClassLoader {

  static {
    System.out.println("test");
  }

  private static final String HELLOWORLD = "hello world";

  public static void main(String[] args){

    ArrayList<String> arrayList = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("test");
//    for(int i = 0; i< Integer.MAX_VALUE - 12;i++){
//      stringBuilder.append((char) i%127);
//    }
    StringBuffer stringBuffer = new StringBuffer();

    Hashtable<String,String> hashtable = new Hashtable<>();
    hashtable.put("key","key");
    HashMap<String,String> hashMap = new HashMap<>();

    for(int i=0;i<64;i++){
      hashMap.put("tests",String.valueOf(i));
    }

    stringBuffer.append("test");
    System.out.println(ClassLoader.HELLOWORLD);
  }

}
