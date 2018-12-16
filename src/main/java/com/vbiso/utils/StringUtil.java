package com.vbiso.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午11:20 2018/10/14
 * @Modified By:
 */
public class StringUtil {

  public static boolean isBlank(String str) {
    return StringUtils.isBlank(str);
  }

  public static boolean isNotBlank(String str) {
    return !isBlank(str);
  }

  public static String format(String str, String... params) {
    return String.format(str, (Object) params);
  }

  public static String format(String str,Object... params){
    return String.format(str,params);
  }


}
