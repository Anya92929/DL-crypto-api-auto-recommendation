package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.gv */
public class C1232gv extends WebView implements DownloadListener {

    /* renamed from: mG */
    private final WindowManager f3781mG;

    /* renamed from: mw */
    private final Object f3782mw = new Object();

    /* renamed from: qr */
    private C0927ay f3783qr;

    /* renamed from: qs */
    private final C1230gt f3784qs;

    /* renamed from: sX */
    private final C1391k f3785sX;

    /* renamed from: wH */
    private final C1234gw f3786wH;

    /* renamed from: wI */
    private final C1233a f3787wI;

    /* renamed from: wJ */
    private C1056dk f3788wJ;

    /* renamed from: wK */
    private boolean f3789wK;

    /* renamed from: wL */
    private boolean f3790wL;

    /* renamed from: wM */
    private boolean f3791wM;

    /* renamed from: wN */
    private boolean f3792wN;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.gv$a */
    private static class C1233a extends MutableContextWrapper {

        /* renamed from: mD */
        private Context f3793mD;

        /* renamed from: wO */
        private Activity f3794wO;

        public C1233a(Context context) {
            super(context);
            setBaseContext(context);
        }

        /* renamed from: dA */
        public Context mo8644dA() {
            return this.f3794wO;
        }

        public void setBaseContext(Context base) {
            this.f3793mD = base.getApplicationContext();
            this.f3794wO = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.f3793mD);
        }

        public void startActivity(Intent intent) {
            if (this.f3794wO != null) {
                this.f3794wO.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.f3793mD.startActivity(intent);
        }
    }

