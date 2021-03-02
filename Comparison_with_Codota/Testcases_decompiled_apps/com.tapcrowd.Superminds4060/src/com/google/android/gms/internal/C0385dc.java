package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.dc */
public class C0385dc implements DialogInterface.OnClickListener {

    /* renamed from: fD */
    private final Activity f1088fD;

    /* renamed from: ky */
    private final int f1089ky;
    private final Intent mIntent;

    public C0385dc(Activity activity, Intent intent, int i) {
        this.f1088fD = activity;
        this.mIntent = intent;
        this.f1089ky = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null) {
                this.f1088fD.startActivityForResult(this.mIntent, this.f1089ky);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
