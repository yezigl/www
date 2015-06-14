/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;


import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yueqiu.entity.Coupon;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Repository
public class CouponDao extends AppEntityDaoMorphiaImpl<Coupon, ObjectId> {

    @Autowired
    public CouponDao(Datastore datastore) {
        super(datastore);
    }
    
    public Coupon get(String id) {
        return getEntityById(new ObjectId(id));
    }
    
    public boolean update(Coupon coupon) {
        return updateEntity(coupon) == 1;
    }
    
    public boolean create(Coupon coupon) {
        return saveEntity(coupon) != null;
    }

}
