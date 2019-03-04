package com.vbiso.structure.sort;

/**
 * @Author: wenliujie
 * @Description: 快速排序
 * @Date: Created in 8:57 PM 2018/12/18
 * @Modified By:
 */
public class QuickSort implements Sort {

  @Override
  public <T extends Comparable<T>> T[] sort(T[] array, SortType sortType) {
    doSort(array, sortType);
    return array;
  }

  private <T extends Comparable<T>> void doSort(T[] array, SortType sortType) {
    quickSort(array, 0, array.length - 1, sortType);
  }

  private <T extends Comparable<T>> void quickSort(T[] array, int left, int right,
      SortType sortType) {
    if (left < right) {
      int pivot = partition(array, left, right, sortType);
      quickSort(array, left, pivot - 1, sortType);
      quickSort(array, pivot, right, sortType);
//      Arrays.asList(array).forEach(number-> System.out.printf("%d\t",number));
//      System.out.println();
    }
  }

  private <T extends Comparable<T>> int partition(T[] array, int left, int right,
      SortType sortType) {
    int mid = (right - left) / 2 + left;
    T pivots = array[mid];
    while (left <= right) {
      while (SortUtil.sortType(array[left], pivots, sortType)) {
        left++;
      }
      while (SortUtil.sortType(pivots, array[right], sortType)) {
        right--;
      }
      if (left <= right) {
        SortUtil.swap(array, left, right);
        ++left;
        --right;
      }
    }
    return left;
  }

}
