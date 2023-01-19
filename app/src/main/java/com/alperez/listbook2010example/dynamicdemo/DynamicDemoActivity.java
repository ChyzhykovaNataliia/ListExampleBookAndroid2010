package com.alperez.listbook2010example.dynamicdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alperez.listbook2010example.R;

/**
 * Created by stanislav.perchenko on 16.01.2023 at 6:53.
 */
public class DynamicDemoActivity extends ListActivity {
    TextView selection;
    static final String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
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

    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
    }

    private class IconicAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.row, parent, false);
            TextView label = (TextView) row.findViewById(R.id.label);
            label.setText(items[position]);

            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            if(items[position].length() > 4) {
                icon.setImageResource(R.drawable.ic_delete);
            }else{
                icon.setImageResource(R.drawable.ic_ok);
            }
            return row;
        }
    }
}
