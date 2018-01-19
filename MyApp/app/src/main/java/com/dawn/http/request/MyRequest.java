package com.dawn.http.request;


import com.http_service.HttpRequest;

import static com.http_service.HttpUrl.home;

/**
 * Created by Administrator on 2017/10/21.
 */

public  class MyRequest  extends HttpRequest {
    public String id;
    public String name;
    public int age;


    public MyRequest(int tag) {
        super(tag,home);
    }
}


