package com.jiuye.sona.common.HttpUtil;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/6/23 16:30
 * @Email: huxinjian@jiuyescm.com
 */
public class HttpClientUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static HttpClientBuilder httpClientBuilder;

    /**
     * 初始化HttpClient
     * 支持连接池，支持http和https
     */
    private static void init() {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
            // 配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslsf).build();
            // 初始化连接管理器
            PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            // 将最大连接数增加到200，实际项目最好从配置文件中读取这个值
            pool.setMaxTotal(200);
            // 设置最大路由
            //这里为什么要特别提到route最大连接数这个参数呢，因为这个参数的默认值为2，如果不设置这个参数值默认情况下对于同一个目标机器的最大并发连接只有2个！这意味着如果你正在执行一个针对某一台目标机器的抓取任务的时候，哪怕你设置连接池的最大连接数为200，但是实际上还是只有2个连接在工作，其他剩余的198个连接都在等待，都是为别的目标机器服务的。
            pool.setDefaultMaxPerRoute(20);
            // 根据默认超时限制初始化requestConfig
            int socketTimeout = 30 * 1000;
            int connectTimeout = 30 * 1000;
            int connectionRequestTimeout = 30 * 1000;
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();

            httpClientBuilder = HttpClients.custom()
                    .setConnectionManager(pool)
                    // 设置请求配置
                    .setDefaultRequestConfig(requestConfig)
                    // 设置重试次数
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        } catch (NoSuchAlgorithmException e) {
            log.error("Init HttpClientConnectionPool failed!", e);
        } catch (KeyStoreException e) {
            log.error("Init HttpClientConnectionPool failed!", e);
        } catch (KeyManagementException e) {
            log.error("Init HttpClientConnectionPool failed!", e);
        }
    }

    /**
     * 获取CloseableHttpClient
     *
     * @return {@link CloseableHttpClient}
     */
    private static CloseableHttpClient getHttpClient() {
        if (httpClientBuilder == null) {
            init();
        }
        CloseableHttpClient httpClient = httpClientBuilder.build();
        return httpClient;
    }

    /**
     * 关闭response
     *
     * @param response http响应
     */
    private static void closeResponse(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                log.error("Http请求处理失败：{}", e);
            }
        }
    }

    /**
     * GET请求
     * 不支持Header参数
     *
     * @param url   请求地址
     * @param param URL参数列表
     * @return 响应内容
     * @throws HttpException
     */
    public static String doGet(String url, Map<String, String> param, Header[] headers) throws HttpException {

        // 创建Httpclient对象
        CloseableHttpClient httpClient = getHttpClient();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if (headers != null && headers.length > 0) {
                httpGet.setHeaders(headers);
            }
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                resultString = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
            }
            //EntityUtils.consume会释放资源，所以放在外面，不然返回不是200的时候不会释放连接
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            log.error("Http GET请求处理失败", e);
            throw new HttpException("Http GET请求处理失败", e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }

    /**
     * GET请求
     * 支持header
     *
     * @param url 请求地址
     * @return 响应内容
     * @throws HttpException
     */
    public static String doGet(String url, Header[] headers) throws HttpException {
        return doGet(url, null, headers);
    }

    /**
     * GET请求
     *
     * @param url 请求地址
     * @return 响应内容
     * @throws HttpException
     */
    public static String doGet(String url) throws HttpException {
        return doGet(url, null, null);
    }

    /**
     * GET请求
     *
     * @param url 请求地址
     * @return 响应内容
     * @throws HttpException
     */
    public static String doGet(String url, Map<String, String> param) throws HttpException {
        return doGet(url, param, null);
    }
    /**
     * POST请求
     * 不支持Header参数
     *
     * @param url   请求地址
     * @param param URL参数列表
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPost(String url, Map<String, String> param) throws HttpException {
        String resultString = doPost(url, param, null);
        return resultString;
    }

    /**
     * POST请求
     *
     * @param url   请求地址
     * @param param URL参数列表
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPost(String url, Map<String, String> param, Header[] headers) throws HttpException {
        long t0 = System.currentTimeMillis();
        long t1 = System.currentTimeMillis();
        CloseableHttpClient httpClient = getHttpClient();
        long t2 = System.currentTimeMillis();
        log.debug("获取HttpClient连接耗时：" + (t2 - t1));
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if (headers != null && headers.length > 0) {
                httpPost.setHeaders(headers);
            }
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            t1 = System.currentTimeMillis();
            log.debug("封装请求参数耗时：" + (t1 - t2));
            // 执行http请求
            response = httpClient.execute(httpPost);
            t2 = System.currentTimeMillis();
            log.debug(" 执行http请求耗时：" + (t2 - t1));
            resultString = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
            t1 = System.currentTimeMillis();
            log.debug(" 解析结果耗时：" + (t1 - t2));
            EntityUtils.consume(response.getEntity());
            t2 = System.currentTimeMillis();
            log.debug(" 释放资源耗时：" + (t2 - t1));
        } catch (Exception e) {
            log.error("Http POST请求处理失败", e);
            throw new HttpException("Http POST请求处理失败", e);
        } finally {
            closeResponse(response);
            t1 = System.currentTimeMillis();
            log.debug(" 关闭response耗时：" + (t1 - t2));
        }
        log.debug(" 总耗时：" + (System.currentTimeMillis() - t0));
        return resultString;
    }

    /**
     * POST请求
     *
     * @param url 请求地址
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPost(String url) throws HttpException {
        return doPost(url, null);
    }

    public static String doPostJson(String url, String json, Header[] headers) throws HttpException {
        long startTime = 0;
        // 创建Httpclient对象
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if (headers != null && headers.length > 0) {
                httpPost.setHeaders(headers);
            }
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            startTime = System.currentTimeMillis();
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            log.info("请求发起到请求异常消耗时间："+ (System.currentTimeMillis() - startTime));
            log.error("Http POST JSON请求处理失败", e);
            throw new HttpException("Http POST JSON请求处理失败", e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }

    /**
     * POST请求
     *
     * @param url  请求地址
     * @param json body内容
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPostJson(String url, String json) throws HttpException {
        String result = doPostJson(url, json, null);
        return result;
    }

    /**
     * POST请求
     *
     * @param url        请求地址
     * @param parameters UrlEncodedForm键值列表
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPostUForm(String url, List<NameValuePair> parameters) throws HttpException {
        String resultString = doPostUForm(url, parameters, null);
        return resultString;
    }

    /**
     * @param url      请求地址
     * @param json     body内容
     * @param filePath
     * @return 如果响应是JSON，返回JSON字符串；不是则将响应存为文件
     */
    public static String doPostJsonFile(String url, String json, String filePath) throws HttpException {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        FileOutputStream outstream = null;
        String resultString = "";
        try {
            // 创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000)
                    .setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
            httpPost.setConfig(requestConfig);

            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            if (response != null) {
                Header[] contentTypeHeader = response.getHeaders("Content-Type");
                if (contentTypeHeader != null && contentTypeHeader.length > 0
                        && ContentType.APPLICATION_JSON.getMimeType()
                        .equals(ContentType.parse(contentTypeHeader[0].getValue()).getMimeType())) {
                    resultString = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
                } else {
                    outstream = new FileOutputStream(new File(filePath));
                    // 获取结果实体
                    response.getEntity().writeTo(outstream);
                }
            }
        } catch (Exception e) {
            log.error("Http POST JSONFile请求处理失败", e);
            throw new HttpException("Http POST JSONFile请求处理失败", e);
        } finally {
            closeResponse(response);

            if (outstream != null) {
                try {
                    outstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }

    /**
     * POST请求
     *
     * @param url        请求地址
     * @param parameters UrlEncodedForm键值列表
     * @return 响应内容
     * @throws HttpException
     */
    public static String doPostUForm(String url, List<NameValuePair> parameters, Header[] headers) throws HttpException {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if (headers != null && headers.length > 0) {
                httpPost.setHeaders(headers);
            }
            // 创建请求内容
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, DEFAULT_CHARSET);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            log.error("Http POST UrlEncodedForm请求处理失败", e);
            throw new HttpException("Http POST UrlEncodedForm请求处理失败", e);
        } finally {
            closeResponse(response);
        }
        return resultString;
    }


    public static void main(String[] args) throws HttpException {
        String url = "https://restapi.amap.com/v3/config/district";
        Map<String, String> params = new HashMap<>();
        params.put("key","cfeb6351758c42fa131477235cfde233");
        params.put("output", "JSON");
        params.put("subdistrict","4");
        String result = HttpClientUtil.doGet(url, params);
        System.out.println(result);
    }
}
