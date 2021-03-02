package com.appbrain.p032a;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.webkit.JavascriptInterface;
import cmn.C0725at;
import cmn.C0749k;
import cmn.Proguard;
import com.appbrain.KeepClass;
import com.appbrain.p037f.C1071bj;
import com.appbrain.p037f.C1073bl;

/* renamed from: com.appbrain.a.ap */
public class C0800ap implements Proguard.KeepMembers, KeepClass {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f2101a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0840cb f2102b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f2103c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1073bl f2104d = C1071bj.m4874p();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2105e = C0841cc.f2215a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f2106f;

    public C0800ap(Context context, boolean z, C0840cb cbVar) {
        this.f2101a = context;
        this.f2102b = cbVar;
        this.f2103c = z;
    }

    @JavascriptInterface
    public void appClicked(String str, String str2, String str3, String str4, int i) {
        C0725at.m3228a((Runnable) new C0834bw(this, str2, str3, str4, str, i));
    }

    @JavascriptInterface
    public void close() {
        C0725at.m3228a((Runnable) new C0837bz(this));
    }

    @JavascriptInterface
    public boolean isPackageInstalled(String str) {
        return C0749k.m3268a(this.f2101a, str);
    }

    @JavascriptInterface
    public boolean openInBrowser(String str) {
        return !C0842cd.m3723a(this.f2101a, Uri.parse(str));
    }

    @JavascriptInterface
    public void reportSelected(String str, String str2, String str3) {
        C0725at.m3228a((Runnable) new C0835bx(this, str, str2, str3));
    }

    /* access modifiers changed from: package-private */
    public void sendImpression() {
        if (this.f2105e == C0841cc.f2216b) {
            this.f2105e = C0841cc.f2217c;
            if (this.f2103c) {
                this.f2104d.mo4317a(SystemClock.elapsedRealtime() - this.f2106f);
            }
            new C0839ca(this, this.f2104d.mo4028d()).mo3410a((Object[]) new Void[0]);
        }
    }

    @JavascriptInterface
    public void setVisibleAppIndex(int i) {
        C0725at.m3228a((Runnable) new C0836by(this, i));
    }
}
