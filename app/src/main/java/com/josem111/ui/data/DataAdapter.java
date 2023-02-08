// DataAdapter.java
package com.josem111.ui.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.josem111.R;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Data> mDataList;

    public DataAdapter(Context context, List<Data> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        Button deleteButton = view.findViewById(R.id.deleteButton);

        final Data data = mDataList.get(position);

        imageView.setImageResource(data.getImage());
        textView.setText(data.getValue());

        deleteButton.setOnClickListener((View v) -> {
            mDataList.remove(position);
            notifyDataSetChanged();
        });

        return view;
    }
}
