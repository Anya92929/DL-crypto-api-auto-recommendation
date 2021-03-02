package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzli;

@zzin
public class zzhz implements Runnable {

    /* renamed from: a */
    protected final zzlh f6363a;

    /* renamed from: b */
    protected boolean f6364b;

    /* renamed from: c */
    protected boolean f6365c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Handler f6366d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final long f6367e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f6368f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public zzli.zza f6369g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final int f6370h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final int f6371i;

    public final class zza extends AsyncTask {

        /* renamed from: b */
        private final WebView f6373b;

        /* renamed from: c */
        private Bitmap f6374c;

        public zza(WebView webView) {
            this.f6373b = webView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean z;
            int width = this.f6374c.getWidth();
            int height = this.f6374c.getHeight();
            if (width == 0 || height == 0) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f6374c.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                z = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            zzhz.m7150c(zzhz.this);
            if (bool.booleanValue() || zzhz.this.zzqb() || zzhz.this.f6368f <= 0) {
                zzhz.this.f6365c = bool.booleanValue();
                zzhz.this.f6369g.zza(zzhz.this.f6363a, true);
            } else if (zzhz.this.f6368f > 0) {
                if (zzkd.zzaz(2)) {
                    zzkd.zzcv("Ad not detected, scheduling another run.");
                }
                zzhz.this.f6366d.postDelayed(zzhz.this, zzhz.this.f6367e);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPreExecute() {
            this.f6374c = Bitmap.createBitmap(zzhz.this.f6371i, zzhz.this.f6370h, Bitmap.Config.ARGB_8888);
            this.f6373b.setVisibility(0);
            this.f6373b.measure(View.MeasureSpec.makeMeasureSpec(zzhz.this.f6371i, 0), View.MeasureSpec.makeMeasureSpec(zzhz.this.f6370h, 0));
            this.f6373b.layout(0, 0, zzhz.this.f6371i, zzhz.this.f6370h);
            this.f6373b.draw(new Canvas(this.f6374c));
            this.f6373b.invalidate();
        }
    }

    public zzhz(zzli.zza zza2, zzlh zzlh, int i, int i2) {
        this(zza2, zzlh, i, i2, 200, 50);
    }

    public zzhz(zzli.zza zza2, zzlh zzlh, int i, int i2, long j, long j2) {
        this.f6367e = j;
        this.f6368f = j2;
        this.f6366d = new Handler(Looper.getMainLooper());
        this.f6363a = zzlh;
        this.f6369g = zza2;
        this.f6364b = false;
        this.f6365c = false;
        this.f6370h = i2;
        this.f6371i = i;
    }

    /* renamed from: c */
    static /* synthetic */ long m7150c(zzhz zzhz) {
        long j = zzhz.f6368f - 1;
        zzhz.f6368f = j;
        return j;
    }

    public void run() {
        if (this.f6363a == null || zzqb()) {
            this.f6369g.zza(this.f6363a, true);
        } else {
            new zza(this.f6363a.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzlr(this, this.f6363a, adResponseParcel.zzccf));
    }

    public void zza(AdResponseParcel adResponseParcel, zzlr zzlr) {
        this.f6363a.setWebViewClient(zzlr);
        this.f6363a.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzbto) ? null : zzu.zzfq().zzco(adResponseParcel.zzbto), adResponseParcel.body, "text/html", "UTF-8", (String) null);
    }

    public void zzpz() {
        this.f6366d.postDelayed(this, this.f6367e);
    }

    public synchronized void zzqa() {
        this.f6364b = true;
    }

    public synchronized boolean zzqb() {
        return this.f6364b;
    }

    public boolean zzqc() {
        return this.f6365c;
    }
}
