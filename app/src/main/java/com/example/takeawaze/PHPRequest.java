package com.example.takeawaze;

import android.app.Activity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class PHPRequest {
    Activity a;
    OkHttpClient client = new OkHttpClient();
    public String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}



