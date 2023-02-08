package com.josem111.ui.msg;

import static com.josem111.ui.msg.PermissionManager.checkPermission;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.josem111.R;


public class MsgFragment extends Fragment {

    public MsgFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_msg, container, false);

        Button showPopupBtn = view.findViewById(R.id.show_popup_btn);
        showPopupBtn.setOnClickListener((View v) -> showPopup());

        return view;
    }

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Allow Text Messaging App?");
        builder.setMessage("The app needs to communicate with the text messaging app.");
        builder.setPositiveButton(
                "Allow",
                (dialog, which) -> checkPermission(getContext(),
                        Manifest.permission.SEND_SMS
                )
        );
        builder.setNegativeButton("Deny", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

