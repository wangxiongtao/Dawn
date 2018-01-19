package com.http_service;

import android.text.TextUtils;

import com.http_service.download.DownLoadRequest;
import com.util.LogUtil;
import com.util.RSACoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by Administrator on 2017/10/21.
 */

public abstract class AbstractHttp {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");


    abstract void doPostRequest(HttpRequest request, HttpCallBack callBack);

    abstract void doGetRequest(HttpCallBack callBack);

    abstract void doDownLoadFile(DownLoadRequest request, HttpCallBack callBack);

    abstract void doUpLoadFile();

    abstract boolean isCorrect(int code);

     OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return addHeader(chain);
                    }
                })
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request r=chain.request();
                        Response response=chain.proceed(r);
                        ResponseBody responseBody = response.body();
                        BufferedSource source = responseBody.source();
                        source.request(Long.MAX_VALUE); // Buffer the entire body.
                        Buffer buffer = source.buffer();
                        Charset charset =  Charset.forName("UTF-8");
                        MediaType contentType = responseBody.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(charset);
                        }

                        String bodyString = buffer.clone().readString(charset);
                        response.body().close();

                        return response;
                    }
                })

                .build();
    }

    private Response addHeader(Chain chain) throws IOException {
        String pKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAnMMaNkfltlJWswWsUhpKHiZ5azMSYueB6kn5YeV0+EB+n0EaLEATTuXqGuTjHYY5fsLbINymG5WXFdh5pTAOaQIDAQABAkBiXV4+P0EZ9XKnpOCrKAnn/1Zi+MoJu6DehYpxbkzGVJ4+bgT2kGt/ef/cFPFVF8/2NeZfQxssjaznfdxqmEP9AiEA0PQ0W9Bdv6EryuWkk+vDTAu5lHJKKiE772ZjVs1Yf18CIQDADqOqYOfMZ7PdC7lU1ycBAkX5g1QsXAGb2aW7FZ3vNwIgbhsgs/jaTa46C1JzJNcpNBtBkS2gUw7sLDyBwC24onUCICbgT7zjVMiJjV0HTIKh8qE/po51SQqZrTGxAt016PxNAiB1Ub4KA7rKnzfwobhOuDexMiNYBksOq4qOp9p1PtN2OA==";
        String signTime = simpleDateFormat.format(System.currentTimeMillis());
        String appVersion = "Android-1.0.0";
        String signContent = "KUAKAO-OTM-STUDENT-" + appVersion + "-" + signTime;
        String deviceId = "11111111";
        String sign = RSACoder.signWithSHA1(signContent, pKey);
        Request original = chain.request();
        LogUtil.e("sign===>" + sign);
        LogUtil.e("signTime===>" + signTime);
        LogUtil.e("deviceId===>" + deviceId);
        LogUtil.e("version===>" + appVersion);

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Connection", "keep-alive")
                .header("token", "")
                .header("sign", TextUtils.isEmpty(sign) ? "" : sign)
                .header("signTime", signTime)
                .header("userType", "2")
                .header("deviceId", deviceId)
                .header("version", appVersion)
                .header("platform", "KUAKAO-OTM-STUDENT");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

}
