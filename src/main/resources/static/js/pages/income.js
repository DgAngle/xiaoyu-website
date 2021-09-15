/* 收入 */
let listVm = new Vue({
    el: "#incomeContainer",
    data: {
        incomeQuery: {
            incomeName: '',
            incomeCatId: -1,
            incomeMoney: -1,
            incomeDate: null,
            incomeContent: null,
            incomeStartDate: null,
            incomeEndDate: null,
        },
        incomeForm: {
            incomeName: '',
            incomeCatId: null,
            incomeMoney: 0,
            incomeDate: null,
            incomeContent: '',
            remark: '',
        },
        incomeId: null,
        totalIncomeMoney: 0,
        modalName: '',
        modalType: 'add',
        incomeList: {},
        incomeMoneyArray: [
            {text: "全部", value: -1},
            {text: "100元及以下", value: 100},
            {text: "1000元及以下", value: 1000},
            {text: "5000元及以下", value: 5000},
            {text: "10000元及以下", value: 10000},
            {text: "10000元以上", value: 10001},
        ],
        incomeCatList: {},
        tableStatusList: [],
    },
    mounted: function () {
        this.queryIncomeCatList();
        this.refreshIncomeList();
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
        queryIncomeCatList() {
            let _this = this;
            let url = "/income/cat/list";
            commonUtil.ajax(url, {}, function (res) {
                if (res && res.value) {
                    _this.incomeCatList = res.data.incomeCatList;
                }
            })
        },
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            _this.modalType = 'add';
            _this.modalName = '新增收入';
            _this.incomeForm = {
                incomeName: '',
                incomeCatId: null,
                incomeMoney: 0,
                incomeDate: null,
                incomeContent: '',
                remark: '',
            };
            $("#incomeDateEdit").flatpickr({
                locale: 'zh',
                enableTime: true,
                // enableSeconds: true,
                time_24hr: true,
                defaultHour: 0,
            })
        },
        // 初始化修改参数
        initEditForm(incomeDetail) {
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改收入';
            _this.incomeForm = {
                incomeId: incomeDetail.incomeId,
                incomeName: incomeDetail.incomeName,
                incomeMoney: incomeDetail.incomeMoney,
                incomeDate: incomeDetail.incomeDateStr,
                incomeContent: incomeDetail.incomeContent,
                incomeCatId: incomeDetail.incomeCatId,
                remark: incomeDetail.remark,
            };
            $("#incomeDateEdit").flatpickr({
                locale: 'zh',
                enableTime: true,
                // enableSeconds: true,
                time_24hr: true,
                defaultDate: incomeDetail.incomeDateStr,
            })
        },
        // 打开新增模态框
        openIncomeAdd() {
            let _this = this;
            _this.initAddForm();
            $("#incomeModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openIncomeEdit(incomeId) {
            let _this = this;
            let url = "/income/detail";
            commonUtil.ajax(url, {'incomeId': incomeId}, function (res) {
                _this.initEditForm(res.data.incomeDetail)
            })
            $("#incomeModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        saveIncome() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/income/add';
            else url = '/income/update';
            commonUtil.ajax(url, _this.incomeForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#incomeModal").modal('hide');
                    _this.refreshIncomeList();
                }
            })
        },
        refreshIncomeList() {
            let _this = this;
            let url = "/income/list";
            commonUtil.ajax(url, _this.incomeQuery, function (res) {
                _this.incomeList = res.data.incomeList;
                _this.totalIncomeMoney = res.data.totalIncomeMoney;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/income/list", pageQuery, function (res) {
                _this.incomeList = res.data.incomeList;
                _this.totalIncomeMoney = res.data.totalIncomeMoney;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})