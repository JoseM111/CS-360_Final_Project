package com.josem111.ui.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.josem111.R;

public class GridAdapter extends BaseAdapter {

    Context context;
    private final String[] values;
    private final int[] images;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        Holder holder = new Holder();
        View rowView;

        rowView = layoutInflater.inflate(R.layout.grid_item, null);
        holder.tv = rowView.findViewById(R.id.textView);
        holder.img = rowView.findViewById(R.id.imageView);

        holder.tv.setText(values[position]);
        holder.img.setImageResource(images[position]);

        rowView.setOnClickListener(view -> {
            Toast.makeText(context, "You Clicked " + values[position], Toast.LENGTH_LONG).show();
        });

        return rowView;
    }

    public static class Holder {
        TextView tv;
        ImageView img;
    }

}