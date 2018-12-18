package com.vbiso.concurent.worker_thread;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 7:35 PM 2018/12/17
 * @Modified By:
 */
public class Production extends InstructionBook {

  private final int prodID;

  public Production(int prodID) {
    this.prodID = prodID;
  }

  @Override
  protected void firstProcess() {
    System.out.println("execute the "+ prodID + " first process");
  }

  @Override
  protected void secondProcess() {
    System.out.println("execute the "+ prodID + " second process");
  }
}
