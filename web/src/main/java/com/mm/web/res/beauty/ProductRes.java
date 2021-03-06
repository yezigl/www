/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.res.beauty;

import com.mm.data.model.beauty.Product;
import com.mm.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月5日
 */
public class ProductRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String applicable;
    private String efficacy;

    public ProductRes(Product product) {
        setProduct(product);
    }

    public ProductRes() {
    }

    public Integer getId() {
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

    public void setProduct(Product product) {
        id = product.getId();
        name = product.getName();
        applicable = product.getApplicable();
        efficacy = product.getEfficacy();
    }

}
