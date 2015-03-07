/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.beauty;

import gl.yezi.data.dao.beauty.DealDao;
import gl.yezi.data.dao.beauty.ProductDao;
import gl.yezi.data.model.beauty.Product;
import gl.yezi.data.model.beauty.Deal;

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
public class DealService {
    
    @Resource
    DealDao dealDao;
    
    @Resource
    ProductDao productDao;

    public List<Deal> getList(int offset, int limit) {
        return dealDao.getList(offset, limit);
    }
    
    public List<Product> getProducts(Deal deal) {
        if (StringUtils.isNotBlank(deal.getComponent())) {
            String[] products = StringUtils.split(deal.getComponent(), ",");
            int[] ids = new int[products.length];
            for (int i = 0; i < products.length; i++) {
                ids[i] = NumberUtils.toInt(products[i]);
            }
            return productDao.getList(ids);
        }
        return null;
    }

    /**
     * @param dealId
     * @return
     */
    public Deal get(int dealId) {
        if (dealId == 0) {
            return null;
        }
        return dealDao.get(dealId);
    }
}
