package com.http2;

/**
 * Created by Administrator on 2017/11/23.
 */

public class HttpMananger {
    private static HttpMananger httpMananger;
    public static HttpMananger getInstance(){
        if(httpMananger==null){
            httpMananger=new HttpMananger();
        }
        return httpMananger;
    }
    public void doRequest(IHttp http,HttpRequest request){
        http.doRequest(request);
    }



}
