/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.web.res.beauty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mm.data.model.beauty.Flow;
import com.mm.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月9日
 */
public class FlowRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer id;
    @JsonInclude(Include.NON_NULL)
    private String name;
    @JsonInclude(Include.NON_NULL)
    private String description;
    @JsonInclude(Include.NON_NULL)
    private String imgUrl;
    @JsonInclude(Include.NON_NULL)
    private Integer step;
    @JsonInclude(Include.NON_NULL)
    private Integer time;
    
    public FlowRes() {
        
    }
    
    public FlowRes(Flow flow) {
        id = flow.getId();
        step = flow.getStep();
        name = flow.getName();
        description = flow.getDescription();
        imgUrl = flow.getImgUrl();
        time = flow.getTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}
