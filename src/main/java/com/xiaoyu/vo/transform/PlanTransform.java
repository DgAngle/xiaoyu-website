package com.xiaoyu.vo.transform;

import lombok.Data;

/**
 * 计划表转义
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 10:19
 */
@Data
public class PlanTransform {
    private String planId; // 计划主键
    private String planName; // 计划名称
    private String planCatId; // 计划分类
    private String planContent; // 计划内容
    private String planStartDt; // 计划开始时间
    private String planEndDt; // 计划结束时间
    private String status; // 执行状态
    private String planFinishedDt; // 计划完成时间
    private String updateDt; // 更新时间
    private String updateBy; // 更新人
    private String createDt; // 创建时间
    private String createBy; // 创建人
    private String remark; // 备注
}
