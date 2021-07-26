let commonUtil;

window.onload = function () {
    // 获取页面路径
    let url = window.location.href;
    let ext = url.indexOf("menuConfig");

    $("#menu").find("li>a").each(function () {
        let href = $(this).attr("href");
        if (href && url.indexOf(href) != -1) {
            $(this).parent("li").addClass("active");
            $(this).parent("li").parent("ul").addClass("in");
            $(this).parent("li").parent("ul").parent("li").addClass("active");
        }
    });

    commonUtil = commonUtil || {};

    /*弹出模态框*/
    commonUtil.openDialog = function (title, url, callback) {
        console.log(title);
    }
}



