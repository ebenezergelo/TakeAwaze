package com.example.takeawaze;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AddOrders extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    MainActivity m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orders);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }
    public void onClick(View v){

    }
    public void addOrder(){
        RequestBody formBody = new FormBody.Builder()
                .add("brand", "")
                .build();

        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addOrder.php")
                .post(formBody)
                .build();

    }
    public void addUser(){
        RequestBody formBody = new FormBody.Builder()
                .add("brand", "")
                .build();

        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addUser.php")
                .post(formBody)
                .build();
    }

}