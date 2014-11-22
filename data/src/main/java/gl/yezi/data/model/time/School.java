/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.time;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月3日
 */
public class School {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_name")
    @Column(type = "VARCHAR(30)")
    private String name;
    @Column(type = "VARCHAR(30)")
    private String province;
    @Index(value = "idx_city")
    @Column(type = "VARCHAR(20)", isNull = true)
    private String city;
    @Column(type = "VARCHAR(100)", isNull = true)
    private String address;
    @Column(type = "INTEGER")
    private int type; // 1=本科 2=专科
    @Column(type = "VARCHAR(100)", isNull = true)
    private String homepage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        builder.append("id", id);
        builder.append("name", name);
        builder.append("province", province);
        builder.append("city", city);
        builder.append("address", address);
        builder.append("type", type);
        builder.append("homepage", homepage);
        return builder.toString();
    }

}
