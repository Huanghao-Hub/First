package com.example.huagnghao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.huagnghao.Bean.Manager;
import com.example.huagnghao.Bean.User;

/**
 * Created by 刘洋 on 2019/6/27.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText password;
    private RadioGroup xingbie;
    private RadioGroup leixing;
    private String resxb;
    private String reslx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        name= (EditText) findViewById(R.id.name);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        xingbie= (RadioGroup) findViewById(R.id.xingbie);
        leixing= (RadioGroup) findViewById(R.id.leixing);
        //性别的单选按钮点击事件
        xingbie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton= (RadioButton) findViewById(i);
                resxb=radioButton.getText()+"";
            }
        });
        //类型的单选按钮点击事件
        leixing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton= (RadioButton) findViewById(i);
                reslx=radioButton.getText()+"";
            }
        });
        //注册按钮点击事件
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User(name.getText()+"",username.getText()+"",password.getText()+"",resxb,reslx);
                Manager.save(user);
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }




}
