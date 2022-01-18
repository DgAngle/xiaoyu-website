function openUserModal() {
    $("#topUserModal").modal({
        keyboard: true,
        backdrop: "static"
    })
}

// 初始化 fileInput
function initFileInput(inputId, uploadUrl) {
    $('#' + inputId).fileinput({
        // theme: 'fas',
        // language: 'zh', //设置语言
        // uploadUrl: uploadUrl, //上传的地址
        // allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
        // showUpload: false, //是否显示上传按钮
        // showCaption: false,//是否显示标题
        // browseClass: "btn btn-primary", //按钮样式
        // previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        theme: 'fa',
        language: 'zh',
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题行
        uploadAsync: true,//异步上传
        uploadUrl: uploadUrl,
        allowedFileExtensions: ['jpg', 'png', 'gif', 'mp4'],
        maxFileSize: 0,
        maxFileCount: 1,
        enctype: 'multipart/form-data',
        maxHeight: '300px',
    });
}

$(function () {
    initFileInput("user-avatar", "/upload/avatar")
})