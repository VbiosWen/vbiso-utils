package com.vbiso.sort;


import com.vbiso.structure.sort.Sort;
import com.vbiso.structure.sort.SortType;
import com.vbiso.structure.sort.SortUtil;

/**
 * @Author: wenliujie
 * @Description: 冒泡排序, 优化后
 * @Date: Created in 7:09 PM 2018/12/18
 * @Modified By:
 */
public class BubbleSort implements Sort {

  @Override
  public <T extends Comparable<T>> T[] sort(T[] array, SortType sortType) {
    bubbleSort(array, sortType);
    return array;
  }

  private <T extends Comparable<T>> void bubbleSort(T[] array, SortType sortType) {
    for (int i = 0; i < array.length - 1; ++i) {
      for (int j = 0; j < array.length - i - 1; ++j) {
        if (SortUtil.sortType(array[j], array[j + 1], sortType)) {
          SortUtil.swap(array, j, j + 1);
        }
      }
    }
  }

  private <T extends Comparable<T>> void sortASC(T[] array) {
    for (int i = 0; i < array.length - 1; ++i) {
      for (int j = 0; j < array.length - 1 - i; ++j) {
        if (SortUtil.max(array[j], array[j + 1])) {
          SortUtil.swap(array, j, j + 1);
        }
      }
    }
  }

  private <T extends Comparable<T>> void sortDESC(T[] array) {
    for (int i = 0; i < array.length - 1; ++i) {
      for (int j = 0; j < array.length - i - 1; ++j) {
        if (array[j].compareTo(array[j + 1]) < 0) {
          SortUtil.swap(array, j, j + 1);
        }
      }
    }
  }
}
