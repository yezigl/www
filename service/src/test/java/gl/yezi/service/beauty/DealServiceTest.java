/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.beauty;

import static org.junit.Assert.*;
import gl.yezi.data.model.beauty.Deal;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月5日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class DealServiceTest {
    
    @Resource
    DealService dealService;

    /**
     * Test method for {@link gl.yezi.service.beauty.DealService#getList(int, int)}.
     */
    @Test
    public void testGetList() {
        List<Deal> list = dealService.getList(0, 10);
        System.out.println(list.size());
    }

}
