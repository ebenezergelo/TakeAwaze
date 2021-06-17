package com.example.takeawaze;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AddOrders extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    MainActivity m;
    StaffLogIN s;
    Staff staff = s.loggedStaff;

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

    public void onClick(View v) throws IOException {
        EditText n = (EditText) findViewById(R.id.userName);
        EditText p = (EditText) findViewById(R.id.userPhone);
        EditText s = (EditText) findViewById(R.id.orderStatus);
        EditText t = (EditText) findViewById(R.id.orderTime);
        String STAFF_NUM = staff.getSTAFF_NUM();
        String STAFF_NAME = staff.getSTAFF_NAME();
        String RESTAURANT = staff.getRESTAURANT();
        String USER_PHONE = p.getText().toString();
        String USER_NAME = n.getText().toString();
        String TIME = t.getText().toString();
        String STATUS = s.getText().toString();
        int RATING = 0;

        if (USER_PHONE.length() == 10) {
            if (USER_NAME.length() > 0 && USER_NAME.length() <= 20) {
                if (TIME.length() == 5) {
                    if (STATUS.equalsIgnoreCase("Pending") | STATUS.equalsIgnoreCase("Ready") | STATUS.equalsIgnoreCase("Collected")) {
                        addUser(USER_PHONE, USER_NAME);
                        addOrder(STAFF_NUM, USER_PHONE, TIME, STATUS, RATING);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Invalid status entered :(";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid time entered :(";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Invalid username entered :(";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid phone number entered :(";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    public void addOrder(String STAFF_NUM, String USER_PHONE, String TIME, String STATUS, int RATING)
            throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addOrder.php" + "?num="
                        + STAFF_NUM + "&phone=" + USER_PHONE + "&time=" + TIME + "&status="
                        + STATUS + "&rest=" + RATING)
                .build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Context context = getApplicationContext();
                CharSequence text = "New order creation failed :(";
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

    public void addUser(String USER_PHONE, String USER_NAME) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addUser.php" + "?phone="
                        + USER_PHONE + "&name=" + USER_NAME)
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