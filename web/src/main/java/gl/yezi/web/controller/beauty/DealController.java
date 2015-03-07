/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import gl.yezi.data.model.beauty.Deal;
import gl.yezi.data.model.beauty.Product;
import gl.yezi.service.beauty.DealService;
import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.Status;
import gl.yezi.web.res.beauty.DealListRes;
import gl.yezi.web.res.beauty.DealRes;
import gl.yezi.web.res.beauty.ProductRes;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        
        return res;
    }
}
