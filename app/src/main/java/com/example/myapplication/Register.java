package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText usename,usepwd,usepwd2;
    Button submit;
    Mysql mysql;
    SQLiteDatabase db;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usename = this.findViewById(R.id.usename);
        usepwd =  this.findViewById(R.id.usepwd);				
        usepwd2 = this.findViewById(R.id.usepwd2);
        submit =   this.findViewById(R.id.submit);
        mysql = new Mysql(this,"Userinfo",null,1);
        db = mysql.getReadableDatabase();
        sp = this.getSharedPreferences("useinfo",this.MODE_PRIVATE);


        submit.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;
            @Override
            public void onClick(View v) {
                String name = usename.getText().toString();
                String pwd01 = usepwd.getText().toString();
                String pwd02 = usepwd2.getText().toString();
                String sex = "";
                if(name.equals("")||pwd01 .equals("")||pwd02.equals("")){
                    Toast.makeText(Register.this, "用户名或密码不能为空!！", Toast.LENGTH_LONG).show();
                }
                else{
                    Cursor cursor = db.query("logins",new String[]{"usname"},null,null,null,null,null);

                    while (cursor.moveToNext()){
                        if(cursor.getString(0).equals(name)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag==true){
                        if (pwd01.equals(pwd02)) {
                            ContentValues cv = new ContentValues();
                            cv.put("usname",name);
                            cv.put("uspwd",pwd01);
                            db.insert("logins",null,cv);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("usname",name);
                            editor.putString("uspwd",pwd01);
                            editor.commit();
                            Intent intent = new Intent();
                            intent.setClass(Register.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(Register.this, "密码不一致！", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "用户已存在！", Toast.LENGTH_LONG).show();
                    }

                }
            }


        });
    }
}
