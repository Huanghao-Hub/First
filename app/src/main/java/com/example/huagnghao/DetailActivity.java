package com.example.huagnghao;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huagnghao.Bean.Manager;
import com.example.huagnghao.Bean.User;

/**
 * Created by 刘洋 on 2019/6/27.
 */

public class DetailActivity extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText password;
    private EditText xingbie;
    private EditText leixing;
    private Button update;
    private  Button delete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        name= (EditText) findViewById(R.id.name);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        xingbie= (EditText) findViewById(R.id.xingbie);
        leixing= (EditText) findViewById(R.id.leixing);
        update= (Button) findViewById(R.id.update);
        delete= (Button) findViewById(R.id.delete);

        Bundle bundle=getIntent().getExtras();
        String res=bundle.getString("username");
        final User user= Manager.findByUsername(res);
        init(user);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DetailActivity.this);
                AlertDialog alertDialog=builder.setTitle("消息")
                        .setMessage("是否修改这个记录")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                user.setName(name.getText()+"");
                                user.setPassword(password.getText()+"");
                                user.setXingbie(xingbie.getText()+"");
                                user.setLeixing(leixing.getText()+"");
                                Manager.update(user);
                                Intent intent=new Intent(DetailActivity.this,IndexActivity.class);
                                startActivity(intent);

                            }
                        }).create();
                alertDialog.show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DetailActivity.this);
                AlertDialog alertDialog=builder.setTitle("消息")
                        .setMessage("是否删除这个记录")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Manager.delete(Manager.findByUsername(user.getUsername()));
                                Intent intent=new Intent(DetailActivity.this,IndexActivity.class);
                                startActivity(intent);

                            }
                        }).create();
                alertDialog.show();
            }
        });

    }
    public  void init(User user){
        name.setText(user.getName());
        username.setText(user.getUsername());
        password.setText(user.getPassword());
        xingbie.setText(user.getXingbie());
        leixing.setText(user.getLeixing());


    }


}
