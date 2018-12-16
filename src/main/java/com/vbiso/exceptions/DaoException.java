package com.vbiso.exceptions;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午5:56 2018/10/26
 * @Modified By:
 */
public class DaoException extends Exception {

  private static final long serialVersionUID = 9192449273617755859L;

  public DaoException() {
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  public DaoException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
