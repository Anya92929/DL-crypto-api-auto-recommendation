package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.ak */
public abstract class C0987ak {

    /* renamed from: a */
    private static final Object f4697a = new Object();

    /* renamed from: b */
    private static C0987ak f4698b;

    /* renamed from: a */
    public static C0987ak m4389a(Context context) {
        synchronized (f4697a) {
            if (f4698b == null) {
                f4698b = new C0988al(context.getApplicationContext());
            }
        }
        return f4698b;
    }

    /* renamed from: a */
    public abstract boolean mo7527a(String str, ServiceConnection serviceConnection, String str2);

    /* renamed from: b */
    public abstract void mo7528b(String str, ServiceConnection serviceConnection, String str2);
}
