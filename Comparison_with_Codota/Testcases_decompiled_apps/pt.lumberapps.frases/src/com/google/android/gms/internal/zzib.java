package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;

@zzin
public abstract class zzib extends zzkc {

    /* renamed from: a */
    protected final zzic.zza f6376a;

    /* renamed from: b */
    protected final Context f6377b;

    /* renamed from: c */
    protected final Object f6378c = new Object();

    /* renamed from: d */
    protected final Object f6379d = new Object();

    /* renamed from: e */
    protected final zzju.zza f6380e;

    /* renamed from: f */
    protected AdResponseParcel f6381f;

    public final class zza extends Exception {

        /* renamed from: a */
        private final int f6382a;

        public zza(String str, int i) {
            super(str);
            this.f6382a = i;
        }

        public int getErrorCode() {
            return this.f6382a;
        }
    }

    protected zzib(Context context, zzju.zza zza2, zzic.zza zza3) {
        super(true);
        this.f6377b = context;
        this.f6380e = zza2;
        this.f6381f = zza2.zzciq;
        this.f6376a = zza3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzju mo8502a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8503a(long j);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8504a(zzju zzju) {
        this.f6376a.zzb(zzju);
    }

    public void onStop() {
    }

    public void zzew() {
        synchronized (this.f6378c) {
            zzkd.zzcv("AdRendererBackgroundTask started.");
            int i = this.f6380e.errorCode;
            try {
                mo8503a(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzkd.zzcw(e.getMessage());
                } else {
                    zzkd.zzcx(e.getMessage());
                }
                if (this.f6381f == null) {
                    this.f6381f = new AdResponseParcel(errorCode);
                } else {
                    this.f6381f = new AdResponseParcel(errorCode, this.f6381f.zzbns);
                }
                zzkh.zzclc.post(new C1680kb(this));
                i = errorCode;
            }
            zzkh.zzclc.post(new C1681kc(this, mo8502a(i)));
        }
    }
}
