package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.ProductMapper;
import gl.yezi.data.model.beauty.Product;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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

    public void update(Product product) {
        productMapper.update(product);
    }

    public List<Product> getList(int... ids) {
        return productMapper.getList(ids);
    }
}