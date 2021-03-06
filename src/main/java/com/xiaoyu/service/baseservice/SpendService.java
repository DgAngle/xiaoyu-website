package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.entity.SpendCatBean;
import com.xiaoyu.vo.basevo.SpendQuery;
import com.xiaoyu.vo.basevo.SpendVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:48
 */
public interface SpendService {
    /************************* 消费分类 *************************/

    List<SpendCatBean> querySpendCatList(SpendCatBean spendCatBean);

    int addSpendCat(SpendCatBean spendCatBean);

    SpendCatBean querySpendCatDetailById(long spendCatId);

    int updateSpendCat(SpendCatBean spendCatBean);

    int deleteSpendCatById(long spendCatId);

    /************************* 消费主表 *************************/

    // ListResult<SpendBean> querySpendList(SpendBean spendBean);

    ListResult<SpendBean> querySpendList(SpendQuery spendQuery);

    int addSpend(SpendBean spendBean);

    SpendVo querySpendDetailById(long spendId);

    int updateSpend(SpendBean spendBean);

    int deleteSpendById(long spendId);

    // BigDecimal queryTotalSpendMoney(SpendBean spendBean);

    BigDecimal queryTotalSpendMoney(SpendQuery spendQuery);


}
