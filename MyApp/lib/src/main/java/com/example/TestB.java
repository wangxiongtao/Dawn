package com.example;

/**
 * Created by Administrator on 2017/11/14.
 */

public class TestB extends TestDerector {
    public TestB(ITest iTest) {
        super(iTest);
    }

    @Override
    public String getValue() {
        return "I AM b"+super.getValue();
    }
}
