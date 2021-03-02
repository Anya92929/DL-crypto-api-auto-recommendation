package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public class zzaqb extends CustomTabsServiceConnection {

    /* renamed from: a */
    private WeakReference f5919a;

    public zzaqb(zzaqc zzaqc) {
        this.f5919a = new WeakReference(zzaqc);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzaqc zzaqc = (zzaqc) this.f5919a.get();
        if (zzaqc != null) {
            zzaqc.zza(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzaqc zzaqc = (zzaqc) this.f5919a.get();
        if (zzaqc != null) {
            zzaqc.zzkm();
        }
    }
}
