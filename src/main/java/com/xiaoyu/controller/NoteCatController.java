package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noteCat")
public class NoteCatController {

    @RequestMapping("noteCatList")
    public String goNoteCatList() {
        return "note/noteCatList";
    }

}
