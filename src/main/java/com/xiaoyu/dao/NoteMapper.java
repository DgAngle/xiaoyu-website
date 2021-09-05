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

    /**
     * 获取根节点 笔记分类
     */
    List<NoteCatBean> queryNoteCatRoot();

    /**
     * 获取下一层节点 笔记分类
     *
     * @param parentNoteCatNum 父节点编号
     */
    List<NoteCatBean> queryNoteCatNextByNum(String parentNoteCatNum);

    NoteCatBean queryNoteCatDetailById(long noteCatId);

    int updateNoteCat(NoteCatBean noteCatBean);

    int deleteNoteCatById(long noteCatId);

    /************** 笔记 **************/

}
