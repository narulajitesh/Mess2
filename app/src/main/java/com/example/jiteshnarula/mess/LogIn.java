package com.example.jiteshnarula.mess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    Button SignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        SignIn=(Button)findViewById(R.id.signIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LogIn.this, "SignIn", Toast.LENGTH_SHORT).show();
                SharedPreferences settings = getSharedPreferences("checkPref", MODE_PRIVATE);

                // Writing data to SharedPreferences
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("check", "1");
                editor.commit();
                Intent intent=new Intent(LogIn.this,MainHomeActivity.class);
                LogIn.this.startActivity(intent);
            }
        });

    }
}
