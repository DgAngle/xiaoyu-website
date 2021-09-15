package com.xiaoyu.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云Oss工具类
 */
public class OssUtil {

    /**
     * 上传图片文件
     *
     * @param file 图片文件
     * @return 文件存储路径
     */
    public static String uploadImageFile(MultipartFile file) {
        // 1. 使用工具类取值
        String endpoint = ConstantUtil.END_POINT;
        String accessKeyId = ConstantUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantUtil.BUCKET_NAME;

        String url = "";

        try {
            // 2. 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 3. 上传文件流。
            InputStream inputStream = file.getInputStream();

            // 4. 文件名称
            String filename = file.getOriginalFilename();
            // 防止重复, 使用 uuid 区分文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            // 分类管理, 添加分类目录: 年/月 -> 2020/12/01.jpg
            String datePath = new DateTime().toString("yyyy/MM");
            filename = datePath + "/" + uuid + "_" + filename;

            // 5. 调用 oss 方法实现上传
            // 参数1：bucketName   -> bucket名称
            // 参数2：filename     -> 上传到oss 的文件路径和文件名称 /aa/bb/01.jpg
            // 参数3：inputStream  -> 上传文件输入流
            ossClient.putObject(bucketName, filename, inputStream);

            // 6. 关闭OSSClient。
            ossClient.shutdown();

            // 7. 拼接返回文件上传路径
            url = "https://" + bucketName + "." + endpoint + "/" + filename;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}
