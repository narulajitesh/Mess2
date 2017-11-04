package com.example.jiteshnarula.mess;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by Dell on 05/11/2017.
 */

public class MainHomeActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager vp = findViewById(R.id.viewpager);
        SharedPreferences sharedPreferences = MainHomeActivity.this.getSharedPreferences("Home", 0);
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        vp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        SharedPreferences settings = getSharedPreferences("checkPref", MODE_PRIVATE);
        String check = settings.getString("check", "");
        if(check.equalsIgnoreCase("1")){

        }

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);


        ActivityCompat.requestPermissions(MainHomeActivity.this,
                new String[]{Manifest.permission.READ_CONTACTS},
                1);
//        ActivityCompat.requestPermissions(MainActivity.this,
//                new String[]{Manifest.permission.WRITE_CONTACTS},
//                1);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
//                messageView.setText(TabMessage.get(tabId, false));
                switch (tabId) {
                    case R.id.tab_recents:
                        vp.setCurrentItem(0);
                        break;

                    case R.id.tab_friends:
                        vp.setCurrentItem(1);
                        break;

                    case R.id.tab_favorites:
                        vp.setCurrentItem(2);
                        break;

                    case R.id.tab_nearby:
                        vp.setCurrentItem(3);
                        break;

                    case R.id.tab_food:
                        vp.setCurrentItem(4);
                        break;


                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Log.i("ntn", "----->" + tabId);
//                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainHomeActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    onDestroy();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}

