package com.xiaoyu.service.impl;

import com.xiaoyu.dao.CollectionMapper;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/11 9:26
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    /************************* 收藏分类 *************************/
    @Override
    public List<CollectionCatBean> queryCollectionCatList(CollectionCatBean collectionCatBean) {
        return collectionMapper.queryCollectionCatList(collectionCatBean);
    }

    @Override
    public int addCollectionCat(CollectionCatBean collectionCatBean) {
        return collectionMapper.addCollectionCat(collectionCatBean);
    }

    /************************* 收藏主表 *************************/

    @Override
    public List<CollectionBean> queryCollectionList(CollectionBean collectionBean) {
        return collectionMapper.queryCollectionList(collectionBean);
    }

    @Override
    public int addCollection(CollectionBean collectionBean) {
        return collectionMapper.addCollection(collectionBean);
    }
}
