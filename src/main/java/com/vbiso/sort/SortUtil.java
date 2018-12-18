package com.vbiso.sort;

import java.util.Optional;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:47 PM 2018/12/18
 * @Modified By:
 */
public class SortUtil {


  public static <T extends Comparable<T>> void swap(T[] array, int v, int w) {
    T temp = array[v];
    array[v] = array[w];
    array[w] = temp;
  }

  public static <T extends Comparable<T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  public static <T extends Comparable<T>> boolean max(T v, T w) {
    return v.compareTo(w) > 0;
  }

  public static <T extends Comparable<T>> boolean sortType(T v, T w, SortType sortType) {
    SortType defaultSortType = Optional.ofNullable(sortType).orElse(SortType.ASC);
    if (SortType.ASC.equals(defaultSortType)) {
      return less(v, w);
    } else {
      return max(v, w);
    }
  }

}
