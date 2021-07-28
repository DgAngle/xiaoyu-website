package com.xiaoyu.dao;

import com.xiaoyu.entity.NoteCatBean;

import java.util.List;

public interface NoteCatMapper {
    int queryNoteCatListCount(NoteCatBean noteCatBean);

    List<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);
}
