/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import java.util.ArrayList;
import java.util.List;

import gl.yezi.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
public class BeauticianListRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<BeauticianRes> beauticians;
    private Integer offset;
    
    public BeauticianListRes() {
        beauticians = new ArrayList<BeauticianRes>();
    }

    public List<BeauticianRes> getBeauticians() {
        return beauticians;
    }

    public void setBeauticians(List<BeauticianRes> beauticians) {
        this.beauticians = beauticians;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void addBeautician(BeauticianRes beauticianRes) {
        beauticians.add(beauticianRes);
    }
}
