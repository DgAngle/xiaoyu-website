package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.utils.ConstantUtil;
import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 11:24
 */
@Data
public class PlanVo extends PlanBean {
    private String planCatName; // 分类名称
    private String statusMessage; // 状态信息

    public String getStatusMessage() {
        return ConstantUtil.planMap.get(getStatus());
    }
}
