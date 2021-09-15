package com.xiaoyu.dao;

import com.xiaoyu.entity.IncomeBean;
import com.xiaoyu.entity.IncomeCatBean;
import com.xiaoyu.vo.basevo.IncomeQuery;
import com.xiaoyu.vo.basevo.IncomeVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:50
 */
public interface IncomeMapper {

    /************************* 收入分类 *************************/

    List<IncomeCatBean> queryIncomeCatList(IncomeCatBean IncomeCatBean);

    int addIncomeCat(IncomeCatBean IncomeCatBean);

    IncomeCatBean queryIncomeCatDetailById(long IncomeCatId);

    int updateIncomeCat(IncomeCatBean IncomeCatBean);

    int deleteIncomeCatById(long IncomeCatId);

    /************************* 收入主表 *************************/

    // int queryIncomeListCount(IncomeBean IncomeBean);
    //
    // List<IncomeBean> queryIncomeList(IncomeBean IncomeBean);

    int queryIncomeListCount(IncomeQuery IncomeQuery);

    List<IncomeBean> queryIncomeList(IncomeQuery IncomeQuery);

    int addIncome(IncomeBean IncomeBean);

    IncomeVo queryIncomeDetailById(long IncomeId);

    int updateIncome(IncomeBean IncomeBean);

    int deleteIncomeById(long IncomeId);

    // BigDecimal queryTotalIncomeMoney(IncomeBean IncomeBean);

    BigDecimal queryTotalIncomeMoney(IncomeQuery IncomeQuery);
}
