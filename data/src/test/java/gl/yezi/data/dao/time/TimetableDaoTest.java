/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.time;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class TimetableDaoTest {

    @Resource
    TimetableDao timetableDao;
    
    @Test
    public void test() {
        fail("Not yet implemented");
    }

    @Test
    public void testTimetableGetByList() {
        int schid = 0;
        int collid = 0;
        String date = "20120101";
        timetableDao.getTimetable(schid, collid, date);
    }
}
