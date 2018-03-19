package com.dawn.modules;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dawn.R;
import com.util.LogUtil;

public class ViewPagerActivity extends AppCompatActivity {
    int imgId[]={
            R.drawable.home_top_banner,
            R.drawable.home_top_banner,
//            R.drawable.home_top_banner1,
//            R.drawable.home_top_banner,
//            R.drawable.home_top_banner,
//            R.drawable.home_top_banner,
//            R.drawable.home_top_banner


    };
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        vp=findViewById(R.id.myvp);
        vp.setAdapter(new MyVpAdater(this,imgId));
//        vp.setPageMargin(100);
        vp.setPageTransformer(false,new MyTransfor());
        vp.setOffscreenPageLimit(3);
    }



    public class MyVpAdater extends PagerAdapter {
        private int  list[];
        private Context context;

        public MyVpAdater(Context context, int  list[]) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            MyImage iv = new MyImage(context);
            iv.setPostion(position);
            ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            iv.setImageResource(list[position]);
            iv.setBackgroundColor(Color.parseColor("#ff6600"));
            container.addView(iv,lp);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


    class MyTransfor implements ViewPager.PageTransformer {
        private static final float DEFAULT_MIN_ALPHA = 0.5f;
        private float mMinAlpha = DEFAULT_MIN_ALPHA;
        @Override
        public void transformPage(View view, float position) {
            MyImage image= (MyImage) view;
//            if(image.getPostion()==1){
//                LogUtil.i(view+"========>"+position);
//            }

            //0--->1   0---->-1 滑出
            //-1--->0   1---->0 滑入



            float alpha = 0.0f;
            if (0.0f <= position && position <= 1.0f) {
                LogUtil.i("0<postion<=1==========>"+position+"==下标为=="+image.getPostion());



                alpha = 1.0f - position;


            } else if (-1.0f <= position && position < 0.0f) {
                LogUtil.i("-1<postion<0=========>"+position+"==下标为=="+image.getPostion());
                alpha = position + 1.0f;

            }

            float normalizedposition = Math.abs(Math.abs(position) - 1);
            view.setScaleX(normalizedposition / 2 + 0.5f);
            view.setScaleY(normalizedposition / 2 + 0.5f);


//            if(position<-1){//画出的页面<-1
//                view.setAlpha(0.5f);
//            }else if(position<=1){//中间状态界面[-1,1]
////                if(position<=0){//[-1,0]//画出
////                    LogUtil.i("-1<postion<0=========>"+position+"==下标为=="+image.getPostion());
////                    view.setAlpha(1-position*position*0.5f);
////                }else {//[0,1]
////                    LogUtil.i("0<postion<1==========>"+position+"==下标为=="+image.getPostion());
////                    view.setAlpha(1-position*position*1.0f);
////                }
////                view.setAlpha(0.5f);
//                view.setAlpha(1-position*position*0.5f);
//
//            }else {//滑入的页面>1
//                view.setAlpha(1.0f);
//            }






        }
    }

    class MyImage extends ImageView{
        int postion;

        public MyImage(Context context) {
            super(context);
        }

        public MyImage(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public void setPostion(int postion) {
            this.postion = postion;
        }

        public int getPostion() {
            return postion;
        }

        @Override
        public String toString() {
            return "【我的下标是"+postion+"】";
        }
    }
}
