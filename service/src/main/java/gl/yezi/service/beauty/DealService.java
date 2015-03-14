/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.beauty;

import gl.yezi.data.dao.beauty.DealDao;
import gl.yezi.data.dao.beauty.FlowDao;
import gl.yezi.data.dao.beauty.ProductDao;
import gl.yezi.data.model.beauty.Deal;
import gl.yezi.data.model.beauty.Flow;
import gl.yezi.data.model.beauty.Product;
import gl.yezi.service.BaseService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@Service
public class DealService extends BaseService {
    
    @Resource
    DealDao dealDao;
    
    @Resource
    ProductDao productDao;
    
    @Resource
    FlowDao flowDao;

    public List<Deal> getList(int offset, int limit) {
        return dealDao.getList(offset, limit);
    }
    
    public List<Product> getProducts(Deal deal) {
        if (StringUtils.isNotBlank(deal.getComponent())) {
            String[] products = StringUtils.split(deal.getComponent(), SPLIT);
            int[] ids = new int[products.length];
            for (int i = 0; i < products.length; i++) {
                ids[i] = NumberUtils.toInt(products[i]);
            }
            return productDao.getList(ids);
        }
        return new ArrayList<Product>();
    }

    public Deal get(int dealId) {
        if (dealId == 0) {
            return null;
        }
        return dealDao.get(dealId);
    }
    
    public List<Flow> getFlows(Deal deal) {
        if (StringUtils.isNotBlank(deal.getFlow())) {
            String[] flows = StringUtils.split(deal.getFlow(), SPLIT);
            int[] ids = new int[flows.length];
            for (int i = 0; i < flows.length; i++) {
                ids[i] = NumberUtils.toInt(flows[i]);
            }
            return flowDao.getList(ids);
        }
        return new ArrayList<Flow>();
    }
    
    public Product getProduct(int productId) {
        if (productId <= 0) {
            return null;
        }
        return productDao.get(productId);
    }
}
