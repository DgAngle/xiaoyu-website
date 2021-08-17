package com.xiaoyu.service.impl;

import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.dao.NoteMapper;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.NoteService;
import com.xiaoyu.utils.ConstantUtil;
import com.xiaoyu.utils.RCode;
import com.xiaoyu.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteMapper noteMapper;

    /**
     * 查询笔记分类列表
     *
     * @param noteCatBean 笔记分类
     * @return 笔记分类列表
     */
    @Override
    public ListResult<NoteCatBean> queryNoteCatList(NoteCatBean noteCatBean) {
        ListResult<NoteCatBean> listResult = new ListResult<>();
        int totalCount = noteMapper.queryNoteCatListCount(noteCatBean);
        if (totalCount > 0) listResult.setList(noteMapper.queryNoteCatList(noteCatBean));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(noteCatBean.getPageCount());
        pagination.setStart(noteCatBean.getStart());
        pagination.setCurrentPage(noteCatBean.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    /**
     * 添加笔记分类
     *
     * @param noteCatBean 笔记分类
     * @return 添加结果
     */
    @Override
    public int addNoteCat(NoteCatBean noteCatBean) {
        // 查重
        if (noteMapper.queryNoteCatByNoteCatName(noteCatBean.getNoteCatName()) > 0) return RCode.repeat_code;

        noteCatBean.setNoteCatNum(getNoteCatNum(noteCatBean.getParentNoteCatNum()));
        noteCatBean.setCreateDt(new Date());
        noteCatBean.setCreateBy("");
        return noteMapper.addNoteCat(noteCatBean);
    }

    /**
     * 获取同一父级分类下的最大编号
     *
     * @param parentNoteCatNum 父分类编号
     * @return 要插入的分类编号
     */
    public String getNoteCatNum(String parentNoteCatNum) {
        parentNoteCatNum = parentNoteCatNum == null ? "" : parentNoteCatNum;
        // 获取最大 子分类编号
        String maxNotCatNum = noteMapper.queryMaxNoteCatNum(parentNoteCatNum);

        return StringUtil.getCatNum(parentNoteCatNum, maxNotCatNum);
    }
}
