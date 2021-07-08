package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SlideActivity extends AppCompatActivity{
    private ImageView mIvHead;
    private SlideMenu slideMenu;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        mIvHead = findViewById(R.id.iv_head);
        slideMenu = findViewById(R.id.slideMenu);
        mBtn1 = findViewById(R.id.btn_main_1);
        mBtn2 = findViewById(R.id.btn_main_2);
        mBtn3 = findViewById(R.id.btn_main_3);
        //实现侧滑
        mIvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });
        setListener();
    }

    private void setListener(){
        OnClick onClick = new OnClick();
        //对每一个按钮进行setOnClickListener
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);
        mBtn3.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_main_1:
                    intent = new Intent(SlideActivity.this,firstActivity.class);
                    break;
                case R.id.btn_main_2:
                    intent = new Intent(SlideActivity.this,secondActivity.class);
                    break;
                case R.id.btn_main_3:
                    intent = new Intent(SlideActivity.this,thirdActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}