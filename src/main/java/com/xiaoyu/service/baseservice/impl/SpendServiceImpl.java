package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.SpendMapper;
import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.entity.SpendCatBean;
import com.xiaoyu.service.baseservice.SpendService;
import com.xiaoyu.utils.ConstantUtil;
import com.xiaoyu.vo.basevo.SpendQuery;
import com.xiaoyu.vo.basevo.SpendVo;
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
public class SpendServiceImpl implements SpendService {
    @Resource
    private SpendMapper spendMapper;

    /************************* 消费分类 *************************/
    @Override
    public List<SpendCatBean> querySpendCatList(SpendCatBean spendCatBean) {
        return spendMapper.querySpendCatList(spendCatBean);
    }

    @Override
    public int addSpendCat(SpendCatBean spendCatBean) {
        spendCatBean.setCreateDt(new Date());
        return spendMapper.addSpendCat(spendCatBean);
    }

    @Override
    public SpendCatBean querySpendCatDetailById(long spendCatId) {
        return spendMapper.querySpendCatDetailById(spendCatId);
    }

    @Override
    public int updateSpendCat(SpendCatBean spendCatBean) {
        return spendMapper.updateSpendCat(spendCatBean);
    }

    @Override
    public int deleteSpendCatById(long spendCatId) {
        return spendMapper.deleteSpendCatById(spendCatId);
    }

    /************************* 消费主表 *************************/

    @Override
    public ListResult<SpendBean> querySpendList(SpendQuery spendQuery) {
        ListResult<SpendBean> listResult = new ListResult<>();
        int totalCount = spendMapper.querySpendListCount(spendQuery);
        if (totalCount > 0) listResult.setList(spendMapper.querySpendList(spendQuery));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(spendQuery.getPageCount());
        pagination.setStart(spendQuery.getStart());
        pagination.setCurrentPage(spendQuery.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addSpend(SpendBean spendBean) {
        Date date = new Date();
        spendBean.setCreateDt(date);
        return spendMapper.addSpend(spendBean);
    }

    @Override
    public SpendVo querySpendDetailById(long spendId) {
        return spendMapper.querySpendDetailById(spendId);
    }

    @Override
    public int updateSpend(SpendBean spendBean) {
        return spendMapper.updateSpend(spendBean);
    }

    @Override
    public int deleteSpendById(long spendId) {
        return spendMapper.deleteSpendById(spendId);
    }

    @Override
    public BigDecimal queryTotalSpendMoney(SpendQuery spendQuery) {
        return spendMapper.queryTotalSpendMoney(spendQuery);
    }
}
