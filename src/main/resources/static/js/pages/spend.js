/* 消费 */
let listVm = new Vue({
    el: "#spendContainer",
    data: {
        spendQuery: {
            spendName: '',
            spendCatId: -1,
            spendMoney: -1,
            spendDate: null,
            spendStartDate: null,
            spendEndDate: null,
        },
        spendForm: {
            spendName: '',
            spendCatId: null,
            spendMoney: 0,
            spendDate: null,
            spendContent: '',
            remark: '',
        },
        spendId: null,
        totalSpendMoney: 0,
        modalName: '',
        modalType: 'add',
        spendList: {},
        spendMoneyArray: [
            {text: "全部", value: -1},
            {text: "10元及以下", value: 10},
            {text: "20元及以下", value: 20},
            {text: "50元及以下", value: 50},
            {text: "100元及以下", value: 100},
            {text: "1000元及以下", value: 1000},
            {text: "1000元以上", value: 1001},
        ],
        spendCatList: {},
        tableStatusList: [],
    },
    mounted: function () {
        this.querySpendCatList();
        this.refreshSpendList();
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
        querySpendCatList() {
            let _this = this;
            let url = "/spend/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.spendCatList = res.data.spendCatList;
                }
            })
        },
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增消费';
            _this.spendForm = {
                spendName: '',
                spendCatId: null,
                spendMoney: 0,
                spendDate: null,
                spendContent: '',
                remark: '',
            };
        },
        // 初始化修改参数
        initEditForm(spendDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改消费';
            _this.spendForm = {
                spendId: spendDetail.spendId,
                spendName: spendDetail.spendName,
                spendMoney: spendDetail.spendMoney,
                spendDate: spendDetail.spendDateStr,
                spendContent: spendDetail.spendContent,
                spendCatId: spendDetail.spendCatId,
                remark: spendDetail.remark,
            };
            $("#spendDateEdit").flatpickr({
                locale: 'zh',
                enableTime: true,
                enableSeconds: true,
                time_24hr: true,
                defaultDate: spendDetail.spendDateStr,
            })
        },
        // 打开新增模态框
        openSpendAdd() {
            let _this = this;
            _this.initAddForm();
            $("#spendModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openSpendEdit(spendId) {
            let _this = this;
            let url = "/spend/detail";
            commonUtil.ajax(url, {'spendId': spendId}, function (res) {
                _this.initEditForm(res.data.spendDetail)
            })
            $("#spendModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        saveSpend() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/spend/add';
            else url = '/spend/update';
            commonUtil.ajax(url, _this.spendForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#spendModal").modal('hide');
                    _this.refreshSpendList();
                }
            })
        },
        refreshSpendList() {
            let _this = this;
            let url = "/spend/list";
            commonUtil.ajax(url, _this.spendQuery, function (res) {
                _this.spendList = res.data.spendList;
                _this.totalSpendMoney = res.data.totalSpendMoney;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/spend/list", pageQuery, function (res) {
                _this.spendList = res.data.spendList;
                _this.totalSpendMoney = res.data.totalSpendMoney;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})