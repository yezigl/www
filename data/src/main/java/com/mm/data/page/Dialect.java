/**
 * Copyright 2012 Sohu.com Inc. All Rights Reserved.
 */
package com.mm.data.page;

/**
 * description here
 *
 * @author lukeli
 * @version 1.0 2012-12-3
 */
public abstract class Dialect {

    public static enum Type {
        MYSQL, ORACLE
    }
    
    public abstract String getLimitString(String sql, int skip, int limit);
}
