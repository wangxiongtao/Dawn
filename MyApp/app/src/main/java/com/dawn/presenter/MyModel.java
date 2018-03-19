package com.dawn.presenter;

import com.dawn.mvp.IModel;
import com.http_service.HttpRequest;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class MyModel implements IModel {


    @Override
    public HttpRequest request(HttpRequest request) {
        return request;
    }
}
