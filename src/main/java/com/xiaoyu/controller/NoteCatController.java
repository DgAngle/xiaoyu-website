package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.NoteCatService;
import com.xiaoyu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/noteCat")
public class NoteCatController {

    @Autowired
    private NoteCatService noteCatService;

    // 进入笔记分类
    @RequestMapping("goNoteCat")
    public String goNoteCat() {
        return "note/noteCatList";
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
}
