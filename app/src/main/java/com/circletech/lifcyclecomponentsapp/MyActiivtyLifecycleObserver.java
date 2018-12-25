package com.circletech.lifcyclecomponentsapp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class MyActiivtyLifecycleObserver implements LifecycleObserver {

    private Logger mLogger;
    private Lifecycle mLifecycle;

    MyActiivtyLifecycleObserver(Lifecycle pLifecycle, Logger pLogger) {
        mLifecycle = pLifecycle;
        mLogger = pLogger;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void logCreate() {
        mLogger.logCreate();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void logStart() {
        if(mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED))
        mLogger.logStart();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void logResume() {
        mLogger.logResume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void logPause() {
        mLogger.logPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void logStop() {
        mLogger.logStop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void logDestroy() {
        if(mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.DESTROYED))
        mLogger.logDestroy();
    }
}
