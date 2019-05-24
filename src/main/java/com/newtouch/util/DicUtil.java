package com.newtouch.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/4/28
 * Time:10:42
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DicUtil {
    String tableName();//条件表名

    String dataType() default "";//条件数据类型名

    String dataTypeValue() default "";//条件数据类型值

    String needColumn();//需要的查询的字段

    String param();//加了属性名对应的指段名 数据库
}
