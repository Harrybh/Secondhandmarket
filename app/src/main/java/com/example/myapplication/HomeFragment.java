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
        mProductInfoList.add(new ProductInfo(0,R.drawable.img1,"语音黄瓜条挂件","会说话的黄瓜条挂件，按一下就会说“下头男”“下头女”“家人们谁懂啊无语死了”之类的，非常符合大学生美丽的精神状态，多买了一根，出出","FamilyWhoKnows111","9.9"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img2,"【95新】Redmi 27英寸显示器 G27 Fast IPS 165Hz高刷","屏幕素质还行，刚买不到两个月，月底手头紧含泪大甩卖！可小刀，可自提。","电专炊事兵bkbkbk","555.55"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img3,"得力A5复古羊巴皮笔记本","得力复古风羊巴皮记事本，颜值超高，书写体验也不错，我一下买了一套用不过来，出一本，两本也可，校内自提","studyMmehappy","6.6"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img4,"【全新】神里绫华痛衣","美丽的绫华大小姐嘿嘿，刚买几天还没穿过，本来打算穿去CP30，（加绒的不怕冷）可是延期了呃呃呃呃呃，坏现充滚出漫展！！！（PS：原友+我UID114514666）","神里绫华的狗www","88"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img5,"【95新】美的酷毙灯充电款","可以磁吸在墙上或者桌子上，朋友送了新的，这个就出了，最低价不可刀","Justman18yearsold","25"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img6,"六级复习资料","买回来一笔没动orz，单买9r/本，两本15r带走不可刀，校内可自提","这次六级又寄了呜呜呜","9"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img7,"【非卖】崩铁联动立牌","嘿嘿嘿让我看看是哪个小开拓者还没有列车长送的联动立牌！不出，就挂一挂，嘿嘿","持明online","9999.99"));
        mProductInfoList.add(new ProductInfo(0,R.drawable.img8,"简约石英表","挺新的，之前考试急用表就随便买了一个，基础功能都没问题，闲置出","ykslkbwlaaa","9.9"));

        //创建适配器
        productListAdapter = new ProductListAdapter(mProductInfoList);
        //设置适配器
        recyclerView.setAdapter(productListAdapter);
        return view;
    }
}
