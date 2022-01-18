package com.xiaoyu.controller;

import com.xiaoyu.service.baseservice.UploadService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:47
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Resource
    private UploadService uploadService;

    // 上传头像
    @RequestMapping("/avatar")
    @ResponseBody
    public R userInfoUpload(MultipartFile multipartFile) {
        // HttpServletRequest request
        return uploadService.avatarUpload(multipartFile);
    }
}
