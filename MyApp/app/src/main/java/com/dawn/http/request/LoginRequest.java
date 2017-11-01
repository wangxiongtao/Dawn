package com.dawn.http.request;

import com.okhttp.HttpRequest;

/**
 * Created by Administrator on 2017/11/1.
 */

public class LoginRequest extends HttpRequest {
    public String name;
    public LoginRequest(int tag) {
        super(tag);
    }

}

