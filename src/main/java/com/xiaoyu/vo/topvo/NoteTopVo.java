package com.xiaoyu.vo.topvo;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/6 10:53
 */
@Data
@AllArgsConstructor
public class NoteTopVo {
    private NoteCatBean noteCat;
    private List<NoteBean> noteList;
}
