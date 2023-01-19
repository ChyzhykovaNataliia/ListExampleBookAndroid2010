package com.alperez.listbook2010example.ratelistdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alperez.listbook2010example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.perchenko on 17.01.2023 at 21:47.
 */
class RatingAdapter extends BaseAdapter {
    private final Context context;
    private final List<RowModel> data;

    RatingAdapter(Context context, List<RowModel> data) {
        super();
        this.context = context;
        if (data == null) throw new IllegalArgumentException("Data is null");
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public RowModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewWrapper wrapper;

        if (row==null) {
            row = LayoutInflater.from(context).inflate(R.layout.rating_bar, parent, false);
            wrapper = new ViewWrapper(row);
            row.setTag(wrapper);
            wrapper.getRatingBar().setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromTouch) {
                    Integer myPosition=(Integer)ratingBar.getTag();
                    RowModel model=getItem(myPosition);
                    model.rating=rating;
                    LinearLayout parent=(LinearLayout)ratingBar.getParent();
                    TextView label=(TextView)parent.findViewById(R.id.label);
                    label.setText(model.toString());
                }
            });
        }
        else {
            wrapper = (ViewWrapper) row.getTag();
        }

        RowModel model = getItem(position);


        wrapper.getLabel().setText(model.toString());
        wrapper.getRatingBar().setRating(model.rating);

        wrapper.getRatingBar().setTag(new Integer(position));

        return(row);
    }



    private class ViewWrapper {
        View base;
        RatingBar rate;
        TextView label;

        ViewWrapper(View base) {
            this.base=base;
        }

        RatingBar getRatingBar() {
            if (rate == null) {
                rate=(RatingBar)base.findViewById(R.id.rate);
            }
            return(rate);
        }
        TextView getLabel() {
            if (label==null) {
                label=(TextView)base.findViewById(R.id.label);
            }
            return(label);
        }
    }


}
