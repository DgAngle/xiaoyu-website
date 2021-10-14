/* 消费 */
let listVm = new Vue({
    el: "#timeRecordContainer",
    data: {
        timeRecordQuery: {
            timeRecordAddress: null,
            timeRecordName: '',
            timeRecordStartDt: null,
            timeRecordEndDt: null,
        },
        timeRecordForm: {
            timeRecordAddress: '江苏苏州',
            timeRecordDt: null,
            timeRecordName: '',
            spendTimeHour: 0,
            spendTimeMin: 0,
            remark: '',
        },
        timeRecordId: null,
        totalTimeRecordDt: "",
        modalName: '',
        modalType: 'add',
        sumHour: 0,
        sumMin: 0,
        timeRecordList: {},
        tableStatusList: [],
    },
    mounted: function () {
        this.refreshTimeRecordList();
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
        // 初始化新增参数
        initAddForm() {
            let _this = this;
            let timeRecordDt = commonUtil.getFormatDate("yyyy-MM-dd");
            _this.modalType = 'add';
            _this.modalName = '新增时间记录';
            _this.timeRecordForm = {
                timeRecordAddress: '江苏苏州',
                timeRecordDt: timeRecordDt,
                timeRecordName: '',
                spendTimeHour: 0,
                spendTimeMin: 0,
                remark: '',
            };
            $("#timeRecordDtEdit").flatpickr({
                locale: 'zh',
                // enableTime: false,
                // enableSeconds: true,
                // time_24hr: true,
                defaultDate: timeRecordDt,
            })
        },
        // 初始化修改参数
        initEditForm(timeRecordDetail) {
            console.log(timeRecordDetail)
            let _this = this;
            _this.modalType = 'edit';
            _this.modalName = '修改时间记录';
            _this.timeRecordForm = {
                timeRecordId: timeRecordDetail.timeRecordId,
                timeRecordAddress: timeRecordDetail.timeRecordAddress,
                timeRecordDt: timeRecordDetail.timeRecordDtStr,
                timeRecordName: timeRecordDetail.timeRecordName,
                spendTimeHour: timeRecordDetail.spendTimeHour,
                spendTimeMin: timeRecordDetail.spendTimeMin,
                remark: timeRecordDetail.remark,
            };
            $("#timeRecordDtEdit").flatpickr({
                locale: 'zh',
                // enableTime: false,
                // enableSeconds: true,
                // time_24hr: true,
                defaultDate: timeRecordDetail.timeRecordDtStr,
            })
        },
        // 打开新增模态框
        openTimeRecordAdd() {
            let _this = this;
            _this.initAddForm();
            $("#timeRecordModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 打开新增修改
        openTimeRecordEdit(timeRecordId) {
            let _this = this;
            let url = "/timeRecord/detail";
            commonUtil.ajax(url, {'timeRecordId': timeRecordId}, function (res) {
                _this.initEditForm(res.data.timeRecordDetail)
            })
            $("#timeRecordModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        // 执行增/改操作
        saveTimeRecord() {
            let _this = this;
            let url = '';
            if (_this.modalType == 'add') url = '/timeRecord/add';
            else url = '/timeRecord/update';
            commonUtil.ajax(url, _this.timeRecordForm, function (res) {
                if (res && res.value) {
                    Qmsg.success(res.message);
                    $("#timeRecordModal").modal('hide');
                    _this.refreshTimeRecordList();
                }
            })
        },
        refreshTimeRecordList() {
            let _this = this;
            let url = "/timeRecord/list";
            commonUtil.ajax(url, _this.timeRecordQuery, function (res) {
                _this.timeRecordList = res.data.timeRecordList;
                _this.sumHour = res.data.sumHour;
                _this.sumMin = res.data.sumMin;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        },
        refreshPaginationList(pageQuery) {
            let _this = this;
            commonUtil.ajax("/timeRecord/list", pageQuery, function (res) {
                _this.timeRecordList = res.data.timeRecordList;
                _this.sumHour = res.data.sumHour;
                _this.sumMin = res.data.sumMin;
                paginationVm.pagination = res.data.pagination;
                paginationVm.initNumbers();
            })
        }
    }
})