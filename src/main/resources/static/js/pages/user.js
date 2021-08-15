/* 收藏分类 */
new Vue({
    el: "#userContainer",
    data: {
        userQuery: {
            userName: '',
        },
        userForm: {
            realname: '',
            username: '',
            password: '',
            sex: 1,
        },
        userList: {}
    },
    mounted: function () {
        this.refreshUserList();
    },
    methods: {
        openUserAdd() {
            let _this = this;
            _this.userForm = {
                realname: '',
                username: '',
                password: '',
                sex: 1,
            };
            $("#userModal").modal({
                keyboard: true,
                backdrop: "static"
            })
        },
        addUser() {
            let _this = this;
            let url = "/collect/cat/add";
            console.log(_this.userForm);
            $("#userModal").modal('hide');
            // commonUtil.ajax(url, _this.userForm, function (res) {
            //     if (res && res.data.value) {
            //         alert(res.data.message);
            //         $("#userModal").modal('hide');
            //         _this.refreshCollationCatList();
            //     }
            // })
        },
        refreshUserList() {
            let _this = this;
            let url = "/user/list";
            commonUtil.ajax(url, _this.userQuery, function (res) {
                console.log(res);
                _this.userList = res.data.userList;
            })
        },
        checkSex(sexValue) {
            let _this = this;
            _this.userForm.sex = sexValue;
        }
    }
})