package com.josem111.ui.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import com.josem111.R;

import java.util.List;

public class DataFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        GridView gridView = view.findViewById(R.id.gridView);
        List<Data> dataList = Data.getDataList();
        DataAdapter adapter = new DataAdapter(getContext(), dataList);
        gridView.setAdapter(adapter);
        return view;
    }
}
