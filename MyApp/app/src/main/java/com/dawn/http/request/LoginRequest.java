package com.dawn.http.request;

import com.http_service.HttpRequest;

import static com.http_service.HttpUrl.login;

/**
 * Created by Administrator on 2017/11/1.
 */

public class LoginRequest extends HttpRequest {
    public String mobilePhone;//11位数字 手机号
    public String vCode;//密码或者验证码
    public LoginRequest(int tag) {
        super(tag, login);
    }

}

