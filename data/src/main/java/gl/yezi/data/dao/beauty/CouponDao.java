package gl.yezi.data.dao.beauty;

import gl.yezi.data.mapper.beauty.CouponMapper;
import gl.yezi.data.model.beauty.Coupon;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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