/* 收藏 */
new Vue({
    el: "#collectionContainer",
    data: {
        collectionQuery: {
            collectionName: '',
            collectionCatId: -1,
        },
        collectionForm: {
            collectionName: '',
            collectionUrl: '',
            collectionCatId: null,
            remark: '',
        },
        collectionList: {},
        collectionCatList: {}
    },
    mounted: function () {
        this.queryCollectionCatList();
        this.refreshCollationList();
    },
    filters: {
        ellipsis(value) {
            if (!value) return '';
            if (value.length > 15) {
                return value.slice(0, 15) + '...'
            }
            return value
        }
    },
    methods: {
        queryCollectionCatList() {
            let _this = this;
            let url = "/collect/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.collectionCatList = res.data.collectionCatList;
                }
            })
        },
        clearForm() {
            let _this = this;
            _this.collectionForm = {
                collectionName: '',
                collectionUrl: '',
                collectionCatId: null,
                remark: '',
            };
        },
        openCollectionAdd() {
            let _this = this;
            _this.clearForm();
            $("#collectionModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        addCollection() {
            let _this = this;
            let url = "/collect/add";
            commonUtil.ajax(url, _this.collectionForm, function (res) {
                if (res && res.value) {
                    alert(res.message);
                    $("#collectionModal").modal('hide');
                    _this.refreshCollationList();
                }
            })
        },
        refreshCollationList() {
            let _this = this;
            let url = "/collect/list";
            commonUtil.ajax(url, _this.collectionQuery, function (res) {
                _this.collectionList = res.data.collectionList;
            })
        }
    }
})