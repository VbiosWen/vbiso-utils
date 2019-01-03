package com.vbiso.concurent.new_active_objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:49 PM 2019/1/3
 * @Modified By:
 */
public class IllegalActiveMethodException extends Exception {

  private static final long serialVersionUID = -6226971438303473438L;

  public IllegalActiveMethodException(String message) {
    super(message);
  }
}
