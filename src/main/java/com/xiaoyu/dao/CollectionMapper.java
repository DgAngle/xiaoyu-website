package com.xiaoyu.dao;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/11 9:27
 */
public interface CollectionMapper {

    /************************* 收藏分类 *************************/
    
    List<CollectionCatBean> queryCollectionCatList(CollectionCatBean collectionCatBean);

    int addCollectionCat(CollectionCatBean collectionCatBean);

    /************************* 收藏主表 *************************/

    List<CollectionBean> queryCollectionList(CollectionBean collectionBean);

    int addCollection(CollectionBean collectionBean);
}
