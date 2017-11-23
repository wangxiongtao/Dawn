package com.example;

/**
 * Created by Administrator on 2017/11/13.
 */

public class ContextState {
    private MyState state;

    public void setState(MyState state) {
        this.state = state;
    }
    public void showSate(int i){
        switch (i){
            case 1:
                break;
            case 2:
                break;
        }
    }
}
