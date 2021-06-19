package com.example.takeawaze;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class UserOrder extends AppCompatActivity {
    UserDashboard u;
    Order order = u.rateOrder;
    int ordRating;
    TextView rating = (TextView) findViewById(R.id.rating);
    final int ordNum = order.getORDER_NUM();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);
        
        TextView ordNum = (TextView) findViewById(R.id.ordNumb);
        TextView staName = (TextView) findViewById(R.id.staName);
        TextView rest = (TextView) findViewById(R.id.rest);
        TextView time = (TextView) findViewById(R.id.ordTime);
        String rt = "";
        int ordRating= order.isRATING();
        if(ordRating==1)
        {
            rt = "👍🏾";
        }else
        {
            rt = "👎🏾";
        }
        ordNum.setText(String.valueOf(order.getORDER_NUM()));
        staName.setText(order.getSTAFF_NAME());
        rest.setText(order.getRESTAURANT());
        time.setText(order.getTIME());
        rating.setText(rt);
    }
//    public void like(View v)throws IOException
//    {
//        update(ordNum, 1);
//        order.setRATING(1);
//        String rt = "👍🏾";
//        rating.setText(rt);
//    }
//    public void unlike(View v)throws IOException
//    {
//        update(ordNum, 0);
//        order.setRATING(0);
//        String rt = "👎🏾";
//        rating.setText(rt);
//    }
//    public void update(int ORDER_NUM, int RATING)
//            throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://lamp.ms.wits.ac.za/home/s2345362/rating.php" + "?num="
//                        + ORDER_NUM + "&rating=" + RATING)
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Context context = getApplicationContext();
//                CharSequence text = "New order creation failed :(";
//                int duration = Toast.LENGTH_LONG;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                // ... check for failure using isSuccessful before proceeding
//                if (!response.isSuccessful()) {
//                    throw new IOException("Unexpected code " + response);
//                }
//
//            }
//        });
//    }
    
}