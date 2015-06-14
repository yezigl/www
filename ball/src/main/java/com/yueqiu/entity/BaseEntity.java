package com.yueqiu.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Author: Neil
 * Date: Apr 17, 2012
 */
public abstract class BaseEntity {

    @Id
    private ObjectId id;
    
    @Property("ctime")
    private Date createTime;
    
    @Property("utime")
    private Date updateTime;

    @JSONField(serialize = false)
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @JSONField(serialize = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JSONField(serialize = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String stringifyId() {
        return id.toString();
    }
}
