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
@Table("movie_celebrity")
public class MovieCelebrity {

    @Column(type = "INTEGER", isNull = false)
    @Index("idx_mov")
    private int movid;
    @Column(type = "INTEGER", isNull = false)
    @Index("idx_cele")
    private int celeid;
    @Column(type = "INTEGER")
    private int type; // 1=导演 2=编剧 3=演员

    public int getMovid() {
        return movid;
    }

    public void setMovid(int movid) {
        this.movid = movid;
    }

    public int getCeleid() {
        return celeid;
    }

    public void setCeleid(int celeid) {
        this.celeid = celeid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
