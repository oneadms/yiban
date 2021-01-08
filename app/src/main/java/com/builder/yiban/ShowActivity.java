package com.builder.yiban;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ShowActivity extends AppCompatActivity {

    private TextView head;
    private TextView div1;
    private TextView name;
    private TextView bianhao;
    private TextView reason;
    private TextView outtime;
    private TextView blacktime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        initView();

    }

    private void initView() {
        head = (TextView) findViewById(R.id.head);
        div1 = (TextView) findViewById(R.id.div1);
        name = (TextView) findViewById(R.id.name);
        bianhao = (TextView) findViewById(R.id.binahao);
        reason = (TextView) findViewById(R.id.reason);
        outtime = (TextView) findViewById(R.id.outtime);
        blacktime = (TextView) findViewById(R.id.blacktime);
    }
}
