/* 收藏分类 */
new Vue({
    el: "#noteCatContainer",
    data: {
        noteCatQuery: {
            noteCatName: '',
        },
        noteCatForm: {
            noteCatName: '',
            parentNoteCatNum: '',
            parentNoteCatId: '',
            orderNum: 0,
        },
        noteCatList: {}
    },
    mounted: function () {
        this.refreshNoteCatList();
    },
    methods: {
        openNoteCatAdd() {
            $("#noteCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        addNoteCat() {
            let _this = this;
            let url = "/note/cat/add";
            commonUtil.ajax(url, _this.noteCatForm, function (res) {
                if (res && res.data.value) {
                    alert(res.data.message);
                    $("#noteCatModal").modal('hide');
                    _this.refreshNoteCatList();
                }
            })
        },
        refreshNoteCatList() {
            let _this = this;
            let url = "/note/cat/list";
            commonUtil.ajax(url, _this.noteCatQuery, function (res) {
                _this.noteCatList = res.data.noteCatList;
            })
        }
    }
})