package com.vbiso.concurent.worker_thread;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:34 PM 2018/12/17
 * @Modified By:
 */
public abstract class InstructionBook {

  public final void create(){
    this.firstProcess();
    this.secondProcess();
  }

  protected abstract void firstProcess();

  protected abstract void secondProcess();

}
