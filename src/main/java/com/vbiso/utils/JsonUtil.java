package com.vbiso.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vbiso.exceptions.JsonException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午11:48 2018/10/14
 * @Modified By:
 */
public class JsonUtil {

  private static final ObjectMapper mapper=new ObjectMapper();


  public static <T> String toJson(T t) throws JsonException {
    try {
      return mapper.writeValueAsString(t);
    } catch (JsonProcessingException e) {
      throw new JsonException(e);
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T parse(String str, Class<T> clazz) throws JsonException  {
    try {
      return mapper.readValue(str, clazz);
    } catch (IOException e) {
      throw new JsonException(e);
    }
  }
}
