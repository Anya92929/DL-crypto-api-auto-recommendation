package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.b */
public class C0314b implements DialogInterface.OnClickListener {

    /* renamed from: Ll */
    private final Fragment f741Ll;

    /* renamed from: Lm */
    private final int f742Lm;
    private final Intent mIntent;

    /* renamed from: nr */
    private final Activity f743nr;

    public C0314b(Activity activity, Intent intent, int i) {
        this.f743nr = activity;
        this.f741Ll = null;
        this.mIntent = intent;
        this.f742Lm = i;
    }

    public C0314b(Fragment fragment, Intent intent, int i) {
        this.f743nr = null;
        this.f741Ll = fragment;
        this.mIntent = intent;
        this.f742Lm = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null && this.f741Ll != null) {
                this.f741Ll.startActivityForResult(this.mIntent, this.f742Lm);
            } else if (this.mIntent != null) {
                this.f743nr.startActivityForResult(this.mIntent, this.f742Lm);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
