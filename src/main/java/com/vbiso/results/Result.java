package com.vbiso.results;

import java.util.function.Supplier;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 下午4:17 2018/10/15
 * @Modified By:
 */
public class Result<T> {

  private  int code;

  private  boolean success;

  private  String msg;

  private  T data;

  private  Exception cause;

  private Result() {
  }

  private Result(int code, boolean success, String msg) {
    this.code = code;
    this.success = success;
    this.msg = msg;
  }

  private Result(int code, boolean success, T data) {
    this.code = code;
    this.success = success;
    this.data = data;
  }

  private Result(int code, boolean success, Exception cause) {
    this.code = code;
    this.success = success;
    this.cause = cause;
  }

  public T orElseGet(Supplier<? extends T> supplier){
    return data !=null ? data :supplier.get();
  }

  public static <T> Result<T> createResult() {
    return new Result<>();
  }

  public static <T> Result<T> ofData(T data) {
    return new Result<>(0, true, data);
  }

  public static <T> Result<T> ofMsg(String msg) {
    return new Result<>(0, true, msg);
  }

  public static <T> Result<T> ofCause(Exception ex) {
    return new Result<>(0, false, ex);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Exception getCause() {
    return cause;
  }

  public void setCause(Exception cause) {
    this.cause = cause;
  }
}
