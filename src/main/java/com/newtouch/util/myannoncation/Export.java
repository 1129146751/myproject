package com.newtouch.util.myannoncation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/6/6
 * Time:12:27
 **/
@Target({ ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Export {
}
