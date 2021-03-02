package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.nf */
public class C1598nf {
    private final C1611nn aku;
    private C1609nl akv;

    /* renamed from: com.google.android.gms.internal.nf$a */
    public interface C1599a {
        /* renamed from: b */
        void mo9502b(PendingIntent pendingIntent);

        /* renamed from: mS */
        void mo9503mS();

        /* renamed from: mT */
        void mo9504mT();
    }

    public C1598nf(Context context, int i, String str, String str2, C1599a aVar, boolean z) {
        int i2 = 0;
        String packageName = context.getPackageName();
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.");
        }
        this.akv = new C1609nl(packageName, i2, i, str, str2, z);
        this.aku = new C1611nn(context, new C1608nk(aVar));
    }

    /* renamed from: a */
    public void mo9506a(long j, String str, byte[] bArr, String... strArr) {
        this.aku.mo9540b(this.akv, new C1603nh(j, str, bArr, strArr));
    }

    /* renamed from: b */
    public void mo9507b(String str, byte[] bArr, String... strArr) {
        mo9506a(System.currentTimeMillis(), str, bArr, strArr);
    }

    public void start() {
        this.aku.start();
    }

    public void stop() {
        this.aku.stop();
    }
}
