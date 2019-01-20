package com.vbiso.utils;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:26 AM 2019/1/7
 * @Modified By:
 */
public class MemoryInfo {

  private int totalMem;

  private int availableMem;

  public int getTotalMem() {
    return totalMem;
  }

  public void setTotalMem(int totalMem) {
    this.totalMem = totalMem;
  }

  public int getAvailableMem() {
    return availableMem;
  }

  public void setAvailableMem(int availableMem) {
    this.availableMem = availableMem;
  }

  @Override
  public String toString() {
    return "MemoryInfo{" +
        "totalMem=" + totalMem +
        ", availableMem=" + availableMem +
        '}';
  }
}
