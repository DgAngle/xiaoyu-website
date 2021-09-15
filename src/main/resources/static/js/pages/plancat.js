/* 计划分类 */
new Vue({
    el: "#planCatContainer",
    data: {
        planCatQuery: {
            planCatName: '',
        },
        planCatForm: {
            planCatName: '',
            orderNum: 0,
        },
        modalName: '',
        modalType: 'add',
        planCatList: {}
    },
    mounted: function () {
        this.refreshPlanCatList();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增计划分类';
            _this.planCatForm = {
                planCatName: '',
                orderNum: 0,
            };
        },
        // 初始化修改参数
        initEditForm(planCatDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改计划分类';
            _this.planCatForm = {
                planCatId: planCatDetail.planCatId,
                planCatName: planCatDetail.planCatName,
                orderNum: planCatDetail.orderNum,
            };
        },
        openPlanCatAdd() {
            let _this = this
            _this.initAddForm();
            $("#planCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        openPlanCatEdit(planCatId) {
            let _this = this;
            let url = "/plan/cat/detail";
            commonUtil.ajax(url, {'planCatId': planCatId}, function (res) {
                _this.initEditForm(res.data.planCatDetail)
            })
            $("#planCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        savePlanCat() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/plan/cat/add';
            else url = '/plan/cat/update';
            commonUtil.ajax(url, _this.planCatForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#planCatModal").modal('hide');
                    _this.refreshPlanCatList();
                }
            })
        },
        refreshPlanCatList() {
            let _this = this;
            let url = "/plan/cat/list";
            commonUtil.ajax(url, _this.planCatQuery, function (res) {
                console.log(res);
                _this.planCatList = res.data.planCatList;
            })
        }
    }
})