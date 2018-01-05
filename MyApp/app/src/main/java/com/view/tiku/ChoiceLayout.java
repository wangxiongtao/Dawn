package com.view.tiku;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dawn.R;
import com.view.adapter.rv.CommonRvAdapter;
import com.view.adapter.rv.CommonRvViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/12.
 */

public class ChoiceLayout extends LinearLayout {
    private TextView mTiContentTxt;
    private RecyclerView mAnswerRv;
    private MyAdapter mAdapter;
    private List<String> mAnswerList;
    private int type;//0:单选  1：多选
    public ChoiceLayout(Context context) {
        super(context);
        init();
    }

    public ChoiceLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChoiceLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        setOrientation(VERTICAL);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        mTiContentTxt=new TextView(getContext());
        mAnswerRv=new RecyclerView(getContext());
        mAnswerList=new ArrayList<>();
        mAnswerRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAnswerRv.setHasFixedSize(true);
        mAnswerRv.setNestedScrollingEnabled(false);
        mAnswerList.add("dsaasdsadddddddddddasd");
        mAnswerList.add("dsa");
        mAnswerList.add("dsaasdaswqedqw");
        mAnswerList.add("dsaddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//
//        for (int i=0;i<20;i++){
//            mAnswerList.add("========>"+i);
//        }
        mAnswerRv.setAdapter(new MyAdapter(mAnswerList));
        mTiContentTxt.setText("我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目我是题目");
        addView(mTiContentTxt);
        addView(mAnswerRv,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView t=new TextView(getContext());
        t.setText("dasdadqwfadfsafsadsadddddddqwedwqdsadsadsafwdasdsasadtsaidgiuasghduhasijdiosajdijasdjasjdjsafiopjsapoifjiopdsajflkjdsifdsifdiojfidskldsjglkfdjgklfdjgklfdjglkdfjglkjlskdjglsdkjfslkdjflksdfjlkjjsdjflksdjfklsdjfsdlijlfsddsfdsfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsddas");
        addView(t);
    }



    class MyAdapter extends CommonRvAdapter<String> {

        public MyAdapter(List<String> mDataList) {
            super(mDataList);
        }

        @Override
        public int getItemLayoutId() {
            return R.layout.item_lv_layout;
        }

        @Override
        public void onBindViewHolder(Context context, CommonRvViewHolder holder, String data, int position) {
            TextView tv=holder.getViewById(R.id.item_tv);
            tv.setText(data);
            Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
            tv.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);

        }
    }
}
