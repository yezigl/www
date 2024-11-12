/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.dao.time;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mm.data.dao.time.TimetableDao;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@SpringBootTest
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
    }
}
