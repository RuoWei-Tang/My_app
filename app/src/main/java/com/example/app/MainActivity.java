package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLogin;
    private EditText mEtUser;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //登录
        mBtnLogin = findViewById(R.id.btn_login);
        mEtUser = findViewById(R.id.et_1);
        mEtPassword = findViewById(R.id.et_2);
        mBtnLogin.setOnClickListener(this);
        //游客登录
        mBtnLogin = findViewById(R.id.btn_log2);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =null;
                intent = new Intent(MainActivity.this, SlideActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onClick(View v){
        //获取输入的用户名和密码
        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        //弹出的内容
        String fail = "登录失败";
        Intent intent = null;
        //管理员登录
        if(username.equals("admin")&&password.equals("123456")){
            //正确
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        }else{
            //不正确，弹出登陆失败toast
            ToastUtil.showMsg(getApplicationContext(),fail);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}