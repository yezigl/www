/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.time;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class UserSell {
    
    /**
     * 等待购买
     */
    public static final int STATUS_SELL = 0;
    
    /**
     * 被购买，未完成
     */
    public static final int STATUS_BUY = 1;
    
    /**
     * 购买者、出售者完成交易
     */
    public static final int STATUS_DONE = 2;
    
    /**
     * 指定时间内无人购买，过期
     */
    public static final int STATUS_EXPIRED = 3;

    /**
     * 出售者取消出售
     */
    public static final int STATUS_CANCEL = 4;
    
    /**
     * 购买者取消购买，重新出售
     */
    public static final int STATUS_RESELL = 5;
    
    /**
     * 购买者完成，等待出售者确认
     */
    public static final int STATUS_TBD = 6;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_uid")
    @Column(type = "INTEGER")
    private int uid;
    @Column(type = "INTEGER")
    private int ttid;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "DATETIME")
    private Date utime;
    @Column(type = "VARCHAR(20)")
    private String ip;
    @Column(type = "DOUBLE")
    private double price;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(100)", isNull = true)
    private String remark;

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

    public int getTtid() {
        return ttid;
    }

    public void setTtid(int ttid) {
        this.ttid = ttid;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
