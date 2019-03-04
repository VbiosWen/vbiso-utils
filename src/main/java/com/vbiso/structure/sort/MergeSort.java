package com.vbiso.structure.sort;

import java.util.Arrays;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:02 PM 2018/12/18
 * @Modified By:
 */
public class MergeSort implements Sort {

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Comparable<T>> T[] sort(T[] array, SortType sortType) {
    T[] temp = (T[]) new Comparable[array.length];
    mergeSort(array, temp, 0, array.length - 1, sortType);
    return null;
  }

  private <T extends Comparable<T>> void mergeSort(T[] array, T[] temp, int left, int right,
      SortType sortType) {
    if (left < right) {
      int mid = (right - left) >> 1 + left;
      mergeSort(array, temp, left, mid, sortType);
      mergeSort(array, temp, mid + 1, right, sortType);
      merge(array, temp, left, mid, right, sortType);
    }
  }

  private <T extends Comparable<T>> void merge(T[] array, T[] temp, int left, int mid, int right,
      SortType sortType) {
    System.arraycopy(array, left, temp, left, right - left + 1);
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right) {
      if (SortUtil.sortType(temp[i], temp[j], sortType)) {
        array[k] = temp[i];
        i++;
      } else {
        array[k] = temp[j];
        j++;
      }
      k++;
    }
    while (i <= mid) {
      array[k] = temp[i];
      i++;
      k++;
    }
    while (j <= right) {
      array[k] = temp[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args){
    Integer[] arr =new Integer[]{1,0};
    MergeSort mergeSort =new MergeSort();
    mergeSort.sort(arr,SortType.ASC);
    Arrays.stream(arr).forEach(System.out::println);
  }
}
