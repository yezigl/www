/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yueqiu.entity.Stadium;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Repository
public class StadiumDao extends AppEntityDaoMorphiaImpl<Stadium, ObjectId> {

    /**
     * @param datastore
     */
    @Autowired
    public StadiumDao(Datastore datastore) {
        super(datastore);
    }
    
    public Stadium get(String id) {
        return getEntityById(new ObjectId(id));
    }
    
    public String create(Stadium stadium) {
        ObjectId id = saveEntity(stadium);
        return id == null ? null : id.toString();
    }
    
    public boolean update(Stadium stadium) {
        return updateEntity(stadium) == 1;
    }

}
