/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.movie;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Table;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月19日
 */
@Table("tag")
public class Tag {

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
