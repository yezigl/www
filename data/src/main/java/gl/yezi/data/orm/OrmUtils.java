/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    private static final String NL = "\n\n";

    private static final String MB_IMPORT = "import org.apache.ibatis.annotations.Insert;\n"
            + "import org.apache.ibatis.annotations.Options;\n" + "import org.apache.ibatis.annotations.Result;\n"
            + "import org.apache.ibatis.annotations.Results;\n" + "import org.apache.ibatis.annotations.Select;\n"
            + "import org.apache.ibatis.annotations.Update;";

    private static final String INJECT_IMPORT = "import javax.annotation.Resource;\n\n"
            + "import org.springframework.stereotype.Repository;";

    public static void createTable(DataSource dataSource, Class<?>... tables) {
        createTable(dataSource, true, tables);
    }

    public static void createTable(DataSource dataSource, boolean execute, Class<?>... tables) {

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

    public static String createInsert(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = clazz.getSimpleName().toLowerCase();
        tableName = table == null ? tableName : StringUtils.defaultIfBlank(table.value(), tableName);

        Field[] fields = clazz.getDeclaredFields();
        Sql sql = Sql.create();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String fieldName = field.getName();
            String columnName = StringUtils.defaultIfBlank(column == null ? null : column.value(),
                    fieldName.toLowerCase());
            if (column.primary()) {
                sql.primary(columnName, fieldName);
            } else {
                sql.insert(columnName, fieldName);
            }
        }

        logger.debug(sql.generateInsert(tableName));
        return sql.generateInsert(tableName);
    }

    public static String createSelect(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = clazz.getSimpleName().toLowerCase();
        tableName = table == null ? tableName : StringUtils.defaultIfBlank(table.value(), tableName);

        Field[] fields = clazz.getDeclaredFields();
        Sql sql = Sql.create();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String fieldName = field.getName();
            String columnName = StringUtils.defaultIfBlank(column == null ? null : column.value(),
                    fieldName.toLowerCase());
            if (column.primary()) {
                sql.primary(columnName, fieldName);
            }
            sql.select(columnName, fieldName);
        }

        logger.debug(sql.generateSelect(tableName));
        return sql.generateSelect(tableName);
    }

    public static String createUpdate(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = clazz.getSimpleName().toLowerCase();
        tableName = table == null ? tableName : StringUtils.defaultIfBlank(table.value(), tableName);

        Field[] fields = clazz.getDeclaredFields();
        Sql sql = Sql.create();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String fieldName = field.getName();
            String columnName = StringUtils.defaultIfBlank(column == null ? null : column.value(),
                    fieldName.toLowerCase());
            if (column.primary()) {
                sql.primary(columnName, fieldName);
            } else {
                sql.update(columnName, fieldName);
            }
        }

        logger.debug(sql.generateUpdate(tableName));
        return sql.generateUpdate(tableName);
    }

    public static void createMapper(String path, Class<?>... classes) {
        String root = new File("").getAbsolutePath();
        for (Class<?> clazz : classes) {
            String filename = clazz.getSimpleName() + "Mapper.java";
            File packagePath = new File(root + "/src/main/java/" + path);
            if (!packagePath.exists()) {
                packagePath.mkdirs();
            }
            File file = new File(root + "/src/main/java/" + path, filename);
            String packageName = path.replace('/', '.');
            String clsSimple = clazz.getSimpleName();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("package " + packageName + ";");
                bw.write(NL);
                bw.write("import " + clazz.getName() + ";");
                bw.write(NL);
                bw.write(MB_IMPORT);
                bw.write(NL);
                bw.write("public interface " + clsSimple + "Mapper {");
                bw.write(NL);
                bw.write("    " + createInsert(clazz) + "\n");
                bw.write("    int create(" + clsSimple + " " + clsSimple.toLowerCase() + ");");
                bw.write(NL);
                bw.write("    " + createSelect(clazz) + "\n");
                bw.write("    " + clsSimple + " get(int id);");
                bw.write(NL);
                bw.write("    " + createUpdate(clazz) + "\n");
                bw.write("    int update(" + clsSimple + " " + clsSimple.toLowerCase() + ");\n");
                bw.write("}");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createDao(String path, Class<?>... classes) {
        String root = new File("").getAbsolutePath();
        for (Class<?> clazz : classes) {
            String filename = clazz.getSimpleName() + "Dao.java";
            File packagePath = new File(root + "/src/main/java/" + path);
            if (!packagePath.exists()) {
                packagePath.mkdirs();
            }
            File file = new File(root + "/src/main/java/" + path, filename);
            String packageName = path.replace('/', '.');
            String mapperPackageName = packageName.replace("dao", "mapper");
            String clsSimple = clazz.getSimpleName();
            String mapper = clsSimple.toLowerCase() + "Mapper";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("package " + packageName + ";");
                bw.write(NL);
                bw.write("import " + mapperPackageName + "." + clsSimple + "Mapper;\n");
                bw.write("import " + clazz.getName() + ";");
                bw.write(NL);
                bw.write(INJECT_IMPORT);
                bw.write(NL);
                bw.write("@Repository\n");
                bw.write("public class " + clsSimple + "Dao {");
                bw.write(NL);
                bw.write("    @Resource\n");
                bw.write("    " + clazz.getSimpleName() + "Mapper " + mapper + ";");
                bw.write(NL);
                bw.write("    public int create(" + clsSimple + " " + clsSimple.toLowerCase() + ") {\n");
                bw.write("        return " + mapper + ".create(" + clsSimple.toLowerCase() + ");\n");
                bw.write("    }");
                bw.write(NL);
                bw.write("    public " + clsSimple + " get(int id) {\n");
                bw.write("        return " + mapper + ".get(id);\n");
                bw.write("    }");
                bw.write(NL);
                bw.write("    public void update(" + clsSimple + " " + clsSimple.toLowerCase() + ") {\n");
                bw.write("        " + mapper + ".update(" + clsSimple.toLowerCase() + ");\n");
                bw.write("    }\n");
                bw.write("}");
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
