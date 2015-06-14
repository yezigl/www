/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yueqiu.res.Representation;
import com.yueqiu.res.Status;
import com.yueqiu.res.UploadRes;

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
    public Representation upload(@RequestParam MultipartFile file, @RequestParam String bucket) {

        Representation rep = new Representation();

        String cdnServer = "http://static.yezi.gl/" + bucket + "/";
        String uploadPath = "/data/upload/" + bucket;
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
            rep.setError(Status.ERROR_400, "上传文件失败");
            return rep;
        }

        UploadRes res = new UploadRes();
        res.setUrl(url);
        rep.setData(res);

        return rep;
    }

}
