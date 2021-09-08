package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Transform;
import com.xiaoyu.entity.IncomeBean;
import com.xiaoyu.entity.IncomeCatBean;
import com.xiaoyu.service.baseservice.IncomeService;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.IncomeQuery;
import com.xiaoyu.vo.transform.IncomeTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:46
 */
@Controller
@RequestMapping("/income")
public class IncomeController {
    private static final String income_path = "pagelist/income";
    private static final String income_cat_path = "pagelist/income";

    @Autowired
    private IncomeService incomeService;

    /************************* 收入分类 *************************/

    @RequestMapping("/cat/goList")
    public String goCatList(IncomeCatBean incomeCatBean) {
        return this.income_cat_path + "/incomecatlist";
    }

    @RequestMapping("/cat/list")
    @ResponseBody
    public R catList(IncomeCatBean incomeCatBean) {
        return R.success().data("incomeCatList", incomeService.queryIncomeCatList(incomeCatBean));
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(IncomeCatBean incomeCatBean) {
        incomeService.addIncomeCat(incomeCatBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long incomeCatId) {
        return R.success().data("incomeCatDetail", incomeService.queryIncomeCatDetailById(incomeCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(IncomeCatBean incomeCatBean) {
        incomeService.updateIncomeCat(incomeCatBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long incomeCatId) {
        incomeService.deleteIncomeCatById(incomeCatId);
        return R.success().message("删除成功！");
    }

    /************************* 收入主表 *************************/

    @RequestMapping("/goList")
    public String goList(IncomeCatBean incomeCatBean) {
        return this.income_path + "/incomelist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(IncomeQuery incomeQuery) {
        // ListResult<IncomeBean> listResult = incomeService.queryIncomeList(new Transform<IncomeBean, IncomeTransform>().transformEntityStringToType(incomeTransform, new IncomeBean()));
        ListResult<IncomeBean> listResult = incomeService.queryIncomeList(incomeQuery);
        return R.success()
                .data("incomeList", listResult.getList())
                .data("totalIncomeMoney", incomeService.queryTotalIncomeMoney(incomeQuery))
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(IncomeTransform incomeTransform) {
        if (!DateUtil.isFormat(incomeTransform.getIncomeDate())) incomeTransform.setIncomeDate(incomeTransform.getIncomeDate() + ":00");
        incomeService.addIncome(new Transform<IncomeBean, IncomeTransform>().transformEntityStringToType(incomeTransform, new IncomeBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long incomeId) {
        return R.success().data("incomeDetail", incomeService.queryIncomeDetailById(incomeId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(IncomeTransform incomeTransform) {
        if (!DateUtil.isFormat(incomeTransform.getIncomeDate())) incomeTransform.setIncomeDate(incomeTransform.getIncomeDate() + ":00");
        incomeService.updateIncome(new Transform<IncomeBean, IncomeTransform>().transformEntityStringToType(incomeTransform, new IncomeBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long incomeId) {
        incomeService.deleteIncomeById(incomeId);
        return R.success().message("删除成功！");
    }
}
