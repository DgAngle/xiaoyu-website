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
        editor: {},
    },
    mounted: function () {
        let _this = this;
        _this.queryNoteCatList();
        _this.refreshNoteList();
        _this.queryNoteCatTree();
        _this.buttonEvent();
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
        buttonEvent() {
            let _this = this;
            $('#noteModal').on('shown.bs.modal', function (event) {
                _this.initMarkdown();
            });
        },
        // 获取分类列表
        initMarkdown() {
            let _this = this;
            _this.editor = editormd("noteContentEditor", {
                width: "100%",
                height: 650,
                path: "/plugs/editor/lib/",
                saveHTMLToTextarea: true,    // 保存 HTML 到 Textarea
                searchReplace: true,
                // watch: true,      // 关闭实时预览
                unwatch: true,      // 关闭实时预览
                tocm : true,
                htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
                onload: function () {
                    // console.log('onload', this);
                    // this.fullscreen();
                    // this.unwatch();
                    // this.watch().fullscreen();

                    //this.setMarkdown("#PHP");
                    // this.width("100%");
                    // this.height(600);
                    // this.resize("100%", 800);
                },
            });
        },
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
        },
        // 打开新增模态框
        openNoteDetail(id) {
            window.open("goMdNoteView/" + id);
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
            _this.noteForm.noteContent = _this.editor.getMarkdown();
            console.log(_this.noteForm);
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