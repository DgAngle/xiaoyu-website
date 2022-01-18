package com.xiaoyu.service.baseservice;

import com.xiaoyu.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:49
 */
public interface UploadService {
    R avatarUpload(MultipartFile multipartFile);
}
