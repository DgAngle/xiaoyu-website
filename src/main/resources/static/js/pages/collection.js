/* 收藏 */
Vue.component('treeselect', VueTreeselect.Treeselect)
let listVm = new Vue({
    el: "#collectionContainer",
    data: {
        collectionQuery: {
            collectionName: '',
            // collectionCatId: null,
        },
        collectionForm: {
            collectionName: '',
            collectionUrl: '',
            collectionCatId: null,
            remark: '',
        },
        modalName: '',
        modalType: 'add',
        collectionList: {},
        collectionCatList: {},
        collectionCatTree: {},
    },
    mounted: function () {
        this.queryCollectionCatList();
        this.refreshCollationList();
        this.queryCollectionCatTree();
    },
    filters: {
        ellipsis(value) {
            if (!value) return '';
            if (value.length > 15) {
                return value.slice(0, 15) + '...'
            }
            return value
        },
        ellipsisUrl(value) {
            if (!value) return '';
            if (value.length > 40) {
                return value.slice(0, 40) + '...'
            }
            return value
        }
    },
    methods: {
        // 获取分类列表
        queryCollectionCatList() {
            let _this = this;
            let url = "/collect/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.collectionCatList = res.data.collectionCatList;
                }
            })
        },
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收藏';
            _this.collectionForm = {
                collectionName: '',
                collectionUrl: '',
                collectionCatId: null,
                remark: '',
            };
        },
        // 初始化修改参数
        initEditForm(collectionDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改收藏';
            _this.collectionForm = {
                collectionId: collectionDetail.collectionId,
                collectionName: collectionDetail.collectionName,
                collectionUrl: collectionDetail.collectionUrl,
                collectionCatId: collectionDetail.collectionCatId,
                remark: collectionDetail.remark,
            };
        },
        // 打开新增模态框
        openCollectionAdd() {
            let _this = this;
            _this.initAddForm();
            $("#collectionModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openCollectionEdit(collectionId) {
            let _this = this;
            let url = "/collect/detail";
            commonUtil.ajax(url, {'collectionId': collectionId}, function (res) {
                _this.initEditForm(res.data.collectionDetail)
            })
            $("#collectionModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        saveCollection() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/collect/add';
            else url = '/collect/update';
            commonUtil.ajax(url, _this.collectionForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#collectionModal").modal('hide');
                    _this.refreshCollationList();
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
        refreshCollationList() {
            let _this = this;
            let url = "/collect/list";
            commonUtil.ajax(url, _this.collectionQuery, function (res) {
                _this.collectionList = res.data.collectionList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/collect/list", pageQuery, function (res) {
                _this.collectionList = res.data.collectionList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})