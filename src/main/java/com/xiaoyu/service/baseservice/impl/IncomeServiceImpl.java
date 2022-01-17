package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.IncomeMapper;
import com.xiaoyu.entity.IncomeBean;
import com.xiaoyu.entity.IncomeCatBean;
import com.xiaoyu.service.baseservice.IncomeService;
import com.xiaoyu.utils.UserUtil;
import com.xiaoyu.vo.basevo.IncomeQuery;
import com.xiaoyu.vo.basevo.IncomeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:48
 */
@Service
public class IncomeServiceImpl implements IncomeService {
    @Resource
    private IncomeMapper incomeMapper;

    @Override
    public List<IncomeCatBean> queryIncomeCatList(IncomeCatBean incomeCatBean) {
        if (!UserUtil.isAdmin()) incomeCatBean.setCreateBy(UserUtil.getUser().getUserId());
        return incomeMapper.queryIncomeCatList(incomeCatBean);
    }

    @Override
    public int addIncomeCat(IncomeCatBean incomeCatBean) {
        incomeCatBean.setCreateDt(new Date());
        incomeCatBean.setCreateBy(UserUtil.getUser().getUserId());
        return incomeMapper.addIncomeCat(incomeCatBean);
    }

    @Override
    public IncomeCatBean queryIncomeCatDetailById(long incomeCatId) {
        return incomeMapper.queryIncomeCatDetailById(incomeCatId);
    }

    @Override
    public int updateIncomeCat(IncomeCatBean incomeCatBean) {
        return incomeMapper.updateIncomeCat(incomeCatBean);
    }

    @Override
    public int deleteIncomeCatById(long incomeCatId) {
        return incomeMapper.deleteIncomeCatById(incomeCatId);
    }

    /************************* 收入主表 *************************/

    @Override
    public ListResult<IncomeBean> queryIncomeList(IncomeQuery incomeQuery) {
        ListResult<IncomeBean> listResult = new ListResult<>();
        if (!UserUtil.isAdmin()) incomeQuery.setCreateBy(UserUtil.getUser().getUserId());
        int totalCount = incomeMapper.queryIncomeListCount(incomeQuery);
        if (totalCount > 0) listResult.setList(incomeMapper.queryIncomeList(incomeQuery));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(incomeQuery.getPageCount());
        pagination.setStart(incomeQuery.getStart());
        pagination.setCurrentPage(incomeQuery.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addIncome(IncomeBean incomeBean) {
        Date date = new Date();
        incomeBean.setCreateDt(date);
        incomeBean.setCreateBy(UserUtil.getUser().getUserId());
        return incomeMapper.addIncome(incomeBean);
    }

    @Override
    public IncomeVo queryIncomeDetailById(long incomeId) {
        return incomeMapper.queryIncomeDetailById(incomeId);
    }

    @Override
    public int updateIncome(IncomeBean incomeBean) {
        return incomeMapper.updateIncome(incomeBean);
    }

    @Override
    public int deleteIncomeById(long incomeId) {
        return incomeMapper.deleteIncomeById(incomeId);
    }

    @Override
    public BigDecimal queryTotalIncomeMoney(IncomeQuery incomeQuery) {
        return incomeMapper.queryTotalIncomeMoney(incomeQuery);
    }
}
