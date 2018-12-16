package com.vbiso.exceptions;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午11:53 2018/10/14
 * @Modified By:
 */
public class JsonException extends JsonProcessingException {

  protected JsonException(String msg, JsonLocation loc,
      Throwable rootCause) {
    super(msg, loc, rootCause);
  }

  public JsonException(String msg) {
    super(msg);
  }

  public JsonException(String msg, JsonLocation loc) {
    super(msg, loc);
  }

  public JsonException(String msg, Throwable rootCause) {
    super(msg, rootCause);
  }

  public JsonException(Throwable rootCause) {
    super(rootCause);
  }
}
