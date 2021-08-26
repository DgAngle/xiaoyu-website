/* 收藏 */
let listVm = new Vue({
    el: "#planContainer",
    data: {
        planQuery: {
            planName: '',
            planCatId: -1,
            status: 2,
        },
        planForm: {
            planName: '',
            planCatId: null,
            planContent: '',
            remark: '',
        },
        planId: null,
        statusCode: null, // 状态
        modalName: '',
        modalType: 'add',
        planList: {},
        planCatList: {},
        tableStatusList: [],
        statusList: {}
    },
    mounted: function () {
        this.queryStatusList();
        this.queryPlanCatList();
        this.refreshPlanList();

    },
    filters: {
        ellipsis(value) {
            if (!value) return '';
            if (value.length > 15) {
                return value.slice(0, 15) + '...'
            }
            return value
        }
    },
    methods: {
        // 获取分类列表
        queryStatusList() {
            let _this = this;
            commonUtil.ajax("/code/statusList", {}, function (res) {
                for (let i = 0; i < commonUtil.status.length; i++) {
                    let statusItem = {};
                    statusItem.statusCode = commonUtil.status[i];
                    statusItem.statusMessage = res.data.statusMap[commonUtil.status[i]];
                    _this.tableStatusList[i] = statusItem;
                }
            })
        },
        // 获取分类列表
        queryPlanCatList() {
            let _this = this;
            let url = "/plan/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.planCatList = res.data.planCatList;
                }
            })
        },
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收藏';
            _this.planForm = {
                planName: '',
                planCatId: null,
                planContent: '',
                remark: '',
            };
        },
        // 初始化修改参数
        initEditForm(planDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改收藏';
            _this.planForm = {
                planId: planDetail.planId,
                planName: planDetail.planName,
                planContent: planDetail.planContent,
                planCatId: planDetail.planCatId,
                remark: planDetail.remark,
            };
        },
        // 打开新增模态框
        openPlanAdd() {
            let _this = this;
            _this.initAddForm();
            $("#planModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openPlanEdit(planId) {
            let _this = this;
            let url = "/plan/detail";
            commonUtil.ajax(url, {'planId': planId}, function (res) {
                _this.initEditForm(res.data.planDetail)
            })
            $("#planModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        savePlan() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/plan/add';
            else url = '/plan/update';
            commonUtil.ajax(url, _this.planForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#planModal").modal('hide');
                    _this.refreshPlanList();
                }
            })
        },
        // 状态变更
        openStatusEdit(planId, statusCode) {
            let _this = this;
            _this.planId = planId;
            _this.statusCode = statusCode;
            _this.statusList = commonUtil.statusList;
            $("#statusModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        saveStatus() {
            let _this = this;
            let url = "/plan/updateStatus";
            commonUtil.ajax(url, {'planId': _this.planId, 'status': _this.statusCode}, function (res) {
                Qmsg.success(res.message);
                $("#statusModal").modal("hide");
                _this.refreshPlanList();
            })

        },
        refreshPlanList() {
            let _this = this;
            let url = "/plan/list";
            commonUtil.ajax(url, _this.planQuery, function (res) {
                _this.planList = res.data.planList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/plan/list", pageQuery, function (res) {
                _this.planList = res.data.planList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})