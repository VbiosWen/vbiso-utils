package com.vbiso.lru;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 20:25 2019-07-07
 * @Modified By:
 */
public interface LRUCache<K,V> {

  void put(K key,V value);

  V get(K key);

  void remove(K key);

  int size();

  void clear();

  int limit();


}
