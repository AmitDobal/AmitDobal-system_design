package com.amit.systemdesign.designpattern.observer;

public class SeniorSubscriber implements Observer{

    @Override
    public void setData(int data) {
        System.out.println("Senior observer data changed: " + data);
    }
    
}
