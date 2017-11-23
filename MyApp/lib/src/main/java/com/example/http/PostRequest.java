package com.example.http;

/**
 * Created by Administrator on 2017/11/14.
 */

public class PostRequest implements IRequest {
    @Override
    public void doRequest() {
        System.out.println("=========>i am post");
    }
}
