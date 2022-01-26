package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/26 14:42
 */
@Data
public class FileBean extends Pagination {
    private long fileId; // 文件主键
    private String fileName; // 文件名称
    private String fileAliasName; // 文件别名(中文名)
    private String fileSavePath; // 文件保存路径
    private long fileCatId; // 文件分类
    private String fileType; // 文件类型(zip/jpg/png/pdf/word/excel/...)
    private String fileCode; // 文件识别码(一段字符串)
    // private String fileImageBase; // 图片base64
    private String remark; // 文件备注说明
    private String createBy;
    private Date createDt;
}
