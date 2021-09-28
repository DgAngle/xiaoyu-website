/* 收藏分类 */
Vue.component('treeselect', VueTreeselect.Treeselect)
let listVm = new Vue({
    el: "#collectionCatContainer",
    data: {
        collectionCatQuery: {
            collectionCatName: '',
        },
        collectionCatForm: {
            collectionCatName: '',
            parentCollectionCatId: null,
            parentCollectionCatNum: null,
            orderNum: 0,
        },
        parentCollectionCatIdAndNum: null,
        modalName: '',
        modalType: 'add',
        collectionCatList: {},
        parentCollectionCatList: {},
        collectionCatTree: {},
    },
    mounted: function () {
        this.refreshCollationCatList();
        this.queryCollectionCatTree();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收藏分类';
            _this.parentCollectionCatIdAndNum = null;
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
                collectionCatNum: collectionCatDetail.noteCatNum,
                orderNum: collectionCatDetail.orderNum,
                parentCollectionCatId: collectionCatDetail.parentCollectionCatId == 0 ? null : collectionCatDetail.parentCollectionCatId,

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
                    _this.queryCollectionCatTree();
                }
            })
        },
        // 下拉树
        queryCollectionCatTree() {
            let _this = this;
            let url = "/collect/cat/tree";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.collectionCatTree = res.data.collectionCatTree;
                }
            })
        },
        refreshCollationCatList() {
            let _this = this;
            let url = "/collect/cat/list";
            commonUtil.ajax(url, _this.collectionCatQuery, function (res) {
                _this.collectionCatList = res.data.collectionCatList;
                _this.parentCollectionCatList = res.data.collectionCatList
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/collect/cat/list", pageQuery, function (res) {
                _this.collectionCatList = res.data.collectionCatList;
                _this.parentCollectionCatList = res.data.collectionCatList
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})