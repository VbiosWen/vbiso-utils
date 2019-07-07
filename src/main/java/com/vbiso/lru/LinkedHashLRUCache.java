package com.vbiso.lru;


import com.google.common.base.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 20:21 2019-07-07
 * @Modified By:
 */
public class LinkedHashLRUCache<K, V> implements LRUCache<K, V> {

  private final byte[] lock = new byte[1];


  private static class InternalLRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 5828851805195517618L;


    final int limit;

    private InternalLRUCache(int limit) {
      super(16, 0.75f, true);
      this.limit = limit;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
      return size() > limit;
    }
  }

  private final int limit;

  private final InternalLRUCache<K, V> internalLRUCache;

  public LinkedHashLRUCache(int limit) {
    Preconditions.checkArgument(limit > 0, "the limit must big than zero.");
    this.limit = limit;
    this.internalLRUCache = new InternalLRUCache<>(limit);
  }

  @Override
  public void put(K key, V value) {
    synchronized (lock) {
      this.internalLRUCache.put(key, value);
    }
  }

  @Override
  public V get(K key) {
    return this.internalLRUCache.get(key);
  }

  @Override
  public void remove(K key) {
    synchronized (lock) {
      this.internalLRUCache.remove(key);
    }
  }

  @Override
  public int size() {
    return this.internalLRUCache.size();
  }

  @Override
  public void clear() {
    synchronized (lock) {
      this.internalLRUCache.clear();
    }
  }

  @Override
  public int limit() {
    return this.limit;
  }

  @Override
  public String toString() {
    return this.internalLRUCache.toString();
  }
}
