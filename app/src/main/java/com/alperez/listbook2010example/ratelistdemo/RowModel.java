package com.alperez.listbook2010example.ratelistdemo;

/**
 * Created by stanislav.perchenko on 17.01.2023 at 21:47.
 */
class RowModel {
    String label;
    float rating=2.0f;

    RowModel(String label) {
        this.label=label;
    }

    public String toString() {
        if (rating>=3.0) {
            return(label.toUpperCase());
        }
        return(label);
    }


}
