package com.circletech.lifcyclecomponentsapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyNameViewModel extends ViewModel {

    private MutableLiveData<String> mName;


    public MutableLiveData<String> getName() {
        if(mName==null){
            mName=new MutableLiveData<>();
            mName.setValue("Sunil Kumar");
        }
        return mName;
    }


}
