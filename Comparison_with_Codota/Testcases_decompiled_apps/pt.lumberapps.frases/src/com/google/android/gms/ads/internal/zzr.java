package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import java.lang.ref.WeakReference;

@zzin
public class zzr {

    /* renamed from: a */
    private final zza f4064a;

    /* renamed from: b */
    private final Runnable f4065b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AdRequestParcel f4066c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f4067d;

    /* renamed from: e */
    private boolean f4068e;

    /* renamed from: f */
    private long f4069f;

    public class zza {

        /* renamed from: a */
        private final Handler f4070a;

        public zza(Handler handler) {
            this.f4070a = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.f4070a.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.f4070a.removeCallbacks(runnable);
        }
    }

    public zzr(zza zza2) {
        this(zza2, new zza(zzkh.zzclc));
    }

    zzr(zza zza2, zza zza3) {
        this.f4067d = false;
        this.f4068e = false;
        this.f4069f = 0;
        this.f4064a = zza3;
        this.f4065b = new C1216ac(this, new WeakReference(zza2));
    }

    public void cancel() {
        this.f4067d = false;
        this.f4064a.removeCallbacks(this.f4065b);
    }

    public void pause() {
        this.f4068e = true;
        if (this.f4067d) {
            this.f4064a.removeCallbacks(this.f4065b);
        }
    }

    public void resume() {
        this.f4068e = false;
        if (this.f4067d) {
            this.f4067d = false;
            zza(this.f4066c, this.f4069f);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.f4067d) {
            zzkd.zzcx("An ad refresh is already scheduled.");
            return;
        }
        this.f4066c = adRequestParcel;
        this.f4067d = true;
        this.f4069f = j;
        if (!this.f4068e) {
            zzkd.zzcw(new StringBuilder(65).append("Scheduling ad refresh ").append(j).append(" milliseconds from now.").toString());
            this.f4064a.postDelayed(this.f4065b, j);
        }
    }

    public boolean zzfc() {
        return this.f4067d;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
