package com.amit.systemdesign.designpattern.observer;

public class Client {
    public static void main(String[] args) {
        Subject youtuber = new Youtuber();
        youtuber.addObserver(new KidSubscriber());
        youtuber.addObserver(new SeniorSubscriber());
        youtuber.addObserver(new KidSubscriber());

        youtuber.updateData(4);
        youtuber.updateData(10);
        youtuber.updateData(8);
    }
}
