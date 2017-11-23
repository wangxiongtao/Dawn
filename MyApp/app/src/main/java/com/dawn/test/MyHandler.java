package com.dawn.test;

import com.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyHandler {
    List<MyMessage>list=new ArrayList<>();

    public void handlerMessage(){

    }

    public void sendMessage(){
        MyMessage myMessage=new MyMessage();
        myMessage.handler=this;
        list.add(myMessage);
        list.get(0).handler.handlerMessage();

    }
    public void loop(){
        LogUtil.i("==-----------------------====loop===========>");
    }


}
