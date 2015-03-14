/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.beauty;

import gl.yezi.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
public class Coupon {
    
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "INTEGER")
    private int type;
    @Column(type = "VARCHAR(200)")
    private String description;
    @Column(type = "FLOAT")
    private float price;
    @Column(type = "FLOAT")
    private float value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    /**
     * @return
     */
    public float getDiscount() {
        if (getType() == TYPE_1) {
            return getPrice();
        } else if (getType() == TYPE_2) {
            return getValue() - getPrice();
        }
        return 0;
    }

}
