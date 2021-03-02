package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.internal.C1234gw;

@C1130ez
/* renamed from: com.google.android.gms.internal.fc */
public class C1152fc implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: lf */
    public final int f3492lf;
    /* access modifiers changed from: private */

    /* renamed from: lg */
    public final int f3493lg;

    /* renamed from: md */
    protected final C1232gv f3494md;
    /* access modifiers changed from: private */

    /* renamed from: td */
    public final Handler f3495td;
    /* access modifiers changed from: private */

    /* renamed from: te */
    public final long f3496te;
    /* access modifiers changed from: private */

    /* renamed from: tf */
    public long f3497tf;
    /* access modifiers changed from: private */

    /* renamed from: tg */
    public C1234gw.C1236a f3498tg;

    /* renamed from: th */
    protected boolean f3499th;

    /* renamed from: ti */
    protected boolean f3500ti;

    /* renamed from: com.google.android.gms.internal.fc$a */
    protected final class C1153a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: tj */
        private final WebView f3501tj;

        /* renamed from: tk */
        private Bitmap f3502tk;

        public C1153a(WebView webView) {
            this.f3501tj = webView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean z;
            int width = this.f3502tk.getWidth();
            int height = this.f3502tk.getHeight();
            if (width == 0 || height == 0) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f3502tk.getPixel(i2, i3) != 0) {
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
            C1152fc.m4416c(C1152fc.this);
            if (bool.booleanValue() || C1152fc.this.mo8475cB() || C1152fc.this.f3497tf <= 0) {
                C1152fc.this.f3500ti = bool.booleanValue();
                C1152fc.this.f3498tg.mo7957a(C1152fc.this.f3494md);
            } else if (C1152fc.this.f3497tf > 0) {
                if (C1229gs.m4684u(2)) {
                    C1229gs.m4675S("Ad not detected, scheduling another run.");
                }
                C1152fc.this.f3495td.postDelayed(C1152fc.this, C1152fc.this.f3496te);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPreExecute() {
            this.f3502tk = Bitmap.createBitmap(C1152fc.this.f3492lf, C1152fc.this.f3493lg, Bitmap.Config.ARGB_8888);
            this.f3501tj.setVisibility(0);
            this.f3501tj.measure(View.MeasureSpec.makeMeasureSpec(C1152fc.this.f3492lf, 0), View.MeasureSpec.makeMeasureSpec(C1152fc.this.f3493lg, 0));
            this.f3501tj.layout(0, 0, C1152fc.this.f3492lf, C1152fc.this.f3493lg);
            this.f3501tj.draw(new Canvas(this.f3502tk));
            this.f3501tj.invalidate();
        }
    }

    public C1152fc(C1234gw.C1236a aVar, C1232gv gvVar, int i, int i2) {
        this(aVar, gvVar, i, i2, 200, 50);
    }

    public C1152fc(C1234gw.C1236a aVar, C1232gv gvVar, int i, int i2, long j, long j2) {
        this.f3496te = j;
        this.f3497tf = j2;
        this.f3495td = new Handler(Looper.getMainLooper());
        this.f3494md = gvVar;
        this.f3498tg = aVar;
        this.f3499th = false;
        this.f3500ti = false;
        this.f3493lg = i2;
        this.f3492lf = i;
    }

    /* renamed from: c */
    static /* synthetic */ long m4416c(C1152fc fcVar) {
        long j = fcVar.f3497tf - 1;
        fcVar.f3497tf = j;
        return j;
    }

    /* renamed from: a */
    public void mo8472a(C1171fk fkVar, C1248ha haVar) {
        this.f3494md.setWebViewClient(haVar);
        this.f3494md.loadDataWithBaseURL(TextUtils.isEmpty(fkVar.f3558rP) ? null : C1213gj.m4608L(fkVar.f3558rP), fkVar.f3560tG, "text/html", "UTF-8", (String) null);
    }

    /* renamed from: b */
    public void mo8473b(C1171fk fkVar) {
        mo8472a(fkVar, new C1248ha(this, this.f3494md, fkVar.f3569tP));
    }

    /* renamed from: cA */
    public synchronized void mo8474cA() {
        this.f3499th = true;
    }

    /* renamed from: cB */
    public synchronized boolean mo8475cB() {
        return this.f3499th;
    }

    /* renamed from: cC */
    public boolean mo8476cC() {
        return this.f3500ti;
    }

    /* renamed from: cz */
    public void mo8477cz() {
        this.f3495td.postDelayed(this, this.f3496te);
    }

    public void run() {
        if (this.f3494md == null || mo8475cB()) {
            this.f3498tg.mo7957a(this.f3494md);
        } else {
            new C1153a(this.f3494md).execute(new Void[0]);
        }
    }
}
