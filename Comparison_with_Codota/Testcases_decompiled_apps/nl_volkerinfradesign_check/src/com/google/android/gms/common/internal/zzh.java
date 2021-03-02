package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.p001v4.app.Fragment;
import android.util.Log;

public class zzh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final Activity f2957a;

    /* renamed from: b */
    private final Fragment f2958b;

    /* renamed from: c */
    private final Intent f2959c;

    /* renamed from: d */
    private final int f2960d;

    public zzh(Activity activity, Intent intent, int i) {
        this.f2957a = activity;
        this.f2958b = null;
        this.f2959c = intent;
        this.f2960d = i;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        this.f2957a = null;
        this.f2958b = fragment;
        this.f2959c = intent;
        this.f2960d = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f2959c != null && this.f2958b != null) {
                this.f2958b.startActivityForResult(this.f2959c, this.f2960d);
            } else if (this.f2959c != null) {
                this.f2957a.startActivityForResult(this.f2959c, this.f2960d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
