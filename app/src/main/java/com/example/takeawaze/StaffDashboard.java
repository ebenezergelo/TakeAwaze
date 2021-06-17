package com.example.takeawaze;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

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
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).USER_NAME.equals(staff.getSTAFF_NAME()))
            {
                staffOrders.add(orders.get(i));
            }
        }
        TextView text = new TextView(this);
        LinearLayout layout = findViewById(R.id.scroll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(10, 10, 0, 10);
        text.setLayoutParams(params);
        String output ="";
        layout.removeAllViews();
        for (int i = 0; i < staffOrders.size(); i++) {
            output = "Order Number: "+ staffOrders.get(i).getORDER_NUM()+'\n'+
                    "Customer Name: "+ staffOrders.get(i).getUSER_NAME()+'\n'+
                    "Staff Name: "+ staffOrders.get(i).getSTAFF_NAME()+'\n'+
                    "Restaurant: "+ staffOrders.get(i).getRESTAURANT()+'\n'+
                    "Order Status: "+ staffOrders.get(i).getSTATUS()+'\n'+
                    "Order Time: "+ staffOrders.get(i).getTIME()+'\n'+
                    "Order rating: "+ staffOrders.get(i).isRATING();
            text.setText(output);
            layout.addView(text);
        }
    }
}