package com.tapcrowd.app.utils;

import android.content.Intent;
import android.support.p000v4.app.Fragment;

public class TCLauncherItem {
    public int defaulticon;
    public Fragment fragment;
    private String iconurl;

    /* renamed from: id */
    private String f2132id;
    private Intent intent;
    private int noticount;
    private String text;

    public TCLauncherItem(String text2, Integer resourceid, Intent intent2) {
        this.text = text2;
        this.defaulticon = resourceid.intValue();
        this.intent = intent2;
    }

    public TCLauncherItem(String text2, String iconurl2, int defaulticon2, Intent intent2) {
        this.text = text2;
        this.iconurl = iconurl2;
        this.intent = intent2;
        this.defaulticon = defaulticon2;
    }

    public TCLauncherItem(String id, String text2, String iconurl2, int defaulticon2, Fragment fragment2) {
        this.f2132id = id;
        this.text = text2;
        this.iconurl = iconurl2;
        this.defaulticon = defaulticon2;
        this.fragment = fragment2;
    }

    public TCLauncherItem(String id, String text2, String iconurl2, int defaulticon2, Fragment fragment2, int noticount2) {
        this.f2132id = id;
        this.text = text2;
        this.iconurl = iconurl2;
        this.defaulticon = defaulticon2;
        this.fragment = fragment2;
        this.noticount = noticount2;
    }

    public String getId() {
        return this.f2132id;
    }

    public String getText() {
        return this.text;
    }

    public String getIconurl() {
        return this.iconurl;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public int getNoticount() {
        return this.noticount;
    }
}
