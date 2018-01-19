package com.dawn.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dawn.R;
import com.dawn.modules.LoginActivity;
import com.http_service.HttpCallBack;


/**
 * 基类Activity 定义了Activity中的常用方法
 * 封装了公共的Toolbar 的初始化，
 * 布局文件初始化
 * 状态栏沉浸颜色的初始化
 */

public abstract class BaseActivity extends AppCompatActivity implements HttpCallBack,Handler.Callback,IView {
    protected final  int STATE_NO_NETWORK=1;
    protected final  int STATE_NO_ERROR=2;
    protected final  int STATE_NO_DATA=3;
    private View mRootLayout;
    protected TextView mToolbar_Title_Txt;
    protected TextView mToolbar_Right_Txt;
    protected View mToolbar_line_Txt;
    protected Toolbar mToolbar;
    private ViewStub mStub;
    private TextView mEmptyTxt;
    private  FrameLayout.LayoutParams lp;
    private  FrameLayout.LayoutParams lp2;
    private  FrameLayout.LayoutParams lp3;
    private OnBackLoginActivityListener listener;
    private boolean isLogin;
    protected Handler mvpHandler;

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.i("aaa","=========onPostCreate==============>");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpHandler=new Handler(this);
        lp3=new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View toolbar=View.inflate(this,R.layout.include_toolbar_layout,null);
        beforeOnCreate();

//        setContentView(toolbar,lp3);
        if (getLayoutId() > 0) {
//            mRootLayout=View.inflate(this,getItemLayoutId(),null);
//            lp2=new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            lp2.topMargin=160;
//            addContentView(mRootLayout,lp2);
            setContentView(getLayoutId());
            if (!setStatusBarColor()) {
//                StatusBarUtils.setStatusBarColor(this, R.color.white);
//                StatusBarUtils.statusBarDarkMode(this);
            }
            initToolbar();
            initView(savedInstanceState);
            setListener();
            initData();
            View v=View.inflate(this,R.layout.include_empty_viewstub_layout,null);
            lp=new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addContentView(v,lp);
             mStub = (ViewStub) findViewById(R.id.viewstub_layout);


//            stub.inflate();
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
                setResult(RESULT_OK);
               onBackPressed();
            }
        });

    }
    public void showBackIcon(boolean isShow){
        if(getSupportActionBar()==null){
            return;
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(isShow);
    }
    protected  void beforeOnCreate(){

    };//加载的布局文件id
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

//    protected void  toActivity(Class<?> cls){
//        Intent intent=new Intent(this,cls);
//        startActivity(intent);
//    }
    protected boolean  toLoginActivity(OnBackLoginActivityListener listener){
        if(!isLogin){
            this.listener=listener;
            Intent intent=new Intent(this, LoginActivity.class);
            startActivityForResult(intent,20);
        }
        return isLogin;

    }


    protected void showLayout(int state){
        switch (state){
            case STATE_NO_DATA:
                if(mEmptyTxt==null){
                    mStub.inflate();
                    mEmptyTxt= (TextView) findViewById(R.id.include_empty_text);
                }
                mStub.setVisibility(View.VISIBLE);
                mEmptyTxt.setText("no data");
                mRootLayout.setVisibility(View.GONE);
                break;

            case STATE_NO_NETWORK:
                if(mEmptyTxt==null){
                    mStub.inflate();
                    mEmptyTxt= (TextView) findViewById(R.id.include_empty_text);
                }
                mStub.setVisibility(View.VISIBLE);
                mEmptyTxt.setText("no network");
                mRootLayout.setVisibility(View.GONE);
                break;
            case STATE_NO_ERROR:
                mRootLayout.setVisibility(View.VISIBLE);
                mStub.setVisibility(View.GONE);
                break;
        }

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(listener!=null){
            listener.onBackLoginActivity();
        }

    }

    @Override
    public void onHttpStart(int tag) {

    }

    @Override
    public void onHttpSuccess(String response, int tag) {

    }

    @Override
    public void onHttpFail(int tag) {

    }

    @Override
    public void onProgress(long total, long current) {

    }
    public interface OnBackLoginActivityListener{
        void onBackLoginActivity();
    }

    @Override
    public boolean handleMessage(Message msg) {
        handlePMessage(msg);
        return true;
    }
    protected void handlePMessage(Message msg){

    }
}
