package com.dawn.modules.fragmenttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dawn.R;
public class PlusOneFragment extends Fragment {
    private TextView mPlusOneButton;


    private int anInt;

    public PlusOneFragment() {
        // Required empty public constructor
    }

    public static PlusOneFragment newInstance(int  param1) {
        PlusOneFragment fragment = new PlusOneFragment();
        Bundle args = new Bundle();
        args.putInt("int", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            anInt = getArguments().getInt("int");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        //Find the +1 button
        mPlusOneButton = (TextView) view.findViewById(R.id.tv);
        switch (anInt){
            case 1:
                mPlusOneButton.setBackgroundColor(Color.parseColor("#ff6600"));
                break;
            case 2:
                mPlusOneButton.setBackgroundColor(Color.parseColor("#ff00ff"));
                break;
        }
        mPlusOneButton.setText(anInt+"");
        mPlusOneButton.animate();
        return view;
    }
    public void setText(String s){
        mPlusOneButton.setText(s);
    }

    @Override
    public void onResume() {
        super.onResume();

    }


}
