package com.example.takeawaze;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class StaffSignUp extends AppCompatActivity {
MainActivity m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_sign_up);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }
    public void staffSignUp(View v)
    {
         String STAFF_NUM;
         String STAFF_NAME;
         String RESTAURANT;
         String STAFF_PASSWORD;
//         String url =
//                 "https://lamp.ms.wits.ac.za/home/s2345362/addStaff.php?num=245676&name=Reece%20Lazo&rest=Habesha%20Rest&pass=Reecie69";
        //validate if the staff is there if not call call post
    }
    public void post( String STAFF_NUM,
            String STAFF_NAME,
            String RESTAURANT,
            String STAFF_PASSWORD){
        RequestBody formBody = new FormBody.Builder()
                .add("brand", "")
                .build();

        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addStaff.php")
                .post(formBody)
                .build();

    }
}