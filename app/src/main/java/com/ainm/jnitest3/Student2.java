package com.ainm.jnitest3;

import android.util.Log;

import com.ainm.jnitest3.inter.Observer;

public class Student2 implements Observer {
    public Student2() {
        Test2.getInstance().registerObserver(this);
    }

    @Override
    public void update(String message) {
        Log.e("tag",getClass().getSimpleName()+","+message);
    }
}
