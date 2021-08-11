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

    @Autowired
    private CollectionService collectionService;


    /************************* 收藏分类 *************************/

    @RequestMapping("/cat/goCatList")
    public String goCatList(CollectionCatBean collectionCatBean) {
        return "collection/collectioncatlist";
    }

    @RequestMapping("/cat/list")
    @ResponseBody
    public R catList(CollectionCatBean collectionCatBean) {
        collectionService.queryCollectionCatList(collectionCatBean);
        return R.success();
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(CollectionCatBean collectionCatBean) {
        collectionService.addCollectionCat(collectionCatBean);
        return R.success();
    }

    /************************* 收藏主表 *************************/

    @RequestMapping("/goList")
    public String goList(CollectionCatBean collectionCatBean) {
        return "collection/collectionlist";
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