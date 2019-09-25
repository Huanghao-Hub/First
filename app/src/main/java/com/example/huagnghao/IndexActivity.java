package com.example.huagnghao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huagnghao.Bean.Manager;
import com.example.huagnghao.Bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘洋 on 2019/6/27.
 *
 */

public class IndexActivity extends AppCompatActivity {
    private TextView textView;

    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> datalist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity);
        textView= (TextView) findViewById(R.id.textView);
        listView= (ListView) findViewById(R.id.listView);

        final Bundle bundle=getIntent().getExtras();
        textView.setText(( Manager.findByUsername(bundle.getString("username"))).getName());

        datalist=new ArrayList<>();
        simpleAdapter=new SimpleAdapter(IndexActivity.this,getDatalist(),R.layout.item,new String[]{"name","username"},new int[]{R.id.name,R.id.username});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(IndexActivity.this,Manager.list.get(position).getUsername(),Toast.LENGTH_SHORT).show();
              Intent intent=new Intent(IndexActivity.this,DetailActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("username",(Manager.list.get(position)).getUsername());
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
    }

    public List<Map<String, Object>> getDatalist() {
        for (User user:Manager.list){
            Map<String,Object> map=new HashMap<>();
            map.put("name",user.getName());
            map.put("username",user.getUsername());
            datalist.add(map);
        }

        return datalist;
    }
}
