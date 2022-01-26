package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.dao.FileMapper;
import com.xiaoyu.entity.FileBean;
import com.xiaoyu.service.baseservice.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/26 14:56
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileMapper fileMapper;


    @Override
    public ListResult<FileBean> queryFileList(FileBean fileBean) {
        // TODO
        return null;
    }

    // 添加文件
    @Override
    public int addFile(FileBean fileBean) {
        return fileMapper.addFile(fileBean);
    }

    // 获取文件详情
    @Override
    public FileBean queryFileDetailById(long fileId) {
        return fileMapper.queryFileDetailById(fileId);
    }

    @Override
    public int updateFile(FileBean fileBean) {
        // TODO
        return 0;
    }

    @Override
    public int deleteFileById(long fileId) {
        // TODO
        return 0;
    }
}
