/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.controller.beauty;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.data.model.beauty.Deal;
import com.mm.data.model.beauty.Flow;
import com.mm.data.model.beauty.Product;
import com.mm.service.beauty.DealService;
import com.mm.service.beauty.ProductService;
import com.mm.web.controller.AbstractController;
import com.mm.web.res.Status;
import com.mm.web.res.beauty.DealListRes;
import com.mm.web.res.beauty.DealRes;
import com.mm.web.res.beauty.FlowRes;
import com.mm.web.res.beauty.ProductRes;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
@RestController
@RequestMapping(value = "/1/beauty")
public class DealController extends AbstractController {

    @Resource
    DealService dealService;
    
    @Resource
    ProductService productService;

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public DealListRes dealList(@RequestParam(defaultValue = "0") int offset) {
        DealListRes res = new DealListRes();

        List<Deal> deals = dealService.getList(offset, LIMIT);
        for (Deal deal : deals) {
            DealRes dealRes = new DealRes(deal);
            List<Product> products = dealService.getProducts(deal);
            for (Product product : products) {
                dealRes.addProductRes(new ProductRes(product));
            }
            List<Flow> flows = dealService.getFlows(deal);
            for (Flow flow : flows) {
                dealRes.addFlows(new FlowRes(flow));
            }
            res.addDealRes(dealRes);
        }
        res.setOffset(deals.size());

        return res;
    }
    
    @RequestMapping(value = "/deal/{dealId}", method = RequestMethod.GET)
    public DealRes deal(@PathVariable int dealId) {
        DealRes res = new DealRes();
        
        Deal deal = dealService.get(dealId);
        if (deal == null) {
            res.setStatus(Status.NOT_EXIST, "项目不存在");
            return res;
        }
        res.setDeal(deal);
        List<Product> products = dealService.getProducts(deal);
        for (Product product : products) {
            res.addProductRes(new ProductRes(product));
        }
        List<Flow> flows = dealService.getFlows(deal);
        for (Flow flow : flows) {
            res.addFlows(new FlowRes(flow));
        }
        
        return res;
    }
    
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ProductRes product(@PathVariable int productId) {
        ProductRes res = new ProductRes();
        
        Product product = productService.get(productId);
        if (product == null) {
            res.setStatus(Status.NOT_EXIST, "产品不存在");
            return res;
        }
        res.setProduct(product);
        
        return res;
    }
}
