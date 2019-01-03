package com.vbiso.concurent.new_active_objects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 8:48 PM 2019/1/3
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ActiveMethod {

}
