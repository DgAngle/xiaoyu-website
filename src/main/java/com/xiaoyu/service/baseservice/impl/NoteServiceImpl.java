package com.xiaoyu.service.baseservice.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.common.TreeNode;
import com.xiaoyu.dao.NoteMapper;
import com.xiaoyu.entity.NoteBean;
import com.xiaoyu.entity.NoteCatBean;
import com.xiaoyu.service.baseservice.NoteService;
import com.xiaoyu.utils.OssUtil;
import com.xiaoyu.utils.RCode;
import com.xiaoyu.utils.StringUtil;
import com.xiaoyu.vo.basevo.NoteQuery;
import com.xiaoyu.vo.basevo.NoteVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteMapper noteMapper;

    /*********************** 笔记分类 ***********************/

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
        noteCatBean.setParentNoteCatNum(noteMapper.queryNoteCatNumById(noteCatBean.getParentNoteCatId()));
        noteCatBean.setNoteCatNum(getNoteCatNum(noteCatBean.getParentNoteCatNum()));
        noteCatBean.setCreateDt(new Date());
        noteCatBean.setCreateBy("");
        return noteMapper.addNoteCat(noteCatBean);
    }

    /**
     * 笔记分类下拉树
     *
     * @return 下拉树
     */
    @Override
    public List<TreeNode> queryNoteCatTreeNode() {
        List<TreeNode> treeNodeList = new ArrayList<>();
        Map<String, TreeNode> map = new HashMap<>();
        // 获取所有分类
        List<NoteCatBean> noteCatBeans = noteMapper.queryAllNoteCat();
        Optional.ofNullable(noteCatBeans).orElse(new ArrayList<>()).forEach((noteCat) -> {
            // 创建节点
            TreeNode node = new TreeNode(String.valueOf(noteCat.getNoteCatId()), noteCat.getNoteCatName(), null);
            if (map.containsKey(noteCat.getParentNoteCatNum())) {
                if (map.get(noteCat.getParentNoteCatNum()).getChildren() == null) map.get(noteCat.getParentNoteCatNum()).setChildren(new ArrayList<>());
                map.get(noteCat.getParentNoteCatNum()).getChildren().add(node);
            } else treeNodeList.add(node);
            map.put(noteCat.getNoteCatNum(), node);
        });
        return treeNodeList;
    }

    /**
     * 笔记分类下拉树
     *
     * @return 下拉树
     */
    @Override
    public List<JSONObject> queryNoteCatTreeJson() {
        List<JSONObject> treeNodeList = new ArrayList<>();
        Map<String, JSONObject> map = new HashMap<>();
        // 获取所有分类
        List<NoteCatBean> noteCatBeans = noteMapper.queryAllNoteCat();
        Optional.ofNullable(noteCatBeans).orElse(new ArrayList<>()).forEach((noteCat) -> {
            // 创建节点
            JSONObject node = createNode(String.valueOf(noteCat.getNoteCatId()), noteCat.getNoteCatName(), null);
            if (map.containsKey(noteCat.getParentNoteCatNum())) {
                if (map.get(noteCat.getParentNoteCatNum()).getJSONArray("children") == null) map.get(noteCat.getParentNoteCatNum()).put("children", new JSONArray());
                map.get(noteCat.getParentNoteCatNum()).getJSONArray("children").add(node);
            } else treeNodeList.add(node);
            map.put(noteCat.getNoteCatNum(), node);
        });
        return treeNodeList;
    }

    public JSONObject createNode(String id, String label, JSONArray children) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(id)) jsonObject.put("id", id);
        if (StringUtils.isNotBlank(label)) jsonObject.put("label", label);
        if (children != null) jsonObject.put("children", children);
        return jsonObject;
    }

    @Override
    public NoteCatBean queryNoteCatDetailById(long noteCatId) {
        return noteMapper.queryNoteCatDetailById(noteCatId);
    }

    @Override
    public int updateNoteCat(NoteCatBean noteCatBean) {
        noteCatBean.setParentNoteCatNum(noteMapper.queryNoteCatNumById(noteCatBean.getParentNoteCatId()));
        // 如果父级分类发生变化,重新生成编号
        String queryParentNum = noteMapper.queryParentNoteCatNumById(noteCatBean.getNoteCatId());
        String parentNum = noteCatBean.getParentNoteCatNum() == null ? "" : noteCatBean.getParentNoteCatNum();
        if (!queryParentNum.equals(parentNum)) {
            noteCatBean.setNoteCatNum(getNoteCatNum(noteCatBean.getParentNoteCatNum()));
        }
        return noteMapper.updateNoteCat(noteCatBean);
    }

    @Override
    public int deleteNoteCatById(long noteCatId) {
        return noteMapper.deleteNoteCatById(noteCatId);
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

    /*********************** 笔记 ***********************/
    @Override
    public ListResult<NoteBean> queryNoteList(NoteQuery noteQuery) {
        ListResult<NoteBean> listResult = new ListResult<>();
        int totalCount = noteMapper.queryNoteListCount(noteQuery);
        if (totalCount > 0) listResult.setList(noteMapper.queryNoteList(noteQuery));

        Pagination pagination = new Pagination();
        pagination.setTotalCount(totalCount);
        pagination.setPageCount(noteQuery.getPageCount());
        pagination.setStart(noteQuery.getStart());
        pagination.setCurrentPage(noteQuery.getCurrentPage());
        listResult.setPagination(pagination);
        return listResult;
    }

    @Override
    public int addNote(NoteBean noteBean) {
        Date date = new Date();
        noteBean.setCreateDt(date);
        return noteMapper.addNote(noteBean);
    }

    @Override
    public NoteVo queryNoteDetailById(long noteId) {
        return noteMapper.queryNoteDetailById(noteId);
    }

    @Override
    public NoteVo queryNoteDetailMdById(long noteId) {
        return noteMapper.queryNoteDetailMdById(noteId);
    }

    @Override
    public int updateNote(NoteBean noteBean) {
        return noteMapper.updateNote(noteBean);
    }

    @Override
    public int deleteNoteById(long noteId) {
        return noteMapper.deleteNoteById(noteId);
    }

    @Override
    public JSONObject uploadImage(MultipartFile file) {
        JSONObject jsonObject = new JSONObject();
        String imageUrl = OssUtil.uploadImageFile(file);
        if (StringUtils.isNotBlank(imageUrl)) {
            jsonObject.put("success", 1);
            jsonObject.put("message", "上传成功！");
            jsonObject.put("url", imageUrl);
        } else {
            jsonObject.put("success", 0);
            jsonObject.put("message", "上传失败！");
        }
        return jsonObject;
    }

}
