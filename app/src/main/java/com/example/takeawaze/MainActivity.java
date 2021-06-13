package com.example.takeawaze;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;

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
        MainActivity.this.runOnUiThread(new Runnable() {
        public void run() {
         try {
          popOrders();
          popStaffs();
          popUsers();
         } catch (IOException | JSONException e) {
          e.printStackTrace();
         }

        }
     });
    }
    public void popUsers() throws IOException, JSONException {
     String json = php.getRequest("", MainActivity.this);
     JSONArray ja = new JSONArray(json);
    }
    public void popStaffs() throws IOException, JSONException {
     String json = php.getRequest("",MainActivity.this);
     JSONArray ja = new JSONArray(json);
    }
    public void popOrders() throws IOException, JSONException {
     String json = php.getRequest("",MainActivity.this);
     JSONArray ja = new JSONArray(json);
    }

}