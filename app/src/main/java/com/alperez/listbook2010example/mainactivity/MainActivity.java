package com.alperez.listbook2010example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alperez.listbook2010example.R;
import com.alperez.listbook2010example.dynamicdemo.DynamicDemoActivity;
import com.alperez.listbook2010example.ratelistdemo.RateListDemoActivity;
import com.alperez.listbook2010example.recyclingdemo.RecyclingDemoActivity;
import com.alperez.listbook2010example.staticdemo.StaticDemoActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnStaticDemo;
    private Button btnDynamicDemo;
    private Button btnRecyclingDemo;
    private Button btnRateListDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDynamicDemo = (Button) findViewById(R.id.button_dynamic_demo);
        btnStaticDemo = (Button) findViewById(R.id.button_static_demo);
        btnRecyclingDemo = (Button) findViewById(R.id.recycling_demo);
        btnRateListDemo = (Button) findViewById(R.id.ratelist_demo);

        btnStaticDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaticDemoActivity.class);
                startActivity(intent);
            }
        });

        btnDynamicDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DynamicDemoActivity.class);
                startActivity(intent);
            }
        });

        btnRecyclingDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclingDemoActivity.class);
                startActivity(intent);
            }
        });

        btnRateListDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RateListDemoActivity.class);
                startActivity(intent);
            }
        });
    }
}