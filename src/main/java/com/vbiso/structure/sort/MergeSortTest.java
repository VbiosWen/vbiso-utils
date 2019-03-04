package com.vbiso.structure.sort;

import java.util.Arrays;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:22 PM 2019/3/3
 * @Modified By:
 */
public class MergeSortTest {


  public void mergeSort(int[] array, int left, int right) {
    int[] temp = new int[array.length];
    spiteSort(array, temp, left, right);
  }

  private void spiteSort(int[] array, int[] temp, int left, int right) {
    if (left < right) {
      int index = (right - left) / 2 + left;
      spiteSort(array, temp, left, index);
      spiteSort(array, temp, index+1, right);
      merge(array, temp, left, index, right);
    }
  }

  private void merge(int[] array, int[] temp, int left, int index, int right) {
    //1.归并排序需要一个临时数组，存放拆分后的数据
    System.arraycopy(array, left, temp, left, right - left + 1);
    int i = left;
    int j = index + 1;
    int k = left;
    while (i <= index && j <= right) {
      if (temp[i] > temp[j]) {
        array[k] = temp[j];
        j++;
      } else {
        array[k] = temp[i];
        j++;
      }
      k++;
    }
    while (i<=index){
      array[k]=temp[i];
      i++;
      k++;
    }
    while (j <= right){
      array[k] = array[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args){
    int[] array=new int[]{1,0};
    MergeSortTest mergeSortTest=new MergeSortTest();
    mergeSortTest.mergeSort(array,0,array.length-1);
    Arrays.stream(array).forEach(System.out::println);
  }

}
