package com.vbiso.list;

import java.util.Iterator;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:28 PM 2018/12/2
 * @Modified By:
 */
public interface Collection<AnyType> extends Iterable<AnyType> {

  int size();

  boolean isEmpty();

  void clear();

  boolean contains(AnyType obj);

  AnyType add(int index,AnyType obj);

  AnyType remove(int idx);

  @Override
  Iterator<AnyType> iterator();
}
