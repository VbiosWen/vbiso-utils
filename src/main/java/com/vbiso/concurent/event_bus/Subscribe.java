package com.vbiso.concurent.event_bus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:25 PM 2019/1/5
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

  String topic() default "default-topic";

}
