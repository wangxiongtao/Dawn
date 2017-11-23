package com.example;

/**
 * Created by Administrator on 2017/11/13.
 */

public class TestDerector implements ITest {
    ITest iTest;
    public TestDerector(ITest iTest){
        this.iTest=iTest;

    }

    @Override
    public String getValue() {
        return iTest.getValue();
    }
}
