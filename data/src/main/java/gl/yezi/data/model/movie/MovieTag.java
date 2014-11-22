/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.movie;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;
import gl.yezi.data.orm.Table;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月19日
 */
@Table("movie_tag")
public class MovieTag {

    @Column(type = "INTEGER", isNull = false)
    @Index(value = "idx_mov", order = 0)
    private int movid;
    @Column(type = "INTEGER", isNull = false)
    @Index(value = "idx_tag", order = 0)
    private int tagid;
    @Column(type = "INTEGER")
    private int count;

    public int getMovid() {
        return movid;
    }

    public void setMovid(int movid) {
        this.movid = movid;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
