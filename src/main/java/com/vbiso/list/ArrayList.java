package com.vbiso.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 10:24 PM 2018/11/29
 * @Modified By:
 */
public class ArrayList<AnyType> implements Collection<AnyType> {

  private static final int DEFAULT_CAPACITY = 10;

  private int size;

  private AnyType[] items;

  public ArrayList() {
    clear();
  }


  private void doClear() {
    this.size = 0;
    ensureCapacity(DEFAULT_CAPACITY);
  }

  private void ensureCapacity(int newCapacity) {
    if (newCapacity < size()) {
      return;
    }
    AnyType[] old = this.items;
    this.items = (AnyType[]) new Object[newCapacity];
    for (int i = 0; i < size(); i++) {
      this.items[i] = old[i];
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void clear() {
    doClear();
  }

  public AnyType get(int idx) {
    if (idx < 0 || idx > size()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return items[idx];
  }

  @Override
  public boolean contains(AnyType obj) {
    return false;
  }

  @Override
  public AnyType add(int idx, AnyType obj) {
    if (this.items.length == size()) {
      ensureCapacity(size() * 2 + 1);
    }
    for (int i = size; i > idx; i--) {
      this.items[i] = this.items[i - 1];
    }
    this.items[idx] = obj;
    size++;
    return obj;
  }

  public void add(AnyType obj) {
    add(size(), obj);
  }

  @Override
  public AnyType remove(int idx) {
    AnyType removedItems = items[idx];
    for (int i = idx; i < size() - 1; i++) {
      items[i] = items[i + 1];
    }
    this.size--;
    return removedItems;
  }

  @Override
  public Iterator<AnyType> iterator() {
    return null;
  }

  private class ArrayListIterator implements Iterator<AnyType> {

    private int current = 0;

    @Override
    public boolean hasNext() {
      return current < size();
    }

    @Override
    public AnyType next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return items[current++];
    }

    @Override
    public void remove() {
      ArrayList.this.remove(--current);
    }
  }
}
