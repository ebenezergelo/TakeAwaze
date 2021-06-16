package com.example.takeawaze;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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

    public void staffSignUp(View v) {
        String STAFF_NUM;
        String STAFF_NAME;
        String RESTAURANT;
        String STAFF_PASSWORD;
//         String url =
//                 "https://lamp.ms.wits.ac.za/home/s2345362/addStaff.php?num=245676&name=Reece%20Lazo&rest=Habesha%20Rest&pass=Reecie69";
        EditText staNum = (EditText) findViewById(R.id.staffNum);
        EditText staName = (EditText) findViewById(R.id.staffName);
        EditText rest = (EditText) findViewById(R.id.restaurant);
        EditText pass2 = (EditText) findViewById(R.id.passWord2);
        String staLoginNum = staNum.getText().toString();
        String staLoginName = staName.getText().toString();
        String restaurantName = rest.getText().toString();
        String passW2 = pass2.getText().toString();
        if (staLoginNum.length() == 6) {
            if (staLoginName.length() <= 20 && staLoginName.length() > 0) {
                if (restaurantName.length() <= 35 && restaurantName.length() > 0) {
                    if (passW2.length() <= 20 && passW2.length() > 0) {
                        post(staLoginNum, staLoginName, restaurantName, passW2);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Invalid restaurant name entered :(";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid restaurant name entered :(";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Invalid name entered :(";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid staff number entered :(";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //validate if the staff is there if not call call post
    }

    public void post(String STAFF_NUM,
                     String STAFF_NAME,
                     String RESTAURANT,
                     String STAFF_PASSWORD) {
        RequestBody formBody = new FormBody.Builder()
                .add("brand", "")
                .build();

        Request request = new Request.Builder()
                .url("https://lamp.ms.wits.ac.za/home/s2345362/addStaff.php")
                .post(formBody)
                .build();

    }
}