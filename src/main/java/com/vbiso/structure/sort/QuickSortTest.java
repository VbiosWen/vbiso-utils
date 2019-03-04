package com.vbiso.structure.sort;


import java.util.Arrays;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:38 PM 2019/3/3
 * @Modified By:
 */
public class QuickSortTest {


  public static void quickSort(int[] array, int left, int right) {
    if (left < right) {
      int index = median3(array, left, right);
      //排左边
      quickSort(array, left, index - 1 );
      //排右边
      quickSort(array, index, right);
      Arrays.stream(array).forEach(arr-> System.out.printf("%d\t",arr));
      System.out.println();
    }
  }

  private static int median3(int[] array, int left, int right) {
    //先找一个约定值
    //1. 中间值作为约定值
    int mid = (right - left) / 2 + left;
    int temp = array[mid];
    //2.两边都开始查找，保证一次排序后约定值左边的值小于右边的值
    while (left <= right) {
      //3.1 当左边的值比约定值小的时候，前进
      while (array[left] < temp) {
        left++;
      }
      //3.2当右边的值比约定值大的时候，后退
      while (temp < array[right]) {
        right--;
      }
      //4 如果左边的值比约定值大，右边的值比约定值小的时候，交换左右的位置
      if (left <= right) {
        int index = array[left];
        array[left] = array[right];
        array[right] =index;
        //跳过这两个
        ++left;
        --right;
      }
    }
    //遍历完成后,left左边的都比右边的小
    return left;
  }

  public static void main(String[] args) {
    int[] array = new int[]{7,9,10, 6, 5,3,4};
    quickSort(array, 0, array.length - 0b1);
    Arrays.stream(array).forEach(System.out::println);
  }

}
