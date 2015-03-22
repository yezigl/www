/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Sql {

    List<String> sqlList;
    List<String> columnList;
    List<String> valueList;
    List<String> cvList;
    String primary;

    Sql() {
        sqlList = new ArrayList<String>();
        columnList = new ArrayList<String>();
        valueList = new ArrayList<String>();
        cvList = new ArrayList<String>();
    }

    static Sql create() {
        return new Sql();
    }

    Sql push(String s) {
        sqlList.add(s);
        return this;
    }

    public String generate() {
        String s = StringUtils.join(sqlList, ' ');
        return s;
    }

    public Sql insert(String column, String value) {
        columnList.add(column);
        valueList.add("#{" + value + "}");
        return this;
    }

    public Sql select(String column, String value) {
        cvList.add("        @Result(column = \"" + column + "\", property = \"" + value + "\")");
        return this;
    }

    public Sql update(String column, String value) {
        cvList.add(column + " = #{" + value + "}");
        return this;
    }

    public String generateInsert(String table) {
        StringBuilder builder = new StringBuilder();
        builder.append("@Insert(\"INSERT INTO `");
        builder.append(table).append("` (");
        builder.append(StringUtils.join(columnList, ", "));
        builder.append(") VALUES (");
        builder.append(StringUtils.join(valueList, ", "));
        builder.append(")\")\n");
        builder.append("    "
                + (primary != null ? primary
                        : "@Options(useGeneratedKeys = true, keyProperty = \"id\", keyColumn = \"id\")"));
        return builder.toString();
    }

    public String generateSelect(String table) {
        StringBuilder builder = new StringBuilder();
        builder.append("@Select(\"SELECT * FROM `" + table + "` WHERE id = #{id}\")\n");
        builder.append("    @Results({\n");
        builder.append(StringUtils.join(cvList, ",\n") + "\n");
        builder.append("    })");
        return builder.toString();
    }

    public String generateUpdate(String table) {
        StringBuilder builder = new StringBuilder();
        builder.append("@Update(\"UPDATE `" + table + "` SET ");
        builder.append(StringUtils.join(cvList, ", "));
        builder.append(" WHERE id = #{id}\")");
        return builder.toString();
    }

    /**
     * @param columnName
     * @param fieldName
     */
    public void primary(String columnName, String fieldName) {
        primary = "@Options(useGeneratedKeys = true, keyProperty = \"" + columnName + "\", keyColumn = \"" + fieldName
                + "\")";
    }
}
