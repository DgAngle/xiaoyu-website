<#if tableInfo?exists>
package ${packageName}.${tableInfo.tableName}.service;

import com.xiaoyu.utils.R;
import com.xiaoyu.common.ListResult;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.${tableInfo.tableName}.dao.${tableInfo.classUppercaseName}Mapper;
import com.xiaoyu.utils.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
* 描述：${tableInfo.tableComment}服务层
* @author ${author}
* @date ${date}
*/
@Service
public class ${tableInfo.classUppercaseName}Service {

    @Resource
    private ${tableInfo.classUppercaseName}Mapper ${tableInfo.classLowercaseName}Mapper;

    // 查询${tableInfo.tableComment}列表
    public List<${tableInfo.classUppercaseName}> queryAllList(){
        return ${tableInfo.classLowercaseName}Mapper.queryAllList();
    }

    // 查询${tableInfo.tableComment}列表
    // public ListResult<${tableInfo.classUppercaseName}> query${tableInfo.classUppercaseName}List(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
    //     if (!UserUtil.isAdmin()) ${tableInfo.classLowercaseName}.setCreateBy(UserUtil.getUser().getUserId());
    //     ListResult<${tableInfo.classUppercaseName}> listResult = new ListResult<>();
    //     int totalCount = ${tableInfo.classLowercaseName}Mapper.query${tableInfo.classUppercaseName}ListCount(${tableInfo.classLowercaseName});
    //     if (totalCount > 0) listResult.setList(${tableInfo.classLowercaseName}Mapper.query${tableInfo.classUppercaseName}List(${tableInfo.classLowercaseName}));
    //
    //     Pagination pagination = new Pagination();
    //     pagination.setTotalCount(totalCount);
    //     pagination.setPageCount(${tableInfo.classLowercaseName}.getPageCount());
    //     pagination.setStart(${tableInfo.classLowercaseName}.getStart());
    //     pagination.setCurrentPage(${tableInfo.classLowercaseName}.getCurrentPage());
    //     listResult.setPagination(pagination);
    //     return listResult;
    // }

    // 添加${tableInfo.tableComment}
    public Integer add${tableInfo.classUppercaseName}(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
        return ${tableInfo.classLowercaseName}Mapper.add${tableInfo.classUppercaseName}(${tableInfo.classLowercaseName});
    }

    // 根据Id查询${tableInfo.tableComment}详情
    public ${tableInfo.classUppercaseName} query${tableInfo.classUppercaseName}DetailById(Long ${tableInfo.classLowercaseName}Id) {
        return ${tableInfo.classLowercaseName}Mapper.query${tableInfo.classUppercaseName}DetailById(${tableInfo.classLowercaseName}Id);
    }

    // 更新${tableInfo.tableComment}
    public Integer update${tableInfo.classUppercaseName}(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName}) {
        return ${tableInfo.classLowercaseName}Mapper.update${tableInfo.classUppercaseName}(${tableInfo.classLowercaseName});
    }

    // 根据Id删除${tableInfo.tableComment}
    public Integer delete${tableInfo.classUppercaseName}ById(Long ${tableInfo.classLowercaseName}Id) {
        return ${tableInfo.classLowercaseName}Mapper.delete${tableInfo.classUppercaseName}ById(${tableInfo.classLowercaseName}Id);
    }
}

</#if>