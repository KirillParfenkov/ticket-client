package com.company;

import com.company.core.ConsoleInput;
import com.company.core.ConsoleOutput;
import com.company.core.sessions.FindSessionObserver;
import com.company.core.sessions.PostSessionObserver;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");

        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.addObserve(new ConsoleOutput());
        consoleInput.addObserve(new FindSessionObserver());
        consoleInput.addObserve(new PostSessionObserver());

        try (
           BufferedReader br = new BufferedReader(
                   new InputStreamReader(System.in));
        ) {

            while (true) {
                String message = br.readLine();
                consoleInput.notify(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
