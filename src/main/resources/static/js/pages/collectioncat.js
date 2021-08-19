/* 收藏分类 */
new Vue({
    el: "#collectionCatContainer",
    data: {
        collectionCatQuery: {
            collectionCatName: '',
        },
        collectionCatForm: {
            collectionCatName: '',
            orderNum: 0,
        },
        modalName: '',
        modalType: 'add',
        collectionCatList: {}
    },
    mounted: function () {
        this.refreshCollationCatList();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收藏分类';
            _this.collectionCatForm = {
                collectionCatName: '',
                orderNum: 0,
            };
        },
        // 初始化修改参数
        initEditForm(collectionCatDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改收藏分类';
            _this.collectionCatForm = {
                collectionCatId: collectionCatDetail.collectionCatId,
                collectionCatName: collectionCatDetail.collectionCatName,
                orderNum: collectionCatDetail.orderNum,
            };
        },
        openCollectionCatAdd() {
            let _this = this
            _this.initAddForm();
            $("#collectionCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        openCollectionCatEdit(collectionCatId) {
            let _this = this;
            let url = "/collect/cat/detail";
            commonUtil.ajax(url, {'collectionCatId': collectionCatId}, function (res) {
                _this.initEditForm(res.data.collectionCatDetail)
            })
            $("#collectionCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        saveCollectionCat() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/collect/cat/add';
            else url = '/collect/cat/update';
            commonUtil.ajax(url, _this.collectionCatForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#collectionCatModal").modal('hide');
                    _this.refreshCollationCatList();
                }
            })
        },
        refreshCollationCatList() {
            let _this = this;
            let url = "/collect/cat/list";
            commonUtil.ajax(url, _this.collectionCatQuery, function (res) {
                _this.collectionCatList = res.data.collectionCatList;
            })
        }
    }
})