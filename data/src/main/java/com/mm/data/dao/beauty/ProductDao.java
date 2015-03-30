package com.mm.data.dao.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.ProductMapper;
import com.mm.data.model.beauty.Product;

@Repository
public class ProductDao {

    @Resource
    ProductMapper productMapper;

    public int create(Product product) {
        return productMapper.create(product);
    }

    public Product get(int id) {
        return productMapper.get(id);
    }

    public int update(Product product) {
        return productMapper.update(product);
    }

    public List<Product> getList(int... ids) {
        return productMapper.getList(ids);
    }

    public List<Product> getAll() {
        return productMapper.getAll();
    }
}