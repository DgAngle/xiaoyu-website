package com.xiaoyu.service.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.NoteCatMapper;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.NoteCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NoteCatServiceImpl implements NoteCatService {
    @Resource
    private NoteCatMapper noteCatMapper;

    /**
     * 查询笔记分类列表
     *
     * @param noteCatBean 笔记分类
     * @return 笔记分类列表
     */
    @Override
    public ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean) {
        ListResult<NoteCatBean> listResult = new ListResult<>();
        Pagination pagination = new Pagination();
        if (noteCatMapper.queryNoteCatListCount(noteCatBean) > 0) {
            listResult.setList(noteCatMapper.queryNoteCatList(noteCatBean));
        }
        listResult.setPagination(pagination);
        return listResult;
    }
}
