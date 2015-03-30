/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.service.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.data.dao.beauty.ProductDao;
import com.mm.data.model.beauty.Product;
import com.mm.service.BaseService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月30日
 */
@Service
public class ProductService extends BaseService {

    @Resource
    ProductDao productDao;

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public Product get(int id) {
        return productDao.get(id);
    }

    public int create(Product product) {
        return productDao.create(product);
    }

    public int update(Product product) {
        Product old = get(product.getId());
        old.setApplicable(product.getApplicable());
        old.setBrand(product.getBrand());
        old.setEfficacy(product.getEfficacy());
        old.setImgUrl(product.getImgUrl());
        old.setName(product.getName());
        return productDao.update(product);
    }

}
