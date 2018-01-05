package com.dawn.modules;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dawn.R;

public class ViewPagerActivity extends AppCompatActivity {
    int imgId[]={
            R.drawable.home_top_banner,
            R.drawable.home_top_banner,
            R.drawable.home_top_banner1,
            R.drawable.home_top_banner,
            R.drawable.home_top_banner,
            R.drawable.home_top_banner,
            R.drawable.home_top_banner


    };
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        vp=findViewById(R.id.myvp);
        vp.setAdapter(new MyVpAdater(this,imgId));
//        vp.setPageMargin(100);
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
            ImageView iv = new ImageView(context);
            ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            iv.setImageResource(list[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(iv,lp);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
