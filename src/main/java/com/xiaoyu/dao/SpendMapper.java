package com.xiaoyu.dao;

import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.entity.SpendCatBean;
import com.xiaoyu.vo.basevo.SpendQuery;
import com.xiaoyu.vo.basevo.SpendVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:50
 */
public interface SpendMapper {

    /************************* 消费分类 *************************/

    List<SpendCatBean> querySpendCatList(SpendCatBean spendCatBean);

    int addSpendCat(SpendCatBean spendCatBean);

    SpendCatBean querySpendCatDetailById(long spendCatId);

    int updateSpendCat(SpendCatBean spendCatBean);

    int deleteSpendCatById(long spendCatId);

    /************************* 消费主表 *************************/

    // int querySpendListCount(SpendBean spendBean);
    //
    // List<SpendBean> querySpendList(SpendBean spendBean);

    int querySpendListCount(SpendQuery spendQuery);

    List<SpendBean> querySpendList(SpendQuery spendQuery);

    int addSpend(SpendBean spendBean);

    SpendVo querySpendDetailById(long spendId);

    int updateSpend(SpendBean spendBean);

    int deleteSpendById(long spendId);

    // BigDecimal queryTotalSpendMoney(SpendBean spendBean);

    BigDecimal queryTotalSpendMoney(SpendQuery spendQuery);
}
