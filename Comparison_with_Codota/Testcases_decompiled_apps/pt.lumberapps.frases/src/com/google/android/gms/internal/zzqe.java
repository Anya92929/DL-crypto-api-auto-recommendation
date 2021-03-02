package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzqe extends BroadcastReceiver {

    /* renamed from: a */
    protected Context f6895a;

    /* renamed from: b */
    private final zza f6896b;

    public abstract class zza {
        public abstract void zzaou();
    }

    public zzqe(zza zza2) {
        this.f6896b = zza2;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            this.f6896b.zzaou();
            unregister();
        }
    }

    public void setContext(Context context) {
        this.f6895a = context;
    }

    public synchronized void unregister() {
        if (this.f6895a != null) {
            this.f6895a.unregisterReceiver(this);
        }
        this.f6895a = null;
    }
}
