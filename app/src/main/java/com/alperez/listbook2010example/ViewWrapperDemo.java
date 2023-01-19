package com.alperez.listbook2010example;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by stanislav.perchenko on 16.01.2023 at 21:28.
 */
public class ViewWrapperDemo extends ListActivity {
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
        setContentView(R.layout.activity_main);
        setListAdapter(new IconicAdapter());
        selection=(TextView)findViewById(R.id.selection);
    }
    private String getModel(int position) {
        return(((IconicAdapter)getListAdapter()).getItem(position));
    }
    public void onListItemClick(ListView parent, View v,
                                int position, long id) {
        selection.setText(getModel(position));
    }
    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(ViewWrapperDemo.this, R.layout.row, items);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            ViewWrapper wrapper=null;
            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
                wrapper=new ViewWrapper(row);
                row.setTag(wrapper);
            }
            else {
                wrapper=(ViewWrapper)row.getTag();
            }
            wrapper.getLabel().setText(getModel(position));
            if (getModel(position).length()>4) {
                wrapper.getIcon().setImageResource(R.drawable.ic_delete);
            }
            else {
                wrapper.getIcon().setImageResource(R.drawable.ic_ok);
            }
            return(row);
        }
    }
}
