/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.dao.beauty;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mm.data.dao.beauty.ProductDao;
import com.mm.data.model.beauty.Product;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月5日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class ProductDaoTest {
    
    @Resource
    ProductDao productDao;

    /**
     * Test method for {@link com.mm.data.dao.beauty.ProductDao#create(com.mm.data.model.beauty.Product)}.
     */
    @Test
    public void testCreate() {
        Product product1 = new Product();
        product1.setName("产品1");
        product1.setEfficacy("功效1");
        product1.setApplicable("适用人群1");
        productDao.create(product1);
        
        Product product2 = new Product();
        product2.setName("产品2");
        product2.setEfficacy("功效2");
        product2.setApplicable("适用人群2");
        productDao.create(product2);
        
        Product product3 = new Product();
        product3.setName("产品3");
        product3.setEfficacy("功效3");
        product3.setApplicable("适用人群3");
        productDao.create(product3);
    }

}
