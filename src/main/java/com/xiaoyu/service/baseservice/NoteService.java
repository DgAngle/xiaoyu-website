package com.xiaoyu.service.baseservice;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.vo.basevo.NoteQuery;
import com.xiaoyu.vo.basevo.NoteVo;

import java.util.Map;

public interface NoteService {

    /********************* 笔记分类 *********************/

    ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);

    int addNoteCat(NoteCatBean noteCatBean);

    Map<String, NoteCatBean> queryNoteCatTree();

    NoteCatBean queryNoteCatDetailById(long noteCatId);

    int updateNoteCat(NoteCatBean noteCatBean);

    int deleteNoteCatById(long noteCatId);


    /********************* 笔记主表 *********************/

    ListResult<NoteBean> queryNoteList(NoteQuery noteQuery);

    int addNote(NoteBean noteBean);

    NoteVo queryNoteDetailById(long noteId);

    int updateNote(NoteBean noteBean);

    int deleteNoteById(long noteId);
}
