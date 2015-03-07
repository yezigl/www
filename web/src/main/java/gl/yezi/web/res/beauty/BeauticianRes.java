/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import gl.yezi.data.model.beauty.Beautician;
import gl.yezi.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月1日
 */
public class BeauticianRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    private Integer id;
    @JsonInclude(Include.NON_NULL)
    private String name;
    @JsonInclude(Include.NON_NULL)
    private Integer age;
    @JsonInclude(Include.NON_NULL)
    private String avatar;
    @JsonInclude(Include.NON_NULL)
    private String introduction;
    @JsonInclude(Include.NON_NULL)
    private String experience;
    @JsonInclude(Include.NON_NULL)
    private String advantage;
    @JsonInclude(Include.NON_NULL)
    private String skill;

    public BeauticianRes() {

    }

    public BeauticianRes(Beautician beautician) {
        setBeautician(beautician);
    }

    public void setBeautician(Beautician beautician) {
        id = beautician.getId();
        name = beautician.getName();
        age = beautician.getAge();
        avatar = beautician.getAvatar();
        introduction = beautician.getIntroduction();
        experience = beautician.getExperience();
        advantage = beautician.getAdvantage();
        skill = beautician.getSkill();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}
