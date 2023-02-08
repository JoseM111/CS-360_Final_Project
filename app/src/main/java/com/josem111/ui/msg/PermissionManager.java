package com.josem111.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionManager {
    public static final int SMS_PERMISSION_REQUEST_CODE = 1;
    private static PermissionCallback mPermissionCallback;

    public static boolean checkPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity activity, String permission, PermissionCallback callback) {
        mPermissionCallback = callback;
        if (!checkPermission(activity, permission)) {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, SMS_PERMISSION_REQUEST_CODE);
        } else {
            mPermissionCallback.onPermissionGranted();
        }
    }

    public static void onRequestPermissionsResult(int requestCode, int[] grantResults) {
        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPermissionCallback.onPermissionGranted();
            } else {
                mPermissionCallback.onPermissionDenied();
            }
        }
    }

    public interface PermissionCallback {
        void onPermissionGranted();
        void onPermissionDenied();
    }
}
