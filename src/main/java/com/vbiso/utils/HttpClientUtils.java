package com.vbiso.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.Nullable;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:19 PM 2019/1/26
 * @Modified By:
 */
public class HttpClientUtils {

  private static final RequestConfig requestConfig;

  private static final CloseableHttpClient httpClient = HttpClients.createDefault();

  static {
    requestConfig = RequestConfig.custom()
        .setSocketTimeout(2000)
        .setConnectTimeout(2000)
        .setConnectionRequestTimeout(2000)
        .build();
  }


  public static String post(String url, String str) throws IOException {
    HttpPost post = new HttpPost(url);
    post.setConfig(requestConfig);
    post.setHeader("Content-type", "application/json;charset=utf-8");
    StringEntity entity = new StringEntity(str, Charset.forName("utf-8"));
    post.setEntity(entity);
    CloseableHttpResponse resp = httpClient.execute(post);

    return result(resp);

  }

  public static String get(String url) throws IOException {

    HttpGet get = new HttpGet(url);
    CloseableHttpResponse resp = httpClient.execute(get);

    return result(resp);
  }

  public static String postForm(String url, JSONObject params) throws IOException {
    HttpPost httpPost = new HttpPost(url);

    List<BasicNameValuePair> paramsList = Lists.newArrayListWithCapacity(params.size());
    params.getInnerMap().forEach((k,v)-> paramsList.add(new BasicNameValuePair(k, (String) v)));

    httpPost.setEntity(new UrlEncodedFormEntity(paramsList, StandardCharsets.UTF_8));
    CloseableHttpResponse resp = httpClient.execute(httpPost);

    return result(resp);
  }

  @Nullable
  private static String result(CloseableHttpResponse resp) throws IOException {
    return resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK ? EntityUtils
        .toString(resp.getEntity()) : null;
  }

}
