/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.time;

import com.mm.data.orm.Column;
import com.mm.data.orm.Index;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class Timetable {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_schoolid")
    @Column(type = "INTEGER")
    private int schid; // school id
    @Index(value = "idx_collegeid")
    @Column(type = "INTEGER")
    private int collid; // college id
    @Column(type = "INTEGER")
    private int season;
    @Index(value = "idx_cdate")
    @Column(type = "VARCHAR(10)")
    private String cdate;
    @Column(type = "VARCHAR(50)")
    private String ctime;
    @Column(type = "VARCHAR(30)")
    private String classroom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchid() {
        return schid;
    }

    public void setSchid(int schid) {
        this.schid = schid;
    }

    public int getCollid() {
        return collid;
    }

    public void setCollid(int collid) {
        this.collid = collid;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

}
