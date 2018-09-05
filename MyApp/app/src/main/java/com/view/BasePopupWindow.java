package com.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public abstract class BasePopupWindow {
     private PopupWindow popupWindow;
     private Context context;
     public BasePopupWindow(Context context){
         this.context=context;
         View contentView = View.inflate(context, getLayoutId(),null);
         popupWindow=new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
         createView(contentView);
         popupWindow.setFocusable(true);
         popupWindow.setOutsideTouchable(true);
//         if(Build.VERSION.SDK_INT!=Build.VERSION_CODES.N){
//             popupWindow.update();
//         }
         popupWindow.update();
//         popupWindow.update();
         // 实例化一个ColorDrawable颜色为半透明
         ColorDrawable dw = new ColorDrawable(0xff6600);
         // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
         popupWindow.setBackgroundDrawable(dw);
     }
     public Context getContext(){
         return context;
     }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public void showAsDropDown(View anchor){
//        if(popupWindow!=null&&!popupWindow.isShowing()) {
//            popupWindow.showAsDropDown(view,0,0, Gravity.NO_GRAVITY);
//        }
        if (Build.VERSION.SDK_INT >= 24) {
            Rect visibleFrame = new Rect();
            anchor.getGlobalVisibleRect(visibleFrame);
            int height = anchor.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
            popupWindow.setHeight(height);
            popupWindow.showAsDropDown(anchor, 0, 0);
        } else {
            popupWindow.showAsDropDown(anchor, 0, 0);

        }
    }
    public void dismiss(){
        if(popupWindow!=null&&popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }

     public abstract int getLayoutId();
     public abstract void  createView(View contentView);
}
