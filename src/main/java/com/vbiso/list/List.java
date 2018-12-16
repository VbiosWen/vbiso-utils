package com.vbiso.list;

import java.util.ListIterator;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:32 PM 2018/12/2
 * @Modified By:
 */
public interface List<AnyType> extends Collection<AnyType> {

  AnyType get(int idx);

  AnyType set(int idx,AnyType newVal);

  AnyType add(int idx,AnyType newVal);

  AnyType remove(int idx);

  ListIterator<AnyType> listIterator(int pos);

}
