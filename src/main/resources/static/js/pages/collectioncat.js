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
        collectionCatList: {}
    },
    mounted: function () {
        this.refreshCollationCatList();
    },
    methods: {
        openCollectionCatAdd() {
            $("#collectionCatModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        addCollectionCat() {
            let _this = this;
            let url = "/collect/cat/add";
            commonUtil.ajax(url, _this.collectionCatForm, function (res) {
                if (res && res.value) {
                    alert(res.message);
                    $("#collectionCatModal").modal('hide');
                    _this.refreshCollationCatList();
                }
            })
        },
        refreshCollationCatList() {
            let _this = this;
            let url = "/collect/cat/list";
            commonUtil.ajax(url, _this.collectionCatQuery, function (res) {
                console.log(res);
                _this.collectionCatList = res.data.collectionCatList;
            })
        }
    }
})