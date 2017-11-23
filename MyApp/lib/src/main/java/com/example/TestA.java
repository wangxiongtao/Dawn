package com.example;

/**
 * Created by Administrator on 2017/11/13.
 */

public class TestA extends TestDerector {
    public TestA(ITest iTest) {
        super(iTest);
    }

    @Override
    public String getValue() {
        return "I am A"+super.getValue();
    }
}
