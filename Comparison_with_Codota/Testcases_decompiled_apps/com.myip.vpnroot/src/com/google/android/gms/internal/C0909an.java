package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.an */
public class C0909an extends Thread {
    private boolean mStarted = false;

    /* renamed from: mw */
    private final Object f2576mw;

    /* renamed from: nf */
    private final int f2577nf;

    /* renamed from: nh */
    private final int f2578nh;

    /* renamed from: ns */
    private boolean f2579ns = false;

    /* renamed from: nt */
    private boolean f2580nt = false;

    /* renamed from: nu */
    private final C0908am f2581nu;

    /* renamed from: nv */
    private final C0907al f2582nv;

    /* renamed from: nw */
    private final C1129ey f2583nw;

    /* renamed from: nx */
    private final int f2584nx;

    /* renamed from: ny */
    private final int f2585ny;

    /* renamed from: nz */
    private final int f2586nz;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.an$a */
    class C0913a {

        /* renamed from: nG */
        final int f2595nG;

        /* renamed from: nH */
        final int f2596nH;

        C0913a(int i, int i2) {
            this.f2595nG = i;
            this.f2596nH = i2;
        }
    }

    public C0909an(C0908am amVar, C0907al alVar, Bundle bundle, C1129ey eyVar) {
        this.f2581nu = amVar;
        this.f2582nv = alVar;
        this.f2583nw = eyVar;
        this.f2576mw = new Object();
        this.f2577nf = bundle.getInt(C0952bn.f2913pe.getKey());
        this.f2585ny = bundle.getInt(C0952bn.f2914pf.getKey());
        this.f2578nh = bundle.getInt(C0952bn.f2915pg.getKey());
        this.f2586nz = bundle.getInt(C0952bn.f2916ph.getKey());
        this.f2584nx = bundle.getInt(C0952bn.f2917pi.getKey(), 10);
        setName("ContentFetchTask");
    }

    /* renamed from: a */
    private void m3874a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                mo7992g(view);
            }
        }
    }

    /* renamed from: a */
    private boolean m3875a(final WebView webView, final C0906ak akVar) {
        if (!C1394kc.m5245hI()) {
            return false;
        }
        akVar.mo7963aR();
        webView.post(new Runnable() {

            /* renamed from: nC */
            ValueCallback<String> f2590nC = new ValueCallback<String>() {
                /* renamed from: k */
                public void onReceiveValue(String str) {
                    C0909an.this.mo7987a(akVar, webView, str);
                }
            };

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f2590nC);
                }
            }
        });
        return true;
    }

    /* renamed from: aW */
    private boolean m3876aW() {
        try {
            Context context = this.f2581nu.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (activityManager == null || keyguardManager == null || powerManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0913a mo7986a(View view, C0906ak akVar) {
        if (view == null) {
            return new C0913a(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            akVar.mo7971i(((TextView) view).getText().toString());
            return new C0913a(1, 0);
        } else if ((view instanceof WebView) && !(view instanceof C1232gv)) {
            akVar.mo7963aR();
            return m3875a((WebView) view, akVar) ? new C0913a(0, 1) : new C0913a(0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C0913a(0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                C0913a a = mo7986a(viewGroup.getChildAt(i3), akVar);
                i2 += a.f2595nG;
                i += a.f2596nH;
            }
            return new C0913a(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7987a(C0906ak akVar, WebView webView, String str) {
        akVar.mo7962aQ();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!TextUtils.isEmpty(webView.getTitle())) {
                    akVar.mo7969h(webView.getTitle() + "\n" + optString);
                } else {
                    akVar.mo7969h(optString);
                }
            }
            if (akVar.mo7959aN()) {
                this.f2582nv.mo7975b(akVar);
            }
        } catch (JSONException e) {
            C1229gs.m4675S("Json string may be malformed.");
        } catch (Throwable th) {
            C1229gs.m4680a("Failed to get webview content.", th);
            this.f2583nw.mo8462b(th);
        }
    }

    /* renamed from: aV */
    public void mo7988aV() {
        synchronized (this.f2576mw) {
            if (this.mStarted) {
                C1229gs.m4675S("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    /* renamed from: aX */
    public C0906ak mo7989aX() {
        return this.f2582nv.mo7974aU();
    }

    /* renamed from: aY */
    public void mo7990aY() {
        synchronized (this.f2576mw) {
            this.f2579ns = true;
            C1229gs.m4675S("ContentFetchThread: paused, mPause = " + this.f2579ns);
        }
    }

    /* renamed from: aZ */
    public boolean mo7991aZ() {
        return this.f2579ns;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo7992g(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() {
            public void run() {
                C0909an.this.mo7993h(view);
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo7993h(View view) {
        try {
            C0906ak akVar = new C0906ak(this.f2577nf, this.f2585ny, this.f2578nh, this.f2586nz);
            C0913a a = mo7986a(view, akVar);
            akVar.mo7964aS();
            if (a.f2595nG != 0 || a.f2596nH != 0) {
                if (a.f2596nH != 0 || akVar.mo7965aT() != 0) {
                    if (a.f2596nH != 0 || !this.f2582nv.mo7973a(akVar)) {
                        this.f2582nv.mo7976c(akVar);
                    }
                }
            }
        } catch (Exception e) {
            C1229gs.m4681b("Exception in fetchContentOnUIThread", e);
            this.f2583nw.mo8462b(e);
        }
    }

    public void run() {
        while (!this.f2580nt) {
            try {
                if (m3876aW()) {
                    Activity activity = this.f2581nu.getActivity();
                    if (activity == null) {
                        C1229gs.m4675S("ContentFetchThread: no activity");
                    } else {
                        m3874a(activity);
                    }
                } else {
                    C1229gs.m4675S("ContentFetchTask: sleeping");
                    mo7990aY();
                }
                Thread.sleep((long) (this.f2584nx * 1000));
            } catch (Throwable th) {
                C1229gs.m4681b("Error in ContentFetchTask", th);
                this.f2583nw.mo8462b(th);
            }
            synchronized (this.f2576mw) {
                while (this.f2579ns) {
                    try {
                        C1229gs.m4675S("ContentFetchTask: waiting");
                        this.f2576mw.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.f2576mw) {
            this.f2579ns = false;
            this.f2576mw.notifyAll();
            C1229gs.m4675S("ContentFetchThread: wakeup");
        }
    }
}
