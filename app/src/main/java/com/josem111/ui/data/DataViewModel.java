package com.josem111.ui.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class DataViewModel {
    private final MutableLiveData<String> mText;

    public DataViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
