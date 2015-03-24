package com.mm.data.dao.beauty;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.CouponMapper;
import com.mm.data.model.beauty.Coupon;

@Repository
public class CouponDao {

    @Resource
    CouponMapper couponMapper;

    public int create(Coupon coupon) {
        return couponMapper.create(coupon);
    }

    public Coupon get(int id) {
        return couponMapper.get(id);
    }

    public void update(Coupon coupon) {
        couponMapper.update(coupon);
    }
}