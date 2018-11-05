package com.ainm.jnitest3.inter;

public interface DemoInterface {
     void registerObserver(Observer o);
     void removeObserver(Observer o);
     void notifyObserver();
}
