/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import gl.yezi.data.orm.OrmUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月20日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class OrmUtilsTest {
    
    @Resource
    DataSource dataSource;

    @Test
    public void test() {
        OrmUtils.createTable(dataSource, false);
    }

}
