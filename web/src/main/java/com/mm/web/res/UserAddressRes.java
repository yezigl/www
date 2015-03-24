/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mm.data.model.user.UserAddress;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
public class UserAddressRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer id;
    @JsonInclude(Include.NON_NULL)
    private String province;
    @JsonInclude(Include.NON_NULL)
    private String city;
    @JsonInclude(Include.NON_NULL)
    private String district;
    @JsonInclude(Include.NON_NULL)
    private String detail;
    @JsonInclude(Include.NON_NULL)
    private String location;
    @JsonInclude(Include.NON_NULL)
    private Float langitude;
    @JsonInclude(Include.NON_NULL)
    private Float latitude;
    @JsonInclude(Include.NON_NULL)
    private Integer type;

    public UserAddressRes() {

    }

    public UserAddressRes(UserAddress userAddress) {
        id = userAddress.getId();
        province = userAddress.getProvince();
        city = userAddress.getCity();
        district = userAddress.getDistrict();
        detail = userAddress.getDetail();
        location = userAddress.getLocation();
        langitude = userAddress.getLangitude();
        latitude = userAddress.getLatitude();
        type = userAddress.getType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getLangitude() {
        return langitude;
    }

    public void setLangitude(Float langitude) {
        this.langitude = langitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
