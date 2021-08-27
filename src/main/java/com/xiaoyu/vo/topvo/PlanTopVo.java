package com.xiaoyu.vo.topvo;

import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.vo.basevo.PlanVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:30
 */
@Data
@AllArgsConstructor
public class PlanTopVo extends PlanVo {
    private PlanCatBean planCat;
    private List<PlanBean> planList;
}
