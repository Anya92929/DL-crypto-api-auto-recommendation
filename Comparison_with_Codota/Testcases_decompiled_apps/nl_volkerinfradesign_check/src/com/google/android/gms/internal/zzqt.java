package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqu;

@Deprecated
public class zzqt implements zzqu.zza {

    /* renamed from: a */
    private final zzqu f3241a;

    /* renamed from: b */
    private boolean f3242b;

    public zzqt(Context context, int i) {
        this(context, i, (String) null);
    }

    public zzqt(Context context, int i, String str) {
        this(context, i, str, (String) null, true);
    }

    public zzqt(Context context, int i, String str, String str2, boolean z) {
        this.f3241a = new zzqu(context, i, str, str2, this, z, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.f3242b = true;
    }

    /* renamed from: a */
    private void m4073a() {
        if (!this.f3242b) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void send() {
        m4073a();
        this.f3241a.start();
        this.f3242b = false;
    }

    public void zzES() {
        this.f3241a.stop();
    }

    public void zzET() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        m4073a();
        this.f3241a.zzb(str, bArr, strArr);
    }

    public void zzc(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }
}
