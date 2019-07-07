package com.vbiso.lru;

import com.google.common.collect.Maps;
import java.util.HashMap;
import org.junit.Assert;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 20:15 2019-07-07
 * @Modified By:
 */
public class SimpleLRUCache {

  private final HashMap<String,Object> cache;

  private final int capacity;

  public SimpleLRUCache(int capacity) {
    this.cache = Maps.newHashMapWithExpectedSize(capacity);
    this.capacity = capacity;
  }

  public Object get(String key){
    Assert.assertNotNull(cache);
    return cache.get(key);
  }

  public void set(String key,String object){
    cache.put(key,object);
  }



}
