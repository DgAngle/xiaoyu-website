/* 收藏 */
let listVm = new Vue({
    el: "#planContainer",
    data: {
        planQuery: {
            planName: '',
            planCatId: -1,
        },
        planForm: {
            planName: '',
            planUrl: '',
            planCatId: null,
            remark: '',
        },
        modalName: '',
        modalType: 'add',
        planList: {},
        planCatList: {}
    },
    mounted: function () {
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
                planUrl: '',
                planCatId: null,
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
                planUrl: planDetail.planUrl,
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