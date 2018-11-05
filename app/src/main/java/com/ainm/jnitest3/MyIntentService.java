package com.ainm.jnitest3;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super("name");
        Log.e("tag","MyIntentService-------name");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("tag","MyIntentService-------onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("tag","MyIntentService-------onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Log.e("tag","MyIntentService-------onHandleIntent");
    /*   Intent intent1 = new Intent(getBaseContext(),FirstActivity.class);
       intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent1);*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("tag","MyIntentService-------onDestroy");
    }
}
