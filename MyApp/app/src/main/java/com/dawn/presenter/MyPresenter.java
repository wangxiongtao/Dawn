package com.dawn.presenter;

import com.dawn.http.request.LoginRequest;
import com.dawn.mvp.IView;

/**
 * Created by Administrator on 2017/11/7.
 */

public class MyPresenter extends BasePresenter {
    public MyPresenter(IView view) {
        super(view);
    }

    public void getData(){
      new MyModel().request(new LoginRequest(1)).doRequest(this);



        getView().handlerView(0,1);

    }

    @Override
    public void onHttpSuccess(String response, int tag) {

    }

    @Override
    public void onProgress(long total, long current) {

    }
}
