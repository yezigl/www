/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月13日
 */
@Entity("order")
public class Order extends BaseEntity {

    @Reference
    private Game game;
    @Reference
    private User user;
    private float amount;
    private float discount;
    @Reference
    private Coupon coupon;
    private int status;
    private Date paytime;
    private Date paytype;
    private String paysn;
    private String ip;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getPaytype() {
        return paytype;
    }

    public void setPaytype(Date paytype) {
        this.paytype = paytype;
    }

    public String getPaysn() {
        return paysn;
    }

    public void setPaysn(String paysn) {
        this.paysn = paysn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
