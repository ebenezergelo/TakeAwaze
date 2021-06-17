package com.example.takeawaze;

import android.content.Context;
import android.content.Intent;
import android.view.View;
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
    
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).USER_NAME.equals(user.getUSER_NAME()))
            {
                usrOrders.add(orders.get(i));
            }
        }
        
    }
    public void post(String STAFF_NUM,
                         String STAFF_NAME,
                         String RESTAURANT,
                         String STAFF_PASSWORD, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addStaff.php" + "?num="
                        + STAFF_NUM + "&name=" + STAFF_NAME + "&rest=" + RESTAURANT + "&pass=" + STAFF_PASSWORD)
                .build();
        client.newCall(request).enqueue(new Callback() {
            
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Context context = getApplicationContext();
                CharSequence text = "Staff account creation failed :(";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                e.printStackTrace();
            }
            
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // ... check for failure using isSuccessful before proceeding
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                
            }
        });
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}