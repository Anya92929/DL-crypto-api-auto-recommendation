package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkd;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.ads.internal.ag */
class C1220ag extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ zzt f3442a;

    private C1220ag(zzt zzt) {
        this.f3442a = zzt;
    }

    /* synthetic */ C1220ag(zzt zzt, C1217ad adVar) {
        this(zzt);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        try {
            zzbw unused = this.f3442a.f4078h = (zzbw) this.f3442a.f4073c.get(((Long) zzdc.zzbdd.get()).longValue(), TimeUnit.MILLISECONDS);
            return null;
        } catch (InterruptedException | ExecutionException e) {
            zzkd.zzd("Failed to load ad data", e);
            return null;
        } catch (TimeoutException e2) {
            zzkd.zzcx("Timed out waiting for ad data");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Void voidR) {
        String a = this.f3442a.mo5893a();
        if (this.f3442a.f4076f != null) {
            this.f3442a.f4076f.loadUrl(a);
        }
    }
}
