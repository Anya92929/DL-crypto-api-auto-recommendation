package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.firebase.iid.g */
public class C1985g {

    /* renamed from: a */
    static Map f7523a = new HashMap();

    /* renamed from: f */
    static String f7524f;

    /* renamed from: g */
    private static C1989k f7525g;

    /* renamed from: h */
    private static C1987i f7526h;

    /* renamed from: b */
    Context f7527b;

    /* renamed from: c */
    KeyPair f7528c;

    /* renamed from: d */
    String f7529d = "";

    /* renamed from: e */
    long f7530e;

    protected C1985g(Context context, String str, Bundle bundle) {
        this.f7527b = context.getApplicationContext();
        this.f7529d = str;
    }

    /* renamed from: a */
    public static synchronized C1985g m8145a(Context context, Bundle bundle) {
        C1985g gVar;
        synchronized (C1985g.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f7525g == null) {
                f7525g = new C1989k(applicationContext);
                f7526h = new C1987i(applicationContext);
            }
            f7524f = Integer.toString(FirebaseInstanceId.m8103b(applicationContext));
            gVar = (C1985g) f7523a.get(str);
            if (gVar == null) {
                gVar = new C1985g(applicationContext, str, bundle);
                f7523a.put(str, gVar);
            }
        }
        return gVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public KeyPair mo9878a() {
        if (this.f7528c == null) {
            this.f7528c = f7525g.mo9908c(this.f7529d);
        }
        if (this.f7528c == null) {
            this.f7530e = System.currentTimeMillis();
            this.f7528c = f7525g.mo9902a(this.f7529d, this.f7530e);
        }
        return this.f7528c;
    }

    /* renamed from: a */
    public void mo9879a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f7525g.mo9906b(this.f7529d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.f7529d) ? str : this.f7529d);
        if (!"".equals(this.f7529d)) {
            str = this.f7529d;
        }
        bundle.putString("X-subtype", str);
        f7526h.mo9894b(f7526h.mo9888a(bundle, mo9878a()));
    }

    /* renamed from: b */
    public String mo9880b(String str, String str2, Bundle bundle) {
        boolean z = false;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean z2 = true;
        String a = mo9885e() ? null : f7525g.mo9901a(this.f7529d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                z2 = false;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                z = z2;
            }
            a = mo9883c(str, str2, bundle);
            if (a != null && z) {
                f7525g.mo9904a(this.f7529d, str, str2, a, f7524f);
            }
        }
        return a;
    }

    /* renamed from: b */
    public void mo9881b() {
        this.f7530e = 0;
        f7525g.mo9910d(this.f7529d);
        this.f7528c = null;
    }

    /* renamed from: c */
    public C1989k mo9882c() {
        return f7525g;
    }

    /* renamed from: c */
    public String mo9883c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f7529d) ? str : this.f7529d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f7526h.mo9894b(f7526h.mo9888a(bundle, mo9878a()));
    }

    /* renamed from: d */
    public C1987i mo9884d() {
        return f7526h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo9885e() {
        String a;
        String a2 = f7525g.mo9899a("appVersion");
        if (a2 == null || !a2.equals(f7524f) || (a = f7525g.mo9899a("lastToken")) == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
