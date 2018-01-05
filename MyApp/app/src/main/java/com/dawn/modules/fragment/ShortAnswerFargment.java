package com.dawn.modules.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.dawn.R;
import com.dawn.base.BaseFragment;
import com.dawn.modules.adapter.TiKuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/15.
 */

public class ShortAnswerFargment extends BaseFragment {
    private ViewPager viewPager;
    @Override
    protected int getLayoutId() {
        return R.layout.short_answer_layout;
    }

    @Override
    protected void initView(View mRootView) {
        viewPager=mRootView.findViewById(R.id.short_vp);
        List<Fragment>list=new ArrayList<>();
        list.add(new SingleChoiceFragment());
        list.add(new SingleChoiceFragment());
        list.add(new SingleChoiceFragment());
        TiKuAdapter adapter=new TiKuAdapter(getActivity().getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter)
        ;

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
}
