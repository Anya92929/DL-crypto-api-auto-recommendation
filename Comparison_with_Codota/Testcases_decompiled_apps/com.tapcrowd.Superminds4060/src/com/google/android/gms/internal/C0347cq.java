package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.cq */
public final class C0347cq extends WebView implements DownloadListener {

    /* renamed from: eJ */
    private final Object f1018eJ = new Object();

    /* renamed from: fg */
    private C0622x f1019fg;

    /* renamed from: go */
    private final C0599h f1020go;

    /* renamed from: hT */
    private final C0348cr f1021hT;

    /* renamed from: hU */
    private final MutableContextWrapper f1022hU;

    /* renamed from: hV */
    private final C0345co f1023hV;

    /* renamed from: hW */
    private C0280bf f1024hW;

    /* renamed from: hX */
    private boolean f1025hX;

    /* renamed from: hY */
    private boolean f1026hY;

    private C0347cq(MutableContextWrapper mutableContextWrapper, C0622x xVar, boolean z, boolean z2, C0599h hVar, C0345co coVar) {
        super(mutableContextWrapper);
        this.f1022hU = mutableContextWrapper;
        this.f1019fg = xVar;
        this.f1025hX = z;
        this.f1020go = hVar;
        this.f1023hV = coVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        C0337ci.m692a((Context) mutableContextWrapper, coVar.f1014hP, settings);
        if (Build.VERSION.SDK_INT >= 17) {
            C0341ck.m719a(getContext(), settings);
        } else if (Build.VERSION.SDK_INT >= 11) {
            C0340cj.m713a(getContext(), settings);
        }
        setDownloadListener(this);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1021hT = new C0359ct(this, z2);
        } else {
            this.f1021hT = new C0348cr(this, z2);
        }
        setWebViewClient(this.f1021hT);
        if (Build.VERSION.SDK_INT >= 14) {
            setWebChromeClient(new C0360cu(this));
        } else if (Build.VERSION.SDK_INT >= 11) {
            setWebChromeClient(new C0351cs(this));
        }
        m742aA();
    }

    /* renamed from: a */
    public static C0347cq m741a(Context context, C0622x xVar, boolean z, boolean z2, C0599h hVar, C0345co coVar) {
        return new C0347cq(new MutableContextWrapper(context), xVar, z, z2, hVar, coVar);
    }

    /* renamed from: aA */
    private void m742aA() {
        synchronized (this.f1018eJ) {
            if (this.f1025hX || this.f1019fg.f1582ex) {
                if (Build.VERSION.SDK_INT < 14) {
                    C0344cn.m733m("Disabling hardware acceleration on an overlay.");
                    m743aB();
                } else {
                    C0344cn.m733m("Enabling hardware acceleration on an overlay.");
                    m744aC();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                C0344cn.m733m("Disabling hardware acceleration on an AdView.");
                m743aB();
            } else {
                C0344cn.m733m("Enabling hardware acceleration on an AdView.");
                m744aC();
            }
        }
    }

    /* renamed from: aB */
    private void m743aB() {
        synchronized (this.f1018eJ) {
            if (!this.f1026hY && Build.VERSION.SDK_INT >= 11) {
                C0340cj.m717c(this);
            }
            this.f1026hY = true;
        }
    }

    /* renamed from: aC */
    private void m744aC() {
        synchronized (this.f1018eJ) {
            if (this.f1026hY && Build.VERSION.SDK_INT >= 11) {
                C0340cj.m718d(this);
            }
            this.f1026hY = false;
        }
    }

    /* renamed from: a */
    public void mo4205a(Context context, C0622x xVar) {
        synchronized (this.f1018eJ) {
            this.f1022hU.setBaseContext(context);
            this.f1024hW = null;
            this.f1019fg = xVar;
            this.f1025hX = false;
            C0337ci.m704b(this);
            loadUrl("about:blank");
            this.f1021hT.reset();
        }
    }

    /* renamed from: a */
    public void mo4206a(C0280bf bfVar) {
        synchronized (this.f1018eJ) {
            this.f1024hW = bfVar;
        }
    }

    /* renamed from: a */
    public void mo4207a(String str, Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        if (map != null) {
            try {
                String jSONObject = C0337ci.m712l(map).toString();
                sb.append(",");
                sb.append(jSONObject);
            } catch (JSONException e) {
                C0344cn.m737q("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        sb.append(");");
        C0344cn.m736p("Dispatching AFMA event: " + sb);
        loadUrl(sb.toString());
    }

    /* renamed from: as */
    public void mo4208as() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f1023hV.f1014hP);
        mo4207a("onhide", (Map<String, ?>) hashMap);
    }

    /* renamed from: at */
    public void mo4209at() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f1023hV.f1014hP);
        mo4207a("onshow", (Map<String, ?>) hashMap);
    }

    /* renamed from: au */
    public C0280bf mo4210au() {
        C0280bf bfVar;
        synchronized (this.f1018eJ) {
            bfVar = this.f1024hW;
        }
        return bfVar;
    }

    /* renamed from: av */
    public C0622x mo4211av() {
        C0622x xVar;
        synchronized (this.f1018eJ) {
            xVar = this.f1019fg;
        }
        return xVar;
    }

    /* renamed from: aw */
    public C0348cr mo4212aw() {
        return this.f1021hT;
    }

    /* renamed from: ax */
    public C0599h mo4213ax() {
        return this.f1020go;
    }

    /* renamed from: ay */
    public C0345co mo4214ay() {
        return this.f1023hV;
    }

    /* renamed from: az */
    public boolean mo4215az() {
        boolean z;
        synchronized (this.f1018eJ) {
            z = this.f1025hX;
        }
        return z;
    }

    /* renamed from: i */
    public void mo4216i(boolean z) {
        synchronized (this.f1018eJ) {
            this.f1025hX = z;
            m742aA();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0344cn.m733m("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
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
            java.lang.Object r4 = r9.f1018eJ
            monitor-enter(r4)
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0016
            boolean r1 = r9.f1025hX     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x001b
        L_0x0016:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x008e }
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
        L_0x001a:
            return
        L_0x001b:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x008e }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x008e }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x008e }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x008e }
            if (r2 == r6) goto L_0x002f
            if (r2 != r8) goto L_0x00a7
        L_0x002f:
            r2 = r3
        L_0x0030:
            if (r5 == r6) goto L_0x0034
            if (r5 != r8) goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.google.android.gms.internal.x r5 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x008e }
            if (r5 > r2) goto L_0x0041
            com.google.android.gms.internal.x r2 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x008e }
            if (r2 <= r0) goto L_0x0091
        L_0x0041:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.x r2 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.x r2 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.String r2 = ", but only has "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.C0344cn.m737q(r0)     // Catch:{ all -> 0x008e }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x008e }
            if (r0 == r7) goto L_0x0087
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x008e }
        L_0x0087:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            goto L_0x001a
        L_0x008e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008e }
            throw r0
        L_0x0091:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x008e }
            if (r0 == r7) goto L_0x009b
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x008e }
        L_0x009b:
            com.google.android.gms.internal.x r0 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.x r1 = r9.f1019fg     // Catch:{ all -> 0x008e }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x008e }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x008e }
            goto L_0x008c
        L_0x00a7:
            r2 = r0
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0347cq.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.f1020go != null) {
            this.f1020go.mo5302a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.f1022hU.setBaseContext(context);
    }
}
