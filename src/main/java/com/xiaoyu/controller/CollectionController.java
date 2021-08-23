package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.baseservice.CollectionService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/11 9:24
 */
@Controller
@RequestMapping("/collect")
public class CollectionController {

    private static final String collection_path = "pagelist/collection";
    private static final String collection_cat_path = "pagelist/collection";

    @Autowired
    private CollectionService collectionService;


    /************************* 收藏分类 *************************/

    @RequestMapping("/cat/goList")
    public String goCatList(CollectionCatBean collectionCatBean) {
        return this.collection_cat_path + "/collectioncatlist";
    }

    @RequestMapping("/cat/list")
    @ResponseBody
    public R catList(CollectionCatBean collectionCatBean) {
        return R.success().data("collectionCatList", collectionService.queryCollectionCatList(collectionCatBean));
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(CollectionCatBean collectionCatBean) {
        collectionService.addCollectionCat(collectionCatBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long collectionCatId) {
        return R.success().data("collectionCatDetail", collectionService.queryCollectionCatDetailById(collectionCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(CollectionCatBean collectionCatBean) {
        collectionService.updateCollectionCat(collectionCatBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long collectionCatId) {
        collectionService.deleteCollectionCatById(collectionCatId);
        return R.success().message("删除成功！");
    }


    /************************* 收藏主表 *************************/

    @RequestMapping("/goList")
    public String goList(CollectionCatBean collectionCatBean) {
        return this.collection_path + "/collectionlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(CollectionBean collectionBean) {
        ListResult<CollectionBean> listResult = collectionService.queryCollectionList(collectionBean);
        return R.success()
                .data("collectionList", listResult.getList())
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(CollectionBean collectionBean) {
        collectionService.addCollection(collectionBean);
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long collectionId) {
        return R.success().data("collectionDetail", collectionService.queryCollectionDetailById(collectionId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(CollectionBean collectionBean) {
        collectionService.updateCollection(collectionBean);
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long collectionId) {
        collectionService.deleteCollectionById(collectionId);
        return R.success().message("删除成功！");
    }
}
