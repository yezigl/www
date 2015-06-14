/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@RestController
@RequestMapping("/1")
public class AppController extends AbstractController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(@RequestParam MultipartFile file, @RequestParam String bucket) {

        ModelAndView mv = new ModelAndView();

        String cdnServer = "http://static.yezi.gl/" + bucket + "/";
        String uploadPath = "/opt/data/upload/" + bucket;
        File path = new File(uploadPath);
        if (!path.exists()) {
            path.mkdirs();
        }

        String url = null;
        String name = StringUtils.substringBeforeLast(file.getOriginalFilename(), ".");
        String suffix = StringUtils.substringAfterLast(file.getOriginalFilename(), ".").toLowerCase();
        String filename = DigestUtils.md5Hex(name + System.currentTimeMillis()) + "_original." + suffix;
        File dest = new File(path, filename);
        try {
            file.transferTo(dest);
            url = cdnServer + filename;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        if (url == null) {
            mv.addObject("code", "-1");
        } else {
            mv.addObject("code", "200");
            mv.addObject("url", url);
        }

        return mv.getModel();
    }

}
