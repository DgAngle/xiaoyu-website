package com.xiaoyu.web.connect.mapper;

import com.xiaoyu.web.connect.bean.DBConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:13
 */
public interface ConnectMapper {

    // 连接列表查询
    @Select("select * from db_config")
    List<DBConfig> queryList();

    // 新增连接配置
    @Insert("insert into db_config(dbConfigId,connectName,driver,host,port,type,dbName,username,password,url,remark,"
            + " createDt,createBy,updateDt,updateBy) "
            + " values(#{dbConfigId},#{connectName},#{driver},#{host},#{port},#{type},#{dbName},#{username},#{password},#{url},#{remark}, "
            + " #{createDt},#{createBy},#{updateDt},#{updateBy})")
    int insertConnect(DBConfig dbConfig);

    // 更新连接配置
    @Update("update db_config set driver=#{driver},#{connectName},host=#{host},port=#{port},type=#{type},dbName=#{dbName},username=#{username},password=#{password}, "
            + " url=#{url},remark=#{remark},updateDt=#{updateDt},updateBy=#{updateDt} "
            + " where dbConfigId=#{dbConfigId}")
    int updateConnect(DBConfig dbConfig);
}
