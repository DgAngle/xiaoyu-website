<#if tableInfo?exists>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>${tableInfo.tableComment}列表</title>
    <!-- 公共 css -->
    <link th:replace="common/common_css"/>
</head>
<body>
<div class="page-container ">
    <div th:replace="layout/sidebar"></div>
    <div th:replace="layout/topMenu"></div>
    <!--<div th:include="common/common_js"></div>-->
    <!-- 内容区域 -->
    <div class="container-fluid">
        <!--<div th:replace="layout/pagnation"></div>-->

        <div id="app">
            <div th:replace="pageedit/${tableInfo.classLowercaseName}/${tableInfo.classLowercaseName}Modal"></div>

            <div class="row comm-operate">
                <button class="btn btn-outline-primary btn-sm" @click="open${tableInfo.classUppercaseName}Modal('add')"><i class="fa fa-plus-square"></i>&nbsp;
                    新增
                </button>
            </div>

            <form class="form-inline form-search " onsubmit="return false;">
                <div class="form-group col-sm-3 ">
                    <label class="col-form-label ">${tableInfo.tableComment}名称:</label>
                    <input type="text" class="form-control form-control-sm" v-model="${tableInfo.classLowercaseName}Query.${tableInfo.classUppercaseName}Name" placeholder="" autocomplete="off"
                           @keyup.enter="refresh${tableInfo.classUppercaseName}List()">
                </div>
                <div class="form-group col-sm-2 ">
                    <button type="button" class="btn btn-outline-primary btn-sm" @click="refresh${tableInfo.classUppercaseName}List()">搜索</button>
                </div>
            </form>

            <div class="comm-table-content">
                <table class="table table-hover table-striped comm-table">
                    <!--
                    <#list tableInfo.columns as column>
                        <#if column.dataType = 'bigint'>
                            Long ${column.attrLowercaseName}; // ${column.columnComment}
                        </#if>
                        <#if (column.dataType = 'varchar' || column.dataType = 'text')>
                            String ${column.attrLowercaseName}; // ${column.columnComment}
                        </#if>
                        <#if column.dataType = 'timestamp'>
                            Date ${column.attrLowercaseName}; // ${column.columnComment}
                        </#if>
                    </#list>
                    -->
                    <thead class="thead-dark">
                    <tr>
                        <th width="60">序号</th>
                        <th width="120">${tableInfo.tableComment}名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(column, index) in dbConfigList">
                        <th>{{index + 1}}</th>
                        <!--<th>{{column.xx}}</th>-->
                        <td>${tableInfo.tableComment}</td>
                        <td class="table-operate">
                            <a href="#" title="修改" @click="open${tableInfo.classUppercaseName}Edit(column.${tableInfo.classLowercaseName}Id)"><i class="fa fa-pencil"></i></a>
                            <a href="#" title="删除"><i class="fa fa-trash-o"></i></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div v-if="!${tableInfo.classLowercaseName}List" class="pagination-no-content">没有符合的条件</div>
            </div>
            <form id="queryForm">
                <input hidden name="${tableInfo.classLowercaseName}Name" v-model="${tableInfo.classLowercaseName}Query.${tableInfo.classLowercaseName}Name">
            </form>
        </div>
        <div th:replace="common/common_js"></div>
        <div th:replace="layout/pagnation"></div>
    </div>
</div>
<script>
    new Vue({
        el: '#app',
        data: {
            // 本页(列表页)
            ${tableInfo.classLowercaseName}: {},
            ${tableInfo.classLowercaseName}Query: {},
            ${tableInfo.classLowercaseName}List: [],
            url: {
                query${tableInfo.classUppercaseName}List: '${tableInfo.classLowercaseName}/list',
                ${tableInfo.classLowercaseName}Add: '${tableInfo.classLowercaseName}/add',
                ${tableInfo.classLowercaseName}Detail: '${tableInfo.classLowercaseName}/detail',
                ${tableInfo.classLowercaseName}Update: '${tableInfo.classLowercaseName}/update',
                ${tableInfo.classLowercaseName}Delete: '${tableInfo.classLowercaseName}/delete',
            },
            // 弹窗(新增/修改)
            modalName: '新增${tableInfo.tableComment}',
            modalType: 'add',
        },
        mounted: function () {
            this.initList();
        },
        methods: {
            // 初始化列表页
            initList() {
            },
            // 打开弹窗
            open${tableInfo.classUppercaseName}Modal(type) {
                this.modalType = type;
                if (this.modalType === 'add') {
                    this.${tableInfo.classLowercaseName} = {};
                }
                $("#${tableInfo.classLowercaseName}Modal").modal({
                    keyboard: true,
                    backdrop: "static"
                })
            },
            // 保存配置
            save${tableInfo.classUppercaseName}() {
                if (this.modalType === 'add') {
                }
            },
            // 刷新列表
            refreshConnectList() {
            },
        }
    })
</script>
</body>
</html>
</#if>