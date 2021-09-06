package com.xiaoyu.service.baseservice;

import com.xiaoyu.vo.basevo.SpendVo;
import com.xiaoyu.vo.topvo.CollectionTopVo;
import com.xiaoyu.vo.topvo.NoteTopVo;
import com.xiaoyu.vo.topvo.PlanTopVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:39
 */
public interface AdminService {
    List<CollectionTopVo> queryTopCollection();

    List<PlanTopVo> queryTopPlan();

    List<SpendVo> queryTopSpend();

    int completePlanById(long planId);

    BigDecimal queryTotalSpendMoney();

    List<NoteTopVo> queryTopNote();
}
