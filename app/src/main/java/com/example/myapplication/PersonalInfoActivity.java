package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfoActivity extends AppCompatActivity {
    private ImageView profileImage;
    private TextView usernameTextView;
    private TextView phoneNumberTextView;
    private Button changePasswordButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        // 初始化界面元素
        profileImage = findViewById(R.id.profile_image);
        usernameTextView = findViewById(R.id.username_text_view);
        phoneNumberTextView = findViewById(R.id.phone_number_text_view);
        changePasswordButton = findViewById(R.id.change_password_button);
        logoutButton = findViewById(R.id.logout_button);

        // 设置用户信息
        profileImage.setImageResource(R.drawable.ic_profile); // 替换成你的头像资源
        usernameTextView.setText("John Doe"); // 替换成实际用户名
        phoneNumberTextView.setText("123-456-7890"); // 替换成实际手机号

        // 修改密码按钮点击事件
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理修改密码逻辑
            }
        });

        // 退出登录按钮点击事件
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理退出登录逻辑
            }
        });
    }


}
