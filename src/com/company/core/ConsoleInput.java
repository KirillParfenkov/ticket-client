package com.company.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public class ConsoleInput implements Observable {

    private List<Observer> observers;

    public ConsoleInput() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserve(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserve(Observer o) {
        observers.remove(o);
    }

    public void notify(String message) {

        for(Observer observer: observers) {
            observer.update(message);
        }
    }
}
