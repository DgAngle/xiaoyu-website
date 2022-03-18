package ${packageName}.bean;

import lombok.Data;
import java.util.Date;

<#if tableInfo?exists>
/**
* ${tableInfo.tableName}${tableInfo.tableComment}实体类
* @author ${author}
* @date ${date}
*/
@Data
public class ${tableInfo.classUppercaseName}{
<#list tableInfo.columns as column>
<#if column.dataType = 'bigint'>
    private Long ${column.attrLowercaseName}; // ${column.columnComment}
</#if>
<#if (column.dataType = 'varchar' || column.dataType = 'text')>
    private String ${column.attrLowercaseName}; // ${column.columnComment}
</#if>
<#if column.dataType = 'timestamp'>
    private Date ${column.attrLowercaseName}; // ${column.columnComment}
</#if>
</#list>
</#if>
}