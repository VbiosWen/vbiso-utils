package com.vbiso.exceptions;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午8:59 2018/10/13
 * @Modified By:
 */
public class SSLException extends Exception {

  private static final long serialVersionUID = 8948985519416498628L;

  /**
   * Constructs a GeneralSecurityException with no detail message.
   */
  public SSLException() {
    super();
  }

  /**
   * Constructs a GeneralSecurityException with the specified detail message. A detail message is a
   * String that describes this particular exception.
   *
   * @param msg the detail message.
   */
  public SSLException(String msg) {
    super("ssl generate throw an exception,please visit www.vbiso.com:"+msg);
  }

  /**
   * Creates a {@code GeneralSecurityException} with the specified detail message and cause.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link
   * #getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
   * (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 1.5
   */
  public SSLException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Creates a {@code GeneralSecurityException} with the specified cause and a detail message of
   * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail
   * message of {@code cause}).
   *
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
   * (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 1.5
   */
  public SSLException(Throwable cause) {
    super(cause);
  }
}
