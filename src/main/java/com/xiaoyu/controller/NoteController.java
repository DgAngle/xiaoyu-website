package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.NoteCatService;
import com.xiaoyu.utils.R;
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
    private NoteCatService noteCatService;

    /***************** 笔记分类 *****************/

    // 进入笔记分类
    @RequestMapping("goList")
    public String goNoteCat() {
        return this.note_cat_path + "/noteCatList";
    }

    // 笔记分类列表查询
    @RequestMapping("queryNoteCatList")
    @ResponseBody
    public R queryNoteCatList(NoteCatBean noteCatBean) {
        ListResult<NoteCatBean> listResult = noteCatService.queryNoteCatList(noteCatBean);

        return R.success()
                .data("noteCatList", listResult.getList())
                .data("pagination", listResult.getPagination());
    }

    /***************** 笔记 *****************/

    @RequestMapping("cat/goList")
    public String goNoteList() {
        return this.note_path + "/noteList";
    }
}
