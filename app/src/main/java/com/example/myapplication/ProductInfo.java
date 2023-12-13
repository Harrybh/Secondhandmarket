package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
public class ProductInfo implements Parcelable{
    private int _id;
    private int product_img;
    private String product_title;
    private String product_description;
    private String product_seller;
    private String product_price;

    public ProductInfo(Parcel in) {//从 Parcel 中读取数据并初始化对象
        this.product_img = in.readInt();
        this.product_title = in.readString();
        this.product_description = in.readString();
        this.product_seller = in.readString();
        this.product_price = in.readString();




    }

    public ProductInfo(int _id,int product_img, String product_title, String product_description, String product_seller, String product_price) {
        this._id = _id;
        this.product_title = product_title;
        this.product_description = product_description;
        this.product_seller = product_seller;
        this.product_price = product_price;
        this.product_img = product_img;
    }


    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_seller() {
        return product_seller;
    }

    public void setProduct_seller(String product_seller) {
        this.product_seller = product_seller;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public static final Creator<ProductInfo> CREATOR = new Creator<ProductInfo>() {
        @Override
        public ProductInfo createFromParcel(Parcel in) {
            return new ProductInfo(in);
        }

        @Override
        public ProductInfo[] newArray(int size) {
            return new ProductInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {///// 将对象数据写入 Parcel 中
        parcel.writeInt(product_img);
        parcel.writeString(product_title);
        parcel.writeString(product_description);
        parcel.writeString(product_seller);
        parcel.writeString(product_price);

    }
}
