package com.myip.vpnroot;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class ProductsActivity extends Fragment {
    private TabsPagerAdapter mAdapter;
    ViewPager mViewPager;
    ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C2344R.layout.new_products_activity, container, false);
        this.viewPager = (ViewPager) rootView.findViewById(C2344R.C2346id.pager);
        this.mAdapter = new TabsPagerAdapter(getChildFragmentManager());
        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(C2344R.C2346id.radiogroup);
        this.viewPager.setAdapter(this.mAdapter);
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(C2344R.C2346id.radioButton);
                        return;
                    case 1:
                        radioGroup.check(C2344R.C2346id.radioButton2);
                        return;
                    case 2:
                        radioGroup.check(C2344R.C2346id.radioButton3);
                        return;
                    default:
                        return;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
        return rootView;
    }

    private float dpFromPx(float px) {
        return px / getActivity().getResources().getDisplayMetrics().density;
    }

    private float pxFromDp(float dp) {
        return getActivity().getResources().getDisplayMetrics().density * dp;
    }
}
