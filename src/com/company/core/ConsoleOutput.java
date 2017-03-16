package com.company.core;

/**
 * Created by Kiryl_Parfiankou on 3/14/2017.
 */
public class ConsoleOutput implements Observer {

    @Override
    public void update(String message) {
        System.out.println(message);
    }

}
