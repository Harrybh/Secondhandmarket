package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,pwd;
    Button btnlogin,btnreg;
    Mysql mysql;
    SQLiteDatabase db;
    SharedPreferences sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = this.findViewById(R.id.name);
        pwd = this.findViewById(R.id.pwd);
        btnlogin = this.findViewById(R.id.login);
        btnreg = this.findViewById(R.id.reg);
        sp1 =  this.getSharedPreferences("useinfo",this.MODE_PRIVATE);
        sp2 = this.getSharedPreferences("username",this.MODE_PRIVATE);

        name.setText(sp1.getString("usname",null));
        pwd.setText(sp1.getString("uspwd",null));
        mysql = new Mysql(this,"Userinfo",null,1);
        db = mysql.getReadableDatabase();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pwd.getText().toString();
                //查询用户名和密码相同的数据
                Cursor cursor = db.query("logins",new String[]{"usname","uspwd"}," usname=? and uspwd=?",new String[]{username,password},null,null,null);

                int flag = cursor.getCount();
                if(flag!=0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Welcome.class);
                    SharedPreferences.Editor editor = sp2.edit();
                    cursor.moveToFirst();
                    String loginname = cursor.getString(0);
                    editor.putString("Loginname",loginname);
                    editor.commit();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"用户名或密码错误！",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Register.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"前往注册！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
