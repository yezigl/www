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
public class OrderListRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer offset;
    private List<OrderRes> orders;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<OrderRes> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderRes> orders) {
        this.orders = orders;
    }

    public void addOrderRes(OrderRes orderRes) {
        if (orders == null) {
            orders = new ArrayList<OrderRes>();
        }
        orders.add(orderRes);
    }
}
