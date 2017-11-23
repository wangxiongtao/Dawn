package com.example.manager;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BaseManger implements IManager{
    private IManager iManager;
    private IManager iManager1;

    public BaseManger(IManager iManager) {
        this.iManager = iManager;
    }

    @Override
    public void destory() {
        iManager.destory();
    }

    @Override
    public IManager getInstance() {
        if(iManager1==null){
            iManager1=iManager;

        }
        return iManager1;
    }
}
