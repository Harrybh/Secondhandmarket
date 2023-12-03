package com.example.myapplication;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<ProductInfo> mProductInfoList = new ArrayList<>();
    private ProductListAdapter productListAdapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        recyclerView = view.findViewById(R.id.rv_home);
        //模拟数据
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.main_cart,"First Ring 灰色/棕色V领修身针织马甲背心复古叠穿百搭马夹上衣","韩版","M","180.90"));

        //创建适配器
        productListAdapter = new ProductListAdapter(mProductInfoList);
        //设置适配器
        recyclerView.setAdapter(productListAdapter);
        return view;
    }
}
