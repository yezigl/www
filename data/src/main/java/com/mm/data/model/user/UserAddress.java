/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.user;

import com.mm.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
public class UserAddress {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int userId;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String province;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String city;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String district;
    @Column(type = "VARCHAR(100)", isNull = true)
    private String location;
    @Column(type = "VARCHAR(100)")
    private String detail;
    @Column(type = "FLOAT", isNull = true)
    private float langitude;
    @Column(type = "FLOAT", isNull = true)
    private float latitude;
    @Column(type = "TINYINT", isNull = true)
    private int type;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getLangitude() {
        return langitude;
    }

    public void setLangitude(float langitude) {
        this.langitude = langitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return
     */
    public String getAddress() {
        if (location != null) {
            return location + detail;
        } else {
            return province + city + district + detail;
        }
    }

}
