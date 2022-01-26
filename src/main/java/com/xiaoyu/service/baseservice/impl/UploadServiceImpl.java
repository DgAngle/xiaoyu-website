package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.config.SysParamConfig;
import com.xiaoyu.dao.FileMapper;
import com.xiaoyu.entity.FileBean;
import com.xiaoyu.service.baseservice.UploadService;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.FileUtil;
import com.xiaoyu.utils.R;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:50
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private FileMapper fileMapper;

    // 头像上传
    @Override
    public R avatarUpload(MultipartFile multipartFile) {
        if (multipartFile == null) return R.error();
        String fileName = multipartFile.getOriginalFilename(); // 文件名称
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);  // 扩展名
        String avatarName = "avatar_" + new Date().getTime() + "." + ext; // 保存的图片名称 + 文件后缀
        // 保存(绝对)路径
        String saveAbsolutionPath = SysParamConfig.sysParamsMap.get(SysParamConfig.sysParam_uploadPath) + "/avatar/" + DateUtil.dateToString(new Date(), DateUtil.default_format_date_day) + "/";
        try {
            FileUtil.writeToFile(multipartFile.getInputStream(), saveAbsolutionPath + avatarName);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // 添加到文件表
        FileBean fileBean = initFile(avatarName, saveAbsolutionPath + avatarName, ext);
        fileMapper.addFile(fileBean);
        return R.success().data("filePath", saveAbsolutionPath + avatarName).data("fileId", fileBean.getFileId());
    }

    @Override
    public FileBean getFile(Long fileId) {
        return fileMapper.queryFileDetailById(fileId);
    }

    /**
     * 初始化文件类
     *
     * @param fileName     文件名称
     * @param fileSavePath 保存路径
     * @param fileType     文件类型,后缀
     */
    public FileBean initFile(String fileName, String fileSavePath, String fileType) {
        FileBean fileBean = new FileBean();
        // fileBean.setFileAliasName(UserUtil.getUser().getNickname() + "的头像");
        fileBean.setFileName(fileName);
        fileBean.setFileSavePath(fileSavePath);
        fileBean.setFileCatId(0);
        fileBean.setFileType(fileType);
        fileBean.setRemark("");
        fileBean.setFileCode(FileUtil.createCode());
        fileBean.setCreateDt(new Date());
        // fileBean.setCreateBy(UserUtil.getUser().getUserId());
        return fileBean;
    }
}
