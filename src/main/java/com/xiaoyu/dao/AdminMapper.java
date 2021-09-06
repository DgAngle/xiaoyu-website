package com.xiaoyu.dao;

import com.xiaoyu.entity.*;
import com.xiaoyu.vo.basevo.SpendVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:40
 */
public interface AdminMapper {

    List<CollectionCatBean> queryCollectionCatTop4();

    List<CollectionBean> queryCollectionTop5(long collectionCatId);

    List<PlanCatBean> queryPlanCatTop3();

    List<PlanBean> queryPlanTop5(long planCatId);

    int updatePlanStatusById(int status, long planId);

    List<SpendVo> querySpendTop5();

    BigDecimal queryTotalSpendMoney();

    List<NoteCatBean> queryNoteCatTop4();

    List<NoteBean> queryNoteTop5(long noteCatId);
}
