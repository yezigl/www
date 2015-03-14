/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import gl.yezi.web.res.Res;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
public class OrderRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date ctime;
    private Float amount;
    private Float discount;
    private String status;
    private String address;
    private boolean isPay;
    private DealRes deal;
    private BeauticianRes beautician;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean isPay) {
        this.isPay = isPay;
    }

    public DealRes getDeal() {
        return deal;
    }

    public void setDeal(DealRes deal) {
        this.deal = deal;
    }

    public BeauticianRes getBeautician() {
        return beautician;
    }

    public void setBeautician(BeauticianRes beautician) {
        this.beautician = beautician;
    }

}
