package com.alperez.listbook2010example.staticdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alperez.listbook2010example.R;

/**
 * Created by stanislav.perchenko on 16.01.2023 at 6:51.
 */
public class StaticDemoActivity extends ListActivity {
    TextView selection;
    String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue",
            "purus"};

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_static_demo);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.row, R.id.label, items));
        selection=(TextView)findViewById(R.id.selection);
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        selection.setText(items[position]);
    }
}
