package com.example.myapplication;

import android.view.View;


public class UserFragment extends BaseFragment{
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_user, null);
        return view;
    }
}
