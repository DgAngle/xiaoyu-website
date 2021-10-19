package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Transform;
import com.xiaoyu.entity.SpendBean;
import com.xiaoyu.entity.SpendCatBean;
import com.xiaoyu.entity.SpendChildBean;
import com.xiaoyu.service.baseservice.SpendService;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.SpendChildQuery;
import com.xiaoyu.vo.basevo.SpendQuery;
import com.xiaoyu.vo.transform.SpendChildTransform;
import com.xiaoyu.vo.transform.SpendTransform;
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
@RequestMapping("/spend")
public class SpendController {
    private static final String spend_path = "pagelist/spend";
    private static final String spend_cat_path = "pagelist/spend";

    @Autowired
    private SpendService spendService;

    /************************* 消费分类 *************************/

    @RequestMapping("/cat/goList")
    public String goCatList(SpendCatBean spendCatBean) {
        return this.spend_cat_path + "/spendcatlist";
    }

    @RequestMapping("/cat/list")
    @ResponseBody
    public R catList(SpendCatBean spendCatBean) {
        return R.success().data("spendCatList", spendService.querySpendCatList(spendCatBean));
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(SpendCatBean spendCatBean) {
        spendService.addSpendCat(spendCatBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long spendCatId) {
        return R.success().data("spendCatDetail", spendService.querySpendCatDetailById(spendCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(SpendCatBean spendCatBean) {
        spendService.updateSpendCat(spendCatBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long spendCatId) {
        spendService.deleteSpendCatById(spendCatId);
        return R.success().message("删除成功！");
    }

    /************************* 消费主表 *************************/

    @RequestMapping("/goList")
    public String goList(SpendCatBean spendCatBean) {
        return this.spend_path + "/spendlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(SpendQuery spendQuery) {
        // ListResult<SpendBean> listResult = spendService.querySpendList(new Transform<SpendBean, SpendTransform>().transformEntityStringToType(spendTransform, new SpendBean()));
        ListResult<SpendBean> listResult = spendService.querySpendList(spendQuery);
        return R.success()
                .data("spendList", listResult.getList())
                .data("totalSpendMoney", spendService.queryTotalSpendMoney(spendQuery))
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(SpendTransform spendTransform) {
        if (!DateUtil.isFormat(spendTransform.getSpendDate())) spendTransform.setSpendDate(spendTransform.getSpendDate() + ":00");
        spendService.addSpend(new Transform<SpendBean, SpendTransform>().transformEntityStringToType(spendTransform, new SpendBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long spendId) {
        return R.success().data("spendDetail", spendService.querySpendDetailById(spendId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(SpendTransform spendTransform) {
        if (!DateUtil.isFormat(spendTransform.getSpendDate())) spendTransform.setSpendDate(spendTransform.getSpendDate() + ":00");
        spendService.updateSpend(new Transform<SpendBean, SpendTransform>().transformEntityStringToType(spendTransform, new SpendBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long spendId) {
        spendService.deleteSpendById(spendId);
        return R.success().message("删除成功！");
    }

    /************************* 子消费表 *************************/

    @RequestMapping("/childList")
    @ResponseBody
    public R childList(SpendChildQuery spendChildQuery) {
        ListResult<SpendChildBean> listResult = spendService.querySpendChildList(spendChildQuery);
        return R.success()
                .data("spendChildList", listResult.getList())
                .data("totalSpendChildMoney", spendService.queryTotalSpendChildMoney(spendChildQuery))
                .data("paginationChild", listResult.getPagination());
    }

    @RequestMapping("/addChild")
    @ResponseBody
    public R addChild(SpendChildTransform spendChildTransform) {
        if (!DateUtil.isFormat(spendChildTransform.getSpendChildDate())) spendChildTransform.setSpendChildDate(spendChildTransform.getSpendChildDate() + ":00");
        spendService.addSpendChild(new Transform<SpendChildBean, SpendChildTransform>().transformEntityStringToType(spendChildTransform, new SpendChildBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detailChild")
    @ResponseBody
    public R detailChild(long spendChildId) {
        return R.success().data("spendDetail", spendService.querySpendChildDetailById(spendChildId));
    }

    @RequestMapping("/updateChild")
    @ResponseBody
    public R updateChild(SpendChildTransform spendChildTransform) {
        if (!DateUtil.isFormat(spendChildTransform.getSpendChildDate())) spendChildTransform.setSpendChildDate(spendChildTransform.getSpendChildDate() + ":00");
        spendService.updateSpendChild(new Transform<SpendChildBean, SpendChildTransform>().transformEntityStringToType(spendChildTransform, new SpendChildBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/delChild")
    @ResponseBody
    public R delChild(long spendChildId) {
        spendService.deleteSpendChildById(spendChildId);
        return R.success().message("删除成功！");
    }
}
