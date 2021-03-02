package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: com.google.android.gms.analytics.internal.s */
public class C0571s extends C0514aa {

    /* renamed from: a */
    protected String f3891a;

    /* renamed from: b */
    protected String f3892b;

    /* renamed from: c */
    protected boolean f3893c;

    /* renamed from: d */
    protected int f3894d;

    /* renamed from: e */
    protected boolean f3895e;

    /* renamed from: f */
    protected int f3896f;

    /* renamed from: g */
    protected boolean f3897g;

    /* renamed from: h */
    protected boolean f3898h;

    public C0571s(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: a */
    private static int m3340a(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        mo6845j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6836a(C0555c cVar) {
        int a;
        mo6869b("Loading global XML config values");
        if (cVar.mo6777a()) {
            String b = cVar.mo6778b();
            this.f3892b = b;
            mo6870b("XML config - app name", b);
        }
        if (cVar.mo6779c()) {
            String d = cVar.mo6780d();
            this.f3891a = d;
            mo6870b("XML config - app version", d);
        }
        if (cVar.mo6781e() && (a = m3340a(cVar.mo6782f())) >= 0) {
            this.f3894d = a;
            mo6866a("XML config - log level", Integer.valueOf(a));
        }
        if (cVar.mo6783g()) {
            int h = cVar.mo6784h();
            this.f3896f = h;
            this.f3895e = true;
            mo6870b("XML config - dispatch period (sec)", Integer.valueOf(h));
        }
        if (cVar.mo6785i()) {
            boolean j = cVar.mo6786j();
            this.f3898h = j;
            this.f3897g = true;
            mo6870b("XML config - dry run", Boolean.valueOf(j));
        }
    }

    /* renamed from: b */
    public String mo6837b() {
        mo6596D();
        return this.f3891a;
    }

    /* renamed from: c */
    public String mo6838c() {
        mo6596D();
        return this.f3892b;
    }

    /* renamed from: d */
    public boolean mo6839d() {
        mo6596D();
        return this.f3893c;
    }

    /* renamed from: e */
    public int mo6840e() {
        mo6596D();
        return this.f3894d;
    }

    /* renamed from: f */
    public boolean mo6841f() {
        mo6596D();
        return this.f3895e;
    }

    /* renamed from: g */
    public int mo6842g() {
        mo6596D();
        return this.f3896f;
    }

    /* renamed from: h */
    public boolean mo6843h() {
        mo6596D();
        return this.f3897g;
    }

    /* renamed from: i */
    public boolean mo6844i() {
        mo6596D();
        return this.f3898h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo6845j() {
        ApplicationInfo applicationInfo;
        int i;
        C0555c cVar;
        Context o = mo6886o();
        try {
            applicationInfo = o.getPackageManager().getApplicationInfo(o.getPackageName(), 129);
        } catch (PackageManager.NameNotFoundException e) {
            mo6877d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            mo6879e("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (cVar = (C0555c) new C0553bm(mo6882k()).mo6718a(i)) != null) {
            mo6836a(cVar);
        }
    }
}
