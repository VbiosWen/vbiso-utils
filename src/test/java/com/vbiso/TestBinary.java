package com.vbiso;

import java.math.BigDecimal;
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

  @Test
  public void testBinary(){
    long USER_TAG_HAS_VERIFY_MOBILE = 1L << 48L;
    long isTry=1L<<48L;
    long tagBit=1420569044060160L;

    long userTag=1420569044060160L;

    long userTagUnset=userTag&(~isTry);
    System.out.println(userTagUnset+"====");

    System.out.println((userTag|isTry)+"========");

    System.out.println(((userTag)&(~isTry)));


    long userTag2=tagBit&(~USER_TAG_HAS_VERIFY_MOBILE);
    System.out.println(USER_TAG_HAS_VERIFY_MOBILE==(userTag&USER_TAG_HAS_VERIFY_MOBILE));
    System.out.println(userTag);
    System.out.println(tagBit&(~USER_TAG_HAS_VERIFY_MOBILE));
    //System.out.println((tagBit&(~USER_TAG_HAS_VERIFY_MOBILE))|USER_TAG_HAS_VERIFY_MOBILE==);
  }

  @Test
  public void testDouble(){
    double a=1.245;
    BigDecimal bigDecimal=new BigDecimal(a);
    double v = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
    System.out.println(v);
    double floor = Math.floor(1.2);
    System.out.println(floor);
    double ceil = Math.ceil(1.2);
    System.out.println(ceil);
  }

}
