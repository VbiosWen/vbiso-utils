package com.vbiso.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 2:19 PM 2019/1/26
 * @Modified By:
 */
public class HttpClientUtils {

  private static final RequestConfig requestConfig;

  static {
    requestConfig=RequestConfig.custom()
        .setSocketTimeout(2000)
        .setConnectTimeout(2000)
        .setConnectionRequestTimeout(2000)
        .build();
  }


  public static String post(String url,String str) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost post=new HttpPost(url);
    post.setConfig(requestConfig);
    post.setHeader("Content-type","application/json;charset=utf-8");
    StringEntity entity=new StringEntity(str, Charset.forName("utf-8"));
    post.setEntity(entity);
    CloseableHttpResponse resp = httpClient.execute(post);
    if(resp.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
      return EntityUtils.toString(resp.getEntity());
    }
    return null;
  }

  public static String get(String url) throws IOException {
    CloseableHttpClient httpClient=HttpClients.createDefault();
    HttpGet get=new HttpGet(url);
    CloseableHttpResponse resp = httpClient.execute(get);
    if(resp.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
      return EntityUtils.toString(resp.getEntity());
    }
    return null;
  }

}
