package com.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;


/**
 * Created by Administrator on 2018/3/1 0001.
 */

public class FragmentUtil {
    /**
     * 用于 多个Fragment之间show或者hide
     *
     * @param manager
     * @param showPosition     显示fragment的位置也就是在数组中的位置
     * @param fragments       全部的fragment数组
     * @param containerViewId 替换的布局控件id
     */
    public static void showFragment(FragmentManager manager, int showPosition, List<Fragment> fragments, int containerViewId) {
        FragmentTransaction transaction = manager.beginTransaction();
        int size = fragments.size();
        if (showPosition < size) {
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                if (fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }

            Fragment showFragment = fragments.get(showPosition);
            if (showFragment == null) {
                return;
            }
            if (showFragment.isAdded()) {
                transaction.show(showFragment);
            } else {
                transaction.add(containerViewId, showFragment);
            }
//            transaction.commit();
            transaction.commitNow();
        }


    }
    public static void removeFragment(FragmentManager manager, List<Fragment> fragments){
        FragmentTransaction transaction = manager.beginTransaction();
            for (int i=0;i<fragments.size();i++){
                transaction.remove(fragments.get(i));
            }
        transaction.commitAllowingStateLoss();
    }

}
