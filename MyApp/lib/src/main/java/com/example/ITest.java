package com.example;

/**
 * Created by Administrator on 2017/10/30.
 */

public interface ITest {
      String  getValue();

      ITest iii=new ITest() {
            @Override
            public String getValue() {
                  return null;
            }
      };
}
