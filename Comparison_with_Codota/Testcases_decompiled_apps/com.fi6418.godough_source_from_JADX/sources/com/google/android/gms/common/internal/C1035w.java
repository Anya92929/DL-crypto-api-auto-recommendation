package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.w */
public class C1035w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final Activity f4762a;

    /* renamed from: b */
    private final Fragment f4763b;

    /* renamed from: c */
    private final Intent f4764c;

    /* renamed from: d */
    private final int f4765d;

    public C1035w(Activity activity, Intent intent, int i) {
        this.f4762a = activity;
        this.f4763b = null;
        this.f4764c = intent;
        this.f4765d = i;
    }

    public C1035w(Fragment fragment, Intent intent, int i) {
        this.f4762a = null;
        this.f4763b = fragment;
        this.f4764c = intent;
        this.f4765d = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f4764c != null && this.f4763b != null) {
                this.f4763b.startActivityForResult(this.f4764c, this.f4765d);
            } else if (this.f4764c != null) {
                this.f4762a.startActivityForResult(this.f4764c, this.f4765d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
