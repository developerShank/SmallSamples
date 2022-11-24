package com.example.smallsamples;

import android.os.Handler;
import android.os.HandlerThread;

public class WorkerThread extends HandlerThread {

    Handler handler;
    private static final String TAG = "WorkerThread";
    public WorkerThread() {
        super(TAG);
        start();
        handler = new Handler();

    }

    public WorkerThread execute(Runnable task){
        handler.post(task);
        return this;
    }
}
