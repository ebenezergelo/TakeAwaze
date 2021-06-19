package com.example.takeawaze;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    MainActivity m;
    UserLogin u;
    User user = u.loggedUser;
    ArrayList<Order> orders = m.orders;
    public static Order rateOrder;
    ArrayList<Order> usrOrders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    
        final ListView lv = (ListView) findViewById(R.id.list);
    
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUSER_NAME().equals(user.getUSER_NAME()))
            {
                usrOrders.add(orders.get(i));
            }
        }
        final ArrayList<String> output = new ArrayList<String>() {
        };
        for (int i = 0; i < usrOrders.size(); i++) {
            String rating = "";
            int r= usrOrders.get(i).isRATING();
            if(r==1)
            {
                rating = "👍🏾";
            }else
            {
                rating = "👎🏾";
            }
            output.add("Order Number: "+ usrOrders.get(i).getORDER_NUM()+'\n'+
                    "Staff Name: "+ usrOrders.get(i).getSTAFF_NAME()+'\n'+
                    "Restaurant: "+ usrOrders.get(i).getRESTAURANT()+'\n'+
                    "Order Status: "+ usrOrders.get(i).getSTATUS()+'\n'+
                    "Order Time: "+ usrOrders.get(i).getTIME()+'\n'+
                    "Order rating: "+ rating);
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, output);
        lv.setAdapter(arrayAdapter);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rateOrder = usrOrders.get(position);
                Intent intent = new Intent(UserDashboard.this, UserOrder.class);
                startActivity(intent);
            }
        });
    }
}
