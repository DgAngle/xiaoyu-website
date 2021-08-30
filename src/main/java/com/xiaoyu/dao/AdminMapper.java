package com.xiaoyu.dao;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.entity.PlanCatBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:40
 */
public interface AdminMapper {

    List<CollectionCatBean> queryCollectionCatTop4();

    List<CollectionBean> queryCollectionTop5(long collectionCatId);

    List<PlanCatBean> queryPlanCatTop2();

    List<PlanBean> queryPlanTop5(long planCatId);

    int updatePlanStatusById(int status, long planId);
}
