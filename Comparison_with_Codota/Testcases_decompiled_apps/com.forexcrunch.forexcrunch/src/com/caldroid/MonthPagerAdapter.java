package com.caldroid;

import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class MonthPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<DateGridFragment> fragments;

    public ArrayList<DateGridFragment> getFragments() {
        if (this.fragments == null) {
            this.fragments = new ArrayList<>();
            for (int i = 0; i < getCount(); i++) {
                this.fragments.add(new DateGridFragment());
            }
        }
        return this.fragments;
    }

    public void setFragments(ArrayList<DateGridFragment> fragments2) {
        this.fragments = fragments2;
    }

    public MonthPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return getFragments().get(position);
    }

    public int getCount() {
        return 4;
    }
}
