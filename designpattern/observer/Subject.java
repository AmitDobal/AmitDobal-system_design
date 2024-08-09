package com.amit.systemdesign.designpattern.observer;

public interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void updateData(int data);
}
