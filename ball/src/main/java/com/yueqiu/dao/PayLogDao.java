/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.yueqiu.entity.Order;
import com.yueqiu.entity.PayLog;

/**
 * description here
 *
 * @author lidehua
 * @since 2015年6月17日
 */
public class PayLogDao extends AppEntityDaoMorphiaImpl<PayLog, ObjectId> {

    /**
     * @param datastore
     */
    @Autowired
    public PayLogDao(Datastore datastore) {
        super(datastore);
    }

    public PayLog get(String id) {
        return getEntityById(new ObjectId(id));
    }

    public List<PayLog> listPayLogs(Order order) {
        Query<PayLog> query = createQuery();
        query.field("order").equal(order);
        return query.asList();
    }

}
