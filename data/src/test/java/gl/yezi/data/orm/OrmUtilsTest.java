/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.orm;

import gl.yezi.data.model.User;
import gl.yezi.data.model.beauty.Deal;
import gl.yezi.data.model.beauty.Employee;
import gl.yezi.data.model.beauty.EmployeeDeal;
import gl.yezi.data.model.beauty.EmployeeTime;
import gl.yezi.data.model.beauty.Feedback;
import gl.yezi.data.model.beauty.Order;
import gl.yezi.data.model.time.College;
import gl.yezi.data.model.time.School;
import gl.yezi.data.model.time.Timetable;
import gl.yezi.data.model.time.UserBuy;
import gl.yezi.data.model.time.UserSell;

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

    @Resource(name = "userDataSource")
    DataSource userDataSource;
    @Resource(name = "beautyDataSource")
    DataSource beautyDataSource;
    @Resource(name = "timeDataSource")
    DataSource timeDataSource;

    Class<?>[] userClasses = { User.class };
    Class<?>[] beautyClasses = { Deal.class, Employee.class, Feedback.class, Order.class, EmployeeDeal.class,
            EmployeeTime.class };
    Class<?>[] timeClasses = { College.class, School.class, Timetable.class, User.class, UserBuy.class, UserSell.class };

    @Test
    public void test() {
        OrmUtils.createTable(userDataSource, true, userClasses);
        OrmUtils.createTable(beautyDataSource, true, beautyClasses);
        OrmUtils.createTable(timeDataSource, true, timeClasses);
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
