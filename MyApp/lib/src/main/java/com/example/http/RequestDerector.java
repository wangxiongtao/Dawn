package com.example.http;

/**
 * Created by Administrator on 2017/11/14.
 */

public class RequestDerector implements IRequest {
    private  IRequest iRequest;
    public RequestDerector(IRequest iRequest){
        this.iRequest=iRequest;
    }

    @Override
    public void doRequest() {
        iRequest.doRequest();

    }
}
