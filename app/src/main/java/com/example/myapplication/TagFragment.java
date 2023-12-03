package com.example.myapplication;


import android.view.View;

import com.example.myapplication.BaseFragment;

public class TagFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_tag, null);
        return view;
    }

}
