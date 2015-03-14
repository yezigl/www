/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.beauty;

import gl.yezi.data.orm.Column;

import java.util.Date;

/**
 * description here
 *
 * @author lidehua
 * @since Feb 28, 2015
 */
public class BeauticianTime {
    
    public static final int STATUS_TODO = 1;
    
    public static final int STATUS_DONE = 2;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int beauticianId;
    @Column(type = "INTEGER")
    private int orderId;
    @Column(type = "DATETIME")
    private Date startTime;
    @Column(type = "DATETIME")
    private Date endTime;
    @Column(type = "INTEGER")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(int beauticianId) {
        this.beauticianId = beauticianId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
