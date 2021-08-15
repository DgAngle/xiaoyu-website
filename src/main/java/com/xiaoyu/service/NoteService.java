package com.xiaoyu.service;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteCatBean;

public interface NoteService {

    ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);

    int addNoteCat(NoteCatBean noteCatBean);
}
