package com.xiaoyu.vo.basevo;

import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.utils.DateUtil;
import lombok.Data;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/6 10:09
 */
@Data
public class NoteVo extends NoteBean {
    private String noteCatName;
    private String createDtStr;

    public String getCreateDtStr() {
        if (this.getCreateDt() != null) createDtStr = DateUtil.dateToString(this.getCreateDt());
        return createDtStr;
    }
}
