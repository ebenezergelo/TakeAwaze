package com.example.takeawaze;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
//        MainActivity.this.runOnUiThread(new Runnable() {
//        public void run() {
//         try {
//          popOrders();
//          popStaffs();
//          popUsers();
//         } catch (IOException | JSONException e) {
//          e.printStackTrace();
//         }
//
//        }
//     });
    }
    public void popUsers() throws IOException, JSONException {
     String json = php.getRequest("");
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
    public void popStaffs() throws IOException, JSONException {
     String json = php.getRequest("");
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
    public void popOrders() throws IOException, JSONException {
     String json = php.getRequest("");
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
    public void userLogin(View v)
    {
     setContentView(R.layout.activity_user_login);
    }
    public void staffLogIn(View v)
    {
     setContentView(R.layout.activity_main_screen);
    }

}