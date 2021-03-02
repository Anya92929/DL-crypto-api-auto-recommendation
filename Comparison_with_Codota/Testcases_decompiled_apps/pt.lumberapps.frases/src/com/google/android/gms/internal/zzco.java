package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.zzs;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@zzin
public class zzco extends Thread {

    /* renamed from: a */
    private boolean f6063a = false;

    /* renamed from: b */
    private boolean f6064b = false;

    /* renamed from: c */
    private boolean f6065c = false;

    /* renamed from: d */
    private final Object f6066d;

    /* renamed from: e */
    private final zzcn f6067e;

    /* renamed from: f */
    private final zzcm f6068f;

    /* renamed from: g */
    private final zzim f6069g;

    /* renamed from: h */
    private final int f6070h;

    /* renamed from: i */
    private final int f6071i;

    /* renamed from: j */
    private final int f6072j;

    /* renamed from: k */
    private final int f6073k;

    /* renamed from: l */
    private final int f6074l;

    public zzco(zzcn zzcn, zzcm zzcm, zzim zzim) {
        this.f6067e = zzcn;
        this.f6068f = zzcm;
        this.f6069g = zzim;
        this.f6066d = new Object();
        this.f6071i = ((Integer) zzdc.zzazi.get()).intValue();
        this.f6072j = ((Integer) zzdc.zzazj.get()).intValue();
        this.f6073k = ((Integer) zzdc.zzazk.get()).intValue();
        this.f6074l = ((Integer) zzdc.zzazl.get()).intValue();
        this.f6070h = ((Integer) zzdc.zzazm.get()).intValue();
        setName("ContentFetchTask");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1523eg mo8219a(View view, zzcl zzcl) {
        if (view == null) {
            return new C1523eg(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C1523eg(this, 0, 0);
            }
            zzcl.zze(text.toString(), globalVisibleRect);
            return new C1523eg(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzlh)) {
            zzcl.zzhv();
            return mo8226a((WebView) view, zzcl, globalVisibleRect) ? new C1523eg(this, 0, 1) : new C1523eg(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C1523eg(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                C1523eg a = mo8219a(viewGroup.getChildAt(i3), zzcl);
                i2 += a.f4965a;
                i += a.f4966b;
            }
            return new C1523eg(this, i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8220a(Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                zzkd.zzcv("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                mo8225a(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8221a(zzcl zzcl, WebView webView, String str, boolean z) {
        zzcl.zzhu();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!TextUtils.isEmpty(webView.getTitle())) {
                    String valueOf = String.valueOf(webView.getTitle());
                    zzcl.zzd(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z);
                } else {
                    zzcl.zzd(optString, z);
                }
            }
            if (zzcl.zzhq()) {
                this.f6068f.zzb(zzcl);
            }
        } catch (JSONException e) {
            zzkd.zzcv("Json string may be malformed.");
        } catch (Throwable th) {
            zzkd.zza("Failed to get webview content.", th);
            this.f6069g.zza(th, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8222a() {
        try {
            Context context = this.f6067e.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
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
                    if (mo8223a(next) && !keyguardManager.inKeyguardRestrictedInputMode() && mo8224a(context)) {
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
    public boolean mo8223a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8224a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8225a(View view) {
        if (view == null) {
            return false;
        }
        view.post(new C1520ed(this, view));
        return true;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(19)
    /* renamed from: a */
    public boolean mo8226a(WebView webView, zzcl zzcl, boolean z) {
        if (!zzs.zzavu()) {
            return false;
        }
        zzcl.zzhv();
        webView.post(new C1521ee(this, zzcl, webView, z));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8227b(View view) {
        try {
            zzcl zzcl = new zzcl(this.f6071i, this.f6072j, this.f6073k, this.f6074l);
            C1523eg a = mo8219a(view, zzcl);
            zzcl.zzhw();
            if (a.f4965a != 0 || a.f4966b != 0) {
                if (a.f4966b != 0 || zzcl.mo8190a() != 0) {
                    if (a.f4966b != 0 || !this.f6068f.zza(zzcl)) {
                        this.f6068f.zzc(zzcl);
                    }
                }
            }
        } catch (Exception e) {
            zzkd.zzb("Exception in fetchContentOnUIThread", e);
            this.f6069g.zza(e, true);
        }
    }

    public void run() {
        while (true) {
            try {
                if (mo8222a()) {
                    Activity activity = this.f6067e.getActivity();
                    if (activity == null) {
                        zzkd.zzcv("ContentFetchThread: no activity. Sleeping.");
                        zzic();
                    } else {
                        mo8220a(activity);
                    }
                } else {
                    zzkd.zzcv("ContentFetchTask: sleeping");
                    zzic();
                }
                Thread.sleep((long) (this.f6070h * 1000));
            } catch (Throwable th) {
                zzkd.zzb("Error in ContentFetchTask", th);
                this.f6069g.zza(th, true);
            }
            synchronized (this.f6066d) {
                while (this.f6064b) {
                    try {
                        zzkd.zzcv("ContentFetchTask: waiting");
                        this.f6066d.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.f6066d) {
            this.f6064b = false;
            this.f6066d.notifyAll();
            zzkd.zzcv("ContentFetchThread: wakeup");
        }
    }

    public void zzhz() {
        synchronized (this.f6066d) {
            if (this.f6063a) {
                zzkd.zzcv("Content hash thread already started, quiting...");
                return;
            }
            this.f6063a = true;
            start();
        }
    }

    public zzcl zzib() {
        return this.f6068f.zzhy();
    }

    public void zzic() {
        synchronized (this.f6066d) {
            this.f6064b = true;
            zzkd.zzcv(new StringBuilder(42).append("ContentFetchThread: paused, mPause = ").append(this.f6064b).toString());
        }
    }

    public boolean zzid() {
        return this.f6064b;
    }
}
