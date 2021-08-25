package com.xiaoyu.vo.topvo;

import com.xiaoyu.entity.CollectionBean;
import com.xiaoyu.entity.CollectionCatBean;
import com.xiaoyu.vo.basevo.CollectionVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/25 9:37
 */
@Data
@AllArgsConstructor
public class CollectionTopVo {
    private CollectionCatBean collectionCat;
    private List<CollectionBean> collections;
}
