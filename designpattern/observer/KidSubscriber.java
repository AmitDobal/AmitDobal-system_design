package com.amit.systemdesign.designpattern.observer;

public class KidSubscriber implements Observer{

    @Override
    public void setData(int data) {
        System.out.println("Kid observer data changed: " + data);
    }
    
}
