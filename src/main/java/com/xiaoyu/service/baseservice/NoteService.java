package com.xiaoyu.service.baseservice;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.TreeNode;
import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.vo.basevo.NoteQuery;
import com.xiaoyu.vo.basevo.NoteVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoteService {

    /********************* 笔记分类 *********************/

    ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean);

    int addNoteCat(NoteCatBean noteCatBean);

    List<TreeNode> queryNoteCatTreeNode();

    List<JSONObject> queryNoteCatTreeJson();

    NoteCatBean queryNoteCatDetailById(long noteCatId);

    int updateNoteCat(NoteCatBean noteCatBean);

    int deleteNoteCatById(long noteCatId);


    /********************* 笔记主表 *********************/

    ListResult<NoteBean> queryNoteList(NoteQuery noteQuery);

    int addNote(NoteBean noteBean);

    NoteVo queryNoteDetailById(long noteId);
    
    NoteVo queryNoteDetailMdById(long noteId);

    int updateNote(NoteBean noteBean);

    int deleteNoteById(long noteId);

    JSONObject uploadImage(MultipartFile file);
}
