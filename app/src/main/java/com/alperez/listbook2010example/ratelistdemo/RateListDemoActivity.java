package com.alperez.listbook2010example.ratelistdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.alperez.listbook2010example.R;

import java.util.ArrayList;

/**
 * Created by stanislav.perchenko on 17.01.2023 at 19:29.
 */
public class RateListDemoActivity extends AppCompatActivity {
    private ListView listView;

    String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue",
            "purus"};

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_ratelist_demo);
        listView = (ListView) findViewById(R.id.list);

        ArrayList<RowModel> list=new ArrayList<RowModel>();
        for (String s : items) {
            list.add(new RowModel(s));
        }

        RatingAdapter adapter = new RatingAdapter(this, list);
        listView.setAdapter(adapter);
    }


}
