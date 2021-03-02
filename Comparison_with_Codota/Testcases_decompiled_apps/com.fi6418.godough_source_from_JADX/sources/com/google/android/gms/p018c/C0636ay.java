package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.ay */
public final class C0636ay extends C0626ao<C0636ay> {

    /* renamed from: a */
    private String f4254a;

    /* renamed from: b */
    private String f4255b;

    /* renamed from: c */
    private String f4256c;

    /* renamed from: d */
    private String f4257d;

    /* renamed from: a */
    public String mo7028a() {
        return this.f4254a;
    }

    /* renamed from: a */
    public void mo7010a(C0636ay ayVar) {
        if (!TextUtils.isEmpty(this.f4254a)) {
            ayVar.mo7030a(this.f4254a);
        }
        if (!TextUtils.isEmpty(this.f4255b)) {
            ayVar.mo7032b(this.f4255b);
        }
        if (!TextUtils.isEmpty(this.f4256c)) {
            ayVar.mo7034c(this.f4256c);
        }
        if (!TextUtils.isEmpty(this.f4257d)) {
            ayVar.mo7036d(this.f4257d);
        }
    }

    /* renamed from: a */
    public void mo7030a(String str) {
        this.f4254a = str;
    }

    /* renamed from: b */
    public String mo7031b() {
        return this.f4255b;
    }

    /* renamed from: b */
    public void mo7032b(String str) {
        this.f4255b = str;
    }

    /* renamed from: c */
    public String mo7033c() {
        return this.f4256c;
    }

    /* renamed from: c */
    public void mo7034c(String str) {
        this.f4256c = str;
    }

    /* renamed from: d */
    public String mo7035d() {
        return this.f4257d;
    }

    /* renamed from: d */
    public void mo7036d(String str) {
        this.f4257d = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f4254a);
        hashMap.put("appVersion", this.f4255b);
        hashMap.put("appId", this.f4256c);
        hashMap.put("appInstallerId", this.f4257d);
        return m3607a((Object) hashMap);
    }
}
