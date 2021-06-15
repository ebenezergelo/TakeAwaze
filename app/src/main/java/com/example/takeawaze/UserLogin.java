package com.example.takeawaze;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class UserLogin extends AppCompatActivity {
    MainActivity m = new MainActivity();
    PHPRequest php = new PHPRequest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        Button loginBtn = (Button) findViewById(R.id.logIN);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { userLogin(v); }
        });

        public void userLogin(View v) {
            //Button loginBtn = (Button) findViewById(R.id.logIN);
            PHPRequest php = new PHPRequest();
            setContentView(R.layout.activity_user_login);
            boolean custLoginToken = false;
            EditText n = (EditText) findViewById(R.id.custName);
            EditText p = (EditText) findViewById(R.id.userPhone);
            String custLoginName = n.getText().toString();
            String custLoginPhone = p.getText().toString();
            String USER_PHONE = null;
            String USER_NAME = null;
            for (int i = 0; i < m.users.size(); i++) {
                (m.users.get(i)).getUSER_NAME();
                if (custLoginName.equals(USER_NAME) && custLoginPhone.equals(USER_PHONE)) {
                    custLoginToken = true;
                    break;
                }
            }
            if (custLoginToken) {
                setContentView(R.layout.activity_user_login);
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Invalid Login Details :(";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }
}