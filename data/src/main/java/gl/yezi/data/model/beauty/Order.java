/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.beauty;

import gl.yezi.data.orm.Column;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Order {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int userId;
    @Column(type = "INTEGER")
    private int dealId;
    @Column(type = "INTEGER")
    private int employeeId;
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
    @Column(type = "INTEGER")
    private int ip;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

}
