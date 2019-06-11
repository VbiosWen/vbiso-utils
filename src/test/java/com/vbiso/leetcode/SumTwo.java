package com.vbiso.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:26 PM 2019/4/20
 * @Modified By:
 */
public class SumTwo {


  @Test
  public void testSum(){
    int[] numbs = new int[]{3,2,4};
    int[] ints = twoSum3(numbs, 6);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }

  /**
   * 暴力解决
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target){
    for(int i=0 ; i < nums.length; ++i){
      for(int j= i + 1 ; j < nums.length ; j++){
        if(nums[i] + nums[j] ==target){
          return new int[]{i,j};
        }
      }
    }
    return null;
  }

  /**
   * 一遍 hash 遍历
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum2(int[] nums, int target){
    Map<Integer,Integer> map = new HashMap<>((int) (nums.length/0.75));
    for (int i = 0; i < nums.length; i++) {
      if(map.containsKey(target - nums[i])){
        return new int[]{map.get(target-nums[i]),i};
      }
      map.put(nums[i],i);
    }
    throw new IllegalArgumentException("No such sum solution");
  }

  public int[] twoSum3(int[] nums , int target){
    Map<Integer,Integer> map = new HashMap<>((int)(nums.length/0.75));
    for(int i= 0; i< nums.length; ++i){
      map.put(nums[i],i);
    }
    for(int i=0 ; i< nums.length ; i++){
      int elem  = target - nums[i];
      if(map.containsKey(elem) && map.get(elem) != i){
        return new int[]{map.get(elem),i};
      }
    }
    throw new IllegalArgumentException("No such sum solution");
  }



}
