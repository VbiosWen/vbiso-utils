package com.vbiso.sort;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 6:42 PM 2018/12/18
 * @Modified By:
 */
public interface Sort {

  <T extends Comparable<T>> T[] sort(T[] unsorted,SortType sortType);

  @SuppressWarnings("unchecked")
  default <T extends Comparable<T>> List<T> sort(List<T> unsorted,SortType sortType){
    return Arrays.asList(sort(unsorted.toArray((T[])new Comparable[unsorted.size()]),sortType));
  }
}
