package com.xiaoyu.web.iot.bean;

import com.xiaoyu.entity.BaseBean;
import lombok.Data;

/**
 * 连接对象
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:21
 */
@Data
public class ConnectObject extends BaseBean {
    private int connObjId; // 连接对象Id
    private int connObjZhName; // 连接对象中文名称(别名)
    private int connObjEnName; // 连接对象英文名称
    private int connObjTypeId; // 连接对象类型
    private int connObjStatus; // 连接对象状态(0:离线,1:在线,2:重连中)
    // private int connObjIsEnable; // 连接对象是否启用(0未启用,1启用)
    private int connObjDesc; // 连接对象描述
}
