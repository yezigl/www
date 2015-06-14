/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yueqiu.entity.User;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Repository
public class UserDao extends AppEntityDaoMorphiaImpl<User, ObjectId> {

    /**
     * @param datastore
     */
    @Autowired
    public UserDao(Datastore datastore) {
        super(datastore);
    }
    
    public User get(String id) {
        return getEntityById(new ObjectId(id));
    }
    
    public boolean create(User user) {
        return saveEntity(user) != null;
    }
    
    public boolean update(User user) {
        return updateEntity(user) == 1;
    }

    public User getByField(String field, String mobile) {
        Query<User> query = createQuery();
        query.field(field).equal(mobile);
        return query.get();
    }
    
}
