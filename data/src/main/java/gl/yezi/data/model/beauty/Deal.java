/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.beauty;

import java.util.Date;

import gl.yezi.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Deal {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(30)")
    private String title;
    @Column(type = "VARCHAR(30)")
    private String description;
    @Column(type = "FLOAT")
    private double price; // 售卖价格
    @Column(type = "FLOAT")
    private double value; // 实际价格
    @Column(type = "INTEGER")
    private int status;
    @Column(type = "INTEGER")
    private int type;
    @Column(type = "VARCHAR(100)", isNull = true)
    private String imgUrl;
    @Column(type = "VARCHAR(300)", isNull = true)
    private String gallery;
    @Column(type = "DATETIME")
    private Date ctime;
    @Column(type = "DATETIME")
    private Date utime;
    @Column(type = "VARCHAR(500)")
    private String content;
    @Column(type = "INTEGER")
    private int costtime;
    @Column(type = "VARCHAR(300)", isNull = true)
    private String efficacy; // 功效
    @Column(type = "VARCHAR(300)", isNull = true)
    private String component; // 产品成分
    @Column(type = "VARCHAR(300)", isNull = true)
    private String flow; // 服务流程
    @Column(type = "VARCHAR(300)", isNull = true)
    private String special;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCosttime() {
        return costtime;
    }

    public void setCosttime(int costtime) {
        this.costtime = costtime;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

}
