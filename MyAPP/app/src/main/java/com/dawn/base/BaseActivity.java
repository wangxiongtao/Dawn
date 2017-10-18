package com.dawn.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.dawn.R;


/**
 * 基类Activity 定义了Activity中的常用方法
 * 封装了公共的Toolbar 的初始化，
 * 布局文件初始化
 * 状态栏沉浸颜色的初始化
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected TextView mToolbar_Title_Txt;
    protected TextView mToolbar_Right_Txt;
    protected View mToolbar_line_Txt;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            if (!setStatusBarColor()) {
//                StatusBarUtils.setStatusBarColor(this, R.color.white);
//                StatusBarUtils.statusBarDarkMode(this);
            }
            initToolbar();
            initView(savedInstanceState);
            setListener();
            initData();
        }
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (mToolbar == null) {
            return;
        }
        mToolbar_Title_Txt = (TextView) findViewById(R.id.include_toolbar_title_txt);
        mToolbar_Right_Txt = (TextView) findViewById(R.id.include_toolbar_right_txt);
        mToolbar_line_Txt = findViewById(R.id.include_toolbar_line_view);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void showBackIcon(boolean isShow){
        if(getSupportActionBar()==null){
            return;
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(isShow);
    }

    protected abstract int getLayoutId();//加载的布局文件id


    protected abstract void initView(Bundle savedInstanceState);//初始化view

    protected abstract void setListener();//添加的各种监听

    protected abstract void initData();//获取数据等逻辑操作

    /**
     * 如果需要自定义状态栏颜色 则重写此方法 并且返回值必须true(true：代表自己消费此方法)
     * @return 是否是自己自定义状态栏颜色
     */
    protected  boolean setStatusBarColor(){
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
