/* 笔记分类 */
Vue.component('treeselect', VueTreeselect.Treeselect)
new Vue({
    el: "#noteCatContainer",
    data: {
        noteCatQuery: {
            noteCatName: '',
        },
        noteCatForm: {
            noteCatName: '',
            parentNoteCatId: null,
            parentNoteCatNum: null,
            orderNum: 0,
        },
        modalName: '',
        modalType: 'add',
        noteCatList: {},
        parentNoteCatIdAndNum: null,
        parentNoteCatList: {},
        noteCatTree: {},
    },
    mounted: function () {
        this.refreshNoteCatList();
        this.queryNoteCatTree();
    },
    methods: {
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增笔记分类';
            _this.parentNoteCatIdAndNum = null;
            _this.noteCatForm = {
                noteCatName: '',
                orderNum: 0,
            };
        },
        // 初始化修改参数
        initEditForm(noteCatDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改笔记分类';
            _this.noteCatForm = {
                noteCatId: noteCatDetail.noteCatId,
                noteCatName: noteCatDetail.noteCatName,
                noteCatNum: noteCatDetail.noteCatNum,
                orderNum: noteCatDetail.orderNum,
                parentNoteCatId: noteCatDetail.parentNoteCatId == 0 ? null : noteCatDetail.parentNoteCatId,
            };
        },
        openNoteCatAdd() {
            let _this = this
            _this.initAddForm();
            $("#noteCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        openNoteCatEdit(noteCatId) {
            let _this = this;
            let url = "/note/cat/detail";
            commonUtil.ajax(url, {'noteCatId': noteCatId}, function (res) {
                _this.initEditForm(res.data.noteCatDetail)
            })
            $("#noteCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        saveNoteCat() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/note/cat/add';
            else url = '/note/cat/update';
            commonUtil.ajax(url, _this.noteCatForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#noteCatModal").modal('hide');
                    _this.refreshNoteCatList();
                    _this.queryNoteCatTree();
                }
            })
        },
        // 下拉树
        queryNoteCatTree() {
            let _this = this;
            let url = "/note/cat/tree";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.noteCatTree = res.data.noteCatTree;
                }
            })
        },
        refreshNoteCatList() {
            let _this = this;
            let url = "/note/cat/list";
            commonUtil.ajax(url, _this.noteCatQuery, function (res) {
                _this.noteCatList = res.data.noteCatList;
                _this.parentNoteCatList = res.data.noteCatList;
            })
        },
    }
})