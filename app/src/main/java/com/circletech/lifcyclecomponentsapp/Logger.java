package com.circletech.lifcyclecomponentsapp;

import android.util.Log;

public class Logger {
    private static  final String TAG="LOGGER";
    public void logCreate(){
        Log.d(TAG,"Log Activity Created");
    }
    public void logStart(){
        Log.d(TAG,"Log Activity Started");
    }
    public void logResume(){
        Log.d(TAG,"Log Activity Resumed");
    }
    public void logPause(){
        Log.d(TAG,"Log Activity Paused");
    }
    public void logStop(){
        Log.d(TAG,"Log Activity Stopped");
    }
    public void logDestroy(){
        Log.d(TAG,"Log Activity Destroyed");
    }


}
