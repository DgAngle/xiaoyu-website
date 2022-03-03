package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/2/24 11:15
 */
@Controller
@RequestMapping("")
public class WebSocketController {
    private static final String websocket_path = "pagelist/websocket";

    @RequestMapping("/websocket/test")
    public String goTest() {
        System.out.println("Websocket测试");
        return this.websocket_path + "/test";
    }
}
