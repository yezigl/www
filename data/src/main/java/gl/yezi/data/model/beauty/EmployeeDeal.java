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
public class EmployeeDeal {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int employeeId;
    @Column(type = "INTEGER")
    private int dealId;
    @Column(type = "FLOAT")
    private float avgSorce;
    @Column(type = "VARCHAR(200)", isNull = true)
    private String subScore;
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "DATETIME")
    private Date utime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public float getAvgSorce() {
        return avgSorce;
    }

    public void setAvgSorce(float avgSorce) {
        this.avgSorce = avgSorce;
    }

    public String getSubScore() {
        return subScore;
    }

    public void setSubScore(String subScore) {
        this.subScore = subScore;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

}
