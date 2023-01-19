package com.alperez.listbook2010example.recyclingdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alperez.listbook2010example.R;

/**
 * Created by stanislav.perchenko on 16.01.2023 at 20:25.
 */
public class RecyclingDemoActivity extends ListActivity {
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
        setContentView(R.layout.activity_dynamic_demo);
        setListAdapter(new IconicAdapter());
        selection=(TextView)findViewById(R.id.selection);
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        selection.setText(items[position]);
    }
    class IconicAdapter extends ArrayAdapter {

        IconicAdapter() {
            super(RecyclingDemoActivity.this, R.layout.row, items);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
            }
            TextView label=(TextView)row.findViewById(R.id.label);
            label.setText(items[position]);
            ImageView icon=(ImageView)row.findViewById(R.id.icon);
            if (items[position].length()>4) {
                icon.setImageResource(R.drawable.ic_delete);
            }
            else {
                icon.setImageResource(R.drawable.ic_ok);
            }
            return(row);
        }
    }
}
