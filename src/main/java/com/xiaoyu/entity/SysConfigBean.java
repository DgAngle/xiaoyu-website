package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

/**
 * 系统配置项
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/26 15:52
 */
@Data
public class SysConfigBean extends Pagination {
    private long configId; // 配置项Id
    private String configName; // 配置项英文名称
    private String configNameCN; // 配置项中文名称
    private String configValue; // 配置项值
    private String publicKeyId; // 公钥标识
    private String publicKeySecret; // 公钥密钥
    private String privateKeyId; // 私钥标识
    private String privateKeySecret; // 私钥密钥
    private String publicUrl; // 公共域名路径
    private String askUrl; // 访问域名路径
    private String belongName; // 所属三方英文名
    private String belongNameCN; // 所属三方中文名
    private int orderNum; // 排序号
    private String remark; // 备注
}
