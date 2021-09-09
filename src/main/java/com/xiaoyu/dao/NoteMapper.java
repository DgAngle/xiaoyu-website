package com.xiaoyu.dao;

import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.vo.basevo.NoteQuery;
import com.xiaoyu.vo.basevo.NoteVo;

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

    String queryParentNoteCatNumById(long noteCatId);

    String queryNoteCatNumById(long parentNoteCatId);

    List<NoteCatBean> queryAllNoteCat();

    /************** 笔记 **************/

    int queryNoteListCount(NoteQuery noteQuery);

    List<NoteBean> queryNoteList(NoteQuery noteQuery);

    int addNote(NoteBean noteBean);

    NoteVo queryNoteDetailById(long noteId);

    int updateNote(NoteBean noteBean);

    int deleteNoteById(long noteId);

}
