package com.xiaoyu.service.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.CollectionMapper;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        collectionCatBean.setCreateDt(new Date());
        return collectionMapper.addCollectionCat(collectionCatBean);
    }

    @Override
    public CollectionCatBean queryCollectionCatDetailById(long collectionCatId) {
        return collectionMapper.queryCollectionCatDetailById(collectionCatId);
    }

    @Override
    public int updateCollectionCat(CollectionCatBean collectionCatBean) {
        return collectionMapper.updateCollectionCat(collectionCatBean);
    }

    @Override
    public int deleteCollectionCatById(long collectionCatId) {
        return collectionMapper.deleteCollectionCatById(collectionCatId);
    }

    /************************* 收藏主表 *************************/

    @Override
    public ListResult<CollectionBean> queryCollectionList(CollectionBean collectionBean) {
        ListResult<CollectionBean> listResult = new ListResult<>();
        int totalCount = collectionMapper.queryCollectionListCount(collectionBean);
        if (totalCount > 0) listResult.setList(collectionMapper.queryCollectionList(collectionBean));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(collectionBean.getPageCount());
        pagination.setStart(collectionBean.getStart());
        pagination.setCurrentPage(collectionBean.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addCollection(CollectionBean collectionBean) {
        collectionBean.setCreateDt(new Date());
        return collectionMapper.addCollection(collectionBean);
    }

    @Override
    public CollectionBean queryCollectionDetailById(long collectionId) {
        return collectionMapper.queryCollectionDetailById(collectionId);
    }

    @Override
    public int updateCollection(CollectionBean collectionBean) {
        return collectionMapper.updateCollection(collectionBean);
    }

    @Override
    public int deleteCollectionById(long collectionId) {
        return collectionMapper.deleteCollectionById(collectionId);
    }
}
