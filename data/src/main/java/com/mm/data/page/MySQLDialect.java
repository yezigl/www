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
public class MySQLDialect extends Dialect {

    @Override
    public String getLimitString(String originSql, int offset, int limit) {
        String sql = getLineSql(originSql);

        sql = sql + " limit " + offset + " ," + limit;

        return sql;
    }

    /**
     * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
     * 
     * @param sql SQL语句
     * @return 如果sql是NULL返回空，否则返回转化后的SQL
     */
    private static String getLineSql(String sql) {
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
    }
}
