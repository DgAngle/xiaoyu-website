package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.FileBean;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/26 14:56
 */
public interface FileService {
    ListResult<FileBean> queryFileList(FileBean fileBean);

    int addFile(FileBean fileBean);

    FileBean queryFileDetailById(long fileId);

    int updateFile(FileBean fileBean);

    int deleteFileById(long fileId);
}
