package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.IncomeBean;
import com.xiaoyu.entity.IncomeCatBean;
import com.xiaoyu.vo.basevo.IncomeQuery;
import com.xiaoyu.vo.basevo.IncomeVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:48
 */
public interface IncomeService {
    /************************* 收入分类 *************************/

    List<IncomeCatBean> queryIncomeCatList(IncomeCatBean incomeCatBean);

    int addIncomeCat(IncomeCatBean incomeCatBean);

    IncomeCatBean queryIncomeCatDetailById(long incomeCatId);

    int updateIncomeCat(IncomeCatBean incomeCatBean);

    int deleteIncomeCatById(long incomeCatId);

    /************************* 收入主表 *************************/

    // ListResult<IncomeBean> queryIncomeList(IncomeBean incomeBean);

    ListResult<IncomeBean> queryIncomeList(IncomeQuery incomeQuery);

    int addIncome(IncomeBean incomeBean);

    IncomeVo queryIncomeDetailById(long incomeId);

    int updateIncome(IncomeBean incomeBean);

    int deleteIncomeById(long incomeId);

    // BigDecimal queryTotalIncomeMoney(IncomeBean incomeBean);

    BigDecimal queryTotalIncomeMoney(IncomeQuery incomeQuery);


}
