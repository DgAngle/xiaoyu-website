package com.xiaoyu.dao;

import com.xiaoyu.entity.FileBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/26 14:59
 */
public interface FileMapper {

    // 添加文件
    @Insert("insert into file(fileId, fileAliasName, fileName, fileSavePath, fileCode, fileCatId, fileType, remark, createBy, createDt)"
            + " values(null, #{fileAliasName}, #{fileName}, #{fileSavePath}, #{fileCode}, #{fileCatId}, #{fileType}, #{remark}, #{createBy}, #{createDt})")
    @Options(useGeneratedKeys = true, keyColumn = "fileId", keyProperty = "fileId")
    int addFile(FileBean fileBean);

    // 获取文件详情
    @Select("select * from file where fileId = #{fileId}")
    FileBean queryFileDetailById(@Param("fileId") long fileId);
}
