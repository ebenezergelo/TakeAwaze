package com.example.takeawaze;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Staff> staffs = new ArrayList<>();
    public ArrayList<Order> orders = new ArrayList<>();
    PHPRequest php = new PHPRequest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
             View.SYSTEM_UI_FLAG_IMMERSIVE
                     | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                     | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                     | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                     | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        MainActivity.this.runOnUiThread(new Runnable() {
//        public void run() {
//         try {
//          popOrders();
//          popStaffs();
//          popUsers();
//         } catch (IOException | JSONException e) {
//          e.printStackTrace();
//         }
//
//        }
//     });
    }
    public void popUsers() throws IOException, JSONException {
     String json = php.getRequest("");
     JSONArray ja = new JSONArray(json);
    }
    public void popStaffs() throws IOException, JSONException {
     String json = php.getRequest("");
     JSONArray ja = new JSONArray(json);
    }
    public void popOrders() throws IOException, JSONException {
     String json = php.getRequest("");
     JSONArray ja = new JSONArray(json);
    }

}