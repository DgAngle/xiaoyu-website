package com.xiaoyu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mapper
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/3 14:35
 */
@Configuration
@MapperScan({"com.xiaoyu.mobile.*.mapper", "com.xiaoyu.web.*.mapper"})
public class MapperConfig {
}
