/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.home;

import gl.yezi.data.orm.Column;

/**
 * description here
 *
 * @author yezi
 * @since 2015年2月4日
 */
public class Employee {

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

}
