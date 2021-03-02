package com.myip.vpnroot;

import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new PersonalVPNActivity();
            case 1:
                return new DedicatedVPNActivity();
            case 2:
                return new BusinessVPNActivity();
            default:
                return null;
        }
    }

    public int getCount() {
        return 3;
    }
}
