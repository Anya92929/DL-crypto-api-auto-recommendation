package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public abstract class zzcd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    protected final Object f6001a = new Object();

    /* renamed from: b */
    protected final zzcf f6002b;

    /* renamed from: c */
    BroadcastReceiver f6003c;

    /* renamed from: d */
    private final WeakReference f6004d;

    /* renamed from: e */
    private WeakReference f6005e;

    /* renamed from: f */
    private final zzck f6006f;

    /* renamed from: g */
    private final Context f6007g;

    /* renamed from: h */
    private final WindowManager f6008h;

    /* renamed from: i */
    private final PowerManager f6009i;

    /* renamed from: j */
    private final KeyguardManager f6010j;

    /* renamed from: k */
    private zzch f6011k;

    /* renamed from: l */
    private boolean f6012l;

    /* renamed from: m */
    private boolean f6013m = false;

    /* renamed from: n */
    private boolean f6014n = false;

    /* renamed from: o */
    private boolean f6015o;

    /* renamed from: p */
    private boolean f6016p;

    /* renamed from: q */
    private boolean f6017q;

    /* renamed from: r */
    private final HashSet f6018r = new HashSet();

    /* renamed from: s */
    private zzkr f6019s;

    /* renamed from: t */
    private final zzep f6020t = new C1510du(this);

    /* renamed from: u */
    private final zzep f6021u = new C1511dv(this);

    /* renamed from: v */
    private final zzep f6022v = new C1512dw(this);

    public class zza implements zzck {

        /* renamed from: a */
        private WeakReference f6023a;

        public zza(zzh zzh) {
            this.f6023a = new WeakReference(zzh);
        }

        public View zzhh() {
            zzh zzh = (zzh) this.f6023a.get();
            if (zzh != null) {
                return zzh.zzlc();
            }
            return null;
        }

        public boolean zzhi() {
            return this.f6023a.get() == null;
        }

        public zzck zzhj() {
            return new zzb((zzh) this.f6023a.get());
        }
    }

    public class zzb implements zzck {

        /* renamed from: a */
        private zzh f6024a;

        public zzb(zzh zzh) {
            this.f6024a = zzh;
        }

        public View zzhh() {
            return this.f6024a.zzlc();
        }

        public boolean zzhi() {
            return this.f6024a == null;
        }

        public zzck zzhj() {
            return this;
        }
    }

    public class zzc implements zzck {

        /* renamed from: a */
        private final View f6025a;

        /* renamed from: b */
        private final zzju f6026b;

        public zzc(View view, zzju zzju) {
            this.f6025a = view;
            this.f6026b = zzju;
        }

        public View zzhh() {
            return this.f6025a;
        }

        public boolean zzhi() {
            return this.f6026b == null || this.f6025a == null;
        }

        public zzck zzhj() {
            return this;
        }
    }

    public class zzd implements zzck {

        /* renamed from: a */
        private final WeakReference f6027a;

        /* renamed from: b */
        private final WeakReference f6028b;

        public zzd(View view, zzju zzju) {
            this.f6027a = new WeakReference(view);
            this.f6028b = new WeakReference(zzju);
        }

        public View zzhh() {
            return (View) this.f6027a.get();
        }

        public boolean zzhi() {
            return this.f6027a.get() == null || this.f6028b.get() == null;
        }

        public zzck zzhj() {
            return new zzc((View) this.f6027a.get(), (zzju) this.f6028b.get());
        }
    }

    public zzcd(Context context, AdSizeParcel adSizeParcel, zzju zzju, VersionInfoParcel versionInfoParcel, zzck zzck) {
        this.f6004d = new WeakReference(zzju);
        this.f6006f = zzck;
        this.f6005e = new WeakReference((Object) null);
        this.f6015o = true;
        this.f6017q = false;
        this.f6019s = new zzkr(200);
        this.f6002b = new zzcf(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zzaur, zzju.zzcie, zzju.zzho(), adSizeParcel.zzauu);
        this.f6008h = (WindowManager) context.getSystemService("window");
        this.f6009i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f6010j = (KeyguardManager) context.getSystemService("keyguard");
        this.f6007g = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8140a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo8141a(View view) {
        if (view == null) {
            return mo8158i();
        }
        boolean isAttachedToWindow = zzu.zzfs().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzkd.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f6008h.getDefaultDisplay().getWidth();
        rect2.bottom = this.f6008h.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, (Point) null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject g = mo8156g();
        g.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", mo8140a(rect2.top, displayMetrics)).put("bottom", mo8140a(rect2.bottom, displayMetrics)).put("left", mo8140a(rect2.left, displayMetrics)).put("right", mo8140a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", mo8140a(rect.top, displayMetrics)).put("bottom", mo8140a(rect.bottom, displayMetrics)).put("left", mo8140a(rect.left, displayMetrics)).put("right", mo8140a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", mo8140a(rect3.top, displayMetrics)).put("bottom", mo8140a(rect3.bottom, displayMetrics)).put("left", mo8140a(rect3.left, displayMetrics)).put("right", mo8140a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", mo8140a(rect4.top, displayMetrics)).put("bottom", mo8140a(rect4.bottom, displayMetrics)).put("left", mo8140a(rect4.left, displayMetrics)).put("right", mo8140a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", mo8140a(rect5.top, displayMetrics)).put("bottom", mo8140a(rect5.bottom, displayMetrics)).put("left", mo8140a(rect5.left, displayMetrics)).put("right", mo8140a(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzu.zzfq().zza(view, this.f6009i, this.f6010j));
        return g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8142a() {
        synchronized (this.f6001a) {
            if (this.f6003c == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                this.f6003c = new C1509dt(this);
                this.f6007g.registerReceiver(this.f6003c, intentFilter);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        com.google.android.gms.internal.zzkd.zza("Active view update failed.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8143a(int r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r3 = r7.f6001a
            monitor-enter(r3)
            boolean r2 = r7.mo8157h()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x000f
            boolean r2 = r7.f6015o     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x0011
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.zzck r2 = r7.f6006f     // Catch:{ all -> 0x0043 }
            android.view.View r4 = r2.zzhh()     // Catch:{ all -> 0x0043 }
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.internal.zzkh r2 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x0043 }
            android.os.PowerManager r5 = r7.f6009i     // Catch:{ all -> 0x0043 }
            android.app.KeyguardManager r6 = r7.f6010j     // Catch:{ all -> 0x0043 }
            boolean r2 = r2.zza((android.view.View) r4, (android.os.PowerManager) r5, (android.app.KeyguardManager) r6)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0046
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r5 = 0
            boolean r2 = r4.getGlobalVisibleRect(r2, r5)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0046
            r2 = r1
        L_0x0034:
            r7.f6017q = r2     // Catch:{ all -> 0x0043 }
            com.google.android.gms.internal.zzck r5 = r7.f6006f     // Catch:{ all -> 0x0043 }
            boolean r5 = r5.zzhi()     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x0048
            r7.zzgy()     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0010
        L_0x0043:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            throw r0
        L_0x0046:
            r2 = r0
            goto L_0x0034
        L_0x0048:
            if (r8 != r1) goto L_0x004b
            r0 = r1
        L_0x004b:
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.zzkr r0 = r7.f6019s     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.tryAcquire()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x005b
            boolean r0 = r7.f6017q     // Catch:{ all -> 0x0043 }
            if (r2 != r0) goto L_0x005b
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0010
        L_0x005b:
            if (r2 != 0) goto L_0x0065
            boolean r0 = r7.f6017q     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0065
            if (r8 != r1) goto L_0x0065
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0010
        L_0x0065:
            org.json.JSONObject r0 = r7.mo8141a((android.view.View) r4)     // Catch:{ JSONException -> 0x007b, RuntimeException -> 0x0074 }
            r7.mo8146a((org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x007b, RuntimeException -> 0x0074 }
        L_0x006c:
            r7.mo8154e()     // Catch:{ all -> 0x0043 }
            r7.mo8153d()     // Catch:{ all -> 0x0043 }
            monitor-exit(r3)     // Catch:{ all -> 0x0043 }
            goto L_0x0010
        L_0x0074:
            r0 = move-exception
        L_0x0075:
            java.lang.String r1 = "Active view update failed."
            com.google.android.gms.internal.zzkd.zza(r1, r0)     // Catch:{ all -> 0x0043 }
            goto L_0x006c
        L_0x007b:
            r0 = move-exception
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcd.mo8143a(int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8144a(View view, Map map) {
        mo8143a(3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8145a(zzft zzft) {
        zzft.zza("/updateActiveView", this.f6020t);
        zzft.zza("/untrackActiveViewUnit", this.f6021u);
        zzft.zza("/visibilityChanged", this.f6022v);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8146a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            mo8151b(jSONObject2);
        } catch (Throwable th) {
            zzkd.zzb("Skipping active view message.", th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8147a(boolean z) {
        Iterator it = this.f6018r.iterator();
        while (it.hasNext()) {
            ((zzce) it.next()).zza(this, z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8148a(Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.f6002b.zzhn());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8149b() {
        synchronized (this.f6001a) {
            if (this.f6003c != null) {
                try {
                    this.f6007g.unregisterReceiver(this.f6003c);
                } catch (IllegalStateException e) {
                    zzkd.zzb("Failed trying to unregister the receiver", e);
                } catch (Exception e2) {
                    zzu.zzft().zzb((Throwable) e2, true);
                }
                this.f6003c = null;
            }
        }
        return;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8150b(zzft zzft) {
        zzft.zzb("/visibilityChanged", this.f6022v);
        zzft.zzb("/untrackActiveViewUnit", this.f6021u);
        zzft.zzb("/updateActiveView", this.f6020t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo8151b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8152c() {
        synchronized (this.f6001a) {
            mo8155f();
            mo8149b();
            this.f6015o = false;
            mo8153d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo8153d() {
        if (this.f6011k != null) {
            this.f6011k.zza(this);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = (android.view.ViewTreeObserver) r3.f6005e.get();
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8154e() {
        /*
            r3 = this;
            com.google.android.gms.internal.zzck r0 = r3.f6006f
            com.google.android.gms.internal.zzck r0 = r0.zzhj()
            android.view.View r1 = r0.zzhh()
            if (r1 != 0) goto L_0x000d
        L_0x000c:
            return
        L_0x000d:
            java.lang.ref.WeakReference r0 = r3.f6005e
            java.lang.Object r0 = r0.get()
            android.view.ViewTreeObserver r0 = (android.view.ViewTreeObserver) r0
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            if (r1 == r0) goto L_0x000c
            r3.mo8155f()
            boolean r2 = r3.f6012l
            if (r2 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.isAlive()
            if (r0 == 0) goto L_0x0033
        L_0x002a:
            r0 = 1
            r3.f6012l = r0
            r1.addOnScrollChangedListener(r3)
            r1.addOnGlobalLayoutListener(r3)
        L_0x0033:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            r3.f6005e = r0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcd.mo8154e():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo8155f() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f6005e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public JSONObject mo8156g() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f6002b.zzhl()).put("activeViewJSON", this.f6002b.zzhm()).put("timestamp", zzu.zzfu().elapsedRealtime()).put("adFormat", this.f6002b.zzhk()).put("hashCode", this.f6002b.zzhn()).put("isMraid", this.f6002b.zzho()).put("isStopped", this.f6014n).put("isPaused", this.f6013m).put("isScreenOn", mo8159j()).put("isNative", this.f6002b.zzhp());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract boolean mo8157h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public JSONObject mo8158i() {
        return mo8156g().put("isAttachedToWindow", false).put("isScreenOn", mo8159j()).put("isVisible", false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo8159j() {
        return this.f6009i.isScreenOn();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public JSONObject mo8160k() {
        JSONObject g = mo8156g();
        g.put("doneReasonCode", "u");
        return g;
    }

    public void onGlobalLayout() {
        mo8143a(2);
    }

    public void onScrollChanged() {
        mo8143a(1);
    }

    public void pause() {
        synchronized (this.f6001a) {
            this.f6013m = true;
            mo8143a(3);
        }
    }

    public void resume() {
        synchronized (this.f6001a) {
            this.f6013m = false;
            mo8143a(3);
        }
    }

    public void stop() {
        synchronized (this.f6001a) {
            this.f6014n = true;
            mo8143a(3);
        }
    }

    public void zza(zzce zzce) {
        this.f6018r.add(zzce);
    }

    public void zza(zzch zzch) {
        synchronized (this.f6001a) {
            this.f6011k = zzch;
        }
    }

    public void zzgy() {
        synchronized (this.f6001a) {
            if (this.f6015o) {
                this.f6016p = true;
                try {
                    mo8146a(mo8160k());
                } catch (JSONException e) {
                    zzkd.zzb("JSON failure while processing active view data.", e);
                } catch (RuntimeException e2) {
                    zzkd.zzb("Failure while processing active view data.", e2);
                }
                String valueOf = String.valueOf(this.f6002b.zzhn());
                zzkd.zzcv(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    public boolean zzha() {
        boolean z;
        synchronized (this.f6001a) {
            z = this.f6015o;
        }
        return z;
    }
}
