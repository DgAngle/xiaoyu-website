package com.xiaoyu.controller;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.CollectionService;
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

    /************************* 收藏主表 *************************/

    @RequestMapping("/goList")
    public String goList(CollectionCatBean collectionCatBean) {
        return this.collection_path + "/collectionlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(CollectionBean collectionBean) {
        collectionService.queryCollectionList(collectionBean);
        return R.success();
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(CollectionBean collectionBean) {
        collectionService.addCollection(collectionBean);
        return R.success();
    }
}
