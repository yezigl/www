/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.data.model.movie;

import com.mm.data.orm.Column;
import com.mm.data.orm.Table;

/**
 * 地区
 *
 * @author yezi
 * @since 2014年8月19日
 */
@Table("region")
public class Region {

    @Column(type = "INTEGER", primary = true, autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(20)")
    private String name;

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

}
