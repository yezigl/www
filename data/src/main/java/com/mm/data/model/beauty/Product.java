/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.beauty;

import com.mm.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月5日
 */
public class Product {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(30)")
    private String name;
    @Column(type = "VARCHAR(100)")
    private String applicable;
    @Column(type = "VARCHAR(200)")
    private String efficacy;

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

    public String getApplicable() {
        return applicable;
    }

    public void setApplicable(String applicable) {
        this.applicable = applicable;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

}
