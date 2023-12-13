package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class ContactDetailsActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;
        // 获取从上一个界面传递过来的联系人信息
        ProductInfo contact = getIntent().getParcelableExtra("contact");
        int rid=contact.getProduct_img();
        String name = contact.getProduct_title();
        String region = contact.getProduct_description();
        String gender = contact.getProduct_seller();
        String type = contact.getProduct_price();
        textView1=findViewById(R.id.textViewa2);
        textView2=findViewById(R.id.textViewb2);
        textView3=findViewById(R.id.textViewc2);
        textView4=findViewById(R.id.textViewd2);
        imageView=findViewById(R.id.imageView5);
        imageView.setImageResource(rid);
        textView1.setText(name);
        textView2.setText(region);
        textView3.setText(gender);
        textView4.setText(type);

    }
}