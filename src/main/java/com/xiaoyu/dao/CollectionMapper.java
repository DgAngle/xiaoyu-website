package com.xiaoyu.dao;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.vo.basevo.CollectionQuery;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/11 9:27
 */
public interface CollectionMapper {

    /************************* 收藏分类 *************************/

    int queryCollectionCatListCount(CollectionCatBean collectionCatBean);

    List<CollectionCatBean> queryCollectionCatList(CollectionCatBean collectionCatBean);

    int addCollectionCat(CollectionCatBean collectionCatBean);

    CollectionCatBean queryCollectionCatDetailById(long collectionCatId);

    int updateCollectionCat(CollectionCatBean collectionCatBean);

    int deleteCollectionCatById(long collectionCatId);

    String queryParentCollectionCatNumById(long collectionCatId);

    String queryCollectionCatNumById(long parentCollectionCatId);

    String queryMaxCollectionCatNum(String parentCollectionCatNum);

    int queryCollectionCatByCollectionCatName(String collectionCatName);

    List<CollectionCatBean> queryAllCollectionCat();

    /************************* 收藏主表 *************************/

    int queryCollectionListCount(CollectionQuery collectionQuery);

    List<CollectionBean> queryCollectionList(CollectionQuery collectionQuery);

    int addCollection(CollectionBean collectionBean);

    CollectionBean queryCollectionDetailById(long collectionId);

    int updateCollection(CollectionBean collectionBean);

    int deleteCollectionById(long collectionId);
}
