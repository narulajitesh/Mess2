package com.example.jiteshnarula.mess;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager vp = findViewById(R.id.viewpager);
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
//                messageView.setText(TabMessage.get(tabId, false));
                switch(tabId)
                {
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
                Log.i("ntn","----->" + tabId);
//                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();


            }
        });
    }
}
