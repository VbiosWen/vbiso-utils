package com.vbiso.sao_operation;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:54 2019-06-17
 * @Modified By:
 */
public class BinaryOperation {


  /**
   * 获取当前数字是否是 2 的次幂
   * 与运算,时间为 o(1)
   * example : 2 (10) 1 (01) 10 & 01 = 0 ; 3(11)  2(10) [11 & 10 = 10] != 0 so it is not the power of 2.
   * @param number
   * @return
   */
  public static boolean judgeIsThePowerOf2(long number) {
    return (number & (number - 1)) == 0;
  }

}
