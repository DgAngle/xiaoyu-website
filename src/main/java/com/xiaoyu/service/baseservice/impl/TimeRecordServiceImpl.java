package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.TimeRecordMapper;
import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.entity.TimeRecordBean;
import com.xiaoyu.service.baseservice.TimeRecordService;
import com.xiaoyu.utils.UserUtil;
import com.xiaoyu.vo.basevo.TimeRecordQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/14 15:12
 */
@Service
public class TimeRecordServiceImpl implements TimeRecordService {

    @Resource
    private TimeRecordMapper timeRecordMapper;

    @Override
    public ListResult<TimeRecordBean> queryTimeRecordList(TimeRecordQuery timeRecordQuery) {
        ListResult<TimeRecordBean> listResult = new ListResult<>();
        if (!UserUtil.isAdmin()) timeRecordQuery.setCreateBy(UserUtil.getUser().getUserId());
        int totalCount = timeRecordMapper.queryTimeRecordListCount(timeRecordQuery);
        if (totalCount > 0) listResult.setList(timeRecordMapper.queryTimeRecordList(timeRecordQuery));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(timeRecordQuery.getPageCount());
        pagination.setStart(timeRecordQuery.getStart());
        pagination.setCurrentPage(timeRecordQuery.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addTimeRecord(TimeRecordBean timeRecordBean) {
        Date date = new Date();
        timeRecordBean.setCreateDt(date);
        timeRecordBean.setCreateBy(UserUtil.getUser().getUserId());
        return timeRecordMapper.addTimeRecord(timeRecordBean);
    }

    @Override
    public TimeRecordBean queryTimeRecordDetailById(long timeRecordId) {
        return timeRecordMapper.queryTimeRecordDetailById(timeRecordId);
    }

    @Override
    public int updateTimeRecord(TimeRecordBean timeRecordBean) {
        return timeRecordMapper.updateTimeRecord(timeRecordBean);
    }

    @Override
    public int deleteTimeRecordById(long timeRecordId) {
        return timeRecordMapper.deleteTimeRecordById(timeRecordId);
    }

    @Override
    public Map<String, Long> queryTotalTime(TimeRecordQuery timeRecordQuery) {
        List<TimeRecordBean> timeRecordBeans = timeRecordMapper.queryTotalTime(timeRecordQuery);
        Map<String, Long> timeMap = new HashMap<>();
        timeMap.put("sumHour", 0L);
        timeMap.put("sumMin", 0L);
        if (timeRecordBeans != null) {
            timeRecordBeans.forEach(timeRecord -> {
                long sumHour = timeMap.get("sumHour") == null ? 0 : timeMap.get("sumHour");
                long sumMin = timeMap.get("sumMin") == null ? 0 : timeMap.get("sumMin");
                sumHour += timeRecord.getSpendTimeHour();
                sumMin += timeRecord.getSpendTimeMin();
                timeMap.put("sumHour", sumHour);
                timeMap.put("sumMin", sumMin);
            });
        }
        // 将分钟换算成小时
        long sumHour = timeMap.get("sumHour") == null ? 0 : timeMap.get("sumHour");
        long sumMin = timeMap.get("sumMin") == null ? 0 : timeMap.get("sumMin");
        sumHour += sumMin / 60;
        sumMin = sumMin % 60;
        timeMap.put("sumHour", sumHour);
        timeMap.put("sumMin", sumMin);

        // timeMap.get("sumHour") + "小时, " + timeMap.get("sumMin") + "分钟"
        return timeMap;
    }
}
