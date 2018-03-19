package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class DottedLineView extends View {
    private int pointLength=25;//虚线中每个点的长度 宽度为在XML中声明的宽度
    private int space=10;//点与点之间的距离
    Paint paint;
    Rect rect;


    public DottedLineView(Context context) {
        super(context);
        init();
    }

    public DottedLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DottedLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        paint.setColor(Color.parseColor("#ff0000"));//虚线的颜色 （黑色）
        rect=new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startLeft=0;
        int startTop=0;
      for (int i=0;;i++){
          if(i!=0){
              startTop=startTop+pointLength+space;
          }
          rect.left=startLeft;
          rect.right=startLeft+getWidth();
          rect.top=startTop;
          rect.bottom=startTop+pointLength;
          canvas.drawRect(rect,paint);
          if(rect.bottom>=getHeight()){//超过View的宽度退出循环
              return;
          }
      }
    }
}
