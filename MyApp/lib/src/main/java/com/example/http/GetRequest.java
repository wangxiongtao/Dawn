package com.example.http;

/**
 * Created by Administrator on 2017/11/14.
 */

public class GetRequest extends RequestDerector {
    public GetRequest(IRequest iRequest) {
        super(iRequest);
    }

    @Override
    public void doRequest() {
        System.out.println("===========>i am get");
    }
}
