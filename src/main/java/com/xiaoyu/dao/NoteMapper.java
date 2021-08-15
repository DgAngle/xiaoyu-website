package com.xiaoyu.dao;

import com.xiaoyu.entity.NoteCatBean;

import java.util.List;

public interface NoteMapper {

    /************** 笔记分类 **************/

    int queryNoteCatListCount(NoteCatBean noteCatBean);

    List<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);

    int addNoteCat(NoteCatBean noteCatBean);

    String queryMaxNoteCatNum(String parentNoteCatNum);

    int queryNoteCatByNoteCatName(String noteCatName);

    /************** 笔记 **************/

}
