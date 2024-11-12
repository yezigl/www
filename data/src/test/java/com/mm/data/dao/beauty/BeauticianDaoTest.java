/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.data.dao.beauty;

import java.util.Date;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mm.data.model.beauty.Beautician;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月7日
 */
@SpringBootTest
@ContextConfiguration("/applicationContext-test.xml")
public class BeauticianDaoTest {

    @Resource
    BeauticianDao beauticianDao;
    
    /**
     * Test method for {@link com.mm.data.dao.beauty.BeauticianDao#create(com.mm.data.model.beauty.Beautician)}.
     */
    @Test
    public void testCreate() {
        Beautician beautician1 = new Beautician();
        beautician1.setName("薛玉玲");
        beautician1.setAge(30);
        beautician1.setGender(1);
        beautician1.setAvatar("http://meirongproject.b0.upaiyun.com/photo/801785381092f068bbaf1e53d374ba90.jpg");
        beautician1.setBirthday("1987-12-12");
        beautician1.setIntroduction("Hello，大家好！欢迎进入我的主页，我从事美容美体多年，擅长美容、SPA、头疗、肩颈背调理、全身经络疏通及乳腺疏通，能够用心的结合我丰富的专业知识和娴熟手法，去改善顾客的皮肤问题，调理亚健康状态，让你们变得更美丽，更健康。");
        beautician1.setAdvantage("");
        beautician1.setJointime(new Date());
        beautician1.setExperience("14");
        beautician1.setIdno("1111111111111111");
        beautician1.setSkill("");
        beauticianDao.create(beautician1);
        
        Beautician beautician2 = new Beautician();
        beautician2.setName("许敏");
        beautician2.setAge(30);
        beautician2.setGender(1);
        beautician2.setAvatar("http://meirongproject.b0.upaiyun.com/photo/e3a69cf19f47bcae0fb4208b76af9ae4.jpg");
        beautician2.setBirthday("1987-12-12");
        beautician2.setIntroduction("本人从事美容行业三年多，十分热爱美容事业，可以为人们带来健康、美丽、自信的行业，本人技术精益，手法娴熟，力求完美，从服务好每一位顾客为宗旨，顾客满意就是对我最大的欣慰与肯定，我会再接再厉，不断努力把握工作，服务做到精致，细腻，谢谢！");
        beautician2.setAdvantage("");
        beautician2.setJointime(new Date());
        beautician2.setExperience("14");
        beautician2.setIdno("1111111111111111");
        beautician2.setSkill("");
        beauticianDao.create(beautician2);
        
        Beautician beautician3 = new Beautician();
        beautician3.setName("张灵芝");
        beautician3.setAge(30);
        beautician3.setGender(1);
        beautician3.setAvatar("http://meirongproject.b0.upaiyun.com/photo/20d3ecdfafce9e3fbb31145248eeecc5.jpg");
        beautician3.setBirthday("1987-12-12");
        beautician3.setIntroduction("擅长中医、SPA手法、多种手法改善身体亚健康，舒缓疲劳放松身心，改善失眠补充能量，面部手法结合高效产品，解决多种面部问题。");
        beautician3.setAdvantage("");
        beautician3.setJointime(new Date());
        beautician3.setExperience("14");
        beautician3.setIdno("1111111111111111");
        beautician3.setSkill("");
        beauticianDao.create(beautician3);
    }

}
