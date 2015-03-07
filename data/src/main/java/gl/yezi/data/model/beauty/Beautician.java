/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.beauty;

import java.util.Date;

import gl.yezi.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Beautician {

    @Column(primary = true, type = "INTEGER", autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(20)")
    private String name;
    @Column(type = "INTEGER")
    private int gender;
    @Column(type = "INTEGER")
    private int age;
    @Column(type = "VARCHAR(10)", isNull = true)
    private String birthday;
    @Column(type = "VARCHAR(100)", isNull = true)
    private String avatar;
    @Column(type = "VARCHAR(300)", isNull = true)
    private String introduction;
    @Column(type = "DATETIME")
    private Date jointime;
    @Column(type = "VARCHAR(20)", isNull = true)
    private String idno;
    @Column(type = "VARCHAR(10)", isNull = true)
    private String experience;
    @Column(type = "VARCHAR(200)", isNull = true)
    private String advantage;
    @Column(type = "VARCHAR(200)", isNull = true)
    private String skill;

    public int getId() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
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
