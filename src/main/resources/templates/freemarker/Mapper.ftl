<#if tableInfo?exists>
package ${packageName}.${tableInfo.tableName}.service;

import ${packageName}.${tableInfo.tableName}.bean.${tableInfo.classUppercaseName};
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* 描述：${tableInfo.tableComment}服务层
* @author ${author}
* @date ${date}
*/
public interface ${tableInfo.classUppercaseName}Service {

    // 查询${tableInfo.tableComment}列表
    @Select("select * from ${tableInfo.tableName}")
    List<${tableInfo.classUppercaseName}> queryAllList();

    // 查询${tableInfo.tableComment}列表数量
    // @Select("select * from ${tableInfo.tableName}")
    // Integer query${tableInfo.classUppercaseName}ListCount(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName});

    // 查询${tableInfo.tableComment}列表数量
    // @Select("")
    // List<${tableInfo.classUppercaseName}> query${tableInfo.classUppercaseName}List(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName});

    // 添加${tableInfo.tableComment}
    @Insert("${tableInfo.insertSql}")
    Integer add${tableInfo.classUppercaseName}(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName});

    // 根据Id查询${tableInfo.tableComment}详情
    @Insert("${tableInfo.selectByIdSql}")
    ${tableInfo.classUppercaseName} query${tableInfo.classUppercaseName}DetailById(Long ${tableInfo.classLowercaseName}Id);

    // 更新${tableInfo.tableComment}
    @Update("")
    Integer update${tableInfo.classUppercaseName}(${tableInfo.classUppercaseName} ${tableInfo.classLowercaseName});

    // 根据Id删除${tableInfo.tableComment}
    @Delete("${tableInfo.deleteByIdSql}")
    Integer delete${tableInfo.classUppercaseName}ById(Long ${tableInfo.classLowercaseName}Id);
}

</#if>