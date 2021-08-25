package com.xiaoyu.vo.topvo;

import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.vo.basevo.PlanVo;
import lombok.Data;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:30
 */
@Data
public class PlanTopVo extends PlanVo {
    private PlanCatBean planCat;
    private PlanVo planVo;
    private List<PlanVo> planVoList;
}
