/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.res.beauty;

import java.util.ArrayList;
import java.util.List;

import com.mm.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
public class DealListRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<DealRes> deals;

    private Integer offset;

    public DealListRes() {
        deals = new ArrayList<DealRes>();
    }

    public void addDealRes(DealRes deal) {
        deals.add(deal);
    }

    public List<DealRes> getDeals() {
        return deals;
    }

    public void setDeals(List<DealRes> deals) {
        this.deals = deals;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
