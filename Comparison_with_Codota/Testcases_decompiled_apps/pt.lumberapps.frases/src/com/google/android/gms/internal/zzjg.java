package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzju;

@zzin
public class zzjg extends zzkc implements zzjh, zzjk {

    /* renamed from: a */
    private final zzju.zza f6512a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f6513b;

    /* renamed from: c */
    private final zzjm f6514c;

    /* renamed from: d */
    private final zzjk f6515d;

    /* renamed from: e */
    private final Object f6516e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f6517f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String f6518g;

    /* renamed from: h */
    private final String f6519h;

    /* renamed from: i */
    private int f6520i = 0;

    /* renamed from: j */
    private int f6521j = 3;

    public zzjg(Context context, String str, String str2, String str3, zzju.zza zza, zzjm zzjm, zzjk zzjk) {
        this.f6513b = context;
        this.f6517f = str;
        this.f6518g = str2;
        this.f6519h = str3;
        this.f6512a = zza;
        this.f6514c = zzjm;
        this.f6516e = new Object();
        this.f6515d = zzjk;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7273a(AdRequestParcel adRequestParcel, zzgk zzgk) {
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f6517f)) {
                zzgk.zza(adRequestParcel, this.f6518g, this.f6519h);
            } else {
                zzgk.zzc(adRequestParcel, this.f6518g);
            }
        } catch (RemoteException e) {
            zzkd.zzd("Fail to load ad from adapter.", e);
            zza(this.f6517f, 0);
        }
    }

    /* renamed from: b */
    private void m7276b(long j) {
        while (true) {
            synchronized (this.f6516e) {
                if (this.f6520i == 0) {
                    if (!mo8564a(j)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8564a(long j) {
        long elapsedRealtime = 20000 - (zzu.zzfu().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f6516e.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
        synchronized (this.f6516e) {
            this.f6520i = 2;
            this.f6521j = i;
            this.f6516e.notify();
        }
    }

    public void zzaw(int i) {
        zza(this.f6517f, 0);
    }

    public void zzcg(String str) {
        synchronized (this.f6516e) {
            this.f6520i = 1;
            this.f6516e.notify();
        }
    }

    public void zzew() {
        if (this.f6514c != null && this.f6514c.zzrv() != null && this.f6514c.zzru() != null) {
            zzjj zzrv = this.f6514c.zzrv();
            zzrv.zza((zzjk) this);
            zzrv.zza((zzjh) this);
            AdRequestParcel adRequestParcel = this.f6512a.zzcip.zzcar;
            zzgk zzru = this.f6514c.zzru();
            try {
                if (zzru.isInitialized()) {
                    zza.zzcnb.post(new C1709ld(this, adRequestParcel, zzru));
                } else {
                    zza.zzcnb.post(new C1710le(this, zzru, adRequestParcel, zzrv));
                }
            } catch (RemoteException e) {
                zzkd.zzd("Fail to check if adapter is initialized.", e);
                zza(this.f6517f, 0);
            }
            m7276b(zzu.zzfu().elapsedRealtime());
            zzrv.zza((zzjk) null);
            zzrv.zza((zzjh) null);
            if (this.f6520i == 1) {
                this.f6515d.zzcg(this.f6517f);
            } else {
                this.f6515d.zza(this.f6517f, this.f6521j);
            }
        }
    }

    public void zzrs() {
        m7273a(this.f6512a.zzcip.zzcar, this.f6514c.zzru());
    }
}
