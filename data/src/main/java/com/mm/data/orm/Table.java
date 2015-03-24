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
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    
    /**
     * 表名
     * @return
     */
    String value() default "";
}
