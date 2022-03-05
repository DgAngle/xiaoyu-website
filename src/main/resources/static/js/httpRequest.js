/* 常量封装 */
var httpRequest = httpRequest || {};

/* 请求返回码 */
httpRequest.error_code = 30400; // 调用失败
httpRequest.success_code = 30200; // 调用成功
httpRequest.not_understand_code = 30400; // 无法解析的请求
httpRequest.not_found_code = 30404; // 请求未找到
httpRequest.service_error_code = 30500; // 请求未找到
httpRequest.repeat_code = -1; // 重复


