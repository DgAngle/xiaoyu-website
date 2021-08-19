package com.xiaoyu.dao;

import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.entity.PlanCatBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 11:07
 */
public interface PlanMapper {

    /************************* 计划分类 *************************/

    List<PlanCatBean> queryPlanCatList(PlanCatBean planCatBean);

    int addPlanCat(PlanCatBean planCatBean);

    PlanCatBean queryPlanCatDetailById(long planCatId);

    int updatePlanCat(PlanCatBean planCatBean);

    int deletePlanCatById(long planCatId);

    /************************* 计划主表 *************************/

    int queryPlanListCount(PlanBean planBean);

    List<PlanBean> queryPlanList(PlanBean planBean);

    int addPlan(PlanBean planBean);

    PlanBean queryPlanDetailById(long planId);

    int updatePlan(PlanBean planBean);

    int deletePlanById(long planId);


}
