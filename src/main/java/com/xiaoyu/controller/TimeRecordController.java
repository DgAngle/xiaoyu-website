package com.xiaoyu.controller;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Transform;
import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.service.baseservice.TimeRecordService;
import com.xiaoyu.utils.DateUtil;
import com.xiaoyu.utils.R;
import com.xiaoyu.vo.basevo.TimeRecordQuery;
import com.xiaoyu.vo.transform.TimeRecordTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:11
 */
@Controller
@RequestMapping("/timeRecord")
public class TimeRecordController {
    private static final String time_record_path = "pagelist/timerecord";

    @Autowired
    private TimeRecordService timeRecordService;

    @RequestMapping("/goList")
    public String goList() {
        return this.time_record_path + "/timerecordlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(TimeRecordQuery timeRecordQuery) {
        // ListResult<TimeRecordBean> listResult = timeRecordService.queryTimeRecordList(new Transform<TimeRecordBean, TimeRecordTransform>().transformEntityStringToType(timeRecordTransform, new TimeRecordBean()));
        ListResult<TimeRecordBean> listResult = timeRecordService.queryTimeRecordList(timeRecordQuery);
        Map<String, Long> stringLongMap = timeRecordService.queryTotalTime(timeRecordQuery);
        return R.success()
                .data("timeRecordList", listResult.getList())
                .data("sumHour", stringLongMap.get("sumHour"))
                .data("sumMin", stringLongMap.get("sumMin"))
                .data("pagination", listResult.getPagination());
    }

    @RequestMapping("/add")
    @ResponseBody
    public R add(TimeRecordTransform timeRecordTransform) {
        // if (!DateUtil.isFormat(timeRecordTransform.getTimeRecordDt())) timeRecordTransform.setTimeRecordDt(timeRecordTransform.getTimeRecordDt() + " 00:00:00");
        timeRecordService.addTimeRecord(new Transform<TimeRecordBean, TimeRecordTransform>().transformEntityStringToType(timeRecordTransform, new TimeRecordBean()));
        return R.success().message("添加成功！");
    }

    @RequestMapping("/detail")
    @ResponseBody
    public R detail(long timeRecordId) {
        return R.success().data("timeRecordDetail", timeRecordService.queryTimeRecordDetailById(timeRecordId));
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(TimeRecordTransform timeRecordTransform) {
        if (!DateUtil.isFormat(timeRecordTransform.getTimeRecordDt())) timeRecordTransform.setTimeRecordDt(timeRecordTransform.getTimeRecordDt() + " 00:00:00");
        timeRecordService.updateTimeRecord(new Transform<TimeRecordBean, TimeRecordTransform>().transformEntityStringToType(timeRecordTransform, new TimeRecordBean()));
        return R.success().message("修改成功！");
    }

    @RequestMapping("/del")
    @ResponseBody
    public R del(long timeRecordId) {
        timeRecordService.deleteTimeRecordById(timeRecordId);
        return R.success().message("删除成功！");
    }
}
