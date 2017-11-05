package com.example.jiteshnarula.mess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signup=(TextView)findViewById(R.id.link_signup);
//        SignIn=(Button)findViewById(R.id.signIn);
//        SignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LogIn.this, "SignIn", Toast.LENGTH_SHORT).show();
//                SharedPreferences settings = getSharedPreferences("checkPref", MODE_PRIVATE);
//
//                // Writing data to SharedPreferences
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("check", "1");
//                editor.commit();
//                Intent intent=new Intent(LogIn.this,MainHomeActivity.class);
//                LogIn.this.startActivity(intent);
//            }
//        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogIn.this,SignUp.class);
            LogIn.this.startActivity(intent);
            }
        });
    }
    public void onLogIn(View v){
        Toast.makeText(LogIn.this, "SignIn", Toast.LENGTH_SHORT).show();
        SharedPreferences settings = getSharedPreferences("checkPref", MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.putString("check", "1");
        editor.commit();
        Intent intent=new Intent(LogIn.this,MainHomeActivity.class);
        LogIn.this.startActivity(intent);
    }
}
