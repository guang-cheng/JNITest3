package com.ainm.jnitest3;

import android.util.Log;

import com.ainm.jnitest3.inter.Observer;

public class Student1 implements Observer {
    public Student1() {
        Test2.getInstance().registerObserver(this);
    }

    @Override
    public void update(String message) {
        Log.e("tag",getClass().getSimpleName()+","+message);
    }
}
