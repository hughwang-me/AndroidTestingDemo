package com.example.androidtestingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(FirstActivity.this , SecondActivity.class) , 1002);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.w("uwjx" , "requestCode -> " + requestCode);
        Log.w("uwjx" , "resultCode -> " + resultCode);
        if(requestCode == 1002 && resultCode == 1001){
            this.finish();
        }
    }
}
