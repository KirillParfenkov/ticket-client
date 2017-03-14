package com.company;

import com.company.ticket.ConsoleInput;
import com.company.ticket.ConsoleOutput;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");

        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.addObserve(new ConsoleOutput());

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                ) {

            String line = reader.readLine();
            consoleInput.notify(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
