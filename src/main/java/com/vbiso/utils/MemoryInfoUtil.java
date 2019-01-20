package com.vbiso.utils;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:20 AM 2019/1/7
 * @Modified By:
 */
public class MemoryInfoUtil {

  private static class Holder{
    private static final OperatingSystemMXBean INSTANCE= (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
  }
  private static OperatingSystemMXBean getInstance(){
    return Holder.INSTANCE;
  }

  public static MemoryInfo getMemoryInfo(){
    OperatingSystemMXBean instance = getInstance();
    long totalPhysicalMemorySize = instance.getTotalPhysicalMemorySize();
    long freePhysicalMemorySize = instance.getFreePhysicalMemorySize();
    MemoryInfo memoryInfo=new MemoryInfo();
    memoryInfo.setTotalMem((int) (totalPhysicalMemorySize/(Math.pow(1024,2))));
    memoryInfo.setAvailableMem((int) (freePhysicalMemorySize/(Math.pow(1024,2))));
    return memoryInfo;
  }

  public static void main(String[] args){
    System.out.println(getMemoryInfo());
  }

}
