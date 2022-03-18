<#if tableInfo?exists>
package ${packageName}.${tableInfo.tableName}.controller;

import com.xiaoyu.utils.R;
import ${packageName}.${tableInfo.classLowercaseName}.bean.${tableInfo.classUppercaseName};
import ${packageName}.${tableInfo.classLowercaseName}.service.${tableInfo.classUppercaseName}Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
* 描述：${tableInfo.tableComment}控制层
* @author ${author}
* @date ${date}
*/
@Controller
public class ${tableInfo.classUppercaseName}Controller {

    @Resource
    private ${tableInfo.classUppercaseName}Service ${tableInfo.classLowercaseName}Service;

    // 打开${tableInfo.tableComment}页面
    @RequestMapping("/${tableInfo.classLowercaseName}/openList")
    public String goCatList(CollectionCatBean collectionCatBean) {
        return StateDefine.PAGEPATH + "/${tableInfo.classLowercaseName}/${tableInfo.classLowercaseName}List";
    }

    // 查询${tableInfo.tableComment}列表
    @RequestMapping("/${tableInfo.classLowercaseName}/list")
    @ResponseBody
    public R query${tableInfo.classUppercaseName}List(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
        // ListResult<${tableInfo.classUppercaseName}> listResult = ${tableInfo.classLowercaseName}Service.query${tableInfo.classLowercaseName}List(${tableInfo.classLowercaseName});
        // return R.success()
        //     .data("${tableInfo.classLowercaseName}List", listResult.getList())
        //     .data("pagination", listResult.getPagination());
        return R.success().data("${tableInfo.classLowercaseName}List", ${tableInfo.classLowercaseName}Service.queryAllList());
    }

    // 添加${tableInfo.tableComment}
    @RequestMapping("/${tableInfo.classLowercaseName}/add")
    @ResponseBody
    public R ${tableInfo.classLowercaseName}Add(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
        ${tableInfo.classLowercaseName}Service.add${tableInfo.classUppercaseName}(${tableInfo.classLowercaseName});
        return R.success().message("添加成功！");
    }

    // 根据Id查询${tableInfo.tableComment}详情
    @RequestMapping("/${tableInfo.classLowercaseName}/detail")
    @ResponseBody
    public R ${tableInfo.classLowercaseName}Detail(Long ${tableInfo.classLowercaseName}Id) {
    return R.success().data("${tableInfo.classLowercaseName}Detail", ${tableInfo.classLowercaseName}Service.query${tableInfo.classUppercaseName}DetailById(${tableInfo.classLowercaseName}Id));
    }

    // 更新${tableInfo.tableComment}
    @RequestMapping("/${tableInfo.classLowercaseName}/update")
    @ResponseBody
    public R ${tableInfo.classLowercaseName}Update(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
    ${tableInfo.classLowercaseName}Service.update${tableInfo.classUppercaseName}(${tableInfo.classLowercaseName});
    return R.success().message("更新成功！");
    }

    // 根据Id删除${tableInfo.tableComment}
    @RequestMapping("/${tableInfo.classLowercaseName}/delete")
    @ResponseBody
    public R ${tableInfo.classLowercaseName}Delete(Long ${tableInfo.classLowercaseName}Id) {
        ${tableInfo.classLowercaseName}Service.delete${tableInfo.classUppercaseName}ById(${tableInfo.classLowercaseName}Id);
        return R.success().message("删除成功！");
    }
}

</#if>