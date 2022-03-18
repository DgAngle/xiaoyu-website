package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Transform;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.baseservice.CollectionService;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.CollectionQuery;
import com.xiaoyu.vo.transform.CollectionCatTransform;
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
        // LogUtils.getLog().info("接收参数：" + JSON.toJSON(collectionCatBean));
        ListResult<CollectionCatBean> listResult = collectionService.queryCollectionCatList(collectionCatBean);
        return R.success()
                .data("collectionCatList", listResult.getList())
                .data("pagination", listResult.getPagination());
        // return R.success().data("collectionCatList", collectionService.queryCollectionCatList(collectionCatBean));
    }

    @RequestMapping("/cat/add")
    @ResponseBody
    public R catAdd(CollectionCatTransform collectionCatTransform) {
        collectionService.addCollectionCat(new Transform<CollectionCatBean, CollectionCatTransform>().transformEntityStringToType(collectionCatTransform, new CollectionCatBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long collectionCatId) {
        return R.success().data("collectionCatDetail", collectionService.queryCollectionCatDetailById(collectionCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(CollectionCatTransform collectionCatTransform) {
        collectionService.updateCollectionCat(new Transform<CollectionCatBean, CollectionCatTransform>().transformEntityStringToType(collectionCatTransform, new CollectionCatBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long collectionCatId) {
        collectionService.deleteCollectionCatById(collectionCatId);
        return R.success().message("删除成功！");
    }

    // 笔记分类下拉树
    @RequestMapping("/cat/tree")
    @ResponseBody
    public R noteCatTree() {
        return R.success().data("collectionCatTree", collectionService.queryCollectionCatTreeJson());
    }

    /************************* 收藏主表 *************************/

    @RequestMapping("/goList")
    public String goList(CollectionCatBean collectionCatBean) {
        return this.collection_path + "/collectionlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(CollectionQuery collectionQuery) {
        ListResult<CollectionBean> listResult = collectionService.queryCollectionList(collectionQuery);
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
