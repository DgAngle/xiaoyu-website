/* 收入分类 */
new Vue({
    el: "#incomeCatContainer",
    data: {
        incomeCatQuery: {
            incomeCatName: '',
        },
        incomeCatForm: {
            incomeCatName: '',
            orderNum: 0,
        },
        modalName: '',
        modalType: 'add',
        incomeCatList: {}
    },
    mounted: function () {
        this.refreshIncomeCatList();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收入分类';
            _this.incomeCatForm = {
                incomeCatName: '',
                orderNum: 0,
            };
        },
        // 初始化修改参数
        initEditForm(incomeCatDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改收入分类';
            _this.incomeCatForm = {
                incomeCatId: incomeCatDetail.incomeCatId,
                incomeCatName: incomeCatDetail.incomeCatName,
                orderNum: incomeCatDetail.orderNum,
            };
        },
        openIncomeCatAdd() {
            let _this = this
            _this.initAddForm();
            $("#incomeCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        openIncomeCatEdit(incomeCatId) {
            let _this = this;
            let url = "/income/cat/detail";
            commonUtil.ajax(url, {'incomeCatId': incomeCatId}, function (res) {
                _this.initEditForm(res.data.incomeCatDetail)
            })
            $("#incomeCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        saveIncomeCat() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/income/cat/add';
            else url = '/income/cat/update';
            commonUtil.ajax(url, _this.incomeCatForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#incomeCatModal").modal('hide');
                    _this.refreshIncomeCatList();
                }
            })
        },
        refreshIncomeCatList() {
            let _this = this;
            let url = "/income/cat/list";
            commonUtil.ajax(url, _this.incomeCatQuery, function (res) {
                console.log(res);
                _this.incomeCatList = res.data.incomeCatList;
            })
        }
    }
})