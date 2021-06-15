package com.example.takeawaze;

import android.app.Activity;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;

public class PHPRequest {
    OkHttpClient client = new OkHttpClient();
    public void doRequest(Activity a, String url, RequestHandle rh) throws IOException {
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
                final String responseData = response.body().string();
                a.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            rh.processResponse(responseData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}



