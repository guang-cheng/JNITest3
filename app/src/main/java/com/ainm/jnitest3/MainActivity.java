package com.ainm.jnitest3;

import android.content.ContentProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] arrs = {1,2,3,4,5};
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private int num;
    private Integer number = new Integer(125);
    char ch[] = {'a','b','a'};
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        arrs = encodeArray(arrs);
        for(int i = 0;i< arrs.length;i++)
        Log.e("tag","arrs["+i+"]="+arrs[i]);
        handlerThread.start();
        MyThread myThread = new MyThread();
//        new Thread(myThread).start();
//        new Thread(myThread).start();
        soft();
        Uri uri = Uri.parse("content://com.carson.provider/User/1");
        String ss="中java";
        int a = 3;
        String str= "k";
        String str2= "国";
        byte[] buff=ss.getBytes();
        int f=buff.length;
       Log.e("tag","字节长度=====·  "+f+",str="+str.getBytes().length+",str2="+str2.getBytes().length);
        //ContentProvider contentProvider =
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,MyService.class);
            startService(intent);
        }
    });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(number);
                Log.e("tag","number="+number+","+(ch[0]==ch[2]));
                Test2.getInstance().setInfomation("我要上课了---");
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,WebViewActivity.class));
            }
        });
        Student1 student1 = new Student1();
        Student2 student2 = new Student2();
    }
    void change(Integer num){
        num = 3;
    }

    private void soft(){
        int [] oldArr = new int[100];
        int [] newArr = new int[100];

        for(int i = 0 ;i<100 ;i++) {
            oldArr[i] = i+1;
        }

        int end = 100;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<100;i++) {
            int num = new Random().nextInt(end);
            newArr[i] = oldArr[num];
            oldArr[num] = oldArr[end-1];
            end--;
            System.out.println("num "+num+"  new "+newArr[i]);
            stringBuilder.append("  ").append(String.valueOf(newArr[i]));
        }
        Log.e("tag",stringBuilder.toString());
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int[] encodeArray(int[] arrs);

    private HandlerThread handlerThread = new HandlerThread("handlerThread");

    private class MyThread  implements Runnable{
        @Override
        public  void run() {
            synchronized(this) {
                for (int i = 0; i < 10; i++) {
                    num++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("tags", Thread.currentThread().getName()+",scvnum=" + num);
                }
            }
        }
    }
}
