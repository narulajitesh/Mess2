package com.example.jiteshnarula.mess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Dell on 29/10/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag=new SecretChat();
                break;
            case 1:
                frag=new Entertainment();
                break;
            case 2:
                frag=new RecentChat();
                break;
            case 3:
                frag=new Contacts();
                break;
            case 4:
                frag=new Profile();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
