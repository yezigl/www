package com.alipay.util.httpclient;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * HttpProtocolHandler
 */
public class HttpProtocolHandler {

    private static final String DEFAULT_CHARSET = "GBK";
    private static final int DEFAULT_CONNECTION_TIMEOUT = 8000;
    private static final int DEFAULT_SO_TIMEOUT = 30000;
    private static final int DEFAULT_IDLE_CONN_TIMEOUT = 60000;
    private static final int DEFAULT_MAX_CONN_PER_ROUTE = 30;
    private static final int DEFAULT_MAX_TOTAL_CONN = 80;

    private final PoolingHttpClientConnectionManager connectionManager;
    private static final HttpProtocolHandler instance = new HttpProtocolHandler();

    private HttpProtocolHandler() {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONN_PER_ROUTE);
        connectionManager.setMaxTotal(DEFAULT_MAX_TOTAL_CONN);
    }

    public static HttpProtocolHandler getInstance() {
        return instance;
    }

    public HttpResponse execute(HttpRequest request, String fileParamName, String filePath) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build()) {

            HttpResponse response = new HttpResponse();
            String charset = request.getCharset() != null ? request.getCharset() : DEFAULT_CHARSET;

            if (HttpRequest.METHOD_GET.equals(request.getMethod())) {
                HttpGet httpGet = new HttpGet(request.getUrl());
                httpGet.setHeader("User-Agent", "Mozilla/4.0");
                response = executeRequest(httpClient, httpGet);
            } else {
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.setHeader("User-Agent", "Mozilla/4.0");

                if (fileParamName != null && !fileParamName.isEmpty() && filePath != null && !filePath.isEmpty()) {
                    // Multipart request
                    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                    builder.addBinaryBody(fileParamName, new File(filePath), ContentType.DEFAULT_BINARY, filePath);

                    for (NameValuePair entry : request.getParameters()) {
                        builder.addTextBody(entry.getName(), entry.getValue(), ContentType.create("text/plain", charset));
                    }

                    httpPost.setEntity(builder.build());
                } else {
                    // Simple POST request
                    StringEntity entity = new StringEntity(request.getQueryString(), ContentType.create("application/x-www-form-urlencoded", charset));
                    httpPost.setEntity(entity);
                }

                response = executeRequest(httpClient, httpPost);
            }
            return response;
        }
    }

    private HttpResponse executeRequest(CloseableHttpClient httpClient, HttpGet httpGet) throws IOException {
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            return handleResponse(httpResponse);
        }
    }

    private HttpResponse executeRequest(CloseableHttpClient httpClient, HttpPost httpPost) throws IOException {
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            return handleResponse(httpResponse);
        }
    }

    private HttpResponse handleResponse(CloseableHttpResponse httpResponse) throws IOException {
        HttpResponse response = new HttpResponse();
        response.setResponseHeaders(httpResponse.getHeaders());
        try {
            response.setStringResult(EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8));
        } catch (ParseException e) {
            // ignore
        }
        return response;
    }
}
