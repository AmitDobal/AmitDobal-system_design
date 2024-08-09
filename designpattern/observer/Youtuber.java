package com.amit.systemdesign.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Youtuber implements Subject {
    private List<Observer> observers;
    private int data;

    public Youtuber() {
        this.observers = new ArrayList<>();
    }

    public void updateData(int data){
        this.data = data;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.setData(data));
    }

}
