package com.example.takeawaze;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StaffDashboard extends AppCompatActivity {
    MainActivity m;
    StaffLogIN s;
    Staff staff = s.loggedStaff;
    ArrayList<Order> orders = m.orders;
    ArrayList<Order> staffOrders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_dashboard);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        final ListView lv = (ListView) findViewById(R.id.list);
        
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).STAFF_NAME.equals(staff.getSTAFF_NAME()))
            {
                staffOrders.add(orders.get(i));
            }
        }
        final ArrayList<String> output = new ArrayList<String>() {
        };
        for (int i = 0; i < staffOrders.size(); i++) {
            String rating = "";
            int r= staffOrders.get(i).isRATING();
           if(r==1)
           {
               rating = "👍🏾";
           }else
           {
               rating = "👎🏾";
           }
            output.add("Order Number: "+ staffOrders.get(i).getORDER_NUM()+'\n'+
                    "Customer Name: "+ staffOrders.get(i).getUSER_NAME()+'\n'+
                    "Staff Name: "+ staffOrders.get(i).getSTAFF_NAME()+'\n'+
                    "Restaurant: "+ staffOrders.get(i).getRESTAURANT()+'\n'+
                    "Order Status: "+ staffOrders.get(i).getSTATUS()+'\n'+
                    "Order Time: "+ staffOrders.get(i).getTIME()+'\n'+
                    "Order rating: "+ rating);
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, output);
        lv.setAdapter(arrayAdapter);
    }
    public void addOrder(View v)
    {
        Intent intent = new Intent(this, AddOrders.class);
        startActivity(intent);
    }
}