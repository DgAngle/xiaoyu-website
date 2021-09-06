package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Transform;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.baseservice.NoteService;
import com.xiaoyu.utils.R;
import com.xiaoyu.utils.RCode;
import com.xiaoyu.vo.basevo.NoteQuery;
import com.xiaoyu.vo.transform.NoteCatTransform;
import com.xiaoyu.vo.transform.NoteTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 笔记管理
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    private static final String note_path = "pagelist/note";
    private static final String note_cat_path = "pagelist/note";

    @Autowired
    private NoteService noteService;

    /***************** 笔记分类 *****************/

    // 进入笔记分类
    @RequestMapping("/cat/goList")
    public String goNoteCat() {
        return this.note_cat_path + "/notecatlist";
    }

    // 笔记分类列表查询
    @RequestMapping("/cat/list")
    @ResponseBody
    public R queryNoteCatList(NoteCatBean noteCatBean) {
        ListResult<NoteCatBean> listResult = noteService.queryNoteCatList(noteCatBean);
        return R.success()
                .data("noteCatList", listResult.getList())
                .data("pagination", listResult.getPagination());
    }

    // 笔记分类添加
    @RequestMapping("/cat/add")
    @ResponseBody
    public R addNoteCat(NoteCatTransform noteCatTransform) {
        int r = noteService.addNoteCat(new Transform<NoteCatBean, NoteCatTransform>().transformEntityStringToType(noteCatTransform, new NoteCatBean()));
        if (r == RCode.repeat_code) return R.error().message("笔记分类名称重复, 请重新输入！");
        return R.success().message("添加成功！");
    }

    @RequestMapping("/cat/detail")
    @ResponseBody
    public R catDetail(long noteCatId) {
        return R.success().data("noteCatDetail", noteService.queryNoteCatDetailById(noteCatId));
    }

    @RequestMapping("/cat/update")
    @ResponseBody
    public R catUpdate(NoteCatTransform noteCatTransform) {
        noteService.updateNoteCat(new Transform<NoteCatBean, NoteCatTransform>().transformEntityStringToType(noteCatTransform, new NoteCatBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/cat/del")
    @ResponseBody
    public R catDel(long noteCatId) {
        noteService.deleteNoteCatById(noteCatId);
        return R.success().message("删除成功！");
    }

    // 笔记分类下拉树
    @RequestMapping("/cat/tree")
    @ResponseBody
    public R noteCatTree() {
        return R.success().data("noteCatTree", noteService.queryNoteCatTree());
    }

    /***************** 笔记 *****************/

    @RequestMapping("/goList")
    public String goNoteList() {
        return this.note_path + "/notelist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(NoteQuery noteQuery) {
        ListResult<NoteBean> listResult = noteService.queryNoteList(noteQuery);
        return R.success()
                .data("noteList", listResult.getList())
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(NoteTransform noteTransform) {
        noteService.addNote(new Transform<NoteBean, NoteTransform>().transformEntityStringToType(noteTransform, new NoteBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long noteId) {
        return R.success().data("noteDetail", noteService.queryNoteDetailById(noteId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(NoteTransform noteTransform) {
        noteService.updateNote(new Transform<NoteBean, NoteTransform>().transformEntityStringToType(noteTransform, new NoteBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long noteId) {
        noteService.deleteNoteById(noteId);
        return R.success().message("删除成功！");
    }

}
