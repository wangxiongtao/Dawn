package com.example.http;

/**
 * Created by Administrator on 2017/11/14.
 */

public class Process {
    public static void  main(String[]args){
        IRequest request=new GetRequest(new PostRequest());
        request.doRequest();

    }
}
