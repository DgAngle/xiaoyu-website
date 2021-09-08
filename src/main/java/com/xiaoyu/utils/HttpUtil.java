package com.xiaoyu.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/8 17:04
 */
public class HttpUtil {


    /**
     * 发送post请求
     *
     * @param url      路径
     * @param params   参数(json类型)
     * @param encoding 编码格式
     * @return 响应报文
     */
    public static String sendPost(String url, JSONObject params, String encoding) {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000) // 设置从connect Manager获取Connection 超时时间，单位毫秒
                .setConnectTimeout(3000) // 设置连接超时时间，单位毫秒
                .setSocketTimeout(3000).build(); // 设置请求获取数据的超时时间，单位毫秒
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //装填参数
        StringEntity stringEntity = new StringEntity(params.toString(), "utf-8");
        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        //设置参数到请求对象中
        httpPost.setEntity(stringEntity);
        // System.out.println("请求地址：" + url);
        // System.out.println("请求参数："+ nvps.toString());

        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        // httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放链接
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}
