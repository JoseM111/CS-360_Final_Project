package com.josem111.ui.msg;

import android.arch.lifecycle.ViewModel;

public class MsgViewModel extends ViewModel {
    // Add any variables or methods needed for the view model here

    private boolean mIsPermissionGranted = false;

    public boolean isPermissionGranted() {
        return mIsPermissionGranted;
    }

    public void setPermissionGranted(boolean permissionGranted) {
        mIsPermissionGranted = permissionGranted;
    }
}
