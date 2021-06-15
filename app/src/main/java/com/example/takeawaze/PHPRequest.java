package com.example.takeawaze;

import android.app.Activity;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class PHPRequest {
    OkHttpClient client = new OkHttpClient();
    MainActivity a;
    public String getRequest(String url) throws IOException {
        final String[] responseData = new String[1];
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                a.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseData[0] = response.body().toString();
                    }
                });
            }
        });
        return responseData[0];
    }
}



