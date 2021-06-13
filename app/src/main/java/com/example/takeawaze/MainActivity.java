package com.example.takeawaze;

import android.view.View;
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
    }

    public void popUsers() throws IOException, JSONException {
     String json = php.getRequest("");
     JSONArray ja = new JSONArray(json);
    }
    public void popStaffs() throws IOException {
     String json = php.getRequest("");
    }
    public void popOrders() throws IOException {
     String json = php.getRequest("");
    }

}