package com.example.smallsamples;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleThread extends Thread {

    private static final String TAG = "SimpleThread";
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue();
    private AtomicBoolean isAlive = new AtomicBoolean(true);

    public SimpleThread(){
        super(TAG);
        start();
    }

    @Override
    public void run() {
        while (isAlive.get()){
            Runnable task = taskQueue.poll();
            if (task != null){
                task.run();
            }
        }
        Log.i(TAG, "run: Simple terminated");
    }

    public SimpleThread execute(Runnable task){
        taskQueue.add(task);
        return this;
    }

    public void quit(){
        isAlive.set(false);
    }
}
