package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 计划主表
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 10:17
 */
@Data
public class PlanBean extends Pagination {
    private long planId; // 计划主键
    private String planName; // 计划名称
    private long planCatId; // 计划分类
    private String planContent; // 计划内容
    private Date planStartDt; // 计划开始时间
    private Date planEndDt; // 计划结束时间
    private int status; // 执行状态
    private Date planFinishedDt; // 计划完成时间
    private Date updateDt; // 更新时间
    private String updateBy; // 更新人
    private Date createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
