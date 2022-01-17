package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.AdminMapper;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.service.baseservice.AdminService;
import com.xiaoyu.utils.ConstantUtil;
import com.xiaoyu.utils.UserUtil;
import com.xiaoyu.vo.basevo.IncomeVo;
import com.xiaoyu.vo.basevo.SpendVo;
import com.xiaoyu.vo.topvo.CollectionTopVo;
import com.xiaoyu.vo.topvo.NoteTopVo;
import com.xiaoyu.vo.topvo.PlanTopVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
        if (UserUtil.isAdmin()) {
            Optional.ofNullable(adminMapper.queryCollectionCatTop4()).orElse(new ArrayList<>()).forEach((collectionCat) -> {
                // 一个分类对应多个收藏
                collectionTopVos.add(new CollectionTopVo(collectionCat, adminMapper.queryCollectionTop5(collectionCat.getCollectionCatId())));
            });
            return collectionTopVos;
        }
        String userId = UserUtil.getUser().getUserId();
        Optional.ofNullable(adminMapper.queryCollectionCatTop4ByUserId(userId)).orElse(new ArrayList<>()).forEach((collectionCat) -> {
            // 一个分类对应多个收藏
            collectionTopVos.add(new CollectionTopVo(collectionCat, adminMapper.queryCollectionTop5ByUserId(collectionCat.getCollectionCatId(), userId)));
        });
        return collectionTopVos;
    }

    @Override
    public List<PlanTopVo> queryTopPlan() {
        List<PlanTopVo> planTopVos = new ArrayList<>();
        // 查询排序后的前2个计划分类
        if (UserUtil.isAdmin()) {
            // List<PlanCatBean> planCatBeans = adminMapper.queryPlanCatTop3();
            Optional.ofNullable(adminMapper.queryPlanCatTop4()).orElse(new ArrayList<>()).forEach((planCat) -> {
                // 一个分类对应多个收藏
                planTopVos.add(new PlanTopVo(planCat, adminMapper.queryPlanTop5(planCat.getPlanCatId())));
            });
            return planTopVos;
        }
        // 非超级管理员
        String userId = UserUtil.getUser().getUserId();
        Optional.ofNullable(adminMapper.queryPlanCatTop4ByUserId(userId)).orElse(new ArrayList<>()).forEach((planCat) -> {
            // 一个分类对应多个收藏
            planTopVos.add(new PlanTopVo(planCat, adminMapper.queryPlanTop5ByUserId(planCat.getPlanCatId(), userId)));
        });
        return planTopVos;
    }

    @Override
    public List<SpendVo> queryTopSpend() {
        if (UserUtil.isAdmin()) return adminMapper.querySpendTop5();
        return adminMapper.querySpendTop5ByUserId(UserUtil.getUser().getUserId());
    }

    @Override
    public BigDecimal queryTotalSpendMoney() {
        if (UserUtil.isAdmin()) return adminMapper.queryTotalSpendMoney();
        return adminMapper.queryTotalSpendMoneyByUserId(UserUtil.getUser().getUserId());
    }

    @Override
    public int completePlanById(long planId) {
        return adminMapper.updatePlanStatusById(ConstantUtil.plan_status_finished, planId);
    }

    @Override
    public int updatePlanStatusById(long planId, int status) {
        return adminMapper.updatePlanStatusById(status, planId);
    }

    @Override
    public List<IncomeVo> queryTopIncome() {
        if (UserUtil.isAdmin()) return adminMapper.queryIncomeTop5();
        return adminMapper.queryIncomeTop5ByUserId(UserUtil.getUser().getUserId());
    }

    @Override
    public BigDecimal queryTotalIncomeMoney() {
        if (UserUtil.isAdmin()) return adminMapper.queryTotalIncomeMoney();
        return adminMapper.queryTotalIncomeMoneyByUserId(UserUtil.getUser().getUserId());
    }

    @Override
    public List<NoteTopVo> queryTopNote() {
        List<NoteTopVo> noteTopVos = new ArrayList<>();
        // 查询排序后的前4个笔记分类
        if (UserUtil.isAdmin()) {
            Optional.ofNullable(adminMapper.queryNoteCatTop4()).orElse(new ArrayList<>()).forEach((noteCat) -> {
                // 一个分类对应多个笔记
                noteTopVos.add(new NoteTopVo(noteCat, adminMapper.queryNoteTop5(noteCat.getNoteCatId())));
            });
            return noteTopVos;
        }
        // 非超级管理员
        String userId = UserUtil.getUser().getUserId();
        Optional.ofNullable(adminMapper.queryNoteCatTop4ByUserId(userId)).orElse(new ArrayList<>()).forEach((noteCat) -> {
            // 一个分类对应多个笔记
            noteTopVos.add(new NoteTopVo(noteCat, adminMapper.queryNoteTop5ByUserId(noteCat.getNoteCatId(), userId)));
        });
        return noteTopVos;
    }
}
