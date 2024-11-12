/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.dao.beauty;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mm.data.model.beauty.Flow;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
@SpringBootTest
@ContextConfiguration("/applicationContext-test.xml")
public class FlowDaoTest {
    
    @Resource
    FlowDao flowDao;

    /**
     * Test method for {@link com.mm.data.dao.beauty.FlowDao#create(com.mm.data.model.beauty.Flow)}.
     */
    @Test
    public void testCreate() {
        Flow flow1 = new Flow();
        flow1.setDealId(1);
        flow1.setStep(1);
        flow1.setName("步骤1");
        flow1.setDescription("步骤1描述");
        flow1.setImgUrl("http://meirongproject.b0.upaiyun.com/service/2a4f238dda9aeebcd33757b3625aa0db.png");
        flow1.setTime(10);
        flowDao.create(flow1);
        
        Flow flow2 = new Flow();
        flow2.setDealId(1);
        flow2.setStep(2);
        flow2.setName("步骤2");
        flow2.setDescription("步骤2描述");
        flow2.setImgUrl("http://meirongproject.b0.upaiyun.com/service/4975da402196255c3a0592de9dc77e79.png");
        flow2.setTime(20);
        flowDao.create(flow2);
        
        flow1.setDealId(2);
        flow2.setDealId(2);
        flowDao.create(flow1);
        flowDao.create(flow2);
    }

}
