package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;



public class AddProductInfoActivity extends AppCompatActivity {

    private EditText productNameEditText;
    private EditText productPriceEditText;
    private EditText productNoteEditText;
    private ImageView productImageView;

    private ActivityResultLauncher<Intent> takePictureLauncher;
    private ActivityResultLauncher<String> pickImageLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_info);

        productNameEditText = findViewById(R.id.product_name_edittext);
        productPriceEditText = findViewById(R.id.product_price_edittext);
        productNoteEditText = findViewById(R.id.product_note_edittext);
        productImageView = findViewById(R.id.product_image_view);

        // 实例化相机拍照的 ActivityResultLauncher
        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle extras = result.getData().getExtras();
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        productImageView.setImageBitmap(imageBitmap);
                    }
                }
        );

        // 实例化从相册选择照片的 ActivityResultLauncher
        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                result -> {
                    if (result != null) {
                        productImageView.setImageURI(result);
                    }
                }
        );

        // 选择图片按钮点击事件处理
        Button selectImageButton = findViewById(R.id.select_image_button);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个选择拍照或从相册选择图片的对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductInfoActivity.this);
                builder.setTitle("选择图片来源");
                builder.setItems(new CharSequence[]{"拍照", "从相册选择"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // 启动相机拍照
                                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                takePictureLauncher.launch(takePictureIntent);
                                break;
                            case 1:
                                // 从相册选择照片
                                pickImageLauncher.launch("image/*");
                                break;
                        }
                    }
                });
                builder.show();
            }
        });

        // 添加商品按钮点击事件处理
        Button addProductButton = findViewById(R.id.add_product_button);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的商品信息
                String productName = productNameEditText.getText().toString();
                String productPrice = productPriceEditText.getText().toString();
                String productNote = productNoteEditText.getText().toString();

                // 执行上传操作，包括商品信息和图片上传至服务器的逻辑
                // TODO

            }
        });
    }


}