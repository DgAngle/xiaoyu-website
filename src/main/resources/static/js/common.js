var commonUtil = commonUtil || {};

commonUtil.statusList = [];
commonUtil.status = [0, 2, 3, 4, 5, 8]

window.onload = function () {
    // 获取页面路径
    let url = window.location.href;

    /* 激活菜单, 如果当前地址包含菜单地址, 证明目前在该菜单 */
    $("#menu").find("li>a").each(function () {
        let href = $(this).attr("href"); // 菜单跳转地址
        if (href && url.indexOf(href) != -1) {
            $(this).parent("li").addClass("active");
            $(this).parent("li").parent("ul").addClass("in");
            $(this).parent("li").parent("ul").parent("li").addClass("active");
        }
    });
    /* 默认时间插件初始化 */
    $(".datetime").flatpickr({
        locale: 'zh',
        enableTime: true,
        defaultHour: 0,
        enableSeconds: true,
        time_24hr: true,
    });
    /* 搜索栏时间插件初始化 */
    $(".datetime-search").flatpickr({
        locale: 'zh',
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
            // alert("error!");
        }
    })
}

/* 获取最后一个反斜杠"/"后的参数 */
commonUtil.getUrlBackslashParams = function () {
    // 获取页面路径
    let url = window.location.href;
    let lastIndex = url.lastIndexOf("\/");
    return url.substring(lastIndex + 1, url.length);
}

/* 获取指定字符串后的反斜杠”/“参数值, 返回数组 */
commonUtil.getUrlBackslashParam = function (param) {
    // 获取页面路径
    let url = window.location.href;
    let lastIndex = url.lastIndexOf("param");
    let str = url.substring(lastIndex + 1, url.length);
    return str.split("\/");
}

/* 获取问号后面指定的参数, 返回对应的参数值, 没有则返回false */
commonUtil.getUrlParam = function (paramName) {
    // 获取页面路径
    let urlParams = window.location.search.substring(1);
    let vars = urlParams.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == paramName) {
            return pair[1];
        }
    }
    return (false);
}

/* 获取问号后面所有的参数, 返回参数值数组 */
commonUtil.getUrlParams = function () {
    // 获取页面路径
    let params = [];
    let urlParamStr = window.location.search.substring(1);
    let vars = urlParamStr.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        params[i] = pair[1];
    }
    return params;
}

commonUtil.keyDown = function (domId) {
    // console.log(event.key) 按键
    // console.log(event.keyCode) 按键对应的code
    if (event.key == 'Enter') {
        document.getElementById(domId).click();
    }
}


commonUtil.getFormatDate = function (format) {
    let curDate = new Date();
    let year = curDate.getFullYear();
    let month = curDate.getMonth() + 1;
    let day = curDate.getDate();

    let hour = curDate.getHours();
    let minutes = curDate.getMinutes();
    let seconds = curDate.getSeconds();

    if (format == "yyyy-MM-dd HH:mm:ss") return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    if (format == "yyyy-MM-dd HH:mm") return year + "-" + month + "-" + day + " " + hour + ":" + minutes;
    if (format == "yyyy-MM-dd") return year + "-" + month + "-" + day;

    return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds

}
