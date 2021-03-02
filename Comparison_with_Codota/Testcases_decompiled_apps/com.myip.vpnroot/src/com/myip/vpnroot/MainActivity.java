package com.myip.vpnroot;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
    /* access modifiers changed from: private */
    public ActionBar actionBar;
    private TabsPagerAdapter mAdapter;
    ViewPager mViewPager;
    private String[] tabs = {"Products", "Services", "Options"};
    ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C2344R.layout.activity_main);
        this.viewPager = (ViewPager) findViewById(C2344R.C2346id.pager);
        this.actionBar = getActionBar();
        this.mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.mAdapter);
        this.actionBar.setHomeButtonEnabled(false);
        this.actionBar.setNavigationMode(2);
        for (String tab_name : this.tabs) {
            this.actionBar.addTab(this.actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                MainActivity.this.actionBar.setSelectedNavigationItem(position);
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        this.viewPager.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
