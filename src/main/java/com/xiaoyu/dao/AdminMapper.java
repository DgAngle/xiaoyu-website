package com.xiaoyu.dao;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:40
 */
public interface AdminMapper {

    List<CollectionCatBean> queryCollectionCatTop4();

    List<CollectionBean> queryCollectionTop5(long collectionCatId);
}