    private C1232gv(C1233a aVar, C0927ay ayVar, boolean z, boolean z2, C1391k kVar, C1230gt gtVar) {
        super(aVar);
        this.f3787wI = aVar;
        this.f3783qr = ayVar;
        this.f3789wK = z;
        this.f3785sX = kVar;
        this.f3784qs = gtVar;
        this.f3781mG = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        C1213gj.m4616a((Context) aVar, gtVar.f3777wD, settings);
        if (Build.VERSION.SDK_INT >= 17) {
            C1226gp.m4664a(getContext(), settings);
        } else if (Build.VERSION.SDK_INT >= 11) {
            C1221gn.m4651a(getContext(), settings);
        }
        setDownloadListener(this);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f3786wH = new C1245gy(this, z2);
        } else {
            this.f3786wH = new C1234gw(this, z2);
        }
        setWebViewClient(this.f3786wH);
        if (Build.VERSION.SDK_INT >= 14) {
            setWebChromeClient(new C1246gz(this));
        } else if (Build.VERSION.SDK_INT >= 11) {
            setWebChromeClient(new C1237gx(this));
        }
        m4689dB();
    }

    /* renamed from: a */
    public static C1232gv m4688a(Context context, C0927ay ayVar, boolean z, boolean z2, C1391k kVar, C1230gt gtVar) {
        return new C1232gv(new C1233a(context), ayVar, z, z2, kVar, gtVar);
    }

    /* renamed from: dB */
    private void m4689dB() {
        synchronized (this.f3782mw) {
            if (this.f3789wK || this.f3783qr.f2623og) {
                if (Build.VERSION.SDK_INT < 14) {
                    C1229gs.m4675S("Disabling hardware acceleration on an overlay.");
                    m4690dC();
                } else {
                    C1229gs.m4675S("Enabling hardware acceleration on an overlay.");
                    m4691dD();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                C1229gs.m4675S("Disabling hardware acceleration on an AdView.");
                m4690dC();
            } else {
                C1229gs.m4675S("Enabling hardware acceleration on an AdView.");
                m4691dD();
            }
        }
    }

    /* renamed from: dC */
    private void m4690dC() {
        synchronized (this.f3782mw) {
            if (!this.f3790wL && Build.VERSION.SDK_INT >= 11) {
                C1221gn.m4655i(this);
            }
            this.f3790wL = true;
        }
    }

    /* renamed from: dD */
    private void m4691dD() {
        synchronized (this.f3782mw) {
            if (this.f3790wL && Build.VERSION.SDK_INT >= 11) {
                C1221gn.m4656j(this);
            }
            this.f3790wL = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: X */
    public void mo8617X(String str) {
        synchronized (this.f3782mw) {
            if (!isDestroyed()) {
                loadUrl(str);
            } else {
                C1229gs.m4679W("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* renamed from: Y */
    public C0927ay mo8618Y() {
        C0927ay ayVar;
        synchronized (this.f3782mw) {
            ayVar = this.f3783qr;
        }
        return ayVar;
    }

    /* renamed from: a */
    public void mo8619a(Context context, C0927ay ayVar) {
        synchronized (this.f3782mw) {
            this.f3787wI.setBaseContext(context);
            this.f3788wJ = null;
            this.f3783qr = ayVar;
            this.f3789wK = false;
            this.f3792wN = false;
            C1213gj.m4627b(this);
            loadUrl("about:blank");
            this.f3786wH.reset();
            setOnTouchListener((View.OnTouchListener) null);
            setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: a */
    public void mo8620a(C0927ay ayVar) {
        synchronized (this.f3782mw) {
            this.f3783qr = ayVar;
            requestLayout();
        }
    }

    /* renamed from: a */
    public void mo8621a(C1056dk dkVar) {
        synchronized (this.f3782mw) {
            this.f3788wJ = dkVar;
        }
    }

    /* renamed from: a */
    public void mo8622a(String str, Map<String, ?> map) {
        try {
            mo8624b(str, C1213gj.m4642t(map));
        } catch (JSONException e) {
            C1229gs.m4679W("Could not convert parameters to JSON.");
        }
    }

    /* renamed from: a */
    public void mo8623a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:" + str + "(");
        sb.append(jSONObject2);
        sb.append(");");
        mo8617X(sb.toString());
    }

    /* renamed from: b */
    public void mo8624b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        C1229gs.m4678V("Dispatching AFMA event: " + sb);
        mo8617X(sb.toString());
    }

    /* renamed from: bT */
    public void mo8625bT() {
        if (mo8631dv().mo8658dF()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.f3781mG.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            int s = C1213gj.m4641s(getContext());
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            int round = Math.round(((float) displayMetrics.widthPixels) * f);
            try {
                mo8624b("onScreenInfoChanged", new JSONObject().put("width", round).put("height", Math.round(((float) (displayMetrics.heightPixels - s)) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (JSONException e) {
                C1229gs.m4681b("Error occured while obtaining screen information.", e);
            }
        }
    }

    /* renamed from: ca */
    public void mo8626ca() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f3784qs.f3777wD);
        mo8622a("onshow", (Map<String, ?>) hashMap);
    }

    /* renamed from: cb */
    public void mo8627cb() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f3784qs.f3777wD);
        mo8622a("onhide", (Map<String, ?>) hashMap);
    }

    /* renamed from: dA */
    public Context mo8628dA() {
        return this.f3787wI.mo8644dA();
    }

    public void destroy() {
        synchronized (this.f3782mw) {
            super.destroy();
            this.f3791wM = true;
        }
    }

    /* renamed from: du */
    public C1056dk mo8630du() {
        C1056dk dkVar;
        synchronized (this.f3782mw) {
            dkVar = this.f3788wJ;
        }
        return dkVar;
    }

    /* renamed from: dv */
    public C1234gw mo8631dv() {
        return this.f3786wH;
    }

    /* renamed from: dw */
    public boolean mo8632dw() {
        return this.f3792wN;
    }

    /* renamed from: dx */
    public C1391k mo8633dx() {
        return this.f3785sX;
    }

    /* renamed from: dy */
    public C1230gt mo8634dy() {
        return this.f3784qs;
    }

    /* renamed from: dz */
    public boolean mo8635dz() {
        boolean z;
        synchronized (this.f3782mw) {
            z = this.f3789wK;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f3782mw
            monitor-enter(r1)
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.C1229gs.m4679W(r0)     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0014
            r0 = 0
            r4.onReceiveValue(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0015:
            return
        L_0x0016:
            super.evaluateJavascript(r3, r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0015
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1232gv.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.f3782mw) {
            z = this.f3791wM;
        }
        return z;
    }

    /* renamed from: o */
    public void mo8638o(boolean z) {
        synchronized (this.f3782mw) {
            if (this.f3788wJ != null) {
                this.f3788wJ.mo8318o(z);
            } else {
                this.f3792wN = z;
            }
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C1229gs.m4675S("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.f3782mw
            monitor-enter(r4)
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x00ae }
            if (r1 != 0) goto L_0x0016
            boolean r1 = r9.f3789wK     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x001b
        L_0x0016:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)     // Catch:{ all -> 0x00ae }
        L_0x001a:
            return
        L_0x001b:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x00ae }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x00ae }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x00ae }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x00ae }
            if (r2 == r6) goto L_0x002f
            if (r2 != r8) goto L_0x00c7
        L_0x002f:
            r2 = r3
        L_0x0030:
            if (r5 == r6) goto L_0x0034
            if (r5 != r8) goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.google.android.gms.internal.ay r5 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x00ae }
            if (r5 > r2) goto L_0x0041
            com.google.android.gms.internal.ay r2 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x00ae }
            if (r2 <= r0) goto L_0x00b1
        L_0x0041:
            com.google.android.gms.internal.gv$a r0 = r9.f3787wI     // Catch:{ all -> 0x00ae }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x00ae }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x00ae }
            float r0 = r0.density     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r2.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ay r5 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x00ae }
            float r5 = (float) r5     // Catch:{ all -> 0x00ae }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = "x"
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ay r5 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r5 = r5.heightPixels     // Catch:{ all -> 0x00ae }
            float r5 = (float) r5     // Catch:{ all -> 0x00ae }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = " dp, but only has "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00ae }
            float r3 = (float) r3     // Catch:{ all -> 0x00ae }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00ae }
            java.lang.String r3 = "x"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00ae }
            float r1 = (float) r1     // Catch:{ all -> 0x00ae }
            float r0 = r1 / r0
            int r0 = (int) r0     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = " dp."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.C1229gs.m4679W(r0)     // Catch:{ all -> 0x00ae }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x00ae }
            if (r0 == r7) goto L_0x00a6
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x00ae }
        L_0x00a6:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x00ae }
        L_0x00ab:
            monitor-exit(r4)     // Catch:{ all -> 0x00ae }
            goto L_0x001a
        L_0x00ae:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ae }
            throw r0
        L_0x00b1:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x00ae }
            if (r0 == r7) goto L_0x00bb
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x00ae }
        L_0x00bb:
            com.google.android.gms.internal.ay r0 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ay r1 = r9.f3783qr     // Catch:{ all -> 0x00ae }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x00ae }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x00ae }
            goto L_0x00ab
        L_0x00c7:
            r2 = r0
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1232gv.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.f3785sX != null) {
            this.f3785sX.mo9089a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.f3787wI.setBaseContext(context);
    }

    /* renamed from: x */
    public void mo8643x(boolean z) {
        synchronized (this.f3782mw) {
            this.f3789wK = z;
            m4689dB();
        }
    }
}
