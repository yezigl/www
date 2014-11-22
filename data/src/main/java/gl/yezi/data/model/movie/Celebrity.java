/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.movie;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;
import gl.yezi.data.orm.Table;

/**
 * 演员
 *
 * @author yezi
 * @since 2014年8月19日
 */
@Table("celebrity")
public class Celebrity {

    @Column(type = "INTEGER", primary = true, autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(20)", isNull = false)
    @Index("idx_name")
    private String name; // 姓名
    @Column(value = "name_en", type = "VARCHAR(40)")
    private String nameEn; // 英文名
    @Column(type = "VARCHAR(40)")
    private String aka; // 更多姓名
    @Column(value = "aka_en", type = "VARCHAR(100)")
    private String akaEn; // 更多英文名
    @Column(type = "VARCHAR(20)")
    private String birthday; // 出生日期
    @Column(type = "VARCHAR(20)")
    private String deadday; // 死亡日期
    @Column(type = "INTEGER")
    private int gender; // 性别
    @Column(type = "INTEGER")
    private int constellation; // 星座
    @Column(type = "VARCHAR(30)")
    private String birthplace; // 出生地
    @Column(type = "TEXT")
    private String summary; // 简介
    @Column(type = "VARCHAR(200)")
    private String avatar; // 头像
    @Column(type = "VARCHAR(100)")
    private String family; // 家庭
    @Column(type = "VARCHAR(50)")
    private String professions; // 职业
    @Column(type = "INTEGER")
    private int douban;
    @Column(type = "VARCHAR(20)")
    private String imdb;

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

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public String getAkaEn() {
        return akaEn;
    }

    public void setAkaEn(String akaEn) {
        this.akaEn = akaEn;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeadday() {
        return deadday;
    }

    public void setDeadday(String deadday) {
        this.deadday = deadday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getConstellation() {
        return constellation;
    }

    public void setConstellation(int constellation) {
        this.constellation = constellation;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getProfessions() {
        return professions;
    }

    public void setProfessions(String professions) {
        this.professions = professions;
    }

    public int getDouban() {
        return douban;
    }

    public void setDouban(int douban) {
        this.douban = douban;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
}
