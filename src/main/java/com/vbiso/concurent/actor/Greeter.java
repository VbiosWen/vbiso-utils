package com.vbiso.concurent.actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 3:20 PM 2019/3/2
 * @Modified By:
 */
public class Greeter extends AbstractActor {

  private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(String.class,s -> log.info("Received String message:{}",s))
        .matchAny(o -> log.info("receive unknown message")).build();
  }

  public static void main(String[] args){
    Props props1 = Props.create(Greeter.class);

  }
}
