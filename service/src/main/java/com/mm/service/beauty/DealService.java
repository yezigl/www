/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.service.beauty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.mm.data.dao.beauty.DealDao;
import com.mm.data.dao.beauty.FlowDao;
import com.mm.data.dao.beauty.ProductDao;
import com.mm.data.model.beauty.Deal;
import com.mm.data.model.beauty.Flow;
import com.mm.data.model.beauty.Product;
import com.mm.service.BaseService;

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

    public int create(Deal deal) {
        deal.setCtime(new Date());
        deal.setUtime(new Date());
        return dealDao.create(deal);
    }

    public int update(Deal deal) {
        Deal old = get(deal.getId());
        old.setComponent(deal.getComponent());
        old.setContent(deal.getContent());
        old.setCosttime(deal.getCosttime());
        old.setDescription(deal.getDescription());
        old.setEfficacy(deal.getEfficacy());
        old.setFlow(deal.getFlow());
        old.setGallery(deal.getGallery());
        old.setImgUrl(deal.getImgUrl());
        old.setPrice(deal.getPrice());
        old.setSpecial(deal.getSpecial());
        old.setTitle(deal.getTitle());
        old.setType(deal.getType());
        old.setUtime(new Date());
        old.setValue(deal.getValue());
        
        return dealDao.update(old);
    }
}
