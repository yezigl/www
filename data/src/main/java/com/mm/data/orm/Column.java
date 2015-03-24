/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.orm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月18日
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    /**
     * 列名
     * @return
     */
    String value() default "";
    
    /**
     * 是否主键
     * @return
     */
    boolean primary() default false;
    
    /**
     * 是否可为空
     * @return
     */
    boolean isNull() default false;
    
    /**
     * 列类型
     * @return
     */
    String type() default "VARCHAR";
    
    boolean autoIncrement() default false;
    
    String comment() default "";
    
}
