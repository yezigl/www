/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package gl.yezi.crawler.time.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.mm.data.dao.time.SchoolDao;
import com.mm.data.model.time.School;
import com.mm.service.utils.HttpUtils;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月11日
 */
@Service
public class SchoolCrawler {

    private Pattern tbablePattern = Pattern.compile("<table.*?>([\\s\\S]*?)</table>");

    private Pattern trPattern = Pattern.compile("<tr>([\\s\\S]*?)</tr>");

    private Pattern tdPattern = Pattern.compile("<td>(?:<a.*?>)?([^<]*)(?:</a>)?</td>");

    private String[] provinces = { "北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省",
            "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "内蒙古自治区",
            "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔族自治区" };

    private String province = null;

    @Resource
    SchoolDao schoolDao;

    public void parseProvince() {
        for (String province : provinces) {
            this.province = province;
            if (province.startsWith("湖北") || province.startsWith("广东")) {
                continue;
            }
            System.out.println(province);
            String url = "http://zh.wikipedia.org/wiki/" + province + "高等学校列表";
            parseList(url);
        }
    }

    public void parseList(String url) {
        String html = HttpUtils.get(url);
        // System.out.println(html);
        Matcher matcher = tbablePattern.matcher(html);
        int count = 0;
        String benke = null, zhuanke = null;
        while (matcher.find()) {
            if (count == 0) {
                benke = matcher.group(1);
                count++;
            } else if (count == 1) {
                zhuanke = matcher.group(1);
                break;
            }
        }
        // System.out.println(benke);
        // System.out.println(zhuanke);

        parseSchool(benke, 1);
        parseSchool(zhuanke, 2);
    }

    private void parseSchool(String table, int type) {
        if (table == null) {
            System.out.println(province + " is null");
            return;
        }
        Matcher matcher = trPattern.matcher(table);
        while (matcher.find()) {
            String tr = matcher.group(1);
            tr = tr.replaceAll("<br />", "");
            Matcher tdMatcher = tdPattern.matcher(tr);
            List<String> tds = new ArrayList<String>();
            while (tdMatcher.find()) {
                tds.add(tdMatcher.group(1));
            }
            School school = new School();
            if (tds.size() == 9) {
                school.setName(tds.get(1));
                school.setProvince(province);
                school.setCity(province);
                school.setAddress(tds.get(3));
                school.setHomepage(tds.get(7));
                school.setType(type);
            } else if (tds.size() == 8) {
                if (NumberUtils.isDigits(tds.get(0))) {
                    school.setName(tds.get(1));
                    school.setProvince(province);
                    school.setCity(tds.get(3));
                    school.setAddress(tds.get(3));
                    school.setHomepage(tds.get(6));
                    school.setType(type);
                } else {
                    school.setName(tds.get(0).replaceAll("独立学院|（.*）", ""));
                    school.setProvince(province);
                    school.setCity(tds.get(2));
                    school.setAddress(tds.get(2));
                    school.setHomepage(tds.get(6));
                    school.setType(type);
                }
            } else if (tds.size() == 7) {
                if (NumberUtils.isDigits(tds.get(0))) {
                    school.setName(tds.get(1));
                    school.setProvince(province);
                    school.setCity(province.contains("市") ? province : tds.get(3));
                    school.setAddress(tds.get(3));
                    school.setHomepage(tds.get(5));
                    school.setType(type);
                } else {
                    school.setName(tds.get(0));
                    school.setProvince(province);
                    school.setCity(tds.get(1));
                    school.setAddress(tds.get(1));
                    school.setHomepage(tds.get(5));
                    school.setType(type);
                }
            } else {
                System.out.println(province);
            }
            if (StringUtils.isNotBlank(school.getName())) {
                System.out.println(school.toString());
                schoolDao.create(school);
            }
        }
    }
}
