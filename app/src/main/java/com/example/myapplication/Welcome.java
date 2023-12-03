package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;



import java.util.ArrayList;


public class Welcome extends FragmentActivity {


    FrameLayout frameLayout;

    RadioButton rbHome;

    RadioButton rbType;

    RadioButton rbCommunity;

    RadioButton rbCart;
    RadioButton rbUser;

    RadioGroup rgMain;
    private ArrayList<BaseFragment> fragments;
    private int position;
    private TagFragment typeFragment;
    private BaseFragment mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        frameLayout = this.findViewById(R.id.frameLayout);
        rbHome = this.findViewById(R.id.rb_home);
        rbCart = this.findViewById(R.id.rb_cart);
        rbType = this.findViewById(R.id.rb_type);
        rbCommunity = this.findViewById(R.id.rb_community);
        rbUser = this.findViewById(R.id.rb_user);
        rgMain = this.findViewById(R.id.rg_main);
        initFragment();
        initListener();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        typeFragment = new TagFragment();
        fragments.add(new HomeFragment());
        fragments.add(typeFragment);
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragment());
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_home) position = 0;
                else if(checkedId==R.id.rb_type)position = 1;
                else if(checkedId==R.id.rb_community)position = 2;
                else if(checkedId==R.id.rb_cart)position = 3;
                else if(checkedId==R.id.rb_user)position = 4;
                BaseFragment baseFragment = getFragment(position);
                switchFragment(mContext, baseFragment);
            }
        });

        rgMain.check(R.id.rb_home);

    }


    /**
     *
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

}

