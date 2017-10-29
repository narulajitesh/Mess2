package com.example.jiteshnarula.mess;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        this.viewPager.setOffscreenPageLimit(8);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
//                messageView.setText(TabMessage.get(tabId, false));
                Log.d("Raman","tabId  -->> "+tabId);
                switch (tabId){
                    case R.id.tab_recents:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.tab_favorites:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.tab_nearby:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.tab_friends:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.tab_food:
                        viewPager.setCurrentItem(4);
                        break;


                }

            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
//                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return true;
            }
        });
    }
}
