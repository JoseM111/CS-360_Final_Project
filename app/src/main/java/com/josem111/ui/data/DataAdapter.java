package com.josem111.ui.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.josem111.R;

import java.util.List;

public class DataAdapter extends ArrayAdapter<Data> {
    private final Context context;
    private final List<Data> dataList;

    public DataAdapter(Context context, List<Data> dataList) {
        super(context, R.layout.grid_item, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView =
                convertView == null
                        ? inflater.inflate(R.layout.grid_item, null)
                        : convertView;

        TextView textView = gridView.findViewById(R.id.textView);
        ImageView imageView = gridView.findViewById(R.id.imageView);

        textView.setText(dataList.get(position).getValue());
        imageView.setImageResource(dataList.get(position).getImage());

        return gridView;
    }
}
