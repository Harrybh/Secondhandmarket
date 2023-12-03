package com.example.myapplication;


import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import android.content.Intent;

import android.os.Parcelable;


import androidx.annotation.NonNull;



public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyHolder> {
    private List<ProductInfo> mProductInfos =new ArrayList<>();

    public ProductListAdapter(List<ProductInfo> list){
        this.mProductInfos =list;

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //绑定数据
        ProductInfo productInfo = mProductInfos.get(position);

        //设置数据
        holder.tv_title.setText(productInfo.getProduct_title());
        holder.tv_style.setText("风格："+productInfo.getProduct_style());
        holder.tv_size.setText("尺寸："+productInfo.getProduct_size());
        holder.tv_price.setText("¥ "+ productInfo.getProduct_price());
        holder.img_product.setImageResource(productInfo.getProduct_img());

    }

    @Override
    public int getItemCount() {
        return mProductInfos.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_style;
        TextView tv_size;
        TextView tv_price;
        ImageView img_product;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //初始化控件
            tv_title =itemView.findViewById(R.id.tv_title);
            tv_style =itemView.findViewById(R.id.tv_style);
            tv_size =itemView.findViewById(R.id.tv_size);
            tv_price =itemView.findViewById(R.id.tv_price);
            img_product =itemView.findViewById(R.id.img_product);
            img_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ProductInfo clickedContact = mProductInfos.get(position);
                        Intent intent = new Intent(itemView.getContext(), ContactDetailsActivity.class);
                        intent.putExtra("contact", (Parcelable) clickedContact);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}
