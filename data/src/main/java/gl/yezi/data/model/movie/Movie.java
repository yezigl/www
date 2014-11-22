/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.data.model.movie;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import gl.yezi.data.orm.Column;
import gl.yezi.data.orm.Index;
import gl.yezi.data.orm.Table;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月19日
 */
@Table("movie")
public class Movie {

    @Column(type = "INTEGER", primary = true, autoIncrement = true)
    private int id;
    @Column(type = "VARCHAR(30)", isNull = false)
    @Index("idx_title")
    private String title; // 中文名
    @Column(type = "VARCHAR(50)", value = "origin_title")
    @Index("idx_origin_title")
    private String originTitle; // 原名
    @Column(type = "VARCHAR(200)")
    private String alias; // 别名
    @Column(type = "VARCHAR(200)")
    private String images; // 海报
    @Column(type = "VARCHAR(100)", isNull = false)
    private int[] directors; // 导演
    @Column(type = "VARCHAR(100)", isNull = false)
    private int[] writors; // 编剧
    @Column(type = "VARCHAR(200)", isNull = false)
    private int[] casts; // 主演
    @Column(type = "VARCHAR(100)", isNull = false)
    private String types; // 类型
    @Column(type = "VARCHAR(100)", isNull = false)
    private String regions; // 地区
    @Column(type = "VARCHAR(20)")
    private String language; // 语言
    @Column(type = "VARCHAR(100)")
    @Index("idx_pubdate")
    private String pubdate; // 上映日期
    @Column(value = "mainland_pubdate", type = "VARCHAR(10)")
    private String mainlandPubdate; // 大陆上映日期
    @Column(type = "INTEGER")
    @Index("idx_year")
    private int year; // 年代
    @Column(type = "VARCHAR(100)")
    private String duration; // 片长
    @Column(type = "VARCHAR(2000)")
    private String summary; // 摘要
    @Column(type = "VARCHAR(100)")
    private String tags; // 标签
    @Column(type = "INTEGER")
    private int douban; // 豆瓣id
    @Column(type = "VARCHAR(20)")
    private String imdb; // imdbid

    public int getId() {
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

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int[] getDirectors() {
        return directors;
    }

    public void setDirectors(int[] directors) {
        this.directors = directors;
    }

    public int[] getWritors() {
        return writors;
    }

    public void setWritors(int[] writors) {
        this.writors = writors;
    }

    public int[] getCasts() {
        return casts;
    }

    public void setCasts(int[] casts) {
        this.casts = casts;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getMainlandPubdate() {
        return mainlandPubdate;
    }

    public void setMainlandPubdate(String mainlandPubdate) {
        this.mainlandPubdate = mainlandPubdate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        builder.append("id", id);
        builder.append("title", title);
        builder.append("originTitle", originTitle);
        builder.append("alias", alias);
        builder.append("images", images);
        builder.append("directors", Arrays.toString(directors));
        builder.append("writors", Arrays.toString(writors));
        builder.append("casts", Arrays.toString(casts));
        builder.append("types", types);
        builder.append("regions", regions);
        builder.append("language", language);
        builder.append("pubdate", pubdate);
        builder.append("mainlandPubdate", mainlandPubdate);
        builder.append("year", year);
        builder.append("duration", duration);
        builder.append("summary", summary);
        builder.append("tags", tags);
        builder.append("douban", douban);
        builder.append("imdb", imdb);
        return builder.toString();
    }

}
