<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/WEB-INF/jsp/common/commonvariable.jsp" %>
    <jsp:include page="<%=commonLib2%>"/>
    <!-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/3th/xx.css"/> -->
    <!-- <script type="text/javascript" src="<%=request.getContextPath()%>/3th/xx.js"></script>-->
    <title>支付配置</title>
    <style>
        body {
            font: 10pt Arial, Microsoft YaHei, Helvetica, sans-serif;
        }

        [v-cloak] {
            display: none;
        }

        /* 面包屑导航区域 */
        .top-breadcrumb {
            color: #27a0d7;
            font-weight: 700;
            padding: 8px 0;
            font-size: 14px;
            height: 40px;
        }

        .main-content-container {
            height: calc(100% - 110px);
        }

        /* 底部区域 */
        .footer-content {
            /*height: 70px;*/
            height: 100%;
        }
    </style>
</head>
<body>
<div id="app" class="container-fluid" v-cloak>
    <!-- 面包屑导航 -->
    <div class="top-breadcrumb">系统管理 &gt; 支付配置</div>
    <!-- 主体内容 -->
    <div class="container-fluid main-content-container">
        <!-- 搜索区域 -->
        <div class="search-content">
            <div class="form-group row">
                <div class="col-md-3 search-item">
                    <div class="search-label">部门名称:</div>
                    <div class="search-input"><input class="col form-control form-control-sm" v-model="deptQuery.deptName"></div>
                </div>
                <div class="col-md-3 search-item">
                    <div class="search-label">部门编号:</div>
                    <div class="search-input"><input class="col form-control form-control-sm" v-model="deptQuery.deptNum"></div>
                </div>
                <div v-if="isAdmin" class="col-md-3 search-item">
                    <div class="search-label">所属公司:</div>
                    <div class="search-input">
                        <select class="form-control form-control-sm" v-model="deptQuery.companyId">
                            <option v-for="(company) in companyList" :value="company.id">{{company.companyName}}</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-3 search-item">
                    <button class="btn btn-primary btn-sm" @click="refreshTableContent()">查询</button>
                    <button class="btn btn-primary btn-sm" @click="openDeptModal()">&nbsp;新增部门&nbsp;</button>
                </div>
            </div>
        </div>
        <!-- 表格区域 -->
        <div class="table-content">
            <table class="table table-sm table-bordered table-striped table-hover">
                <thead class="thead-light">
                <tr>
                    <th scope="col" width="100px">序号</th>
                    <th scope="col">公司名称</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(dept, index) in deptList">
                    <th scope="row">{{index + 1}}</th>
                    <td style="text-align: center">-</td>
                    <td>
                        <a class="table-opt-item" href="#" @click="openUpdateDeptModal(dept.id)" title="编辑"><span class="fa fa-edit"></span></a>
                        <a class="table-opt-item" href="#" @click="deleteDept(dept.id)" title="删除"><span class="fa fa-times-circle"></span></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <div v-if="!deptList" style="text-align: center;">没有符合条件的内容</div>
        </div>
    </div>
    <!-- 底部区域 -->
    <div class="footer-content">
        <!-- 分页 -->
        <div class="" style="margin-top: 10px;">
            <div v-if="deptList" class="row">
                <div class="col text-left" style="line-height: 40px; display: flex">
                    <div>显示第 {{ pagination.start + 1 }} 到第 {{ pagination.end }} 条记录，总共 {{ pagination.totalCount }} 条记录</div>
                    <div v-if="this.pagination.totalPage > 1" style="margin-left: 3px">每页显示</div>
                    <div v-if="this.pagination.totalPage > 1">
                        <select class="form-control form-control-sm" v-model="pagination.count" @change="pageCountChanged()">
                            <option v-for="count in pageCountArr">{{count}}</option>
                        </select>
                    </div>
                    <div v-if="this.pagination.totalPage > 1">条记录</div>
                </div>

                <div v-if="this.pagination.totalPage > 1" class="col">
                    <nav class="float-right">
                        <ul class="pagination">
                            <li class="page-item " :class=" this.pagination.currentPage == 1 ? 'disabled': ''"
                                @click="currentPageChanged(pagination.currentPage > 1 ? (pagination.currentPage - 1) : 1)">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&lsaquo;</span>
                                </a>
                            </li>
                            <li v-if="showPrevMore" class="page-item"><a class="page-link" href="#" @click="currentPageChanged(1)">1</a></li>
                            <li v-if="showPrevMore" class="page-item disabled"><a class="page-link" href="#">...</a></li>
                            <li v-for="pageNumber in pageNumberArr" class="page-item" :class="pagination.currentPage == pageNumber ? 'active' : ''">
                                <a class="page-link" href="#" @click="currentPageChanged(pageNumber)">{{pageNumber}}</a>
                            </li>
                            <li v-if="showNextMore" class="page-item  disabled"><a class="page-link" href="#">...</a></li>
                            <li v-if="showNextMore" class="page-item"><a class="page-link" href="#" @click="currentPageChanged(pagination.totalPage)">{{pagination.totalPage}}</a></li>
                            <li class="page-item" :class=" this.pagination.currentPage == this.pagination.totalPage ? 'disabled': ''"
                                @click="currentPageChanged(pagination.currentPage < pagination.totalPage ? (pagination.currentPage + 1) : pagination.totalPage)">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&rsaquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    new Vue({
        el: '#app',
        data: {
            pagination: {}, // 分页参数
            pageCountArr: [10, 20, 50], // 显示数量
            pageNumberArr: [], // 分页数
            showPrevMore: false, // 首页及...
            showNextMore: false, // 尾页及...

            payConfig: {},
            url: {
                queryPayConfig: commonutil.actionPath + "/sys/queryPayConfig", // 查询支付配置
                savePayConfig: commonutil.actionPath + "/sys/savePayConfig", // 保存支付配置
            }
        },
        mounted() {
            this.initConfig();
        },
        methods: {
            // 初始化配置数据显示
            initConfig: function () {
                let _this = this;
                commonutil.doAjax(_this.url.queryPayConfig, {}, function (res) {
                    console.log(res);
                    if (res && res.value) {
                        _this.payConfig = res.data.payConfig || {};
                    }
                })
            },
            // 保存配置
            saveConfig: function () {
                // TODO 参数长度验证
                let _this = this;
                commonutil.doAjax(_this.url.savePayConfig, _this.payConfig, function (res) {
                    console.log(res);
                    if (res && res.value) {
                        alert(res.message !== 'success' ? (res.message || "保存成功") : "保存成功")
                    }
                })
            }
        }
    })
</script>
</body>
</html>
