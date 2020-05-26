package com.example.androidtestingdemo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    RecyclerView listview;
    MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);


        final List<ItemDataBean> data = new ArrayList<>();
        ItemDataBean bean1 = new ItemDataBean();
        bean1.setName("王欢1");
        data.add(bean1);

        ItemDataBean bean2 = new ItemDataBean();
        bean2.setName("王欢2");
        data.add(bean2);

        ItemDataBean bean3 = new ItemDataBean();
        bean3.setName("王欢3");
        data.add(bean3);

        adapter = new MyRecyclerAdapter(MainActivity.this , data);
        listview.setLayoutManager(new LinearLayoutManager(this));
        listview.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("uwjx" , "result->");
                for (ItemDataBean bean : data) {
                    Log.d("uwjx" , "result-> " + bean.toString());
                }
            }
        });
    }
}
