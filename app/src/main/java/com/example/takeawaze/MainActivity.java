package com.example.takeawaze;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Staff> staffs = new ArrayList<>();
    public ArrayList<Order> orders = new ArrayList<>();
    PHPRequest php = new PHPRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            php.doRequest(MainActivity.this, "https://lamp.ms.wits.ac.za/home/s2345362/popuser.php",
                    new RequestHandle() {
                        @Override
                        public void processResponse(String response) throws JSONException {
                            popUsers(response);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            php.doRequest(MainActivity.this, "https://lamp.ms.wits.ac.za/home/s2345362/popstaff.php",
                    new RequestHandle() {
                        @Override
                        public void processResponse(String response) throws JSONException {
                            popUsers(response);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            php.doRequest(MainActivity.this, "https://lamp.ms.wits.ac.za/home/s2345362/poporder.php",
                    new RequestHandle() {
                        @Override
                        public void processResponse(String response) throws JSONException {
                            popUsers(response);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void popUsers(String json) throws JSONException {
        JSONArray ja = new JSONArray(json);
        String USER_PHONE;
        String USER_NAME;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            USER_PHONE = jo.getString("USER_PHONE");
            USER_NAME = jo.getString("USER_NAME");
            User usr = new User(USER_PHONE, USER_NAME);
            users.add(usr);
        }
    }

    public void popStaffs(String json) throws JSONException {
        JSONArray ja = new JSONArray(json);
        String STAFF_NUM;
        String STAFF_NAME;
        String RESTAURANT;
        String STAFF_PASSWORD;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            STAFF_NUM = jo.getString("STAFF_NUM");
            STAFF_NAME = jo.getString("STAFF_NAME");
            RESTAURANT = jo.getString("RESTAURANT");
            STAFF_PASSWORD = jo.getString("STAFF_PASSWORD");
            Staff stf = new Staff(STAFF_NUM, STAFF_NAME, RESTAURANT, STAFF_PASSWORD);
            staffs.add(stf);
        }
    }

    public void popOrders(String json) throws JSONException {
        JSONArray ja = new JSONArray(json);
        int ORDER_NUM;
        String USER_NAME;
        String STAFF_NAME;
        String RESTAURANT;
        String STATUS;
        String TIME;
        int RATING;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            ORDER_NUM = jo.getInt("ORDER_NUM");
            USER_NAME = jo.getString("USER_NAME");
            STAFF_NAME = jo.getString("STAFF_NAME");
            RESTAURANT = jo.getString("RESTAURANT");
            STATUS = jo.getString("STATUS");
            TIME = jo.getString("TIME");
            RATING = jo.getInt("RATING");
            Order ordr = new Order(ORDER_NUM, USER_NAME, STAFF_NAME, RESTAURANT, STATUS, TIME, RATING);
            orders.add(ordr);
        }
    }

    public void staffLogIn(View v) {
        setContentView(R.layout.activity_main_screen);
    }
    public void userLogIn(View v) {
        setContentView(R.layout.activity_user_login);
    }


}