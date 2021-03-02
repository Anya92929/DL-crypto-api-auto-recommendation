package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.p009v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzqk;

public abstract class zzi implements DialogInterface.OnClickListener {
    public static zzi zza(Activity activity, Intent intent, int i) {
        return new C1378q(intent, activity, i);
    }

    public static zzi zza(Fragment fragment, Intent intent, int i) {
        return new C1379r(intent, fragment, i);
    }

    public static zzi zza(zzqk zzqk, Intent intent, int i) {
        return new C1380s(intent, zzqk, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzasr();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }

    public abstract void zzasr();
}
