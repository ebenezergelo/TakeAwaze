package com.example.takeawaze;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Staff> staffs = new ArrayList<>();
    public ArrayList<Order> orders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void popUsers()
    {

    }
    public void popStaffs()
    {

    }
    public void popOrders()
    {

    }

}