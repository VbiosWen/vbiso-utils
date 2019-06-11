package algorithm;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 17:23 2019-05-23
 * @Modified By:
 */
public class Test {

  @org.junit.Test
  public void test(){
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("test");

    stringBuilder.append("hahafafdfaafafafdafdasfasfasf");

    System.out.println(stringBuilder.toString());

    StringBuffer stringBuffer = new StringBuffer();

    stringBuffer.append("test");
    stringBuffer.append("hahahahhhhhahgagdaadfadfadfffaf");

    Hashtable<String,String> table = new Hashtable<>();

    table.put("test","test"); //key 是调用的自身的 hashcode,所以为null 会导致 NPE
    HashMap<String,String> map = new HashMap<>();

    map.put("test","test");
  }

  @org.junit.Test
  public void test1(){
    System.out.println(10000&255);
  }
  
  

}
