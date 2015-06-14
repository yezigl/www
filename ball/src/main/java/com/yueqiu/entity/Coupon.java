/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月13日
 */
@Entity("coupon")
public class Coupon extends BaseEntity {

    private String name;
    private String desc;
    private float price;
    private Date endtime;
    private Date usetime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }

}
