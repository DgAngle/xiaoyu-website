package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.PlanMapper;
import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.service.baseservice.PlanService;
import com.xiaoyu.utils.ConstantUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 11:06
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanMapper planMapper;

    /************************* 计划分类 *************************/
    @Override
    public List<PlanCatBean> queryPlanCatList(PlanCatBean planCatBean) {
        return planMapper.queryPlanCatList(planCatBean);
    }

    @Override
    public int addPlanCat(PlanCatBean planCatBean) {
        planCatBean.setCreateDt(new Date());
        return planMapper.addPlanCat(planCatBean);
    }

    @Override
    public PlanCatBean queryPlanCatDetailById(long planCatId) {
        return planMapper.queryPlanCatDetailById(planCatId);
    }

    @Override
    public int updatePlanCat(PlanCatBean planCatBean) {
        return planMapper.updatePlanCat(planCatBean);
    }

    @Override
    public int deletePlanCatById(long planCatId) {
        return planMapper.deletePlanCatById(planCatId);
    }

    /************************* 计划主表 *************************/

    @Override
    public ListResult<PlanBean> queryPlanList(PlanBean planBean) {
        ListResult<PlanBean> listResult = new ListResult<>();
        int totalCount = planMapper.queryPlanListCount(planBean);
        if (totalCount > 0) listResult.setList(planMapper.queryPlanList(planBean));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(planBean.getPageCount());
        pagination.setStart(planBean.getStart());
        pagination.setCurrentPage(planBean.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addPlan(PlanBean planBean) {
        Date date = new Date();
        planBean.setCreateDt(date);
        planBean.setUpdateDt(date);
        planBean.setStatus(ConstantUtil.plan_status_not_start);
        return planMapper.addPlan(planBean);
    }

    @Override
    public PlanBean queryPlanDetailById(long planId) {
        return planMapper.queryPlanDetailById(planId);
    }

    @Override
    public int updatePlan(PlanBean planBean) {
        return planMapper.updatePlan(planBean);
    }

    @Override
    public int deletePlanById(long planId) {
        return planMapper.deletePlanById(planId);
    }
}
