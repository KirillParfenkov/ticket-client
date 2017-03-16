package com.company.core.sessions;

import com.company.core.Observer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kiryl_Parfiankou on 3/16/2017.
 */
public class FindSessionObserver implements Observer {

    private static final String keyWord = "find session";

    @Override
    public void update(String message) {
        // String[] commands = message.split("\\s");

        if (keyWord.equals(message)) {

            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://localhost:8080/ticket/sessions");

            BufferedReader br = null;

            try {

                HttpResponse response = client.execute(httpGet);
                br = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br == null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
