/* 笔记 */
Vue.component('treeselect', VueTreeselect.Treeselect)
let listVm = new Vue({
    el: "#noteContainer",
    data: {
        noteQuery: {
            noteName: '',
            // noteCatId: null,
            noteContent: null,
            createStartDt: null,
            createEndDt: null,
        },
        noteForm: {
            noteName: '',
            noteCatId: null,
            noteContent: '',
        },
        noteId: null,
        modalName: '',
        modalType: 'add',
        noteList: {},
        noteCatList: {},
        noteCatTree: {},
    },
    mounted: function () {
        this.queryNoteCatList();
        this.refreshNoteList();
        this.queryNoteCatTree();
        // this.$forceUpdate();
    },
    filters: {
        ellipsis(value) {
            if (!value) return '';
            if (value.length > 20) {
                return value.slice(0, 20) + '...'
            }
            return value
        }
    },
    methods: {
        // 获取分类列表
        queryNoteCatList() {
            let _this = this;
            let url = "/note/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.noteCatList = res.data.noteCatList;
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
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增笔记';
            _this.noteForm = {
                noteName: '',
                noteCatId: null,
                noteContent: '',
            };
        },
        // 初始化修改参数
        initEditForm(noteDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改笔记';
            _this.noteForm = {
                noteId: noteDetail.noteId,
                noteName: noteDetail.noteName,
                noteContent: noteDetail.noteContent,
                noteCatId: noteDetail.noteCatId,
            };
            // $("#noteDateEdit").flatpickr({
            //     locale: 'zh',
            //     enableTime: true,
            //     enableSeconds: true,
            //     time_24hr: true,
            //     defaultDate: noteDetail.noteDateStr,
            // })
        },
        // 打开新增模态框
        openNoteAdd() {
            let _this = this;
            _this.initAddForm();
            $("#noteModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openNoteEdit(noteId) {
            let _this = this;
            let url = "/note/detail";
            commonUtil.ajax(url, {'noteId': noteId}, function (res) {
                _this.initEditForm(res.data.noteDetail)
            })
            $("#noteModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        saveNote() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/note/add';
            else url = '/note/update';
            commonUtil.ajax(url, _this.noteForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#noteModal").modal('hide');
                    _this.refreshNoteList();
                }
            })
        },
        refreshNoteList() {
            let _this = this;
            let url = "/note/list";
            commonUtil.ajax(url, _this.noteQuery, function (res) {
                _this.noteList = res.data.noteList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/note/list", pageQuery, function (res) {
                _this.noteList = res.data.noteList;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})