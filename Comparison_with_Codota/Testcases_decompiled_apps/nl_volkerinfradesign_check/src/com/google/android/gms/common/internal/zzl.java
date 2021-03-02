package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl {

    /* renamed from: a */
    private static final Object f3006a = new Object();

    /* renamed from: b */
    private static zzl f3007b;

    public static zzl zzau(Context context) {
        synchronized (f3006a) {
            if (f3007b == null) {
                f3007b = new zzm(context.getApplicationContext());
            }
        }
        return f3007b;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, ServiceConnection serviceConnection, String str2);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, ServiceConnection serviceConnection, String str2);
}
