package com.alperez.listbook2010example;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by stanislav.perchenko on 16.01.2023 at 21:14.
 */
public class ViewWrapper {
    View base;
    TextView label=null;
    ImageView icon=null;
    ViewWrapper(View base) {
        this.base=base;
    }
    TextView getLabel() {
        if (label==null) {
            label=(TextView)base.findViewById(R.id.label);
        }
        return(label);
    }
    ImageView getIcon() {
        if (icon==null) {
            icon=(ImageView)base.findViewById(R.id.icon);
        }
        return(icon);
    }
}
