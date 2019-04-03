package com.vbiso.concurent.mq;

import java.util.List;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 5:22 PM 2019/4/3
 * @Modified By:
 */
public class MqControl {

  private final List<Consumer> consumers;

  private final List<Producer> producers;

  public MqControl(List<Consumer> consumers,
      List<Producer> producers) {
    this.consumers = consumers;
    this.producers = producers;
  }


  public void take(){

  }
}
