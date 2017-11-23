package com.http_service.download;

import com.http_service.HttpRequest;

/**
 * Created by Administrator on 2017/11/2.
 */

public class DownLoadRequest extends HttpRequest {
    public String desFilePath;
    public String fileName;
    public DownLoadRequest(int tag) {
        super(tag,"http://kaochong.oss-cn-beijing.aliyuncs.com/app-kaochong.apk");
    }
}
