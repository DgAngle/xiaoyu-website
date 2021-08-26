var commonUtil = commonUtil || {};

commonUtil.statusList = [];
commonUtil.status = [0, 2, 3, 4, 5, 8]

window.onload = function () {
    // 获取页面路径
    let url = window.location.href;

    $("#menu").find("li>a").each(function () {
        let href = $(this).attr("href");
        if (href && url.indexOf(href) != -1) {
            $(this).parent("li").addClass("active");
            $(this).parent("li").parent("ul").addClass("in");
            $(this).parent("li").parent("ul").parent("li").addClass("active");
        }
    });

    Qmsg.config({
        position: 'center',
        showClose: true,
        timeout: 5000
    })

    /* 全局状态码 */
    commonUtil.ajax("/code/statusList", {}, function (res) {
        for (let i = 0; i < commonUtil.status.length; i++) {
            let statusItem = {};
            statusItem.statusCode = commonUtil.status[i];
            statusItem.statusMessage = res.data.statusMap[commonUtil.status[i]];
            commonUtil.statusList[i] = statusItem;
        }
    })
}

/*弹出模态框*/
commonUtil.openDialog = function (title, url, callback) {
    console.log(title);
}

/*Ajax请求*/
commonUtil.ajax = function (url, data, successCallback) {
    $.ajax({
        // async: false, // 默认true, 异步执行
        // traditional:true // 默认为false,是否使用传统的方式浅层序列化, 如果是数组, 设置为true
        url: url,
        data: data,
        type: 'POST',
        dataType: 'JSON',
        success: successCallback,
        error: function () {
            alert("error!");
        }
    })
}



