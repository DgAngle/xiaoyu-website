package com.xiaoyu.service;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteCatBean;

public interface NoteCatService {

    ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);
}
