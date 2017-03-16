package com.company.core.sessions;

import com.company.core.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by Kiryl_Parfiankou on 3/16/2017.
 */
public class PostSessionObserver implements Observer{

    private static final String keyWord = "post";

    @Override
    public void update(String message) {

        if( message == null ) {
            return;
        }

        String[] commands = message.split("\\s");

        if (keyWord.equals(commands[0])) {

            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost("http://localhost:8080/ticket/sessions");

            try {
                client.execute(request);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
