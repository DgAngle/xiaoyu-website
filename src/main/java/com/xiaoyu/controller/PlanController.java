package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.PlanBean;
import com.xiaoyu.entity.PlanCatBean;
import com.xiaoyu.service.PlanService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/19 11:03
 */
@Controller
@RequestMapping("plan")
public class PlanController {
    private static final String plan_path = "pagelist/plan";
    private static final String plan_cat_path = "pagelist/plan";

    @Autowired
    private PlanService planService;

    /************************* 收藏分类 *************************/

    @RequestMapping("/cat/goList")
    public String goCatList(PlanCatBean planCatBean) {
        return this.plan_cat_path + "/plancatlist";
    }

    @RequestMapping("/cat/list")
    @ResponseBody
    public R catList(PlanCatBean planCatBean) {
        return R.success().data("planCatList", planService.queryPlanCatList(planCatBean));
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(PlanCatBean planCatBean) {
        planService.addPlanCat(planCatBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long planCatId) {
        return R.success().data("planCatDetail", planService.queryPlanCatDetailById(planCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(PlanCatBean planCatBean) {
        planService.updatePlanCat(planCatBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long planCatId) {
        planService.deletePlanCatById(planCatId);
        return R.success().message("删除成功！");
    }

    /************************* 收藏主表 *************************/

    @RequestMapping("/goList")
    public String goList(PlanCatBean planCatBean) {
        return this.plan_path + "/planlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(PlanBean planBean) {
        ListResult<PlanBean> listResult = planService.queryPlanList(planBean);
        return R.success()
                .data("planList", listResult.getList())
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(PlanBean planBean) {
        planService.addPlan(planBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long planId) {
        return R.success().data("planDetail", planService.queryPlanDetailById(planId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(PlanBean planBean) {
        planService.updatePlan(planBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long planId) {
        planService.deletePlanById(planId);
        return R.success().message("删除成功！");
    }
}
