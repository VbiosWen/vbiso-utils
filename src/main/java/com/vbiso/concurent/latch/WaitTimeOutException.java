package com.vbiso.concurent.latch;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 9:26 PM 2018/12/16
 * @Modified By:
 */
public class WaitTimeOutException extends Exception {


  public WaitTimeOutException() {
  }

  public WaitTimeOutException(String message) {
    super(message);
  }
}
