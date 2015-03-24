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
public class Feedback {
    
    public static final int STATUS_NORMAL = 1;
    
    public static final int STATUS_DELETE = 2;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int userId;
    @Column(type = "INTEGER")
    private int dealId;
    @Column(type = "INTEGER")
    private int beauticianId;
    @Column(type = "VARCHAR(1000)")
    private String content;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "DATETIME")
    private Date utime;
    @Column(type = "VARCHAR(15)")
    private String ip;
    @Column(type = "INTEGER")
    private int score;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "VARCHAR(1000)")
    private String reply;
    @Column(type = "DATETIME")
    private Date replyTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
