package com.xiaoyu.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/9 12:55
 */
@Data
@AllArgsConstructor
public class TreeNode {
    private String id;
    private String label;
    private List<TreeNode> children;
}
