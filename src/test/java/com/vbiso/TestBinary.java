package com.vbiso;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 4:49 PM 2018/12/23
 * @Modified By:
 */
public class TestBinary {

  @Test
  public void test() {
    //先定义 length =4;
    int length = 4;

    //header length 假设为8
    length += 8;

    //body length 假设为16
    length += 16;
    //总的length length+
    length += (4 - 16);
    System.out.println((318 >> 16) & 0xFF);
    System.out.println((318 >> 8) & 0xFF);
    System.out.println(318 & 0xFF);
    System.out.println();
    byte a = 4;
    System.out.println((char) a);
  }

  @Test
  public void testBinary() {
    long USER_TAG_HAS_VERIFY_MOBILE = 1L << 48L;
    long isTry = 1L << 48L;
    long tagBit = 1420569044060160L;

    long userTag = 1420569044060160L;

    long userTagUnset = userTag & (~isTry);
    System.out.println(userTagUnset + "====");

    System.out.println((userTag | isTry) + "========");

    System.out.println(((userTag) & (~isTry)));

    long userTag2 = tagBit & (~USER_TAG_HAS_VERIFY_MOBILE);
    System.out.println(USER_TAG_HAS_VERIFY_MOBILE == (userTag & USER_TAG_HAS_VERIFY_MOBILE));
    System.out.println(userTag);
    System.out.println(tagBit & (~USER_TAG_HAS_VERIFY_MOBILE));
    //System.out.println((tagBit&(~USER_TAG_HAS_VERIFY_MOBILE))|USER_TAG_HAS_VERIFY_MOBILE==);
  }

  @Test
  public void testDouble() {
    double a = 1.245;
    BigDecimal bigDecimal = new BigDecimal(a);
    double v = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
    System.out.println(v);
    double floor = Math.floor(1.2);
    System.out.println(floor);
    double ceil = Math.ceil(1.2);
    System.out.println(ceil);
  }

  @Test
  public void testSplit() {
    String test = "2113790535,2576189099,835026114,303566060,2219387890,358164451,450969373,2177009988,3299066796,2968292908,1848219836,2614008534,1808945499,770622025,2174360244,2354641172,2119678292,274181551,2081058060,2298471098,797567822,2179896756,285940116,1620343221,2452347015,1710310361,1791703401,734548981,1712484042,758299113,3037963981,2098904675,1692267959,820353206,200906269,1623755810,1650429497,108727117,1107209550,379752451,2794890945,2660143464,699724610,2451193866,43290044,772376192,704298669,690444147,773592828,3309612210,2075384612,2032840798,1720131773,1690425481,2217145602,2995821815,752440565,1983221995,474461573,1052501866,2253486272,1812648039,2457813340,2098914042,2482635690,436282312,779266623,743491614,806799685,2877706782,2265599537,1102315914,18520876762,87578096,3085429505,357031128,1872340602,13626568,2561855019,163613819,2863359127,1873220527,1832738091,2765322692,2550592806,2662673928,4075533129,1746354587,3436533774,137999689,3599678600,3698120262,4163194675,508215524,4106327825,2456352427,18103702,2922587332,12028739,3200313398,279512537,2078754326,3083793236,2072004631,4093779675,44674038,2078754326,3083793236,2072004631,4093779675,44674038,3329219734,3821475377,3994652824,3329219734,527702517,3421570100,3083639051,2570569779,1700259263,2636016065,2182574435,496068508";

    AtomicInteger i = new AtomicInteger();
    Arrays.stream(test.split(",")).filter(str -> {
      if (i.get() > 60) {
        return true;
      } else {
        i.incrementAndGet();
        return false;
      }
    }).forEach(str -> {

      System.out.printf("%s,", str);
    });
    System.out.println(i.get());

    System.out.println(
        "2113790535,2576189099,835026114,303566060,2219387890,358164451,450969373,2177009988,3299066796,2968292908,1848219836,2614008534,1808945499,770622025,2174360244,2354641172,2119678292,274181551,2081058060,2298471098,797567822,2179896756,285940116,1620343221,2452347015,1710310361,1791703401,734548981,1712484042,758299113,3037963981,2098904675,1692267959,820353206,200906269,1623755810,1650429497,108727117,1107209550,379752451,2794890945,2660143464,699724610,2451193866,43290044,772376192,704298669,690444147,773592828,3309612210,2075384612,2032840798,1720131773,1690425481,2217145602,2995821815,752440565,1983221995,474461573,1052501866"
            .split(",").length);

  }

  @Test
  public void testLength(){
    String str = "【yaoyantest】老朋友还记得去年春天您与我的那场约会吗，一周年到了，今年優惠尤其大，滿減優惠哲上哲、特價秒殺零点抢、快来看看吧！回T退订";
    System.out.println(str.length());
  }

}
