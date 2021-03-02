package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzm {

    /* renamed from: a */
    private static final Object f4597a = new Object();

    /* renamed from: b */
    private static zzm f4598b;

    public static zzm zzce(Context context) {
        synchronized (f4597a) {
            if (f4598b == null) {
                f4598b = new zzn(context.getApplicationContext());
            }
        }
        return f4598b;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
