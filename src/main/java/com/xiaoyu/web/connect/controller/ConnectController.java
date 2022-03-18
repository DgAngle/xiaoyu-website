package com.xiaoyu.web.connect.controller;

import com.xiaoyu.utils.R;
import com.xiaoyu.web.connect.bean.DBConfig;
import com.xiaoyu.web.connect.service.ConnectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 连接管理
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:11
 */
@Controller
public class ConnectController {
    private static final String connect_path = "pagelist/connect";

    @Resource
    private ConnectService connectService;

    // 打开连接管理列表页
    @RequestMapping("connect/goList")
    public String goList() {
        return connect_path + "/connectlist";
    }

    // 打开代码生成列表
    @RequestMapping("connect/goCodeGenerateList")
    public String goCodeGenerateList() {
        return connect_path + "/codeGenerateList";
    }

    // 数据库表列表 - 默认当前数据库
    @RequestMapping("connect/queryTableList")
    @ResponseBody
    public R queryTableList(DBConfig dbConfig) {
        return R.success().data("tableList", connectService.queryTableList(dbConfig));
    }

    // 查询连接配置列表
    @RequestMapping("connect/queryConnectList")
    @ResponseBody
    public R queryConnectList(DBConfig dbConfig) {
        return R.success().data("dbConfigList", connectService.queryList(dbConfig));
    }

    // 代码生成
    @RequestMapping("connect/generateCode")
    @ResponseBody
    public R generateCode(DBConfig dbConfig) {
        return R.success().data("dbConfigList", connectService.generateCode(dbConfig));
    }

    // 新增连接配置
    @RequestMapping("connect/insertConnect")
    @ResponseBody
    public R insertConnect(DBConfig dbConfig) {
        connectService.insertConnect(dbConfig);
        return R.success();
    }

    // 更新连接配置
    @RequestMapping("connect/updateConnect")
    @ResponseBody
    public R updateConnect(DBConfig dbConfig) {
        int res = connectService.insertConnect(dbConfig);
        return R.success().data("res", res);
    }

    /**
     * TODO 数据库备份
     *
     * @param dbConfig 数据库配置
     */
    @RequestMapping("connect/backup")
    @ResponseBody
    public R backup(DBConfig dbConfig) {
        int res = connectService.updateConnect(dbConfig);
        return R.success().data("res", res);
    }

    // TODO 后续计划：
    // 1.查看备份文件
    // 2.下载备份文件
    // 3.添加定时任务自动备份文件
    // 4.日志监控(获取运行日志,下载日志..)
    // 5.性能分析(慢SQL查询,数据瓶颈...)
}
