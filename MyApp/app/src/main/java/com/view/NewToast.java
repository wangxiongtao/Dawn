package com.view;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by anderson9 on 2016-9-24.
 */

public class NewToast {
    boolean hasReflectException = false;//是否反射成功
      int mAnim =0; //动画配置 默认无



    public   void   setanim (@Nullable int AnimStyle) {
        mAnim=AnimStyle;
    }


    /**
     * 初始化
     */
    public void init(Context context,int AnimStyle) {
//        if (!hasReflectException) //反射获得成功才调用动画否则无设置动画。
            initTN(context,AnimStyle);
    }



    private void initTN(Context context,int AnimStyle) {

        Field mTN;
        Object mObj;
        Class<Toast> clazz = Toast.class;
        Toast t=Toast.makeText(context,"wqdaas",0);
        t.setGravity(Gravity.TOP,0,300);

        try {
            mTN = clazz.getDeclaredField("mTN");
            mTN.setAccessible(true);
            mObj = mTN.get(t);

            // 修改掉默认toast弹出动画
            Field field = mObj.getClass().getDeclaredField("mParams");
            if (field != null) {
                field.setAccessible(true);
                Object mParams = field.get(mObj);
                if (mParams != null
                        && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.flags= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                            | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
                    params.windowAnimations = AnimStyle;

                }
            }
            hasReflectException = false;
        } catch (NoSuchFieldException e) {
            hasReflectException = true;
        } catch (IllegalAccessException e) {
            hasReflectException = true;
        } catch (IllegalArgumentException e) {
            hasReflectException = true;
        }
        t.show();
    }


//    @Override
//    public void cancel() {
//        super.cancel();
//    }

    public int  getAnim() {
        return mAnim;
    }
//    public void show(Context context,String str){
//        init();
//        makeText(context,str,0).show();
//    }

}








