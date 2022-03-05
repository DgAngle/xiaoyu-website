var commonUtil = commonUtil || {};

// 日期格式化
commonUtil.dateFormat = {formatDefault: 'yyyy-MM-dd HH:mm:ss', formatDay: 'yyyy-MM-dd', formatMin: 'yyyy-MM-dd HH:mm'};


window.onload = function () {
    commonUtil.iosClickConfig();

    Qmsg.config({
        position: 'center',
        showClose: true,
        timeout: 5000
    })
}

/* ios 禁止双击放大 */
commonUtil.iosClickConfig = function () {
    document.addEventListener('touchstart', function (event) {
        if (event.touches.length > 1) {
            event.preventDefault();
        }
    })
    var lastTouchEnd = 0;
    document.addEventListener('touchend', function (event) {
        var now = (new Date()).getTime();
        if (now - lastTouchEnd <= 1) {
            event.preventDefault();
        }
        lastTouchEnd = now;
    }, false)
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


commonUtil.openToPlanIndex = function () {
    window.location.href = "/mobile/plan/index";
}

commonUtil.openToPlanWeek = function () {
    window.location.href = "/mobile/plan/week";
}

commonUtil.openToPlanDaily = function () {
    window.location.href = "/mobile/plan/daily";
}