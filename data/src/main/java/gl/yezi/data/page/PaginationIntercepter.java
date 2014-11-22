/**
 * Copyright 2012 Sohu.com Inc. All Rights Reserved.
 */
package gl.yezi.data.page;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description here
 *
 * @author lukeli
 * @version 1.0 2012-12-3
 */
@Intercepts(value = { @Signature(args = { Connection.class }, method = "prepare", type = StatementHandler.class) })
public class PaginationIntercepter implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(PaginationIntercepter.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(),
                new DefaultObjectWrapperFactory());

        RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
        if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
            return invocation.proceed();
        }

        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
        Dialect.Type databaseType = null;
        try {
            databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
        } catch (Exception e) {
            // ignore
        }
        if (databaseType == null) {
            throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : "
                    + configuration.getVariables().getProperty("dialect"));
        }

        Dialect dialect = null;
        switch (databaseType) {
        case MYSQL:
            dialect = new MySQLDialect();
            break;
        default:
            logger.warn("not yet support {}", databaseType);
        }

        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        String boundSql = dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit());
        metaStatementHandler.setValue("delegate.boundSql.sql", boundSql);
        metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
        metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
