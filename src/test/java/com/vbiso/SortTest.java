package com.vbiso;

import com.vbiso.sort.BubbleSort;
import com.vbiso.sort.MergeSort;
import com.vbiso.sort.QuickSort;
import com.vbiso.sort.Sort;
import com.vbiso.sort.SortType;
import java.util.Arrays;
import org.junit.Test;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:34 PM 2018/12/18
 * @Modified By:
 */
public class SortTest {

  @Test
  public void sortQuickSort() {
    Sort sort = new QuickSort();
    Integer[] array = new Integer[]{98, 97, 96, 95, 94};
    sort.sort(array, SortType.DESC);
  }

  @Test
  public void sortBubbleSort(){
    Sort sort=new BubbleSort();
    Integer[] array = new Integer[]{98, 97, 96, 95, 94};
    sort.sort(array,SortType.DESC);
    Arrays.asList(array).forEach(number-> System.out.printf("%d\t",number));
  }

  @Test
  public void sortMerge(){
    Sort sort=new MergeSort();
    Integer[] array = new Integer[]{98, 97, 96, 95, 94};
    sort.sort(array,SortType.ASC);
    Arrays.asList(array).forEach(number-> System.out.printf("%d\t",number));
  }
}
