/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.spider.movie.douban;

import gl.yezi.data.dao.movie.MovieDao;
import gl.yezi.data.model.movie.Movie;
import gl.yezi.data.utils.DataUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description here
 *
 * @author yezi
 * @since 2014年8月25日
 */
@Component
public class DoubanMovie {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Pattern infoPattern = Pattern.compile("<div[ ]+id=[\"']info[\"']>([\\s\\S]*?)</div>", Pattern.MULTILINE);

    private Pattern plPattern = Pattern.compile("<span[ ]+class=[\"']pl[\"']>(.*?)</span>(.*?)<br/?>",
            Pattern.MULTILINE);

    private Pattern summaryPattern = Pattern.compile(
            "<span[ ]+property=[\"']v:summary[\"'][ ]+class=[\"'][\"']>([\\s\\S]*?)</span>", Pattern.MULTILINE);

    private Pattern imagePattern = Pattern.compile("<img src=\"([^\"]+)\".*?rel=\"v:image\"[ ]*/>");

    private Pattern titlePattern = Pattern
            .compile("<span property=\"v:itemreviewed\">(.+?)(?:[ ]((:?[a-zA-Z]+|\\d{2,}|\\W+)[ ]?.+?))?</span>");

    private Pattern tagPattern = Pattern.compile("<.*?/?>|</.*?>|[ ]");

    private Pattern celebrityPattern = Pattern.compile("/celebrity/(\\d{4,})/");

    private Pattern aPattern = Pattern.compile("<a[ ]*href=\"(http://movie.douban.com/subject/\\d+/)[^\"].*\".*?>");

    @Resource
    MovieDao movieDao;

    public Set<String> parse(int douban, String html) {
        Set<String> list = new HashSet<String>();

        try {
            Map<String, String> movieMap = new HashMap<String, String>();
            // 找到电影信息的div
            Matcher infoMatcher = infoPattern.matcher(html);
            while (infoMatcher.find()) {
                String info = infoMatcher.group(1);
                logger.debug(info);
                if (info != null) {
                    // 电影信息的每一项
                    Matcher plMatcher = plPattern.matcher(info);
                    while (plMatcher.find()) {
                        String key = plMatcher.group(1);
                        String value = plMatcher.group(2);

                        // 处理名人
                        Matcher celebrityMatcher = celebrityPattern.matcher(value);
                        String valueActual = "";
                        while (celebrityMatcher.find()) {
                            valueActual += celebrityMatcher.group(1) + "/";
                        }
                        if (StringUtils.isBlank(valueActual)) {
                            valueActual = value;
                        }

                        movieMap.put(trim(key, ":"), trim(valueActual, tagPattern.pattern()));
                        logger.debug("{} {}", key, value);
                    }
                } else {
                    logger.warn("{} parse fail.", douban);
                }
                // 处理简介
                Matcher summaryMatcher = summaryPattern.matcher(html);
                while (summaryMatcher.find()) {
                    String summary = summaryMatcher.group(1);
                    movieMap.put("简介", summary.trim());
                }
                // 处理海报
                Matcher imageMatcher = imagePattern.matcher(html);
                while (imageMatcher.find()) {
                    String image = imageMatcher.group(1);
                    movieMap.put("image", image);
                }
                // 处理相关电影链接
                Matcher aMatcher = aPattern.matcher(html);
                while (aMatcher.find()) {
                    list.add(aMatcher.group(1));
                }
                // 处理电影名
                Matcher titleMatcher = titlePattern.matcher(html);
                while (titleMatcher.find()) {
                    if (titleMatcher.groupCount() == 1) {
                        String title = titleMatcher.group(1);
                        movieMap.put("title", title);
                    } else if (titleMatcher.groupCount() >= 2) {
                        movieMap.put("title", titleMatcher.group(1));
                        movieMap.put("originTitle", StringUtils.trim(titleMatcher.group(2)));
                    }
                }

                movieMap.put("douban", String.valueOf(douban));

                Movie movie = new Movie();
                movie.setTitle(movieMap.get("title"));
                movie.setOriginTitle(movieMap.get("originTitle"));
                movie.setAlias(movieMap.get("又名"));
                movie.setDirectors(DataUtils.toIntArray(StringUtils.split(movieMap.get("导演"), "/")));
                movie.setWritors(DataUtils.toIntArray(StringUtils.split(movieMap.get("编剧"), "/")));
                movie.setCasts(DataUtils.toIntArray(StringUtils.split(movieMap.get("主演"), "/")));
                movie.setImages(movieMap.get("image"));
                movie.setTypes(movieMap.get("类型"));
                movie.setRegions(movieMap.get("制片国家/地区"));
                movie.setLanguage(movieMap.get("语言"));
                movie.setPubdate(movieMap.get("上映日期"));
                movie.setDuration(movieMap.get("片长"));
                movie.setSummary(movieMap.get("简介"));
                movie.setDouban(douban);
                movie.setImdb(movieMap.get("IMDb链接"));

                try {
                    movieDao.create(movie);
                } catch (Exception e) {
                    logger.error("create {} fail", douban);
                }
                // movie = movieDao.get(4);
                logger.debug("{}", movie);
            }

            logger.debug("{}", movieMap);
            logger.debug("{}", list);
            logger.info("create movie {}", douban);
        } catch (Exception e) {
            logger.error("create {} fail, {}", douban, e.getMessage());
        }
        return list;
    }

    private String trim(String s, String replace) {
        return s.replaceAll(replace, "");
    }
}
