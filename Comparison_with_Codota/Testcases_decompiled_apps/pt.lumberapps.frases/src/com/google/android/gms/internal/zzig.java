package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzin
public class zzig extends zzkc {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzic.zza f6393a;

    /* renamed from: b */
    private final AdResponseParcel f6394b;

    /* renamed from: c */
    private final zzju.zza f6395c;

    /* renamed from: d */
    private final zzii f6396d;

    /* renamed from: e */
    private final Object f6397e;

    /* renamed from: f */
    private Future f6398f;

    public zzig(Context context, zzq zzq, zzju.zza zza, zzas zzas, zzic.zza zza2) {
        this(zza, zza2, new zzii(context, zzq, new zzkn(context), zzas, zza));
    }

    zzig(zzju.zza zza, zzic.zza zza2, zzii zzii) {
        this.f6397e = new Object();
        this.f6395c = zza;
        this.f6394b = zza.zzciq;
        this.f6393a = zza2;
        this.f6396d = zzii;
    }

    /* renamed from: a */
    private zzju m7177a(int i) {
        return new zzju(this.f6395c.zzcip.zzcar, (zzlh) null, (List) null, i, (List) null, (List) null, this.f6394b.orientation, this.f6394b.zzbns, this.f6395c.zzcip.zzcau, false, (zzfz) null, (zzgk) null, (String) null, (zzga) null, (zzgc) null, this.f6394b.zzcbz, this.f6395c.zzapa, this.f6394b.zzcbx, this.f6395c.zzcik, this.f6394b.zzccc, this.f6394b.zzccd, this.f6395c.zzcie, (zzh.zza) null, (RewardItemParcel) null, (List) null, (List) null, this.f6395c.zzciq.zzccq, this.f6395c.zzciq.zzccr, (String) null, (List) null);
    }

    public void onStop() {
        synchronized (this.f6397e) {
            if (this.f6398f != null) {
                this.f6398f.cancel(true);
            }
        }
    }

    public void zzew() {
        zzju zzju;
        int i;
        try {
            synchronized (this.f6397e) {
                this.f6398f = zzkg.zza((Callable) this.f6396d);
            }
            zzju = (zzju) this.f6398f.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzkd.zzcx("Timed out waiting for native ad.");
            this.f6398f.cancel(true);
            i = 2;
            zzju = null;
        } catch (ExecutionException e2) {
            zzju = null;
            i = 0;
        } catch (InterruptedException e3) {
            zzju = null;
            i = 0;
        } catch (CancellationException e4) {
            zzju = null;
            i = 0;
        }
        if (zzju == null) {
            zzju = m7177a(i);
        }
        zzkh.zzclc.post(new C1683ke(this, zzju));
    }
}
