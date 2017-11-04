package com.example.jiteshnarula.mess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences("checkPref", MODE_PRIVATE);
        String check = settings.getString("check", "");
        if (check.equalsIgnoreCase("1")) {
            Intent intent=new Intent(MainActivity.this,MainHomeActivity.class);
            MainActivity.this.startActivity(intent);
        }else {
            Intent intent=new Intent(MainActivity.this,LogIn.class);
            MainActivity.this.startActivity(intent);
        }
    }

}
