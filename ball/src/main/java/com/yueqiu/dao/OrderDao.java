/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yueqiu.entity.Order;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Repository
public class OrderDao extends AppEntityDaoMorphiaImpl<Order, ObjectId> {

    /**
     * @param datastore
     */
    @Autowired
    public OrderDao(Datastore datastore) {
        super(datastore);
    }
    
    public Order get(String id) {
        return getEntityById(new ObjectId(id));
    }
    
    public boolean create(Order order) {
        return saveEntity(order) != null;
    }
    
    public boolean update(Order order) {
        return updateEntity(order) == 1;
    }

    public List<Order> listByUser(String userId) {
        Query<Order> query = createQuery();
        query.field("user").equal(new ObjectId(userId));
        return query.asList();
    }
}
