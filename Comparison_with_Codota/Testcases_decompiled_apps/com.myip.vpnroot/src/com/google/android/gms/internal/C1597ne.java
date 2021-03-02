package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.C1598nf;

/* renamed from: com.google.android.gms.internal.ne */
public class C1597ne implements C1598nf.C1599a {
    private final C1598nf aks;
    private boolean akt;

    public C1597ne(Context context, int i) {
        this(context, i, (String) null);
    }

    public C1597ne(Context context, int i, String str) {
        this(context, i, str, (String) null, true);
    }

    public C1597ne(Context context, int i, String str, String str2, boolean z) {
        this.aks = new C1598nf(context, i, str, str2, this, z);
        this.akt = true;
    }

    /* renamed from: mR */
    private void m5676mR() {
        if (!this.akt) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    /* renamed from: a */
    public void mo9501a(String str, byte[] bArr, String... strArr) {
        m5676mR();
        this.aks.mo9507b(str, bArr, strArr);
    }

    /* renamed from: b */
    public void mo9502b(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }

    /* renamed from: mS */
    public void mo9503mS() {
        this.aks.stop();
    }

    /* renamed from: mT */
    public void mo9504mT() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void send() {
        m5676mR();
        this.aks.start();
        this.akt = false;
    }
}
