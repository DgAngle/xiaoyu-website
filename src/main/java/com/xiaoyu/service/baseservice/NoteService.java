package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteCatBean;

import java.util.Map;

public interface NoteService {

    ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);

    int addNoteCat(NoteCatBean noteCatBean);

    Map<String, NoteCatBean> queryNoteCatTree();
}
