package com.http_service;

/**
 * Created by Administrator on 2017/10/21.
 */

public interface HttpCallBack {
    void onHttpStart(int tag);

    void onHttpSuccess(String response, int tag);

    void onHttpFail(int tag);

    void onProgress(long total, long current);
}
