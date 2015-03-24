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
public class College {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Index(value = "idx_schoolid")
    @Column(type = "INTEGER")
    private int schid; // school id
    @Column(type = "VARCHAR(50)")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
