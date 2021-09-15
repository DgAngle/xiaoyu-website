package com.xiaoyu.dao;

import com.xiaoyu.entity.*;
import com.xiaoyu.vo.basevo.IncomeVo;
import com.xiaoyu.vo.basevo.SpendVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:40
 */
public interface AdminMapper {

    // 收藏
    List<CollectionCatBean> queryCollectionCatTop4();

    List<CollectionBean> queryCollectionTop5(long collectionCatId);

    // 计划
    // List<PlanCatBean> queryPlanCatTop3();
    List<PlanCatBean> queryPlanCatTop4();

    List<PlanBean> queryPlanTop5(long planCatId);

    int updatePlanStatusById(int status, long planId);

    // 消费
    List<SpendVo> querySpendTop5();

    BigDecimal queryTotalSpendMoney();

    // 收入
    List<IncomeVo> queryIncomeTop5();

    BigDecimal queryTotalIncomeMoney();

    // 笔记
    List<NoteCatBean> queryNoteCatTop4();

    List<NoteBean> queryNoteTop5(long noteCatId);
}
