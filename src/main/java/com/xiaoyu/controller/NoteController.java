package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 笔记管理
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    /**
     * 跳转 笔记列表
     *
     * @return
     */
    @RequestMapping("noteList")
    public String goNoteList() {
        return "note/noteList";
    }
}
