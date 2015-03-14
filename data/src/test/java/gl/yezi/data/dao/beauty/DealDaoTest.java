/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.dao.beauty;

import static org.junit.Assert.*;

import java.util.Date;

import gl.yezi.data.model.beauty.Deal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月4日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class DealDaoTest {
    
    @Resource
    DealDao dealDao;

    @Test
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testCreate() {
        Deal deal1 = new Deal();
        deal1.setTitle("青柠净白养润护理");
        deal1.setDescription("手工服务+美容师提供高级净白保湿产品");
        deal1.setPrice(100.00f);
        deal1.setValue(200);
        deal1.setStatus(1);
        deal1.setType(1);
        deal1.setImgUrl("http://meirongproject.b0.upaiyun.com/service/41c396e9f9c3563dab7fc7474eb5f279.jpg");
        deal1.setGallery("");
        deal1.setCtime(new Date());
        deal1.setUtime(new Date());
        deal1.setCosttime(100);
        deal1.setContent("主要针对肌肤晦暗、角质代谢缓慢、缺水等现象，独特的青柠精华能在即时提亮肤色的同时改善肤色不均匀的皮肤状况，刺激细胞再生、加强皮肤抵抗力。");
        deal1.setEfficacy("");
        deal1.setComponent("1,2,3");
        deal1.setFlow("");
        deal1.setSpecial("1.顾客月经和怀孕期间不建议做背部舒缓\n2.顾客请准备好美容师操作时的床和凳子\n3.请准备好温水，方便浸泡洁肤棉片\n4.护理当中有身体的护理，如需沐浴，请提前准备好");
        
        dealDao.create(deal1);
    }

}
