package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.internal.C0897ah;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.af */
public final class C0888af implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: mK */
    private static final long f2514mK = TimeUnit.MILLISECONDS.toNanos(100);

    /* renamed from: mA */
    private WeakReference<ViewTreeObserver> f2515mA;

    /* renamed from: mB */
    private final WeakReference<View> f2516mB;
    /* access modifiers changed from: private */

    /* renamed from: mC */
    public final C0886ad f2517mC;

    /* renamed from: mD */
    private final Context f2518mD;

    /* renamed from: mE */
    private final C0897ah f2519mE;
    /* access modifiers changed from: private */

    /* renamed from: mF */
    public boolean f2520mF;

    /* renamed from: mG */
    private final WindowManager f2521mG;

    /* renamed from: mH */
    private final PowerManager f2522mH;

    /* renamed from: mI */
    private final KeyguardManager f2523mI;

    /* renamed from: mJ */
    private C0896ag f2524mJ;

    /* renamed from: mL */
    private boolean f2525mL;

    /* renamed from: mM */
    private final BlockingQueue<Runnable> f2526mM;

    /* renamed from: mN */
    private long f2527mN;

    /* renamed from: mO */
    private boolean f2528mO;

    /* renamed from: mP */
    private boolean f2529mP;

    /* renamed from: mQ */
    private BroadcastReceiver f2530mQ;

    /* renamed from: mR */
    private final HashSet<C0885ac> f2531mR;

    /* renamed from: mn */
    private boolean f2532mn;

    /* renamed from: mw */
    private final Object f2533mw;

    /* renamed from: mz */
    private final WeakReference<C1196fz> f2534mz;

    public C0888af(Context context, C0927ay ayVar, C1196fz fzVar, View view, C1230gt gtVar) {
        this(ayVar, fzVar, gtVar, view, (C0897ah) new C0902aj(context, gtVar));
    }

    public C0888af(C0927ay ayVar, C1196fz fzVar, C1230gt gtVar, final View view, C0897ah ahVar) {
        this.f2533mw = new Object();
        this.f2532mn = false;
        this.f2525mL = false;
        this.f2526mM = new ArrayBlockingQueue(2);
        this.f2527mN = Long.MIN_VALUE;
        this.f2531mR = new HashSet<>();
        this.f2534mz = new WeakReference<>(fzVar);
        this.f2516mB = new WeakReference<>(view);
        this.f2515mA = new WeakReference<>((Object) null);
        this.f2528mO = true;
        this.f2517mC = new C0886ad(UUID.randomUUID().toString(), gtVar, ayVar.f2622of, fzVar.f3680vp);
        this.f2519mE = ahVar;
        this.f2521mG = (WindowManager) view.getContext().getSystemService("window");
        this.f2522mH = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.f2523mI = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.f2518mD = view.getContext().getApplicationContext();
        mo7914a(ahVar);
        this.f2519mE.mo7943a(new C0897ah.C0898a() {
            /* renamed from: aM */
            public void mo7938aM() {
                boolean unused = C0888af.this.f2520mF = true;
                C0888af.this.mo7927d(view);
                C0888af.this.mo7917aD();
            }
        });
        mo7926b(this.f2519mE);
        try {
            final JSONObject e = mo7930e(view);
            this.f2526mM.add(new Runnable() {
                public void run() {
                    C0888af.this.mo7915a(e);
                }
            });
        } catch (Throwable th) {
        }
        this.f2526mM.add(new Runnable() {
            public void run() {
                C0888af.this.mo7931e(false);
            }
        });
        C1229gs.m4675S("Tracking ad unit: " + this.f2517mC.mo7900aC());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7910a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7911a(View view, Map<String, String> map) {
        mo7931e(false);
    }

    /* renamed from: a */
    public void mo7912a(C0885ac acVar) {
        this.f2531mR.add(acVar);
    }

    /* renamed from: a */
    public void mo7913a(C0896ag agVar) {
        synchronized (this.f2533mw) {
            this.f2524mJ = agVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7914a(C0897ah ahVar) {
        ahVar.mo7948f("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7915a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.f2519mE.mo7946a("AFMA_updateActiveView", jSONObject2);
        } catch (Throwable th) {
            C1229gs.m4681b("Skipping active view message.", th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7916a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.f2517mC.mo7900aC());
    }

    /* access modifiers changed from: protected */
    /* renamed from: aD */
    public void mo7917aD() {
        synchronized (this.f2533mw) {
            if (this.f2530mQ == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                this.f2530mQ = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        C0888af.this.mo7931e(false);
                    }
                };
                this.f2518mD.registerReceiver(this.f2530mQ, intentFilter);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aE */
    public void mo7918aE() {
        synchronized (this.f2533mw) {
            if (this.f2530mQ != null) {
                this.f2518mD.unregisterReceiver(this.f2530mQ);
                this.f2530mQ = null;
            }
        }
    }

    /* renamed from: aF */
    public void mo7919aF() {
        synchronized (this.f2533mw) {
            if (this.f2528mO) {
                this.f2529mP = true;
                try {
                    mo7915a(mo7925aL());
                } catch (JSONException e) {
                    C1229gs.m4681b("JSON Failure while processing active view data.", e);
                }
                C1229gs.m4675S("Untracking ad unit: " + this.f2517mC.mo7900aC());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public void mo7920aG() {
        if (this.f2524mJ != null) {
            this.f2524mJ.mo7904a(this);
        }
    }

    /* renamed from: aH */
    public boolean mo7921aH() {
        boolean z;
        synchronized (this.f2533mw) {
            z = this.f2528mO;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = (android.view.ViewTreeObserver) r2.f2515mA.get();
     */
    /* renamed from: aI */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7922aI() {
        /*
            r2 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r2.f2516mB
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            return
        L_0x000b:
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r2.f2515mA
            java.lang.Object r1 = r1.get()
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            if (r0 == r1) goto L_0x000a
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r0)
            r2.f2515mA = r1
            r0.addOnScrollChangedListener(r2)
            r0.addOnGlobalLayoutListener(r2)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0888af.mo7922aI():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: aJ */
    public void mo7923aJ() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f2515mA.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aK */
    public JSONObject mo7924aK() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f2517mC.mo7898aA()).put("activeViewJSON", this.f2517mC.mo7899aB()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.f2517mC.mo7901az()).put("hashCode", this.f2517mC.mo7900aC());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: aL */
    public JSONObject mo7925aL() throws JSONException {
        JSONObject aK = mo7924aK();
        aK.put("doneReasonCode", "u");
        return aK;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7926b(C0897ah ahVar) {
        ahVar.mo7945a("/updateActiveView", (C0974by) new C0974by() {
            /* renamed from: a */
            public void mo7942a(C1232gv gvVar, Map<String, String> map) {
                if (C0888af.this.mo7916a(map)) {
                    C0888af.this.mo7911a((View) gvVar, map);
                }
            }
        });
        ahVar.mo7945a("/untrackActiveViewUnit", (C0974by) new C0974by() {
            /* renamed from: a */
            public void mo7942a(C1232gv gvVar, Map<String, String> map) {
                if (C0888af.this.mo7916a(map)) {
                    C1229gs.m4675S("Received request to untrack: " + C0888af.this.f2517mC.mo7900aC());
                    C0888af.this.destroy();
                }
            }
        });
        ahVar.mo7945a("/visibilityChanged", (C0974by) new C0974by() {
            /* renamed from: a */
            public void mo7942a(C1232gv gvVar, Map<String, String> map) {
                if (C0888af.this.mo7916a(map) && map.containsKey("isVisible")) {
                    C0888af.this.mo7928d(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))).booleanValue());
                }
            }
        });
        ahVar.mo7945a("/viewabilityChanged", C0965bx.f2942pA);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo7927d(View view) {
        ArrayList arrayList = new ArrayList();
        this.f2526mM.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo7928d(boolean z) {
        Iterator<C0885ac> it = this.f2531mR.iterator();
        while (it.hasNext()) {
            it.next().mo7897a(this, z);
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (this.f2533mw) {
            mo7923aJ();
            mo7918aE();
            this.f2528mO = false;
            try {
                this.f2519mE.destroy();
            } catch (Throwable th) {
            }
            mo7920aG();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public JSONObject mo7930e(View view) throws JSONException {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(new int[2]);
        JSONObject aK = mo7924aK();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f2521mG.getDefaultDisplay().getWidth();
        rect2.bottom = this.f2521mG.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, (Point) null);
        Rect rect4 = new Rect();
        aK.put("viewBox", new JSONObject().put("top", mo7910a(rect2.top, displayMetrics)).put("bottom", mo7910a(rect2.bottom, displayMetrics)).put("left", mo7910a(rect2.left, displayMetrics)).put("right", mo7910a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", mo7910a(rect.top, displayMetrics)).put("bottom", mo7910a(rect.bottom, displayMetrics)).put("left", mo7910a(rect.left, displayMetrics)).put("right", mo7910a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", mo7910a(rect3.top, displayMetrics)).put("bottom", mo7910a(rect3.bottom, displayMetrics)).put("left", mo7910a(rect3.left, displayMetrics)).put("right", mo7910a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", mo7910a(rect4.top, displayMetrics)).put("bottom", mo7910a(rect4.bottom, displayMetrics)).put("left", mo7910a(rect4.left, displayMetrics)).put("right", mo7910a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", view.getLocalVisibleRect(rect4)).put("screenDensity", (double) displayMetrics.density).put("isVisible", mo7932f(view)).put("isStopped", this.f2525mL).put("isPaused", this.f2532mn);
        return aK;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7931e(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r2 = r7.f2533mw
            monitor-enter(r2)
            boolean r0 = r7.f2520mF     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x000b
            boolean r0 = r7.f2528mO     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
        L_0x000c:
            return
        L_0x000d:
            long r0 = java.lang.System.nanoTime()     // Catch:{ all -> 0x001e }
            if (r8 == 0) goto L_0x0021
            long r3 = r7.f2527mN     // Catch:{ all -> 0x001e }
            long r5 = f2514mK     // Catch:{ all -> 0x001e }
            long r3 = r3 + r5
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0021
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            goto L_0x000c
        L_0x001e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x0021:
            r7.f2527mN = r0     // Catch:{ all -> 0x001e }
            java.lang.ref.WeakReference<com.google.android.gms.internal.fz> r0 = r7.f2534mz     // Catch:{ all -> 0x001e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001e }
            com.google.android.gms.internal.fz r0 = (com.google.android.gms.internal.C1196fz) r0     // Catch:{ all -> 0x001e }
            java.lang.ref.WeakReference<android.view.View> r1 = r7.f2516mB     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x001e }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x0037
            if (r0 != 0) goto L_0x003f
        L_0x0037:
            r0 = 1
        L_0x0038:
            if (r0 == 0) goto L_0x0041
            r7.mo7919aF()     // Catch:{ all -> 0x001e }
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            goto L_0x000c
        L_0x003f:
            r0 = 0
            goto L_0x0038
        L_0x0041:
            org.json.JSONObject r0 = r7.mo7930e((android.view.View) r1)     // Catch:{ JSONException -> 0x0050 }
            r7.mo7915a((org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x0050 }
        L_0x0048:
            r7.mo7922aI()     // Catch:{ all -> 0x001e }
            r7.mo7920aG()     // Catch:{ all -> 0x001e }
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            goto L_0x000c
        L_0x0050:
            r0 = move-exception
            java.lang.String r1 = "Active view update failed."
            com.google.android.gms.internal.C1229gs.m4680a(r1, r0)     // Catch:{ all -> 0x001e }
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0888af.mo7931e(boolean):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo7932f(View view) {
        return view.getVisibility() == 0 && view.isShown() && this.f2522mH.isScreenOn() && !this.f2523mI.inKeyguardRestrictedInputMode();
    }

    public void onGlobalLayout() {
        mo7931e(false);
    }

    public void onScrollChanged() {
        mo7931e(true);
    }

    public void pause() {
        synchronized (this.f2533mw) {
            this.f2532mn = true;
            mo7931e(false);
            this.f2519mE.pause();
        }
    }

    public void resume() {
        synchronized (this.f2533mw) {
            this.f2519mE.resume();
            this.f2532mn = false;
            mo7931e(false);
        }
    }

    public void stop() {
        synchronized (this.f2533mw) {
            this.f2525mL = true;
            mo7931e(false);
            this.f2519mE.pause();
        }
    }
}
