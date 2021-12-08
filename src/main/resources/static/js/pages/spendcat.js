/* 消费分类 */
new Vue({
    el: "#spendCatContainer",
    data: {
        spendCatQuery: {
            spendCatName: '',
        },
        spendCatForm: {
            spendCatName: '',
            orderNum: 0,
        },
        modalName: '',
        modalType: 'add',
        spendCatList: {}
    },
    mounted: function () {
        this.refreshSpendCatList();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增消费分类';
            _this.spendCatForm = {
                spendCatName: '',
                orderNum: 0,
            };
        },
        // 初始化修改参数
        initEditForm(spendCatDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改消费分类';
            _this.spendCatForm = {
                spendCatId: spendCatDetail.spendCatId,
                spendCatName: spendCatDetail.spendCatName,
                orderNum: spendCatDetail.orderNum,
            };
        },
        openSpendCatAdd() {
            let _this = this
            _this.initAddForm();
            $("#spendCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        openSpendCatEdit(spendCatId) {
            let _this = this;
            let url = "/spend/cat/detail";
            commonUtil.ajax(url, {'spendCatId': spendCatId}, function (res) {
                _this.initEditForm(res.data.spendCatDetail)
            })
            $("#spendCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        saveSpendCat() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/spend/cat/add';
            else url = '/spend/cat/update';
            commonUtil.ajax(url, _this.spendCatForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#spendCatModal").modal('hide');
                    _this.refreshSpendCatList();
                }
            })
        },
        refreshSpendCatList() {
            let _this = this;
            let url = "/spend/cat/list";
            commonUtil.ajax(url, _this.spendCatQuery, function (res) {
                _this.spendCatList = res.data.spendCatList;
            })
        }
    }
})