package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.AdminMapper;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.service.baseservice.AdminService;
import com.xiaoyu.utils.ConstantUtil;
import com.xiaoyu.vo.topvo.CollectionTopVo;
import com.xiaoyu.vo.topvo.PlanTopVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:40
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<CollectionTopVo> queryTopCollection() {
        List<CollectionTopVo> collectionTopVos = new ArrayList<>();
        // 查询排序后的前4个收藏分类
        List<CollectionCatBean> collectionCatBeans = adminMapper.queryCollectionCatTop4();
        Optional.ofNullable(collectionCatBeans).orElse(new ArrayList<>()).forEach((collectionCat) -> {
            // 一个分类对应多个收藏
            collectionTopVos.add(new CollectionTopVo(collectionCat, adminMapper.queryCollectionTop5(collectionCat.getCollectionCatId())));
        });
        return collectionTopVos;
    }

    @Override
    public List<PlanTopVo> queryTopPlan() {
        List<PlanTopVo> planTopVos = new ArrayList<>();
        // 查询排序后的前2个计划分类
        List<PlanCatBean> planCatBeans = adminMapper.queryPlanCatTop2();
        Optional.ofNullable(planCatBeans).orElse(new ArrayList<>()).forEach((planCat) -> {
            // 一个分类对应多个收藏
            planTopVos.add(new PlanTopVo(planCat, adminMapper.queryPlanTop5(planCat.getPlanCatId())));
        });
        return planTopVos;
    }

    @Override
    public int completePlanById(long planId) {
        return adminMapper.updatePlanStatusById(ConstantUtil.plan_status_finished, planId);
    }
}
