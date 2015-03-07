/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import gl.yezi.data.model.beauty.Deal;
import gl.yezi.web.res.Res;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    private Double price; // 售卖价格
    @JsonInclude(Include.NON_NULL)
    private Double value; // 实际价格
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
    private String flow; // 服务流程
    @JsonInclude(Include.NON_NULL)
    private String special;
    @JsonInclude(Include.NON_NULL)
    private List<ProductRes> products;
    
    public DealRes() {
        
    }

    public DealRes(Deal deal) {
        products = new ArrayList<ProductRes>();
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
        flow = deal.getFlow();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
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

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
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

}
