package com.vbiso.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vbiso.exceptions.JsonException;
import java.io.IOException;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午11:48 2018/10/14
 * @Modified By:
 */
public class JsonUtil {


  public static <T> String toJson(T t) throws JsonException {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(t);
    } catch (JsonProcessingException e) {
      throw new JsonException(e);
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T parse(String str, Class<T> clazz) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(str, clazz);
  }

}
