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
 * @since 2014年8月20日
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Index {

    /**
     * 索引名
     * @return
     */
    String value() default  "";
    
    /**
     * 列在索引的位置
     * @return
     */
    int order() default 0;
}
