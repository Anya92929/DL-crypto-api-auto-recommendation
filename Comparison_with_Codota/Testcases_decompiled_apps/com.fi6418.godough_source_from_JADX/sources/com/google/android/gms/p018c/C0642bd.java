package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.bd */
public final class C0642bd extends C0626ao<C0642bd> {

    /* renamed from: a */
    public String f4282a;

    /* renamed from: b */
    public boolean f4283b;

    /* renamed from: a */
    public String mo7091a() {
        return this.f4282a;
    }

    /* renamed from: a */
    public void mo7010a(C0642bd bdVar) {
        if (!TextUtils.isEmpty(this.f4282a)) {
            bdVar.mo7093a(this.f4282a);
        }
        if (this.f4283b) {
            bdVar.mo7094a(this.f4283b);
        }
    }

    /* renamed from: a */
    public void mo7093a(String str) {
        this.f4282a = str;
    }

    /* renamed from: a */
    public void mo7094a(boolean z) {
        this.f4283b = z;
    }

    /* renamed from: b */
    public boolean mo7095b() {
        return this.f4283b;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.f4282a);
        hashMap.put("fatal", Boolean.valueOf(this.f4283b));
        return m3607a((Object) hashMap);
    }
}
