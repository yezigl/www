/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import gl.yezi.data.model.User;
import gl.yezi.data.model.home.Deal;
import gl.yezi.data.model.home.Employee;
import gl.yezi.data.model.home.Feedback;
import gl.yezi.data.model.home.Order;
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
    
    @Resource(name = "homeDataSource")
    DataSource dataSource;

    @Test
    public void test() {
        OrmUtils.createTable(dataSource, true);
    }
    
    @Test
    public void testCreateInsert() {
        OrmUtils.createInsert(User.class);
        OrmUtils.createSelect(User.class);
        OrmUtils.createUpdate(User.class);
    }

    @Test
    public void testCreateMapper() {
        OrmUtils.createMapper("gl/yezi/data/mapper/home", Deal.class, Employee.class, Feedback.class, Order.class);
    }
    
    @Test
    public void testCreateDao() {
        OrmUtils.createDao("gl/yezi/data/dao/home", Deal.class, Employee.class, Feedback.class, Order.class);
    }
}
