package com.ainm.jnitest3;

import com.ainm.jnitest3.inter.DemoInterface;
import com.ainm.jnitest3.inter.Observer;

import java.util.ArrayList;
import java.util.List;
/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author jstao
 *
 */
public class Test2 implements DemoInterface {
    private static Test2 instance = null;
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private String message;
    private Test2() {
      list = new ArrayList<>();
    }
   public static Test2 getInstance(){
        if(instance == null){
            synchronized (Test2.class){
                if(instance == null)
                    instance = new Test2();
            }
        }
        return instance;
   }
    private List<Observer> list;
    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        message = s;
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
