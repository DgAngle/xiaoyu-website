package com.xiaoyu.service.baseservice;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/11 9:26
 */
public interface CollectionService {
    /************************* 收藏分类 *************************/

    ListResult<CollectionCatBean> queryCollectionCatList(CollectionCatBean collectionCatBean);

    int addCollectionCat(CollectionCatBean collectionCatBean);

    CollectionCatBean queryCollectionCatDetailById(long collectionCatId);

    int updateCollectionCat(CollectionCatBean collectionCatBean);

    int deleteCollectionCatById(long collectionCatId);

    List<JSONObject>  queryCollectionCatTreeJson();

    /************************* 收藏主表 *************************/

    ListResult<CollectionBean> queryCollectionList(CollectionBean collectionBean);

    int addCollection(CollectionBean collectionBean);

    CollectionBean queryCollectionDetailById(long collectionId);

    int updateCollection(CollectionBean collectionBean);

    int deleteCollectionById(long collectionId);

}
