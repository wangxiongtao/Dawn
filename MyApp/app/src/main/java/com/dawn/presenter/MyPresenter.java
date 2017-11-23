package com.dawn.presenter;

import android.os.Message;

import com.dawn.base.IPresenter;
import com.util.LogUtil;

/**
 * Created by Administrator on 2017/11/7.
 */

public class MyPresenter implements IPresenter {
    public void fun(Message msg){
        LogUtil.i("=====MyPresenter=====>");
        msg.obj="success";
        msg.what=56;
        msg.getTarget().sendMessage(msg);
    }
}
