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

import com.yueqiu.entity.Entry;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Repository
public class EntryDao extends AppEntityDaoMorphiaImpl<Entry, ObjectId> {

    /**
     * @param datastore
     */
    @Autowired
    public EntryDao(Datastore datastore) {
        super(datastore);
    }

    public boolean create(Entry entry) {
        return saveEntity(entry) != null;
    }

    public List<Entry> getByGame(String gameId) {
        Query<Entry> query = createQuery();
        query.field("game").equal(new ObjectId(gameId));
        return query.asList();
    }

}
