/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.time;

import java.util.Date;

import com.mm.data.orm.Column;
import com.mm.data.orm.Index;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class UserBuy {

    /**
     * 购买者购买，未完成
     */
    public static final int STATUS_BUY = 0;

    /**
     * 双方完成交易
     */
    public static final int STATUS_DONE = 1;

    /**
     * 购买者在有效时间内取消购买
     */
    public static final int STATUS_CANCEL = 2;

    /**
     * 购买者在有效时间内未完成交易，同时未取消购买
     */
    public static final int STATUS_BREAK = 3;
    
    /**
     * 完成，等待出售者确认
     */
    public static final int STATUS_TBD = 4;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_sellid")
    @Column(type = "INTEGER")
    private int sellid;
    @Index(value = "idx_uid")
    @Column(type = "INTEGER")
    private int uid;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "DATETIME")
    private Date utime;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(20)")
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
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

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public int getSellid() {
        return sellid;
    }

    public void setSellid(int sellid) {
        this.sellid = sellid;
    }

}
