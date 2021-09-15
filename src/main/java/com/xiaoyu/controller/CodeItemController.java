package com.xiaoyu.controller;

import com.xiaoyu.utils.ConstantUtil;
import com.xiaoyu.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 代码项
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/26 15:54
 */
@Controller
@RequestMapping("code")
public class CodeItemController {

    @RequestMapping("/statusList")
    @ResponseBody
    public R queryStatusList() {
        return R.success().data("statusMap", ConstantUtil.planMap);
    }

}
