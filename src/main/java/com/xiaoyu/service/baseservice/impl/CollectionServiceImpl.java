package com.xiaoyu.service.baseservice.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.CollectionMapper;
import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.service.baseservice.CollectionService;
import com.xiaoyu.utils.RCode;
import com.xiaoyu.utils.StringUtil;
import com.xiaoyu.utils.UserUtil;
import com.xiaoyu.vo.basevo.CollectionQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    public ListResult<CollectionCatBean> queryCollectionCatList(CollectionCatBean collectionCatBean) {
        // return collectionMapper.queryCollectionCatList(collectionCatBean);
        if (!UserUtil.isAdmin()) collectionCatBean.setCreateBy(UserUtil.getUser().getUserId());
        ListResult<CollectionCatBean> listResult = new ListResult<>();
        int totalCount = collectionMapper.queryCollectionCatListCount(collectionCatBean);
        if (totalCount > 0) listResult.setList(collectionMapper.queryCollectionCatList(collectionCatBean));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(collectionCatBean.getPageCount());
        pagination.setStart(collectionCatBean.getStart());
        pagination.setCurrentPage(collectionCatBean.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addCollectionCat(CollectionCatBean collectionCatBean) {
        // 查重
        if (collectionMapper.queryCollectionCatByCollectionCatName(collectionCatBean.getCollectionCatName()) > 0) return RCode.repeat_code;
        collectionCatBean.setParentCollectionCatNum(collectionMapper.queryCollectionCatNumById(collectionCatBean.getParentCollectionCatId()));
        collectionCatBean.setCollectionCatNum(getCollectionCatNum(collectionCatBean.getParentCollectionCatNum()));
        collectionCatBean.setCreateDt(new Date());
        collectionCatBean.setCreateBy(UserUtil.getUser().getUserId());
        return collectionMapper.addCollectionCat(collectionCatBean);
    }

    @Override
    public CollectionCatBean queryCollectionCatDetailById(long collectionCatId) {
        return collectionMapper.queryCollectionCatDetailById(collectionCatId);
    }

    @Override
    public int updateCollectionCat(CollectionCatBean collectionCatBean) {
        collectionCatBean.setParentCollectionCatNum(collectionMapper.queryCollectionCatNumById(collectionCatBean.getParentCollectionCatId()));
        // 如果父级分类发生变化,重新生成编号
        String queryParentNum = collectionMapper.queryParentCollectionCatNumById(collectionCatBean.getCollectionCatId());
        String parentNum = collectionCatBean.getParentCollectionCatNum() == null ? "" : collectionCatBean.getParentCollectionCatNum();
        if (!queryParentNum.equals(parentNum)) {
            collectionCatBean.setCollectionCatNum(getCollectionCatNum(collectionCatBean.getParentCollectionCatNum()));
        }
        return collectionMapper.updateCollectionCat(collectionCatBean);
    }

    @Override
    public int deleteCollectionCatById(long collectionCatId) {
        return collectionMapper.deleteCollectionCatById(collectionCatId);
    }

    /**
     * 收藏分类下拉树
     */
    @Override
    public List<JSONObject> queryCollectionCatTreeJson() {
        List<JSONObject> treeNodeList = new ArrayList<>();
        Map<String, JSONObject> map = new HashMap<>();
        // 获取所有分类
        List<CollectionCatBean> collectionCatBeans = collectionMapper.queryAllCollectionCat();
        Optional.ofNullable(collectionCatBeans).orElse(new ArrayList<>()).forEach((collectionCat) -> {
            // 创建节点
            JSONObject node = StringUtil.createNode(String.valueOf(collectionCat.getCollectionCatId()), collectionCat.getCollectionCatName(), null);
            // 如果存在相同的父节点
            if (map.containsKey(collectionCat.getParentCollectionCatNum())) {
                // 如果子节点为空, 创建子节点
                if (map.get(collectionCat.getParentCollectionCatNum()).getJSONArray("children") == null) map.get(collectionCat.getParentCollectionCatNum()).put("children", new JSONArray());
                // 将分类点加到子节点
                map.get(collectionCat.getParentCollectionCatNum()).getJSONArray("children").add(node);
            } else treeNodeList.add(node);
            map.put(collectionCat.getCollectionCatNum(), node);
        });
        return treeNodeList;
    }

    /**
     * 获取同一父级分类下的最大编号
     *
     * @param parentCollectionCatNum 父分类编号
     * @return 要插入的分类编号
     */
    public String getCollectionCatNum(String parentCollectionCatNum) {
        parentCollectionCatNum = parentCollectionCatNum == null ? "" : parentCollectionCatNum;
        // 获取最大 子分类编号
        String maxNotCatNum = collectionMapper.queryMaxCollectionCatNum(parentCollectionCatNum);

        return StringUtil.getCatNum(parentCollectionCatNum, maxNotCatNum);
    }

    /************************* 收藏主表 *************************/

    @Override
    public ListResult<CollectionBean> queryCollectionList(CollectionQuery collectionQuery) {
        if (!UserUtil.isAdmin()) collectionQuery.setCreateBy(UserUtil.getUser().getUserId());
        ListResult<CollectionBean> listResult = new ListResult<>();
        int totalCount = collectionMapper.queryCollectionListCount(collectionQuery);
        if (totalCount > 0) listResult.setList(collectionMapper.queryCollectionList(collectionQuery));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(collectionQuery.getPageCount());
        pagination.setStart(collectionQuery.getStart());
        pagination.setCurrentPage(collectionQuery.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addCollection(CollectionBean collectionBean) {
        collectionBean.setCreateDt(new Date());
        collectionBean.setCreateBy(UserUtil.getUser().getUserId());
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
