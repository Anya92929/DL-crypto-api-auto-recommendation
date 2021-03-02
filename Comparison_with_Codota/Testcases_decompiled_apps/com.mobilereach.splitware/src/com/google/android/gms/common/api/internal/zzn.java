package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.gms.common.zzc;

abstract class zzn extends BroadcastReceiver {
    protected Context mContext;

    zzn() {
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t) {
        return zza(context, t, zzc.zzoK());
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t, zzc zzc) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.mContext = context;
        if (zzc.zzi(context, "com.google.android.gms")) {
            return t;
        }
        t.zzpJ();
        t.unregister();
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            zzpJ();
            unregister();
        }
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }

    /* access modifiers changed from: protected */
    public abstract void zzpJ();
}
