package com.xiaoyu.vo.transform;

import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:29
 */
@Data
public class TimeRecordTransform {
    private String timeRecordId; // 时间记录主键
    private String timeRecordName; // 时间记录名称
    private String timeRecordDt; // 时间记录日期
    private String timeRecordAddress; // 记录地点
    private String spendTimeHour; // 用时小时
    private String spendTimeMin; // 用时分钟
    private String createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
