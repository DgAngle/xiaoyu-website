package com.xiaoyu.dao;

import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.entity.SpendCatBean;

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

    int querySpendListCount(SpendBean spendBean);

    List<SpendBean> querySpendList(SpendBean spendBean);

    int addSpend(SpendBean spendBean);

    SpendBean querySpendDetailById(long spendId);

    int updateSpend(SpendBean spendBean);

    int deleteSpendById(long spendId);
}
