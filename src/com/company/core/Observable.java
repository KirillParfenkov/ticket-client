package com.company.core;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public interface Observable {

    void addObserve(Observer o);
    void deleteObserve(Observer o);
}
