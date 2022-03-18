package com.xiaoyu.utils.generate;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

/**
 * Freemarker 工具类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/14 17:45
 */
public class FreemarkerUtil {
    // 公开 - 模板
    public static final String templateBean = "Bean.ftl"; // 后端Bean
    public static final String templateController = "Controller.ftl"; // 后端Controller
    public static final String templateService = "Service.ftl"; // 后端Service
    public static final String templateMapper = "Mapper.ftl"; // 后端Mapper
    public static final String templateHtmlList = "HtmlList.ftl"; // 前端List
    public static final String templateHtmlModal = "HtmlModal.ftl"; // 前端Bootstrap->Modal弹窗
    // 私有
    private static final String basePackagePath = "/templates/freemarker/"; // freemarker代码生成模板所在路径
    private static final String encoding = "UTF-8"; // 默认编码


    private FreemarkerUtil() {
    }

    private static final Configuration configuration = new Configuration(Configuration.VERSION_2_3_30); // 版本跟Pom对应

    static {
        //这里比较重要，用来指定加载模板所在的路径
        configuration.setTemplateLoader(new ClassTemplateLoader(FreemarkerUtil.class, basePackagePath));
        configuration.setDefaultEncoding(encoding);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    // 获取指定名称模板, 获取不到抛出异常
    public static Template getTemplate(String templateName) throws IOException {
        try {
            return configuration.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    // 清空缓存
    public static void clearCache() {
        configuration.clearTemplateCache();
    }
}
