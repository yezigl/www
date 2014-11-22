/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import gl.yezi.data.utils.DataUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月26日
 */
@MappedTypes(int[].class)
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class IntArrayTypeHandler extends BaseTypeHandler<int[]> {
    
    private char separator = '/';

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, int[] parameter, JdbcType jdbcType)
            throws SQLException {
        String s = StringUtils.join(parameter, separator);
        ps.setString(i, s);
    }

    @Override
    public int[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String[] ss = StringUtils.split(rs.getString(columnName), separator);
        return DataUtils.toIntArray(ss);
    }

    @Override
    public int[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String[] ss = StringUtils.split(rs.getString(columnIndex), separator);
        return DataUtils.toIntArray(ss);
    }

    @Override
    public int[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String[] ss = StringUtils.split(cs.getString(columnIndex), separator);
        return DataUtils.toIntArray(ss);
    }


}
