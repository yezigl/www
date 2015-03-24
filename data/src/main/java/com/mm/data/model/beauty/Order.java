/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.beauty;

import java.util.Date;

import com.mm.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Order {

    public static final int STATUS_TOPAY = 1;

    public static final int STATUS_PAYED = 2;

    public static final int STATUS_DONE = 4;
    
    public static final int STATUS_REFOUND = 8;
    
    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int userId;
    @Column(type = "INTEGER")
    private int dealId;
    @Column(type = "INTEGER")
    private int beauticianId;
    @Column(type = "DATETIME")
    private Date ctime; // 下单时间
    @Column(type = "DATETIME")
    private Date utime;
    @Column(type = "DATETIME")
    private Date paytime;
    @Column(type = "INTEGER")
    private int paytype;
    @Column(type = "FLOAT")
    private float amount;
    @Column(type = "FLOAT")
    private float discount;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(15)")
    private String ip;
    @Column(type = "INTEGER")
    private int addressId;
    @Column(type = "INTEGER")
    private int couponId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(int beauticianId) {
        this.beauticianId = beauticianId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    /**
     * @return
     */
    public String getStatusStr() {
        String str = "";
        switch (status) {
        case STATUS_TOPAY:
            str = "待支付";
            break;
        case STATUS_PAYED:
            str = "已支付";
            break;
        case STATUS_REFOUND:
            str = "退款中";
            break;
        case STATUS_DONE:
            str = "已完成";
            break;
        default:
            break;
        }
        return str;
    }

    /**
     * @return
     */
    public boolean isPay() {
        return status != STATUS_TOPAY;
    }

}
