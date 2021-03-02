package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzae;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.gass.internal.a */
class C1403a implements zzd.zzb, zzd.zzc {

    /* renamed from: a */
    protected zzb f4805a;

    /* renamed from: b */
    private final String f4806b;

    /* renamed from: c */
    private final String f4807c;

    /* renamed from: d */
    private final LinkedBlockingQueue f4808d;

    /* renamed from: e */
    private final HandlerThread f4809e = new HandlerThread("GassClient");

    public C1403a(Context context, String str, String str2) {
        this.f4806b = str;
        this.f4807c = str2;
        this.f4809e.start();
        this.f4805a = new zzb(context, this.f4809e.getLooper(), this, this);
        this.f4808d = new LinkedBlockingQueue();
        mo7020c();
    }

    /* renamed from: a */
    public zzae.zza mo7017a() {
        return mo7018a(2000);
    }

    /* renamed from: a */
    public zzae.zza mo7018a(int i) {
        zzae.zza zza;
        try {
            zza = (zzae.zza) this.f4808d.poll((long) i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zza = null;
        }
        return zza == null ? new zzae.zza() : zza;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zze mo7019b() {
        try {
            return this.f4805a.zzblb();
        } catch (DeadObjectException | IllegalStateException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7020c() {
        this.f4805a.zzarx();
    }

    /* renamed from: d */
    public void mo7021d() {
        if (this.f4805a == null) {
            return;
        }
        if (this.f4805a.isConnected() || this.f4805a.isConnecting()) {
            this.f4805a.disconnect();
        }
    }

    public void onConnected(Bundle bundle) {
        zze b = mo7019b();
        if (b != null) {
            try {
                this.f4808d.put(b.zza(new GassRequestParcel(this.f4806b, this.f4807c)).zzbld());
            } catch (Throwable th) {
            } finally {
                mo7021d();
                this.f4809e.quit();
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.f4808d.put(new zzae.zza());
        } catch (InterruptedException e) {
        }
    }

    public void onConnectionSuspended(int i) {
        try {
            this.f4808d.put(new zzae.zza());
        } catch (InterruptedException e) {
        }
    }
}
