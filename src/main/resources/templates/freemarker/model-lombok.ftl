package ${package_name}.model;

import lombok.Data;
import com.evada.inno.common.domain.BaseModel;
import com.evada.inno.common.listener.ICreateListenable;
import com.evada.inno.common.listener.IDeleteListenable;
import com.evada.inno.common.listener.IModifyListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Data
public class ${table_name}{

<#if model_column?exists>
    <#list model_column as model>
        <#if (model.columnType = 'varchar' || model.columnType = 'text')>
            @Column(name = "${model.columnName}",columnDefinition = "VARCHAR")
            private String ${model.changeColumnName?uncap_first}; // ${model.columnComment!}

        </#if>
        <#if model.columnType = 'timestamp' >
            @Column(name = "${model.columnName}",columnDefinition = "TIMESTAMP")
            private Date ${model.changeColumnName?uncap_first}; // ${model.columnComment!}

        </#if>
    </#list>
</#if>

}