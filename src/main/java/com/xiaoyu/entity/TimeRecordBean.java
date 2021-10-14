package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 时间记录
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 13:40
 */
@Data
public class TimeRecordBean extends Pagination {
    private long timeRecordId; // 时间记录主键
    private String timeRecordName; // 时间记录名称
    private Date timeRecordDt; // 时间记录日期
    private String timeRecordAddress; // 记录地点
    private int spendTimeHour; // 用时小时
    private int spendTimeMin; // 用时分钟
    private Date createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
