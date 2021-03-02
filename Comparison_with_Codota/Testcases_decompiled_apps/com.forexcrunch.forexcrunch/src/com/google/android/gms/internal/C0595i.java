package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.i */
public class C0595i implements DialogInterface.OnClickListener {

    /* renamed from: bm */
    private final Activity f1383bm;

    /* renamed from: bn */
    private final int f1384bn;
    private final Intent mIntent;

    public C0595i(Activity activity, Intent intent, int i) {
        this.f1383bm = activity;
        this.mIntent = intent;
        this.f1384bn = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null) {
                this.f1383bm.startActivityForResult(this.mIntent, this.f1384bn);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
