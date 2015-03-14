/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.user;

import gl.yezi.data.orm.Column;

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
    @Column(type = "VARCHAR(20)")
    private String province;
    @Column(type = "VARCHAR(20)")
    private String city;
    @Column(type = "VARCHAR(20)")
    private String district;
    @Column(type = "VARCHAR(100)")
    private String detail;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return
     */
    public String getAddress() {
        return province + city + district + detail;
    }

}
