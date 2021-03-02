package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.bf */
public final class C0644bf extends C0626ao<C0644bf> {

    /* renamed from: a */
    public String f4292a;

    /* renamed from: b */
    public String f4293b;

    /* renamed from: c */
    public String f4294c;

    /* renamed from: a */
    public String mo7109a() {
        return this.f4292a;
    }

    /* renamed from: a */
    public void mo7010a(C0644bf bfVar) {
        if (!TextUtils.isEmpty(this.f4292a)) {
            bfVar.mo7111a(this.f4292a);
        }
        if (!TextUtils.isEmpty(this.f4293b)) {
            bfVar.mo7113b(this.f4293b);
        }
        if (!TextUtils.isEmpty(this.f4294c)) {
            bfVar.mo7115c(this.f4294c);
        }
    }

    /* renamed from: a */
    public void mo7111a(String str) {
        this.f4292a = str;
    }

    /* renamed from: b */
    public String mo7112b() {
        return this.f4293b;
    }

    /* renamed from: b */
    public void mo7113b(String str) {
        this.f4293b = str;
    }

    /* renamed from: c */
    public String mo7114c() {
        return this.f4294c;
    }

    /* renamed from: c */
    public void mo7115c(String str) {
        this.f4294c = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.f4292a);
        hashMap.put("action", this.f4293b);
        hashMap.put("target", this.f4294c);
        return m3607a((Object) hashMap);
    }
}
