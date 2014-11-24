/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import gl.yezi.data.model.time.College;
import gl.yezi.data.model.time.School;
import gl.yezi.data.model.time.Timetable;
import gl.yezi.data.model.time.User;
import gl.yezi.data.model.time.UserBuy;
import gl.yezi.data.model.time.UserSell;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月18日
 */
public class OrmUtils {

    private static Logger logger = LoggerFactory.getLogger(OrmUtils.class);

    private static final String ENGINE = " ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static void createTable(DataSource dataSource) {
        createTable(dataSource, true);
    }

    public static void createTable(DataSource dataSource, boolean execute) {

        Class<?>[] tables = new Class[] { College.class, School.class, Timetable.class, User.class, UserBuy.class,
                UserSell.class };

        try {
            if (execute) {
                Connection conn = dataSource.getConnection();
                Statement st = conn.createStatement();
                for (Class<?> clazz : tables) {
                    String sql = createSql(clazz);
                    try {
                        st.execute(sql);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
            } else {
                StringBuilder builder = new StringBuilder("\n");

                for (Class<?> clazz : tables) {
                    String sql = createSql(clazz);
                    builder.append(sql).append("\n\n");
                }
                logger.info(builder.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static String createSql(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = clazz.getSimpleName().toLowerCase();
        tableName = table == null ? tableName : StringUtils.defaultIfBlank(table.value(), tableName);

        StringBuilder builder = new StringBuilder();
        Map<String, List<String>> indexMap = new HashMap<String, List<String>>();

        builder.append("CREATE TABLE `" + tableName + "` (\n");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            String columnName = StringUtils.defaultIfBlank(column.value(), field.getName().toLowerCase());
            boolean primary = column.primary();
            String columnType = column.type();
            boolean isNull = column.isNull();
            boolean autoIncrement = column.autoIncrement();
            String comment = column.comment();

            builder.append(createColumn(columnName, columnType, primary, isNull, autoIncrement, comment)).append(",\n");

            Index index = field.getAnnotation(Index.class);
            if (index != null) {
                String indexName = index.value();
                if (StringUtils.isNotBlank(indexName)) {
                    List<String> value = indexMap.get(indexName);
                    if (value == null) {
                        value = new ArrayList<String>();
                        value.add(index.order(), columnName);
                        indexMap.put(indexName, value);
                    } else {
                        value.add(index.order(), columnName);
                    }
                }
            }
        }
        if (indexMap.isEmpty()) {
            builder.deleteCharAt(builder.length() - 2);
        } else {
            for (Map.Entry<String, List<String>> entry : indexMap.entrySet()) {
                String indexName = entry.getKey();
                List<String> columnList = entry.getValue();
                builder.append(createIndex(indexName, columnList));
            }
            builder.deleteCharAt(builder.length() - 2);
        }

        builder.append(")").append(ENGINE);
        logger.debug(builder.toString());

        return builder.toString();
    }

    private static String createColumn(String name, String type, boolean primary, boolean isNull,
            boolean autoIncrement, String comment) {
        StringBuilder builder = new StringBuilder();
        builder.append("  `").append(name).append("` ");
        builder.append(type);
        if (primary) {
            builder.append(" ").append("PRIMARY KEY");
        }
        if (!primary && !isNull) {
            builder.append(" ").append("NOT NULL");
        } else if (isNull) {
            builder.append(" ").append("NULL ").append("DEFAULT " + (type.equals("INTEGER") ? "0" : "''"));
        }
        if (autoIncrement) {
            builder.append(" ").append("AUTO_INCREMENT");
        }
        if (StringUtils.isNotBlank(comment)) {
            builder.append(" ").append("COMMENT ").append(comment);
        }
        return builder.toString();
    }

    private static String createIndex(String name, List<String> columnList) {
        StringBuilder builder = new StringBuilder();
        builder.append("  KEY `").append(name).append("` (`").append(StringUtils.join(columnList, ',')).append("`),\n");
        return builder.toString();
    }
}
