/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.res.beauty;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mm.data.model.beauty.Deal;
import com.mm.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月5日
 */
public class DealRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer id;
    @JsonInclude(Include.NON_NULL)
    private String title;
    @JsonInclude(Include.NON_NULL)
    private String description;
    @JsonInclude(Include.NON_NULL)
    private Float price; // 售卖价格
    @JsonInclude(Include.NON_NULL)
    private Float value; // 实际价格
    @JsonInclude(Include.NON_NULL)
    private String type;
    @JsonInclude(Include.NON_NULL)
    private String imgUrl;
    @JsonInclude(Include.NON_NULL)
    private String gallery;
    @JsonInclude(Include.NON_NULL)
    private String content;
    @JsonInclude(Include.NON_NULL)
    private Integer costtime;
    @JsonInclude(Include.NON_NULL)
    private String efficacy; // 功效
    @JsonInclude(Include.NON_NULL)
    private List<FlowRes> flows; // 服务流程
    @JsonInclude(Include.NON_NULL)
    private String special;
    @JsonInclude(Include.NON_NULL)
    private List<ProductRes> products;
    
    public DealRes() {
        
    }

    public DealRes(Deal deal) {
        products = new ArrayList<ProductRes>();
        flows = new ArrayList<FlowRes>();
        setDeal(deal);
    }
    
    public void setDeal(Deal deal) {
        id = deal.getId();
        title = deal.getTitle();
        description = deal.getDescription();
        price = deal.getPrice();
        value = deal.getValue();
        imgUrl = deal.getImgUrl();
        content = deal.getContent();
        costtime = deal.getCosttime();
        efficacy = deal.getEfficacy();
        special = deal.getSpecial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCosttime() {
        return costtime;
    }

    public void setCosttime(int costtime) {
        this.costtime = costtime;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public List<FlowRes> getFlows() {
        return flows;
    }

    public void setFlows(List<FlowRes> flows) {
        this.flows = flows;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public List<ProductRes> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRes> products) {
        this.products = products;
    }

    public void addProductRes(ProductRes productRes) {
        products.add(productRes);
    }
    
    public void addFlows(FlowRes flowRes) {
        flows.add(flowRes);
    }

}
